package org.xcolab.portlets.proposals.wrappers;

import com.ext.portlet.model.Proposal;
import com.ext.portlet.model.Proposal2Phase;
import com.ext.portlet.service.ContestLocalServiceUtil;
import com.ext.portlet.service.FocusAreaOntologyTermLocalServiceUtil;
import com.ext.portlet.service.Proposal2PhaseLocalServiceUtil;
import com.ext.portlet.service.ProposalLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;

import org.xcolab.client.comment.CommentClient;
import org.xcolab.client.contest.ContestClient;
import org.xcolab.client.contest.exceptions.ContestNotFoundException;
import org.xcolab.client.contest.pojo.Contest;
import org.xcolab.client.contest.pojo.ContestCollectionCard;
import org.xcolab.client.contest.pojo.ContestPhase;
import org.xcolab.client.contest.pojo.ContestPhaseType;
import org.xcolab.client.members.pojo.Member;
import org.xcolab.client.proposals.ProposalsClient;
import org.xcolab.portlets.proposals.utils.GenericJudgingStatus;
import org.xcolab.wrappers.BaseContestPhaseWrapper;
import org.xcolab.wrappers.BaseContestWrapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContestWrapper extends BaseContestWrapper {

    private static final long ONTOLOGY_SPACE_ID_WHERE = 104L;
    private static final long ONTOLOGY_SPACE_ID_WHO = 102L;
    private static final long ONTOLOGY_SPACE_ID_WHAT = 103L;
    private static final long ONTOLOGY_SPACE_ID_HOW = 103L;
    private static final long CONTEST_TIER_FOR_SHOWING_SUB_CONTESTS = 3L;

    private static final String EMAIL_TEMPLATE_URL = "/resources/-/wiki/Main/Judging+Mail+Templates";

    private Map<String, String> ontologyJoinedNames = new HashMap<>();
    private List<BaseContestPhaseWrapper> visiblePhases;

    public ContestWrapper(long contestId) throws ContestNotFoundException {
        super(contestId);
    }

    public ContestWrapper(Contest contest) {
        super(contest);
    }



    public boolean getIsSharedContest(){
        return contest.getIsSharedContest();
    }

    public String getContestDescription() {
        return contest.getContestDescription();
    }

    public void setContestDescription(String ContestDescription) {
        contest.setContestDescription(ContestDescription);
    }

    public String getContestModelDescription() {
        return contest.getContestModelDescription();
    }

    public void setContestModelDescription(String ContestModelDescription) {
        contest.setContestModelDescription(ContestModelDescription);
    }

    public String getDefaultModelSettings(){
        return contest.getDefaultModelSettings();
    }

    public void setDefaultModelSettings(String defaultModelSettings) {
        contest.setDefaultModelSettings(defaultModelSettings);
    }

    public String getEmailTemplateUrl() {
        if (contest.getEmailTemplateUrl().isEmpty()) {
            return EMAIL_TEMPLATE_URL;
        } else {
            return contest.getEmailTemplateUrl();
        }
    }

    public void setEmailTemplateUrl(String emailTemplateUrl) {
        contest.setEmailTemplateUrl(emailTemplateUrl);
    }

    public boolean getShowInTileView(){
        return contest.getShow_in_tile_view();
    }

    public boolean isShowInTileView(){
        return contest.getShow_in_tile_view();
    }

    public void setShowInTileView(boolean showInTileView){
        contest.setShow_in_tile_view(showInTileView);
    }

    public boolean getShowInListView(){
        return contest.getShow_in_list_view();
    }

    public boolean isShowInListView(){
        return contest.getShow_in_list_view();
    }

    public void setShowInListView(boolean showInListView){
        contest.setShow_in_list_view(showInListView);
    }

    public boolean getShowInOutlineView(){
        return contest.getShow_in_outline_view();
    }

    public boolean isShowInOutlineView(){
        return contest.getShow_in_outline_view();
    }

    public void setShowInOutlineView(boolean showInOutlineView){
        contest.setShow_in_outline_view(showInOutlineView);
    }



    public String getContestPositionsDescription() {
        return contest.getContestPositionsDescription();
    }

    public void setContestPositionsDescription(String ContestPositionsDescription) {
        contest.setContestPositionsDescription(ContestPositionsDescription);
    }

    public long getCreatedTime() {
    	if (contest.getCreated() != null) {
    		return contest.getCreated().getTime();
    	}
    	else if (contest.getUpdated() != null) {
    		return contest.getUpdated().getTime();
    	}
    	return 0;
    }

    public long getTotalCommentsCount() throws PortalException, SystemException {
        ContestCollectionCard contestCollectionCard = ContestClient.getContestCollectionCard(1);
        List<ContestCollectionCard>  cardList = ContestClient.getSubContestCollectionCards();
        System.out.println(contestCollectionCard);
        if (getContestType().getHasDiscussion()) {
           return CommentClient.countComments(contest.getDiscussionGroupId());
        }
        Integer contestComments = CommentClient.countComments(contest.getDiscussionGroupId());
        ContestPhase phase = ContestClient.getActivePhase(contest.getContestPK());
        contestComments += CommentClient.countCommentsInContestPhase(
                phase.getContestPhasePK(), phase.getContestPK());
        return contestComments;
    }

    public long getVotesCount() throws PortalException, SystemException {
        ContestPhase phase = ContestClient.getActivePhase(contest.getContestPK());
        return ProposalsClient.countProposalsInContestPhaseVotes(phase.getContestPhasePK());
    }

    public BaseContestPhaseWrapper getLastPhase() throws PortalException, SystemException {
        BaseContestPhaseWrapper last = null;
        for (BaseContestPhaseWrapper ph : getPhases()) {
            if (last == null || (ph.getPhaseReferenceDate() != null && ph.getPhaseReferenceDate().compareTo(last.getPhaseReferenceDate()) > 0)) {
                last = ph;
            }
        }
        return last;
    }

    public String getWhoName() throws PortalException, SystemException {
        return getTermNameFromSpace(WHO);
    }

    public String getWhatName() throws PortalException, SystemException {
        return getTermNameFromSpace(WHAT);
    }

    public String getWhereName() throws PortalException, SystemException {
        return getTermNameFromSpace(WHERE);
    }

    public String getHowName() throws PortalException, SystemException {
        return getTermNameFromSpace(HOW);
    }

    public String getTermNameFromSpace(String space) throws PortalException, SystemException {
        String ontologyJoinedName = ontologyJoinedNames.get(space);
        if (ontologyJoinedName == null) {
            getTermFromSpace(space);
            ontologyJoinedName = ontologyJoinedNames.get(space);
        }

        if (ontologyJoinedName == null) {
        	return "";
        }
        return ontologyJoinedName;
    }

    public boolean getShowSubContests(){
        // Removed due to COLAB-518; keep the functionality in the code base for the case that we need it again.
//        return contest.getContestTier() == CONTEST_TIER_FOR_SHOWING_SUB_CONTESTS;
        return false;
    }

    public boolean getShowParentContest(){
        return contest.getContestTier() == CONTEST_TIER_FOR_SHOWING_SUB_CONTESTS - 1;
    }

    public List<Contest> getSubContests() throws SystemException, PortalException {
        List <Contest> subContests = ContestClient.getSubContestsByOntologySpaceId(contest.getContestPK(), ONTOLOGY_SPACE_ID_WHERE);
        Collections.sort(subContests, new Comparator<Contest>() {
            @Override
            public int compare(Contest c1, Contest c2) {
                return c1.getWeight() - c2.getWeight();
            }
        });
        return subContests;
    }

    public ContestWrapper getParentContest() throws SystemException, PortalException {
        List<Long> focusAreaOntologyTermIds =
                FocusAreaOntologyTermLocalServiceUtil.getFocusAreaOntologyTermIdsByFocusAreaAndSpaceId(contest.getFocusAreaId(), ONTOLOGY_SPACE_ID_WHERE);
        List<Contest> contests = ContestClient.findContestsTierLevelAndOntologyTermIds(CONTEST_TIER_FOR_SHOWING_SUB_CONTESTS, focusAreaOntologyTermIds);
        return new ContestWrapper(contests.get(0));
    }

    public Long getVotingPhasePK() throws PortalException, SystemException {
        BaseContestPhaseWrapper lastVotingPhase = null;
        for (BaseContestPhaseWrapper ph : getPhases()) {
            if (ph.getContestPhaseTypeObject() != null && "VOTING".equals(ph.getContestPhaseTypeObject().getStatus())) {
                lastVotingPhase = ph;
            }
        }
        return lastVotingPhase != null ? lastVotingPhase.getContestPhasePK() : 0;
    }

    public boolean isContestCompleted(BaseContestPhaseWrapper contestPhase) {
        ContestPhaseType type;
        ContestPhase activePhase;
        try {
            activePhase = ContestClient.getActivePhase(this.contest.getContestPK());
            type = new BaseContestPhaseWrapper(activePhase).getContestPhaseTypeObject();
        } catch (IllegalArgumentException | NullPointerException | SystemException  e) {
            return false;
        }
        return !(type == null || activePhase == null
                    || contestPhase.getContestPhasePK() != activePhase.getContestPhasePK()
                ) && ("COMPLETED".equals(type.getStatus()));
    }

    public List<BaseContestPhaseWrapper> getVisiblePhases() throws SystemException, PortalException {
        if (visiblePhases == null) {
            visiblePhases = new ArrayList<>();
            for (ContestPhase phase : ContestClient.getVisibleContestPhases(contest.getContestPK())) {
                visiblePhases.add(new BaseContestPhaseWrapper(phase));
            }
        }
        return visiblePhases;
    }

    public boolean getHasFocusArea() {
        return contest.getFocusAreaId() > 0;
    }

    public boolean isUserAmongAdvisors(User userInQuestion) throws SystemException, PortalException {
        for (Member judge : getContestAdvisors()) {
            if (judge.getUserId() == userInQuestion.getUserId()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Determine if judges are done with proposal
     *
     * @return 0 if judge action is incomplete, 1 judge actions completed
     */
    public boolean getJudgeStatus() {
        try {
            com.ext.portlet.model.Contest contestLiferay = ContestLocalServiceUtil.getContest(contest.getContestPK());
            com.ext.portlet.model.ContestPhase contestPhase = ContestLocalServiceUtil.getActiveOrLastPhase(contestLiferay);
            for (Proposal proposal : ProposalLocalServiceUtil.getProposalsInContestPhase(contestPhase.getPrimaryKey())) {
                Proposal2Phase p2p = Proposal2PhaseLocalServiceUtil.getByProposalIdContestPhaseId(proposal.getProposalId(), contestPhase.getContestPhasePK());
                if ((new ProposalWrapper(proposal, proposal.getCurrentVersion(), contestLiferay, contestPhase, p2p)).getJudgeStatus() == GenericJudgingStatus.STATUS_ACCEPTED) {
                    return false;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Determine if fellows are done with proposal
     *
     * @return 0 if fellow action is incomplete, 1 fellow action completed
     */
    public boolean getScreeningStatus() {
        try {
            com.ext.portlet.model.Contest contestLiferay = ContestLocalServiceUtil.getContest(contest.getContestPK());
            com.ext.portlet.model.ContestPhase contestPhase = ContestLocalServiceUtil.getActiveOrLastPhase(contestLiferay);

            for (Proposal proposal : ProposalLocalServiceUtil.getProposalsInContestPhase(contestPhase.getPrimaryKey())) {
                Proposal2Phase p2p = Proposal2PhaseLocalServiceUtil.getByProposalIdContestPhaseId(proposal.getProposalId(), contestPhase.getContestPhasePK());
                if ((new ProposalWrapper(proposal, proposal.getCurrentVersion(), contestLiferay, contestPhase, p2p)).getScreeningStatus() == GenericJudgingStatus.STATUS_UNKNOWN) {
                    return false;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public String getNewProposalLinkUrl() throws SystemException {
        final String portletUrl = getContestType().getPortletUrl();
        return String.format("%s/%s/%s/createProposal",
                portletUrl, contest.getContestYear(), contest.getContestUrlName());
    }
}
