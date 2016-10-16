package org.xcolab.portlets.proposals.view.action;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.xcolab.client.proposals.ProposalAttributeClient;
import org.xcolab.client.proposals.pojo.attributes.ProposalUnversionedAttribute;
import org.xcolab.enums.ProposalUnversionedAttributeName;
import org.xcolab.portlets.proposals.exceptions.ProposalsAuthorizationException;
import org.xcolab.portlets.proposals.utils.context.ProposalsContext;
import org.xcolab.portlets.proposals.wrappers.ProposalTab;
import org.xcolab.portlets.proposals.wrappers.ProposalWrapper;
import org.xcolab.util.html.HtmlUtil;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;


@Controller
@RequestMapping("view")
public class UpdateProposalScenarioActionController {

    @Autowired
    private ProposalsContext proposalsContext;

    @RequestMapping(params = {"action=updateProposalScenario"})
    public void show(ActionRequest request, Model model,
            ActionResponse response,
                     @RequestParam long scenarioId,
                     @RequestParam long modelId,
                     @RequestParam(required = false) String region,
                     @RequestParam(required = false) String impactAuthorComment,
                     @RequestParam(required = false) String impactIAFComment,
                     @RequestParam(required = false) Boolean isConsolidatedScenario)
            throws ProposalsAuthorizationException, IOException {

        if (proposalsContext.getProposal(request) != null && !canEditImpactTab(request)){
            throw new ProposalsAuthorizationException("User is not allowed to edit proposal, user: "
                    + proposalsContext.getMember(request).getUserId() + ", proposal: "
                    + proposalsContext.getProposal(request).getProposalId());
        }

        ProposalWrapper proposal = proposalsContext.getProposalWrapped(request);
        Long consolidatedScenario = isConsolidatedScenario != null && isConsolidatedScenario ? 1L : 0L;
        proposal.setScenarioId(scenarioId, consolidatedScenario, proposalsContext.getMember(request).getUserId());

        if (StringUtils.isNotBlank(region)) {
            proposal.setModelRegion(region, proposalsContext.getMember(request).getUserId());
        }

        ProposalAttributeClient proposalAttributeClient = proposalsContext.getClients(request)
                .getProposalAttributeClient();

        List<ProposalUnversionedAttribute> unversionedAttributes = proposalAttributeClient.
                getProposalUnversionedAttributesByProposalId(proposal.getProposalId());

        if (impactAuthorComment != null || impactIAFComment != null) {
              if (impactAuthorComment != null) {

                  proposalAttributeClient.createOrUpdateProposalUnversionedAttribute(proposalsContext.getMember(request).getUserId(),
                          HtmlUtil.cleanAll(impactAuthorComment),
                          ProposalUnversionedAttributeName.IMPACT_AUTHOR_COMMENT.toString(),
                          proposal.getProposalId());
                }
                if (impactIAFComment != null) {
                    proposalAttributeClient.createOrUpdateProposalUnversionedAttribute(
                            proposalsContext.getMember(request).getUserId(),
                            HtmlUtil.cleanAll(impactIAFComment),
                            ProposalUnversionedAttributeName.IMPACT_IAF_COMMENT.toString(),
                            proposal.getProposalId());
                }
        }
        proposalsContext.invalidateContext(request);
        response.sendRedirect(proposal.getProposalUrl() + "/tab/IMPACT");
    }

    private boolean canEditImpactTab(PortletRequest request) {
        return ProposalTab.IMPACT.getCanEdit(
                proposalsContext.getPermissions(request), proposalsContext, request);
    }
}
