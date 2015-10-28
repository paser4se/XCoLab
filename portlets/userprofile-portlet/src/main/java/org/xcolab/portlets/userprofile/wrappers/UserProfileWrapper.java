package org.xcolab.portlets.userprofile.wrappers;

import com.ext.portlet.Activity.ActivityUtil;
import com.ext.portlet.community.CommunityConstants;
import com.ext.portlet.messaging.MessageConstants;
import com.ext.portlet.messaging.MessageUtil;
import com.ext.portlet.model.Message;
import com.ext.portlet.model.Proposal;
import com.ext.portlet.model.ProposalSupporter;
import com.ext.portlet.service.ActivitySubscriptionLocalServiceUtil;
import com.ext.portlet.service.PointsLocalServiceUtil;
import com.ext.portlet.service.Proposal2PhaseLocalServiceUtil;
import com.ext.portlet.service.ProposalLocalServiceUtil;
import com.ext.portlet.service.ProposalSupporterLocalServiceUtil;
import com.ext.portlet.service.Xcolab_UserLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;
import com.liferay.portlet.social.model.SocialActivity;
import com.liferay.portlet.social.service.SocialActivityLocalServiceUtil;
import org.xcolab.enums.MemberRole;
import org.xcolab.portlets.userprofile.beans.BadgeBean;
import org.xcolab.portlets.userprofile.beans.MessageBean;
import org.xcolab.portlets.userprofile.beans.UserBean;
import org.xcolab.portlets.userprofile.entity.Badge;
import org.xcolab.utils.SendMessagePermissionChecker;
import org.xcolab.wrappers.BaseProposalWrapper;

import javax.portlet.PortletRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserProfileWrapper implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final long DEFAULT_COMPANY_ID = 10112L;
    private User user;
    private UserBean userBean;

    private String realName;
    private Boolean attendsConference;
    private MemberRole role;
    private int subscriptionsPageSize = 20;
    private int subscriptionsPaginationPageId;
    private static final int MAX_ACTIVITIES_COUNT = 50;

    private SendMessagePermissionChecker messagePermissionChecker;
    private List<MessageBean> messages;
    private final List<SupportedProposalWrapper> supportedProposals = new ArrayList<>();
    private final List<BaseProposalWrapper> userProposals = new ArrayList<>();
    private List<BaseProposalWrapper> linkingProposals;
    private final ArrayList<UserActivityWrapper> userActivities = new ArrayList<>();
    private List<UserActivityWrapper> subscribedActivities;
    private UserSubscriptionsWrapper userSubscriptions;
    private BadgeBean badges;

    private static final boolean FIRE_GOOGLE_EVENT = false;
    private static final boolean DISPLAY_EMAIL_ERROR_MESSAGE = false;
    private boolean viewingOwnProfile;

    private String messagingPortletId = "messagingportlet_WAR_messagingportlet";
    private final ThemeDisplay themeDisplay;

    private final static Log _log = LogFactoryUtil.getLog(UserProfileWrapper.class);

    public UserProfileWrapper(String userIdString, PortletRequest request) throws PortalException, SystemException {
        Long userId = Long.parseLong(userIdString);
        themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        user = UserLocalServiceUtil.getUser(userId);
        if (user.isActive()) {
            User loggedInUser = com.liferay.portal.util.PortalUtil.getUser(request);
            if (loggedInUser != null) {
                messagePermissionChecker = new SendMessagePermissionChecker(loggedInUser);
                if(loggedInUser.getUserId() == user.getUserId()) {
                    viewingOwnProfile = true;
                }
            }
            init(user);
        }
    }

    private void init(User user) throws PortalException, SystemException {
        this.user = user;

        userBean = new UserBean(user);
        realName = getName(user.getFullName(), user.getScreenName());

        String firstPart = realName.substring(0, realName.length() / 2).trim();
        String secondPart = realName.substring(realName.length() / 2).trim();

        if (firstPart.equals(secondPart)) {
            realName = user.getFirstName();
        }

        attendsConference = ExpandoValueLocalServiceUtil.getData(DEFAULT_COMPANY_ID, User.class.getName(), CommunityConstants.EXPANDO, CommunityConstants.CONFERENCE2014, user.getUserId(), "").equals("1");
        badges = new BadgeBean(user.getUserId());

        List<Role> roles = user.getRoles();
        // Determine the highest role of the user (copied from {@link org.xcolab.portlets.members.MemberListItemBean})
        role = MemberRole.MEMBER;

        for (Role r: roles) {
            final String roleString = r.getName();

            MemberRole currentRole = MemberRole.getMember(roleString);
            if (currentRole != null && role != null) {
                if (currentRole.ordinal() > role.ordinal()) {
                    role = currentRole;
                }
            }
        }

        if (role == MemberRole.MODERATOR) {
            role = MemberRole.STAFF;
        }

        userSubscriptions = new UserSubscriptionsWrapper(user);
        supportedProposals.clear();
        userActivities.clear();
        userProposals.clear();
        for (Object o : ProposalSupporterLocalServiceUtil.getProposals(user.getUserId())) {
            ProposalSupporter ps = (ProposalSupporter) o;
            try {
                Proposal2PhaseLocalServiceUtil.getCurrentContestForProposal(ps.getProposalId());
                supportedProposals.add(new SupportedProposalWrapper(ps));
            } catch (SystemException | PortalException e) {
                _log.warn("Could not add supported plan with id: " + ps.getProposalId());
                //e.printStackTrace();
            }
        }

        for (SocialActivity activity : ActivityUtil.groupActivities(SocialActivityLocalServiceUtil
                .getUserActivities(user.getUserId(), 0, MAX_ACTIVITIES_COUNT))) {

            UserActivityWrapper a = new UserActivityWrapper(activity, themeDisplay);
            if (a.getBody() != null && !a.getBody().equals("")) {
                userActivities.add(a);
            }
        }

        List<Proposal> proposals = ProposalLocalServiceUtil.getUserProposals(user.getUserId());
        for (Proposal p : proposals) {
            userProposals.add(new BaseProposalWrapper(p));
        }
    }

    private boolean profileIsComplete() {
        //ignore mandatory fields, only care about optional ones
        String[] blankCheck = {userBean.getShortBio(), userBean.getCountry()};
        for (String s : blankCheck) {
            if (s == null || s.equals(StringPool.BLANK)) {
                return false;
            }
        }

        return true;
    }

    public boolean isStaffMemberProfile(){
        return this.role == MemberRole.STAFF;
    }

    public boolean isInitialized() {
        return this.user != null;
    }

    public boolean isActive() {
        return user != null && user.isActive();
    }

    public boolean isViewingOwnProfile() {
        return viewingOwnProfile;
    }

    public void setUser(User user){ this.user=user; }

    public User getUser(){ return user; }

    public Long getUserId() {
        return user.getUserId();
    }

    public UserBean getUserBean(){ return userBean; }

    public void setUserBean(UserBean userBean){ this.userBean=userBean; }

    private String getName(String name, String defaultName) {
        if (name == null || name.trim().equals("")) {
            return defaultName;
        }
        return name;
    }

    public Date getJoinDate() { return user.getCreateDate(); }

    public Boolean getAttendsConference() { return attendsConference; }

    public void setAttendsConference(Boolean attendsConference) { this.attendsConference = attendsConference; }

    public String getRealName() { return realName; }

    public UserSubscriptionsWrapper getUserSubscriptions(){return userSubscriptions;}

    public int getSubscriptionsPageSize(){return subscriptionsPageSize; }

    public void setSubscriptionsPageSize(int subscriptionsPageSize) {this.subscriptionsPageSize = subscriptionsPageSize;}

    public int getSubscriptionsPaginationPageId() {return subscriptionsPaginationPageId;}

    public void setSubscriptionsPaginationPageId(int subscriptionsPaginationPageId){this.subscriptionsPaginationPageId = subscriptionsPaginationPageId;}

    public int getSubscriptionsPaginationPageMax(){
        if (subscribedActivities != null && subscriptionsPageSize != 0) {
            double d1=subscribedActivities.size();
            double d2=subscriptionsPageSize;
            return (int) Math.ceil(d1/d2);
        }
        return 0;
    }

    public int getSubscribedActivitiesCount() {
        if (subscribedActivities != null) {
            return subscribedActivities.size();
        }
        return 0;
    }

    // TODO check this
    // public void setAbout(String about) throws UserInputException { this.about = UserInputFilterUtil.filterHtml(about); }
    //public String getFilteredAbout() {        return filteredAbout;    }

    public boolean getHasFacebookId() {
        return user.getFacebookId() != 0;
    }

    public boolean getHasOpenId() {
        return (user.getOpenId() != null && !user.getOpenId().isEmpty());
    }

    public void setMessagingPortletId(String messagingPortletId) {
        this.messagingPortletId = messagingPortletId;
    }

    public String getMessagingPortletId() {
        return messagingPortletId;
    }

    public User getWrapped() {
        return user;
    }

    public boolean isFireGoogleEvent() {
        return FIRE_GOOGLE_EVENT;
    }

    public MemberRole getRole() { return role; }

    public boolean isDisplayEMailErrorMessage() {
        return DISPLAY_EMAIL_ERROR_MESSAGE;
    }

    public ThemeDisplay getThemeDisplay() {
        return themeDisplay;
    }

    public boolean getCanSendMessage() throws SystemException {
        return messagePermissionChecker != null && messagePermissionChecker.canSendToUser(this.user);
    }

    public List<MessageBean> getMessages() throws SystemException, PortalException {
        if (messages == null) {
            messages = new ArrayList<MessageBean>();
            for (Message msg: MessageUtil.getMessages(this.user.getUserId(), 0, 2, MessageConstants.INBOX)) {
                messages.add(new MessageBean(msg));
            }
        }
        return messages;
    }

    public List<UserActivityWrapper> getSubscribedActivities() throws SystemException, PortalException {
        if (subscribedActivities == null) {
            subscribedActivities = new ArrayList<UserActivityWrapper>();
            for (SocialActivity activity: ActivityUtil.groupActivities(ActivitySubscriptionLocalServiceUtil.getActivities(this.user.getUserId(), 0, 1000))) {
                try {
                    subscribedActivities.add(new UserActivityWrapper(activity, themeDisplay));
                } catch (Exception ignored) { }
            }
        }
        return subscribedActivities;
    }

    public List<SupportedProposalWrapper> getSupportedProposals() { return supportedProposals; }

    public List<UserActivityWrapper> getActivities() { return userActivities; }

    public List<BaseProposalWrapper> getProposals() { return userProposals; }

    public List<Badge> getBadges() { return badges.getBadges(); }

    public long getUserActivityCount() {
        try {
            return Xcolab_UserLocalServiceUtil.getUserActivityCount(getUserId()).get(0);
        } catch (SystemException e) {
            return 0;
        }
    }

    public String getUserActivityCountFormatted() {
        return String.format("%,d", getUserActivityCount());
    }

    public long getActualPoints() {
        try {
            return PointsLocalServiceUtil.getUserMaterializedPoints(getUserId());
        } catch (SystemException e) {
            return 0;
        }
    }

    public String getActualPointsFormatted() {
        return String.format("%,d", getActualPoints());
    }

    public long getPotentialPoints() {
        try {
            return PointsLocalServiceUtil.getUserHypotheticalPoints(getUserId());
        } catch (SystemException e) {
            return 0;
        }
    }

    public String getPotentialPointsFormatted() {
        return String.format("%,d", getPotentialPoints());
    }

    public List<BaseProposalWrapper> getLinkingProposals() {
        if (linkingProposals == null) {
            try {
                linkingProposals = new ArrayList<>();
                List<Proposal> proposals = PointsLocalServiceUtil.getLinkingProposalsForUser(getUserId());
                for (Proposal p : proposals) {
                    linkingProposals.add(new BaseProposalWrapper(p));
                }
            } catch (PortalException | SystemException ignored) { }
        }
        return linkingProposals;
    }
}
