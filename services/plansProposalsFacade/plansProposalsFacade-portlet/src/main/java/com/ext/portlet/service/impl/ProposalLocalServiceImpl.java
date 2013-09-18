package com.ext.portlet.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.ext.portlet.NoSuchProposalAttributeException;
import com.ext.portlet.discussions.DiscussionActions;
import com.ext.portlet.model.DiscussionCategoryGroup;
import com.ext.portlet.model.Proposal;
import com.ext.portlet.model.ProposalAttribute;
import com.ext.portlet.model.ProposalVersion;
import com.ext.portlet.service.base.ProposalLocalServiceBaseImpl;
import com.ext.portlet.service.persistence.ProposalAttributePK;
import com.ext.portlet.service.persistence.ProposalVersionPK;
import com.ext.utils.PortalServicesHelper;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the proposal local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.ext.portlet.service.ProposalLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author janusz
 * @see com.ext.portlet.service.base.ProposalLocalServiceBaseImpl
 * @see com.ext.portlet.service.ProposalLocalServiceUtil
 */
public class ProposalLocalServiceImpl extends ProposalLocalServiceBaseImpl {

    /**
     * Default community permissions for community forum category.
     */
    public static final String[] DEFAULT_CATEGORY_COMMUNITY_PERMISSIONS = { ActionKeys.VIEW, ActionKeys.SUBSCRIBE,
            ActionKeys.REPLY_TO_MESSAGE, ActionKeys.ADD_MESSAGE };

    /**
     * Default guest permissions for community forum category.
     */
    public static final String[] DEFAULT_CATEGORY_GUEST_PERMISSIONS = { ActionKeys.VIEW, ActionKeys.SUBSCRIBE };

    /**
     * Default description of group working on a plan.
     */
    public static final String DEFAULT_GROUP_DESCRIPTION = "Group working on plan %s";
    
    /**
     * Service helper for accessing external services
     */
    private PortalServicesHelper portalServicesHelper;
    
    /**
     * Setter for PortalServicesHelper. 
     * @param portalServicesHelper
     */
    public ProposalLocalServiceImpl(PortalServicesHelper portalServicesHelper) {
        this.portalServicesHelper = portalServicesHelper;
    }

    /**
     * <p>
     * Creates new proposal initialized to version 1 with one attribute "NAME"
     * set to "Untitled proposal - PROPOSAL_ID". All related entities are
     * created:
     * </p>
     * <ul>
     * <li>liferay group</li>
     * <li>discussion for proposal comments</li>
     * <li>discussion for judges</li>
     * <li>discussion for advisors</li>
     * <li>discussion for</li>
     * </ul>
     * <p>
     * Creation of all entities is wrapped into a transaction.
     * </p>
     * 
     * @param authorId
     *            id of proposal author
     * @return created proposal
     * @throws SystemException
     *             in case of a Liferay error
     * @throws PortalException
     *             in case of a Liferay error
     *             
     * @author janusz
     */
    @Transactional
    public Proposal create(long authorId) throws SystemException, PortalException {

        long proposalId = portalServicesHelper.getCounterLocalService().increment(Proposal.class.getName());
        Proposal proposal = createProposal(proposalId);
        proposal.setVisible(true);
        proposal.setAuthorId(authorId);
        proposal.setCreateDate(new Date());

        // create discussions
        DiscussionCategoryGroup proposalDiscussion = discussionCategoryGroupLocalService
                .createDiscussionCategoryGroup("Proposal " + proposalId + " main discussion");
        proposal.setDiscussionId(proposalDiscussion.getId());

        DiscussionCategoryGroup judgesDiscussion = discussionCategoryGroupLocalService
                .createDiscussionCategoryGroup("Proposal " + proposalId + " judges discussion");
        proposal.setJudgeDiscussionId(judgesDiscussion.getId());

        DiscussionCategoryGroup advisorsDiscussion = discussionCategoryGroupLocalService
                .createDiscussionCategoryGroup("Proposal " + proposalId + " judges discussion");
        proposal.setAdvisorDiscussionId(advisorsDiscussion.getId());

        DiscussionCategoryGroup fellowsDiscussion = discussionCategoryGroupLocalService
                .createDiscussionCategoryGroup("Proposal " + proposalId + " judges discussion");
        proposal.setFellowDiscussionId(fellowsDiscussion.getId());

        // create group
        Group group = createGroupAndSetUpPermissions(authorId, proposalId);
        proposal.setGroupId(group.getGroupId());
        
        
        addProposal(proposal);

        return proposal;
    }

    /**
     * <p>Sets attribute value and creates new version for a proposal that reflects the change</p>
     * <p>The algorithm for setting an attribute value is as follows:</p>
     * <ol>
     *  <li>new proposal version is created</li>
     *  <li>for each attribute that was already present in the proposal (excluding the one that is currently being set)
     *      it is copied to the new version</li>
     *  <li>for attribute that is being set it's value (if present) isn't copied to the new version as it gets new value</li>
     * </ol>
     * 
     * @param authorId id of a change author
     * @param proposalId id of a proposal
     * @param attributeName name of an attribute
     * @param additionalId additional id for an attribute
     * @param stringValue string value for an attribute
     * @param numericValue numeric value for an attribute
     * @param doubleValue double value for an attribute
     * 
     * @return ProposalAttribute that represents newly set attribute
     * 
     * @throws PortalException in case of an LR error
     * @throws SystemException in case of an LR error
     * 
     * @author janusz 
     */
    @Transactional
    public ProposalAttribute setAttribute(long authorId, long proposalId, String attributeName, long additionalId,
            String stringValue, long numericValue, double realValue) throws PortalException, SystemException {
        Proposal proposal = getProposal(proposalId);

        int currentVersion = proposal.getCurrentVersion();
        int newVersion = currentVersion + 1;

        proposal.setCurrentVersion(newVersion);

        // find attributes for current version of a proposal
        List<ProposalAttribute> currentProposalAttributes = proposalAttributePersistence.findByProposalIdVersion(
                proposalId, currentVersion);

        // for each attribute, if it isn't the one that we are changing, simply
        // update it to the most recent version
        // if it is the one that we are changing then leave old one as it is and
        // create new one with for new proposal version
        for (ProposalAttribute attribute : currentProposalAttributes) {
            if (!attributeName.equals(attribute.getName()) || additionalId != attribute.getAdditionalId()) {
                // clone the attribute and set its version to the new value
                ProposalAttribute newAttribute = (ProposalAttribute) attribute.clone();
                newAttribute.setNew(true);
                
                newAttribute.setVersion(newVersion);
                proposalAttributeLocalService.addProposalAttribute(newAttribute);
            }
        }

        // set new value for provided attribute
        ProposalAttribute attribute = setAttributeValue(proposalId, newVersion, attributeName, additionalId, stringValue, numericValue, realValue);

        // create newly created version descriptor
        createPlanVersionDescription(authorId, proposalId, newVersion, attributeName, additionalId);
        updateProposal(proposal);
        
        return attribute;
    }
    
    /**
     * <p>Sets an attribute for a proposal. See  {@link #setAttribute(long, long, String, long, String, long, double)} 
     * it uses nulls/zeros for unspecified values</p>
     * @param authorId
     * @param proposalId
     * @param attributeName
     * @param additionalId
     * @param stringValue
     * @return
     * @throws PortalException
     * @throws SystemException
     */
    public ProposalAttribute setAttribute(long authorId, long proposalId, String attributeName,
            String stringValue, long numericValue, double realValue) throws PortalException, SystemException {
        return setAttribute(authorId, proposalId, attributeName, 0L, stringValue, numericValue, realValue);
    }
    
    /**
     * <p>Sets an attribute for a proposal. See  {@link #setAttribute(long, long, String, long, String, long, double)} 
     * it uses nulls/zeros for unspecified values</p>
     * @param authorId
     * @param proposalId
     * @param attributeName
     * @param additionalId
     * @param stringValue
     * @return
     * @throws PortalException
     * @throws SystemException
     */
    public ProposalAttribute setAttribute(long authorId, long proposalId, String attributeName, long additionalId, String stringValue) throws PortalException, SystemException {
        return setAttribute(authorId, proposalId, attributeName, additionalId, stringValue, 0, 0);
    }
    
    /**
     * <p>Sets an attribute for a proposal. See  {@link #setAttribute(long, long, String, long, String, long, double)} 
     * it uses nulls/zeros for unspecified values</p>
     * @param authorId
     * @param proposalId
     * @param attributeName
     * @param additionalId
     * @param stringValue
     * @return
     * @throws PortalException
     * @throws SystemException
     */
    public ProposalAttribute setAttribute(long authorId, long proposalId, String attributeName, String stringValue) throws PortalException, SystemException {
        return setAttribute(authorId, proposalId, attributeName, 0, stringValue, 0, 0);
    }
    
    /**
     * <p>Sets an attribute for a proposal. See  {@link #setAttribute(long, long, String, long, String, long, double)} 
     * it uses nulls/zeros for unspecified values</p>
     * @param authorId
     * @param proposalId
     * @param attributeName
     * @param additionalId
     * @param numericValue
     * @return
     * @throws PortalException
     * @throws SystemException
     */
    public ProposalAttribute setAttribute(long authorId, long proposalId, String attributeName, long additionalId, long numericValue) throws PortalException, SystemException {
        return setAttribute(authorId, proposalId, attributeName, additionalId, null, numericValue, 0);
    }
    
    /**
     * <p>Sets an attribute for a proposal. See  {@link #setAttribute(long, long, String, long, String, long, double)} 
     * it uses nulls/zeros for unspecified values</p>
     * @param authorId
     * @param proposalId
     * @param attributeName
     * @param additionalId
     * @param numericValue
     * @return
     * @throws PortalException
     * @throws SystemException
     */
    public ProposalAttribute setAttribute(long authorId, long proposalId, String attributeName, long numericValue) throws PortalException, SystemException {
        return setAttribute(authorId, proposalId, attributeName, 0, null, numericValue, 0);
    }
    
    /**
     * <p>Sets an attribute for a proposal. See  {@link #setAttribute(long, long, String, long, String, long, double)} 
     * it uses nulls/zeros for unspecified values</p>
     * @param authorId
     * @param proposalId
     * @param attributeName
     * @param additionalId
     * @param realValue
     * @return
     * @throws PortalException
     * @throws SystemException
     */
    public ProposalAttribute setAttribute(long authorId, long proposalId, String attributeName, long additionalId, double realValue) throws PortalException, SystemException {
        return setAttribute(authorId, proposalId, attributeName, additionalId, null, 0, realValue);
    }
    
    /**
     * <p>Sets an attribute for a proposal. See  {@link #setAttribute(long, long, String, long, String, long, double)} 
     * it uses nulls/zeros for unspecified values</p>
     * @param authorId
     * @param proposalId
     * @param attributeName
     * @param additionalId
     * @param realValue
     * @return
     * @throws PortalException
     * @throws SystemException
     */
    public ProposalAttribute setAttribute(long authorId, long proposalId, String attributeName, double realValue) throws PortalException, SystemException {
        return setAttribute(authorId, proposalId, attributeName, 0, null, 0, realValue);
    }
    
    /**
     * <p>Returns all attributes for current version of a proposal.</p>
     * 
     * @param proposalId id of a proposal
     * @return list of proposal attributes for current version of a proposal
     * 
     * @throws PortalException in case of an LR error
     * @throws SystemException in case of an LR error
     * 
     * @author janusz
     */
    public List<ProposalAttribute> getAttributes(long proposalId) throws SystemException, PortalException {
        Proposal proposal = getProposal(proposalId);
        
        return getAttributes(proposalId, proposal.getCurrentVersion());
    }
    
    /**
     * <p>Returns all attributes for given version of a proposal.</p>
     * 
     * @param proposalId id of a proposal
     * @param version version number of a proposal
     * 
     * @return list of proposal attributes for current version of a proposal
     * 
     * @throws PortalException in case of an LR error
     * @throws SystemException in case of an LR error
     * 
     * @author janusz
     */
    public List<ProposalAttribute> getAttributes(long proposalId, int version) throws SystemException, PortalException {
        return proposalAttributePersistence.findByProposalIdVersion(proposalId, version);   
    }
    
    /**
     * <p>Returns an attribute for current version of a proposal.</p>
     * 
     * @param proposalId id of a proposal
     * @param attributeName name of an attribute
     * @param additionalId additionalId of an attribute
     * 
     * @return proposal attribute
     * 
     * @throws PortalException in case of an LR error
     * @throws SystemException in case of an LR error
     * 
     * @author janusz
     */
    public ProposalAttribute getAttribute(long proposalId, String attributeName, long additionalId) throws PortalException, SystemException {
        Proposal proposal = getProposal(proposalId);
        return getAttribute(proposalId, proposal.getCurrentVersion(), attributeName, additionalId);
    }
    
    /**
     * <p>Returns an attribute for concrete version of a proposal.</p>
     * 
     * @param proposalId id of a proposal
     * @param version version of a proposal
     * @param attributeName name of an attribute
     * @param additionalId additionalId of an attribute
     * 
     * @return proposal attribute
     * 
     * @throws PortalException in case of an LR error
     * @throws SystemException in case of an LR error
     * 
     * @author janusz
     */
    public ProposalAttribute getAttribute(long proposalId, int version, String attributeName, long additionalId) throws NoSuchProposalAttributeException, SystemException {
        return proposalAttributePersistence.findByProposalIdVersionNameAdditionalId(proposalId, version, attributeName, additionalId);
    }
    
    /**
     * <p>Returns a list of all proposal version descriptors.</p>
     * 
     * @param proposalId id of a proposal
     * 
     * @return list of proposal versions covering entire change history for a proposal
     * 
     * @throws PortalException in case of an LR error
     * @throws SystemException in case of an LR error
     * 
     * @author janusz
     * 
     */
    public List<ProposalVersion> getProposalVersions(long proposalId) throws PortalException, SystemException {
        return proposalVersionPersistence.findByProposalId(proposalId);
    }
    
    /**
     * <p>Returns a concrete proposal version descriptor.</p>
     * 
     * @param proposalId id of a proposal
     * @param version version of a proposal
     * 
     * @return proposal version descriptor
     * 
     * @throws PortalException in case of an LR error
     * @throws SystemException in case of an LR error
     * 
     * @author janusz
     * 
     */
    public ProposalVersion getProposalVersion(long proposalId, int version) throws PortalException, SystemException {
        return proposalVersionLocalService.getProposalVersion(new ProposalVersionPK(proposalId, version));
    }
    

    /**
     * <p>Helper method that sets an attribute value by creating a new attribute and setting all values according to passed parameters. This method doesn't care about other attributes.</p>
     * 
     * @param proposalId id of a proposal
     * @param version proposal version
     * @param attributeName name of an attribute
     * @param additionalId additional id for an attribute
     * @param stringValue string value for an attribute
     * @param numericValue numeric value for an attribute
     * @param realValue real value for an attribute
     * @return newly created proposal attribute
     * @throws SystemException in case of a LR error
     * 
     * @author janusz
     */
    @Transactional
    private ProposalAttribute setAttributeValue(long proposalId, int version, String attributeName, long additionalId,
            String stringValue, long numericValue, double realValue) throws SystemException {
        ProposalAttribute attribute = proposalAttributeLocalService.createProposalAttribute(new ProposalAttributePK(
                proposalId, version, attributeName, additionalId));

        attribute.setNumericValue(numericValue);
        attribute.setStringValue(stringValue);
        attribute.setRealValue(realValue);

        proposalAttributeLocalService.addProposalAttribute(attribute);
        
        return attribute;
    }

    /**
     * <p>Creates a Liferay group for proposal and sets up proper permissions on it.</p>
     * 
     * @param authorId id of a proposal author
     * @param proposalId id of a proposal
     * @return newly created group
     * @throws PortalException in case on LR error
     * @throws SystemException in case on LR error
     * 
     * @author janusz
     */
    @Transactional
    private Group createGroupAndSetUpPermissions(long authorId, long proposalId) throws PortalException,
            SystemException {

        // create new gropu
        ServiceContext groupServiceContext = new ServiceContext();
        groupServiceContext.setUserId(authorId);
        String groupName = "Proposal_" + proposalId;

        Group group = portalServicesHelper.getGroupService().addGroup(StringUtils.substring(groupName, 0, 80),
                String.format(DEFAULT_GROUP_DESCRIPTION, StringUtils.substring(groupName, 0, 80)),
                GroupConstants.TYPE_SITE_RESTRICTED, null, true, true, groupServiceContext);

        // set up permissions
        Long companyId = group.getCompanyId();
        Role owner = portalServicesHelper.getRoleLocalService().getRole(companyId, RoleConstants.SITE_OWNER);
        Role admin = portalServicesHelper.getRoleLocalService().getRole(companyId, RoleConstants.SITE_ADMINISTRATOR);
        Role member = portalServicesHelper.getRoleLocalService().getRole(companyId, RoleConstants.SITE_MEMBER);
        Role userRole = portalServicesHelper.getRoleLocalService().getRole(companyId, RoleConstants.USER);
        Role guest = portalServicesHelper.getRoleLocalService().getRole(companyId, RoleConstants.GUEST);
        Role moderator = portalServicesHelper.getRoleLocalService().getRole(companyId, "Moderator");

        String[] ownerActions = { DiscussionActions.ADMIN.name(), DiscussionActions.ADD_CATEGORY.name(),
                DiscussionActions.ADD_MESSAGE.name(), DiscussionActions.ADD_THREAD.name(),
                DiscussionActions.ADMIN_CATEGORIES.name(), DiscussionActions.ADMIN_MESSAGES.name(),
                DiscussionActions.ADD_COMMENT.name() };

        String[] adminActions = { DiscussionActions.ADD_CATEGORY.name(), DiscussionActions.ADD_MESSAGE.name(),
                DiscussionActions.ADD_THREAD.name(), DiscussionActions.ADMIN_CATEGORIES.name(),
                DiscussionActions.ADMIN_MESSAGES.name(), DiscussionActions.ADD_COMMENT.name() };

        String[] moderatorActions = { DiscussionActions.ADD_CATEGORY.name(), DiscussionActions.ADD_MESSAGE.name(),
                DiscussionActions.ADD_THREAD.name(), DiscussionActions.ADMIN_CATEGORIES.name(),
                DiscussionActions.ADMIN_MESSAGES.name(), DiscussionActions.ADD_COMMENT.name() };

        String[] memberActions = { DiscussionActions.ADD_CATEGORY.name(), DiscussionActions.ADD_MESSAGE.name(),
                DiscussionActions.ADD_THREAD.name(), DiscussionActions.ADD_COMMENT.name() };

        String[] userActions = { DiscussionActions.ADD_MESSAGE.name(), DiscussionActions.ADD_THREAD.name(),
                DiscussionActions.ADD_COMMENT.name() };

        String[] guestActions = {};

        Map<Role, String[]> rolesActionsMap = new HashMap<Role, String[]>();

        rolesActionsMap.put(owner, ownerActions);
        rolesActionsMap.put(admin, adminActions);
        rolesActionsMap.put(member, memberActions);
        rolesActionsMap.put(userRole, userActions);
        rolesActionsMap.put(guest, guestActions);
        rolesActionsMap.put(moderator, moderatorActions);

        for (Role role : rolesActionsMap.keySet()) {
            portalServicesHelper.getPermissionLocalService().setRolePermissions(role.getRoleId(), companyId,
                    DiscussionCategoryGroup.class.getName(), ResourceConstants.SCOPE_GROUP,
                    String.valueOf(group.getGroupId()), rolesActionsMap.get(role));
        }

        return group;
    }

    /**
     * <p>Creates new plan version descriptor</p>
     * 
     * @param authorId id of a change author
     * @param proposalId id of a proposal
     * @param version proposal version
     * @param updateType name of updated attribute
     * @param additionalId additional id of an updated attribute
     * @throws SystemException
     */
    @Transactional
    private void createPlanVersionDescription(long authorId, long proposalId, int version, String updateType,
            long additionalId) throws SystemException {

        ProposalVersion proposalVersion = proposalVersionLocalService.createProposalVersion(new ProposalVersionPK(
                proposalId, version));

        proposalVersion.setAuthorId(authorId);
        proposalVersion.setUpdateType(updateType);
        proposalVersion.setUpdateAdditionalId(additionalId);

        proposalVersionLocalService.addProposalVersion(proposalVersion);
    }



    private static Log _log = LogFactoryUtil.getLog(ProposalLocalServiceImpl.class);
}
