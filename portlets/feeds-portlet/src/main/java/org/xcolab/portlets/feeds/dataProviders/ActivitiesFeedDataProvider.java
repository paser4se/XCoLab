package org.xcolab.portlets.feeds.dataProviders;

import org.springframework.ui.Model;

import org.xcolab.client.activities.ActivitiesClientUtil;
import org.xcolab.client.activities.pojo.ActivityEntry;
import org.xcolab.client.members.MembersClient;
import org.xcolab.client.members.PermissionsClient;
import org.xcolab.client.members.pojo.Member;
import org.xcolab.commons.beans.SortFilterPage;
import org.xcolab.entity.utils.portlet.PortletUtil;
import org.xcolab.portlets.feeds.FeedTypeDataProvider;
import org.xcolab.portlets.feeds.FeedsPreferences;
import org.xcolab.portlets.feeds.wrappers.SocialActivityWrapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;

public class ActivitiesFeedDataProvider implements FeedTypeDataProvider {

	@Override
	public String populateModel(PortletRequest request,
								PortletResponse response, SortFilterPage sortFilterPage,
								FeedsPreferences feedsPreferences, Model model) {


            HttpServletRequest originalRequest = PortletUtil.getHttpServletRequest(request);

            Map<String, String[]> parameters = request.getParameterMap();
            final int pageSize = feedsPreferences.getFeedSize();
            String userIdStr = null;
            if (parameters.containsKey("userId")) {
                userIdStr = parameters.get("userId")[0];
            } else if (originalRequest.getParameter("userId") != null) {
                userIdStr = originalRequest.getParameter("userId");
            }
            long filterUserId = 0L;
            if (userIdStr != null) {
                try {
                    filterUserId = Long.parseLong(userIdStr);
                    Member filterUser = MembersClient.getMember(filterUserId);
                    model.addAttribute("filterUserId", filterUserId);
                    model.addAttribute("filterUser", filterUser);
                } catch (Throwable ignored) {
                }
            }

            List<ActivityEntry> windowedActivities;
            int startRetrievalAt = sortFilterPage.getPage() * pageSize;
            int endRetrievalAt = (sortFilterPage.getPage() + 1) * pageSize;
            if (filterUserId == 0) {
                windowedActivities = ActivitiesClientUtil
                        .getActivityEntries(startRetrievalAt, endRetrievalAt, null, null);

            } else {
                windowedActivities = ActivitiesClientUtil
                        .getActivityEntries(startRetrievalAt, endRetrievalAt, filterUserId, null);
            }

            int lastDaysBetween = -1;
            int i = 0;
            List<SocialActivityWrapper> activities = new ArrayList<>();
            Date now = new Date();
            for (ActivityEntry activity : windowedActivities) {

                if (SocialActivityWrapper.isEmpty(activity, request)) {
                    continue;
                }
                if (!feedsPreferences.getRemoveAdmin() && PermissionsClient.canAdminAll(activity.getMemberId())) {
                    continue;
                }
                if (PermissionsClient.canStaff(activity.getMemberId())) {
                    continue;
                }
                if (i >= feedsPreferences.getFeedSize()) {
                    break;
                }

                int curDaysBetween =
                        getDaysBetween(new Date(activity.getCreateDate().getTime()), now);
                activities.add(new SocialActivityWrapper(activity, curDaysBetween,
                        lastDaysBetween < curDaysBetween, i % 2 == 1, request,
                        feedsPreferences.getFeedMaxLength()));
                lastDaysBetween = curDaysBetween;
                i++;
            }

            model.addAttribute("activities", activities);

            int activitiesCount  = ActivitiesClientUtil.countActivities(filterUserId,null);
            if (filterUserId == 0) {
                model.addAttribute("isLastPage",
                        ((pageSize * (sortFilterPage.getPage() + 1)) >= activitiesCount));
            } else {
                model.addAttribute("isLastPage",
                        ((pageSize * (sortFilterPage.getPage() + 1) >= activitiesCount)));
            }

            return "activities";

    }
    private static int getDaysBetween(Date d1, Date d2){
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }
}
