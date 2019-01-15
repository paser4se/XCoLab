package org.xcolab.client.activities;

import org.xcolab.client.activities.exceptions.ActivityEntryNotFoundException;
import org.xcolab.client.activities.exceptions.ActivitySubscriptionNotFoundException;
import org.xcolab.client.activities.pojo.IActivityEntry;
import org.xcolab.client.activities.pojo.IActivitySubscription;
import org.xcolab.util.activities.enums.ActivityCategory;
import org.xcolab.util.activities.enums.ActivityType;

import java.util.Date;
import java.util.List;

public class ActivitiesClientUtil {

    private static final ActivitiesClient activitiesClient = new ActivitiesClient();

    public static ActivitiesClient getClient() {
        return activitiesClient;
    }

    public static IActivityEntry createActivityEntry(ActivityType activityType, long userId,
            long categoryId) {
        return activitiesClient.createActivityEntry(activityType, userId, categoryId);
    }

    public static IActivityEntry createActivityEntry(ActivityType activityType, long userId,
            long categoryId, Long additionalId) {
        return activitiesClient.createActivityEntry(activityType, userId, categoryId,
                additionalId);
    }

    public static IActivityEntry getActivityEntry(Long activityEntryId)
            throws ActivityEntryNotFoundException {
        return activitiesClient.getActivityEntry(activityEntryId);
    }

    public static List<IActivityEntry> getActivityEntries(Integer startRecord,
            Integer limitRecord, Long userId, List<Long> userIdsToExclude) {
        return activitiesClient.getActivityEntries(startRecord,
                limitRecord, userId, userIdsToExclude);
    }

    public static List<IActivityEntry> getActivityEntriesAfter(Date afterDate) {
        return activitiesClient.getActivityEntriesAfter(afterDate);
    }

    public static int countActivities(Long userId, List<Long> userIdsToExclude) {
        return activitiesClient.countActivities(userId, userIdsToExclude);
    }

    public static IActivitySubscription getActivitySubscription(long activitySubscriptionId)
            throws ActivitySubscriptionNotFoundException {

        return activitiesClient.getActivitySubscription(activitySubscriptionId);
    }

    private static IActivitySubscription createActivitySubscription(
            IActivitySubscription activitySubscription) {
        return activitiesClient.createActivitySubscription(activitySubscription);
    }

    public static boolean deleteSubscription(Long pk) {
        return activitiesClient.deleteSubscription(pk);
    }

    public static IActivitySubscription addSubscription(long userId,
            ActivityCategory activityCategory, long categoryId, String extraInfo) {
        return activitiesClient.addSubscription(userId, activityCategory, categoryId, extraInfo);
    }

    public static boolean deleteSubscription(Long receiverId, ActivityCategory activityCategory,
            Long categoryId) {
        return activitiesClient.deleteSubscription(receiverId, activityCategory,
                categoryId);
    }

    public static boolean batchDelete(ActivityCategory activityCategory, List<Long> categoryIds) {
        return activitiesClient.batchDelete(activityCategory, categoryIds);
    }

    public static boolean deleteSubscriptionById(Long subscriptionId) {
        return activitiesClient.deleteSubscriptionById(subscriptionId);
    }

    public static boolean isSubscribedToActivity(Long receiverId,
            ActivityCategory activityCategory, Long categoryId, String extraInfo) {
        return isSubscribedToActivity(receiverId, activityCategory, categoryId);
    }

    public static boolean isSubscribedToActivity(Long receiverId, ActivityCategory activityCategory,
            Long categoryId) {
        return activitiesClient.isSubscribedToActivity(receiverId, activityCategory, categoryId);
    }

    public static List<IActivitySubscription> getActivitySubscriptions(ActivityCategory
            activityCategory, Long categoryId,
            Long receiverId) {
        return activitiesClient.getActivitySubscriptions(activityCategory, categoryId,
                receiverId);
    }

    public static List<IActivityEntry> getActivitiesByCategoryId(String activityCategory,
            Long categoryId) {
        return activitiesClient.getActivitiesByCategoryId(activityCategory, categoryId);
    }

    public static List<IActivitySubscription> getActivitySubscriptionsForMember(Long userId) {
        return activitiesClient.getActivitySubscriptionsForMember(userId);
    }
}
