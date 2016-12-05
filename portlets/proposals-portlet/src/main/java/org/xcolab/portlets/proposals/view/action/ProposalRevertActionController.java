package org.xcolab.portlets.proposals.view.action;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

import org.xcolab.client.contest.pojo.templates.PlanSectionDefinition;
import org.xcolab.client.proposals.ProposalAttributeClientUtil;
import org.xcolab.client.proposals.ProposalClientUtil;
import org.xcolab.client.proposals.enums.ProposalAttributeKeys;
import org.xcolab.client.proposals.exceptions.ProposalNotFoundException;
import org.xcolab.client.proposals.pojo.Proposal;
import org.xcolab.client.proposals.pojo.phases.Proposal2Phase;
import org.xcolab.portlets.proposals.exceptions.ProposalsAuthorizationException;
import org.xcolab.portlets.proposals.utils.context.ProposalsContext;
import org.xcolab.portlets.proposals.utils.context.ProposalsContextUtil;
import org.xcolab.util.enums.proposal.PlanSectionTypeKeys;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;


@Controller
@RequestMapping("view")
public class ProposalRevertActionController {

    @Autowired
    private ProposalsContext proposalsContext;

    @RequestMapping(params = "action=proposalRevert")
    public void showProposalRevert(ActionRequest request, Model model,
                                    ActionResponse response)

    throws ProposalsAuthorizationException, IOException {

        if (proposalsContext.getProposal(request) != null && !proposalsContext.getPermissions(request).getCanEdit()) {
            throw new ProposalsAuthorizationException("User is not allowed to edit proposal, user: "
                    + proposalsContext.getMember(request).getUserId() + ", proposal: "
                    + proposalsContext.getProposal(request).getProposalId());
        }

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        long userId = themeDisplay.getUserId();

        if (proposalsContext.getProposal(request) != null) {
            Proposal oldProposalVersionToBeBecomeCurrent = proposalsContext.getProposalWrapped(request);
            updateProposalSpecialAttributes(userId, oldProposalVersionToBeBecomeCurrent);

            updateProposalAttributes(request, userId, oldProposalVersionToBeBecomeCurrent);

            proposalsContext.invalidateContext(request);

            request.setAttribute("ACTION_REDIRECTING", true);
            response.sendRedirect((oldProposalVersionToBeBecomeCurrent).getBaseProposal().getProposalUrl());
        }
    }

    private void updateProposalAttributes(ActionRequest request, long userId, Proposal oldProposalVersionToBeBecomeCurrent) {
        boolean updateProposalReferences = false;
        for (PlanSectionDefinition section: oldProposalVersionToBeBecomeCurrent.getSections()) {
            String newSectionValue = section.getStringValue();
            if (section.getType() == PlanSectionTypeKeys.TEXT
                    || section.getType() == PlanSectionTypeKeys.PROPOSAL_LIST_TEXT_REFERENCE
                    || section.getType() == PlanSectionTypeKeys.DROPDOWN_MENU) {

                ProposalAttributeClientUtil.setProposalAttribute(userId,
                        oldProposalVersionToBeBecomeCurrent.getProposalId(),
                        ProposalAttributeKeys.SECTION, section.getSectionDefinitionId(), newSectionValue);

                if (section.getType() == PlanSectionTypeKeys.PROPOSAL_LIST_TEXT_REFERENCE) {
                    updateProposalReferences = true;
                }
            }
            if (section.getType() == PlanSectionTypeKeys.ONTOLOGY_REFERENCE) {
                if (StringUtils.isNumeric(newSectionValue)) {
                    long newNumericVal = Long.parseLong(newSectionValue);
                    if (newNumericVal != section.getNumericValue()) {
                        ProposalAttributeClientUtil.setProposalAttribute(userId,
                                oldProposalVersionToBeBecomeCurrent.getProposalId(), ProposalAttributeKeys.SECTION, section.getSectionDefinitionId(), newNumericVal);
                    }
                }
            }
            if (section.getType() == PlanSectionTypeKeys.PROPOSAL_REFERENCE) {
                if (StringUtils.isNumeric(newSectionValue) && StringUtils.isNotBlank(newSectionValue)) {
                    final long newNumericValue = Long.parseLong(newSectionValue);
                    if (section.getNumericValue() != newNumericValue) {
                        ProposalAttributeClientUtil.setProposalAttribute(userId, oldProposalVersionToBeBecomeCurrent.getProposalId(), ProposalAttributeKeys.SECTION, section.getSectionDefinitionId(), newNumericValue);
                        updateProposalReferences = true;
                    }
                } else if (StringUtils.isBlank(newSectionValue)) {
                    ProposalAttributeClientUtil.setProposalAttribute(userId, oldProposalVersionToBeBecomeCurrent.getProposalId(), ProposalAttributeKeys.SECTION, section.getSectionDefinitionId(), 0L);
                }
            }
            if (section.getType() == PlanSectionTypeKeys.PROPOSAL_LIST_REFERENCE) {
                StringBuilder cleanedReferences = new StringBuilder();
                if (StringUtils.isNotBlank(newSectionValue)){
                    String[]referencedProposals = newSectionValue.split(",");
                    for (String referencedProposal : referencedProposals) {
                        if (StringUtils.isNotBlank(referencedProposal) && StringUtils.isNumeric(referencedProposal)) {
                            cleanedReferences.append(referencedProposal).append(",");
                        }
                    }
                }
                if (!section.getStringValue().equals(cleanedReferences.toString())) {
                    ProposalAttributeClientUtil.setProposalAttribute(userId, oldProposalVersionToBeBecomeCurrent.getProposalId(), ProposalAttributeKeys.SECTION, section.getSectionDefinitionId(), cleanedReferences.toString());
                    updateProposalReferences = true;
                }
            }
        }

        //this code was on the proposal add/update controller, if the user could edit and save , he might just want to revert
        // and leave it like that , so this code must be executed as well.
        final Proposal2Phase p2p = proposalsContext.getProposal2Phase(request);
        try {
            if (p2p != null && p2p.getVersionTo() != -1) {
                // we are in a completed phase - need to adjust the end version
                final Proposal updatedProposal = ProposalsContextUtil.getClients(request).getProposalClient().getProposal(oldProposalVersionToBeBecomeCurrent.getProposalId());
                p2p.setVersionTo(updatedProposal.getCurrentVersion());
                proposalsContext.getClients(request).getProposalPhaseClient().updateProposal2Phase(p2p);
            }
            // extra check to reset dependencies from the old versions
            if (updateProposalReferences) {
                ProposalClientUtil
                        .populateTableWithProposal(oldProposalVersionToBeBecomeCurrent.getWrapped().getProposalId());
            }
        }catch (ProposalNotFoundException ignored){

        }
    }

    private void updateProposalSpecialAttributes(long userId, Proposal oldProposalVersionToBeBecomeCurrent) {
        ProposalAttributeClientUtil.setProposalAttribute(userId,  oldProposalVersionToBeBecomeCurrent.getProposalId(), ProposalAttributeKeys.NAME,0l, oldProposalVersionToBeBecomeCurrent.getName());
        ProposalAttributeClientUtil.setProposalAttribute(userId, oldProposalVersionToBeBecomeCurrent.getProposalId(), ProposalAttributeKeys.PITCH,0l, oldProposalVersionToBeBecomeCurrent.getPitch());
        ProposalAttributeClientUtil.setProposalAttribute(userId, oldProposalVersionToBeBecomeCurrent.getProposalId(), ProposalAttributeKeys.DESCRIPTION,0l, oldProposalVersionToBeBecomeCurrent.getDescription());
        ProposalAttributeClientUtil.setProposalAttribute(userId, oldProposalVersionToBeBecomeCurrent.getProposalId(), ProposalAttributeKeys.TEAM,0l, oldProposalVersionToBeBecomeCurrent.getTeam());
        ProposalAttributeClientUtil.setProposalAttribute(userId, oldProposalVersionToBeBecomeCurrent.getProposalId(), ProposalAttributeKeys.IMAGE_ID,0l, oldProposalVersionToBeBecomeCurrent.getImageId());
    }
}
