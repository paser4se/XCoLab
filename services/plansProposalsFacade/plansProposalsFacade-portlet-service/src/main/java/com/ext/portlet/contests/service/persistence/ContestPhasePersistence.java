package com.ext.portlet.contests.service.persistence;

import com.ext.portlet.contests.model.ContestPhase;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the contest phase service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContestPhasePersistenceImpl
 * @see ContestPhaseUtil
 * @generated
 */
public interface ContestPhasePersistence extends BasePersistence<ContestPhase> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ContestPhaseUtil} to access the contest phase persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the contest phase in the entity cache if it is enabled.
    *
    * @param contestPhase the contest phase
    */
    public void cacheResult(
        com.ext.portlet.contests.model.ContestPhase contestPhase);

    /**
    * Caches the contest phases in the entity cache if it is enabled.
    *
    * @param contestPhases the contest phases
    */
    public void cacheResult(
        java.util.List<com.ext.portlet.contests.model.ContestPhase> contestPhases);

    /**
    * Creates a new contest phase with the primary key. Does not add the contest phase to the database.
    *
    * @param ContestPhasePK the primary key for the new contest phase
    * @return the new contest phase
    */
    public com.ext.portlet.contests.model.ContestPhase create(
        java.lang.Long ContestPhasePK);

    /**
    * Removes the contest phase with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param ContestPhasePK the primary key of the contest phase
    * @return the contest phase that was removed
    * @throws com.ext.portlet.contests.NoSuchContestPhaseException if a contest phase with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.contests.model.ContestPhase remove(
        java.lang.Long ContestPhasePK)
        throws com.ext.portlet.contests.NoSuchContestPhaseException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.ext.portlet.contests.model.ContestPhase updateImpl(
        com.ext.portlet.contests.model.ContestPhase contestPhase, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the contest phase with the primary key or throws a {@link com.ext.portlet.contests.NoSuchContestPhaseException} if it could not be found.
    *
    * @param ContestPhasePK the primary key of the contest phase
    * @return the contest phase
    * @throws com.ext.portlet.contests.NoSuchContestPhaseException if a contest phase with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.contests.model.ContestPhase findByPrimaryKey(
        java.lang.Long ContestPhasePK)
        throws com.ext.portlet.contests.NoSuchContestPhaseException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the contest phase with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param ContestPhasePK the primary key of the contest phase
    * @return the contest phase, or <code>null</code> if a contest phase with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.contests.model.ContestPhase fetchByPrimaryKey(
        java.lang.Long ContestPhasePK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the contest phase where ContestPK = &#63; and PhaseStartDate &le; &#63; and PhaseEndDate &ge; &#63; or throws a {@link com.ext.portlet.contests.NoSuchContestPhaseException} if it could not be found.
    *
    * @param ContestPK the contest p k
    * @param PhaseStartDate the phase start date
    * @param PhaseEndDate the phase end date
    * @return the matching contest phase
    * @throws com.ext.portlet.contests.NoSuchContestPhaseException if a matching contest phase could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.contests.model.ContestPhase findByContestIdStartEnd(
        java.lang.Long ContestPK, java.util.Date PhaseStartDate,
        java.util.Date PhaseEndDate)
        throws com.ext.portlet.contests.NoSuchContestPhaseException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the contest phase where ContestPK = &#63; and PhaseStartDate &le; &#63; and PhaseEndDate &ge; &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param ContestPK the contest p k
    * @param PhaseStartDate the phase start date
    * @param PhaseEndDate the phase end date
    * @return the matching contest phase, or <code>null</code> if a matching contest phase could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.contests.model.ContestPhase fetchByContestIdStartEnd(
        java.lang.Long ContestPK, java.util.Date PhaseStartDate,
        java.util.Date PhaseEndDate)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the contest phase where ContestPK = &#63; and PhaseStartDate &le; &#63; and PhaseEndDate &ge; &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param ContestPK the contest p k
    * @param PhaseStartDate the phase start date
    * @param PhaseEndDate the phase end date
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching contest phase, or <code>null</code> if a matching contest phase could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.contests.model.ContestPhase fetchByContestIdStartEnd(
        java.lang.Long ContestPK, java.util.Date PhaseStartDate,
        java.util.Date PhaseEndDate, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the contest phases where ContestPK = &#63;.
    *
    * @param ContestPK the contest p k
    * @return the matching contest phases
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.contests.model.ContestPhase> findByContestId(
        java.lang.Long ContestPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the contest phases where ContestPK = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param ContestPK the contest p k
    * @param start the lower bound of the range of contest phases
    * @param end the upper bound of the range of contest phases (not inclusive)
    * @return the range of matching contest phases
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.contests.model.ContestPhase> findByContestId(
        java.lang.Long ContestPK, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the contest phases where ContestPK = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param ContestPK the contest p k
    * @param start the lower bound of the range of contest phases
    * @param end the upper bound of the range of contest phases (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching contest phases
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.contests.model.ContestPhase> findByContestId(
        java.lang.Long ContestPK, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first contest phase in the ordered set where ContestPK = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param ContestPK the contest p k
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching contest phase
    * @throws com.ext.portlet.contests.NoSuchContestPhaseException if a matching contest phase could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.contests.model.ContestPhase findByContestId_First(
        java.lang.Long ContestPK,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.contests.NoSuchContestPhaseException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last contest phase in the ordered set where ContestPK = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param ContestPK the contest p k
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching contest phase
    * @throws com.ext.portlet.contests.NoSuchContestPhaseException if a matching contest phase could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.contests.model.ContestPhase findByContestId_Last(
        java.lang.Long ContestPK,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.contests.NoSuchContestPhaseException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the contest phases before and after the current contest phase in the ordered set where ContestPK = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param ContestPhasePK the primary key of the current contest phase
    * @param ContestPK the contest p k
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next contest phase
    * @throws com.ext.portlet.contests.NoSuchContestPhaseException if a contest phase with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.contests.model.ContestPhase[] findByContestId_PrevAndNext(
        java.lang.Long ContestPhasePK, java.lang.Long ContestPK,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.contests.NoSuchContestPhaseException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the contest phases.
    *
    * @return the contest phases
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.contests.model.ContestPhase> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.ext.portlet.contests.model.ContestPhase> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the contest phases.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of contest phases
    * @param end the upper bound of the range of contest phases (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of contest phases
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.contests.model.ContestPhase> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the contest phase where ContestPK = &#63; and PhaseStartDate &le; &#63; and PhaseEndDate &ge; &#63; from the database.
    *
    * @param ContestPK the contest p k
    * @param PhaseStartDate the phase start date
    * @param PhaseEndDate the phase end date
    * @throws SystemException if a system exception occurred
    */
    public void removeByContestIdStartEnd(java.lang.Long ContestPK,
        java.util.Date PhaseStartDate, java.util.Date PhaseEndDate)
        throws com.ext.portlet.contests.NoSuchContestPhaseException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the contest phases where ContestPK = &#63; from the database.
    *
    * @param ContestPK the contest p k
    * @throws SystemException if a system exception occurred
    */
    public void removeByContestId(java.lang.Long ContestPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the contest phases from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of contest phases where ContestPK = &#63; and PhaseStartDate &le; &#63; and PhaseEndDate &ge; &#63;.
    *
    * @param ContestPK the contest p k
    * @param PhaseStartDate the phase start date
    * @param PhaseEndDate the phase end date
    * @return the number of matching contest phases
    * @throws SystemException if a system exception occurred
    */
    public int countByContestIdStartEnd(java.lang.Long ContestPK,
        java.util.Date PhaseStartDate, java.util.Date PhaseEndDate)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of contest phases where ContestPK = &#63;.
    *
    * @param ContestPK the contest p k
    * @return the number of matching contest phases
    * @throws SystemException if a system exception occurred
    */
    public int countByContestId(java.lang.Long ContestPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of contest phases.
    *
    * @return the number of contest phases
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
