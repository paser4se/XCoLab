package org.xcolab.view.pages.proposals.view.action;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.xcolab.client.contest.exceptions.ContestNotFoundException;
import org.xcolab.client.contest.pojo.Contest;
import org.xcolab.client.members.MembersClient;
import org.xcolab.client.members.pojo.Member;
import org.xcolab.client.proposals.ProposalClient;
import org.xcolab.client.proposals.ProposalMemberRatingClient;
import org.xcolab.client.proposals.pojo.Proposal;
import org.xcolab.client.proposals.pojo.evaluation.members.ProposalVote;
import org.xcolab.entity.utils.notifications.proposal.ProposalVoteNotification;
import org.xcolab.view.pages.proposals.exceptions.ProposalsAuthorizationException;
import org.xcolab.view.pages.proposals.utils.context.ClientHelper;
import org.xcolab.view.pages.proposals.utils.context.ProposalContext;
import org.xcolab.view.pages.proposals.utils.voting.VoteValidator;
import org.xcolab.view.pages.proposals.utils.voting.VoteValidator.ValidationResult;
import org.xcolab.view.util.entity.analytics.AnalyticsUtil;
import org.xcolab.view.util.entity.flash.AlertMessage;
import org.xcolab.view.util.googleanalytics.GoogleAnalyticsEventType;
import org.xcolab.view.util.googleanalytics.GoogleAnalyticsUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/contests/{contestYear}/{contestUrlName}/c/{proposalUrlString}/{proposalId}")
public class VoteOnProposalActionController {

    private final static String VOTE_ANALYTICS_KEY = "VOTE_CONTEST_ENTRIES";
    private final static String VOTE_ANALYTICS_CATEGORY = "User";
    private final static String VOTE_ANALYTICS_ACTION = "Vote contest entry";
    private final static String VOTE_ANALYTICS_LABEL = "";

    @PostMapping("voteOnProposalAction")
    public String handleAction(HttpServletRequest request, HttpServletResponse response, Model model,
            ProposalContext proposalContext, Member member)
            throws ProposalsAuthorizationException {

        final ClientHelper clients = proposalContext.getClients();
        final ProposalMemberRatingClient proposalMemberRatingClient =
                clients.getProposalMemberRatingClient();

        final Proposal proposal = proposalContext.getProposal();
        final Contest contest = proposalContext.getContest();
        final String proposalLinkUrl = proposal.getProposalLinkUrl(contest);

        if (!proposalContext.getPermissions().getCanVote()) {
            if (member == null) {
                /* User is not logged in - don't count vote and let user log in*/
                AlertMessage.danger("You must be logged in to vote.").flash(request);
                return "redirect:" + proposalLinkUrl;
            } else {
                throw new ProposalsAuthorizationException("User not allowed to vote on proposal.");
            }
        }

        boolean hasVoted = false;
        long proposalId = proposal.getProposalId();
        long contestPhaseId = proposalContext.getContestPhase().getContestPhasePK();
        long memberId = member.getUserId();
        if (proposalMemberRatingClient.hasUserVoted(proposalId, contestPhaseId, memberId)) {
            // User has voted for this proposal and would like to retract the vote
            proposalMemberRatingClient.deleteProposalVote(contestPhaseId, memberId);
        } else {
            if (proposalMemberRatingClient.hasUserVoted(contestPhaseId, memberId)) {
                // User has voted for a different proposal. Vote will be retracted and
                // converted to a vote of this proposal.
                proposalMemberRatingClient.deleteProposalVote(contestPhaseId, memberId);
            }

            proposalMemberRatingClient.addProposalVote(proposalId, contestPhaseId, memberId);
            VoteValidator voteValidator =
                    new VoteValidator(member, proposal, contest, request.getRemoteAddr(),
                            clients.getProposalMemberRatingClient());
            final ValidationResult validationResult = voteValidator.validate();
            if (validationResult == ValidationResult.INVALID_BLACKLISTED
                    || validationResult == ValidationResult.INVALID_BOUNCED_EMAIL) {
                //TODO: decide if we want to inform users of this
                //                    AlertMessage.danger("Your vote was NOT counted because
                // it violates our email policy. "
                //                            + "Please refer to the Voting Rules for
                // additional information.")
                //                            .flash(request);
            } else {
                try {
                    new ProposalVoteNotification(proposal, contest, member).sendMessage();
                } catch (ContestNotFoundException ignored) {

                }

                //publish event per contestPhaseId to allow voting on exactly one proposal per
                // contest(phase)
                AnalyticsUtil.publishEvent(request, memberId, VOTE_ANALYTICS_KEY + contestPhaseId,
                        VOTE_ANALYTICS_CATEGORY, VOTE_ANALYTICS_ACTION, VOTE_ANALYTICS_LABEL, 1);
				GoogleAnalyticsUtils.pushEventAsync(GoogleAnalyticsEventType.CONTEST_ENTRY_VOTE);
                hasVoted = true;
            }
        }
        // Redirect to prevent page-refreshing from influencing the vote
        if (ConfigurationAttributeKey.PROPOSALS_VOTING_SUCCESS_MESSAGE_IS_ACTIVE.get()
                && hasVoted) {
            return "redirect:" + proposalLinkUrl + "/voted";
        }
        return "redirect:" + proposalLinkUrl;
    }

    @GetMapping("confirmVote/{proposalId}/{userId}/{confirmationToken}")
    public String confirmVote(HttpServletRequest request, HttpServletResponse response, Model model,
            ProposalContext proposalContext, @PathVariable long proposalId,
            @PathVariable long userId, @PathVariable String confirmationToken) {
        boolean success = false;
        final ClientHelper clients = proposalContext.getClients();
        final ProposalClient proposalClient = clients.getProposalClient();
        final ProposalMemberRatingClient proposalMemberRatingClient =
                clients.getProposalMemberRatingClient();

        ProposalVote vote =
                proposalMemberRatingClient.getProposalVoteByProposalIdUserId(proposalId, userId);
        if (vote != null && isValidToken(confirmationToken, vote)) {
            final Member member = MembersClient.getMemberUnchecked(vote.getUserId());
            member.setIsEmailConfirmed(true);
            MembersClient.updateMember(member);

            vote.setIsValid(true);
            proposalMemberRatingClient.updateProposalVote(vote);

            Proposal proposal = new Proposal(proposalClient.getProposal(proposalId));
            model.addAttribute("proposal", proposal);
            success = true;
        } else {
            model.addAttribute("error", "TokenError");
        }
        model.addAttribute("success", success);
        return "proposals/confirmVote";
    }

    private boolean isValidToken(@PathVariable String confirmationToken, ProposalVote vote) {
        return StringUtils.isNotEmpty(vote.getConfirmationToken()) && vote.getConfirmationToken()
                .equalsIgnoreCase(confirmationToken);
    }
}
