package com.ext.portlet.contests.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ContestLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ContestLocalService
 * @generated
 */
public class ContestLocalServiceWrapper implements ContestLocalService,
    ServiceWrapper<ContestLocalService> {
    private ContestLocalService _contestLocalService;

    public ContestLocalServiceWrapper(ContestLocalService contestLocalService) {
        _contestLocalService = contestLocalService;
    }

    /**
    * Adds the contest to the database. Also notifies the appropriate model listeners.
    *
    * @param contest the contest
    * @return the contest that was added
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.contests.model.Contest addContest(
        com.ext.portlet.contests.model.Contest contest)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contestLocalService.addContest(contest);
    }

    /**
    * Creates a new contest with the primary key. Does not add the contest to the database.
    *
    * @param ContestPK the primary key for the new contest
    * @return the new contest
    */
    public com.ext.portlet.contests.model.Contest createContest(
        java.lang.Long ContestPK) {
        return _contestLocalService.createContest(ContestPK);
    }

    /**
    * Deletes the contest with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param ContestPK the primary key of the contest
    * @throws PortalException if a contest with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public void deleteContest(java.lang.Long ContestPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _contestLocalService.deleteContest(ContestPK);
    }

    /**
    * Deletes the contest from the database. Also notifies the appropriate model listeners.
    *
    * @param contest the contest
    * @throws SystemException if a system exception occurred
    */
    public void deleteContest(com.ext.portlet.contests.model.Contest contest)
        throws com.liferay.portal.kernel.exception.SystemException {
        _contestLocalService.deleteContest(contest);
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contestLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _contestLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contestLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contestLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.ext.portlet.contests.model.Contest fetchContest(
        java.lang.Long ContestPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contestLocalService.fetchContest(ContestPK);
    }

    /**
    * Returns the contest with the primary key.
    *
    * @param ContestPK the primary key of the contest
    * @return the contest
    * @throws PortalException if a contest with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.contests.model.Contest getContest(
        java.lang.Long ContestPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _contestLocalService.getContest(ContestPK);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _contestLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the contests.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of contests
    * @param end the upper bound of the range of contests (not inclusive)
    * @return the range of contests
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.contests.model.Contest> getContests(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contestLocalService.getContests(start, end);
    }

    /**
    * Returns the number of contests.
    *
    * @return the number of contests
    * @throws SystemException if a system exception occurred
    */
    public int getContestsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contestLocalService.getContestsCount();
    }

    /**
    * Updates the contest in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param contest the contest
    * @return the contest that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.contests.model.Contest updateContest(
        com.ext.portlet.contests.model.Contest contest)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contestLocalService.updateContest(contest);
    }

    /**
    * Updates the contest in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param contest the contest
    * @param merge whether to merge the contest with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the contest that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.contests.model.Contest updateContest(
        com.ext.portlet.contests.model.Contest contest, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contestLocalService.updateContest(contest, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _contestLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _contestLocalService.setBeanIdentifier(beanIdentifier);
    }

    public com.ext.portlet.contests.model.Contest getContestByActiveFlag(
        boolean contestActive)
        throws com.ext.portlet.contests.NoSuchContestException,
            com.liferay.portal.kernel.exception.SystemException {
        return _contestLocalService.getContestByActiveFlag(contestActive);
    }

    public com.ext.portlet.contests.model.Contest createNewContest(
        java.lang.Long userId, java.lang.String name)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _contestLocalService.createNewContest(userId, name);
    }

    public void updateContestGroupsAndDiscussions()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _contestLocalService.updateContestGroupsAndDiscussions();
    }

    public java.util.List<com.ext.portlet.contests.model.Contest> findByActiveFeatured(
        boolean active, boolean featured)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contestLocalService.findByActiveFeatured(active, featured);
    }

    public java.util.List<com.ext.portlet.contests.model.Contest> findByActiveFlag(
        boolean active, int flag)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contestLocalService.findByActiveFlag(active, flag);
    }

    public java.util.List<com.ext.portlet.contests.model.Contest> findByActiveFlagText(
        boolean active, java.lang.String flagText)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contestLocalService.findByActiveFlagText(active, flagText);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public ContestLocalService getWrappedContestLocalService() {
        return _contestLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedContestLocalService(
        ContestLocalService contestLocalService) {
        _contestLocalService = contestLocalService;
    }

    public ContestLocalService getWrappedService() {
        return _contestLocalService;
    }

    public void setWrappedService(ContestLocalService contestLocalService) {
        _contestLocalService = contestLocalService;
    }
}
