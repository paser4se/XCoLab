package com.ext.portlet.contests.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the contest phase local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContestPhaseLocalServiceUtil
 * @see com.ext.portlet.contests.service.base.ContestPhaseLocalServiceBaseImpl
 * @see com.ext.portlet.contests.service.impl.ContestPhaseLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface ContestPhaseLocalService extends PersistedModelLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ContestPhaseLocalServiceUtil} to access the contest phase local service. Add custom service methods to {@link com.ext.portlet.contests.service.impl.ContestPhaseLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Adds the contest phase to the database. Also notifies the appropriate model listeners.
    *
    * @param contestPhase the contest phase
    * @return the contest phase that was added
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.contests.model.ContestPhase addContestPhase(
        com.ext.portlet.contests.model.ContestPhase contestPhase)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Creates a new contest phase with the primary key. Does not add the contest phase to the database.
    *
    * @param ContestPhasePK the primary key for the new contest phase
    * @return the new contest phase
    */
    public com.ext.portlet.contests.model.ContestPhase createContestPhase(
        java.lang.Long ContestPhasePK);

    /**
    * Deletes the contest phase with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param ContestPhasePK the primary key of the contest phase
    * @throws PortalException if a contest phase with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public void deleteContestPhase(java.lang.Long ContestPhasePK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Deletes the contest phase from the database. Also notifies the appropriate model listeners.
    *
    * @param contestPhase the contest phase
    * @throws SystemException if a system exception occurred
    */
    public void deleteContestPhase(
        com.ext.portlet.contests.model.ContestPhase contestPhase)
        throws com.liferay.portal.kernel.exception.SystemException;

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
        throws com.liferay.portal.kernel.exception.SystemException;

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
        int end) throws com.liferay.portal.kernel.exception.SystemException;

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
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.ext.portlet.contests.model.ContestPhase fetchContestPhase(
        java.lang.Long ContestPhasePK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the contest phase with the primary key.
    *
    * @param ContestPhasePK the primary key of the contest phase
    * @return the contest phase
    * @throws PortalException if a contest phase with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.ext.portlet.contests.model.ContestPhase getContestPhase(
        java.lang.Long ContestPhasePK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the contest phases.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of contest phases
    * @param end the upper bound of the range of contest phases (not inclusive)
    * @return the range of contest phases
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.ext.portlet.contests.model.ContestPhase> getContestPhases(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of contest phases.
    *
    * @return the number of contest phases
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getContestPhasesCount()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the contest phase in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param contestPhase the contest phase
    * @return the contest phase that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.contests.model.ContestPhase updateContestPhase(
        com.ext.portlet.contests.model.ContestPhase contestPhase)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the contest phase in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param contestPhase the contest phase
    * @param merge whether to merge the contest phase with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the contest phase that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.contests.model.ContestPhase updateContestPhase(
        com.ext.portlet.contests.model.ContestPhase contestPhase, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.ext.portlet.contests.model.ContestPhase> getPhasesForContest(
        com.ext.portlet.contests.model.Contest contest)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.ext.portlet.contests.model.ContestPhase getActivePhaseForContest(
        com.ext.portlet.contests.model.Contest contest)
        throws com.ext.portlet.contests.NoSuchContestPhaseException,
            com.liferay.portal.kernel.exception.SystemException;
}
