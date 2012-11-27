package com.ext.portlet.contests.service.base;

import com.ext.portlet.contests.model.ContestTeamMember;
import com.ext.portlet.contests.service.ContestDebateLocalService;
import com.ext.portlet.contests.service.ContestDebateService;
import com.ext.portlet.contests.service.ContestLocalService;
import com.ext.portlet.contests.service.ContestPhaseColumnLocalService;
import com.ext.portlet.contests.service.ContestPhaseColumnService;
import com.ext.portlet.contests.service.ContestPhaseLocalService;
import com.ext.portlet.contests.service.ContestPhaseService;
import com.ext.portlet.contests.service.ContestService;
import com.ext.portlet.contests.service.ContestTeamMemberLocalService;
import com.ext.portlet.contests.service.ContestTeamMemberService;
import com.ext.portlet.contests.service.persistence.ContestDebatePersistence;
import com.ext.portlet.contests.service.persistence.ContestPersistence;
import com.ext.portlet.contests.service.persistence.ContestPhaseColumnPersistence;
import com.ext.portlet.contests.service.persistence.ContestPhasePersistence;
import com.ext.portlet.contests.service.persistence.ContestTeamMemberPersistence;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the contest team member local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.ext.portlet.contests.service.impl.ContestTeamMemberLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ext.portlet.contests.service.impl.ContestTeamMemberLocalServiceImpl
 * @see com.ext.portlet.contests.service.ContestTeamMemberLocalServiceUtil
 * @generated
 */
public abstract class ContestTeamMemberLocalServiceBaseImpl
    implements ContestTeamMemberLocalService, IdentifiableBean {
    private static Log _log = LogFactoryUtil.getLog(ContestTeamMemberLocalServiceBaseImpl.class);
    @BeanReference(type = ContestLocalService.class)
    protected ContestLocalService contestLocalService;
    @BeanReference(type = ContestService.class)
    protected ContestService contestService;
    @BeanReference(type = ContestPersistence.class)
    protected ContestPersistence contestPersistence;
    @BeanReference(type = ContestDebateLocalService.class)
    protected ContestDebateLocalService contestDebateLocalService;
    @BeanReference(type = ContestDebateService.class)
    protected ContestDebateService contestDebateService;
    @BeanReference(type = ContestDebatePersistence.class)
    protected ContestDebatePersistence contestDebatePersistence;
    @BeanReference(type = ContestPhaseLocalService.class)
    protected ContestPhaseLocalService contestPhaseLocalService;
    @BeanReference(type = ContestPhaseService.class)
    protected ContestPhaseService contestPhaseService;
    @BeanReference(type = ContestPhasePersistence.class)
    protected ContestPhasePersistence contestPhasePersistence;
    @BeanReference(type = ContestPhaseColumnLocalService.class)
    protected ContestPhaseColumnLocalService contestPhaseColumnLocalService;
    @BeanReference(type = ContestPhaseColumnService.class)
    protected ContestPhaseColumnService contestPhaseColumnService;
    @BeanReference(type = ContestPhaseColumnPersistence.class)
    protected ContestPhaseColumnPersistence contestPhaseColumnPersistence;
    @BeanReference(type = ContestTeamMemberLocalService.class)
    protected ContestTeamMemberLocalService contestTeamMemberLocalService;
    @BeanReference(type = ContestTeamMemberService.class)
    protected ContestTeamMemberService contestTeamMemberService;
    @BeanReference(type = ContestTeamMemberPersistence.class)
    protected ContestTeamMemberPersistence contestTeamMemberPersistence;
    @BeanReference(type = CounterLocalService.class)
    protected CounterLocalService counterLocalService;
    @BeanReference(type = ResourceLocalService.class)
    protected ResourceLocalService resourceLocalService;
    @BeanReference(type = ResourceService.class)
    protected ResourceService resourceService;
    @BeanReference(type = ResourcePersistence.class)
    protected ResourcePersistence resourcePersistence;
    @BeanReference(type = UserLocalService.class)
    protected UserLocalService userLocalService;
    @BeanReference(type = UserService.class)
    protected UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    private String _beanIdentifier;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link com.ext.portlet.contests.service.ContestTeamMemberLocalServiceUtil} to access the contest team member local service.
     */

    /**
     * Adds the contest team member to the database. Also notifies the appropriate model listeners.
     *
     * @param contestTeamMember the contest team member
     * @return the contest team member that was added
     * @throws SystemException if a system exception occurred
     */
    public ContestTeamMember addContestTeamMember(
        ContestTeamMember contestTeamMember) throws SystemException {
        contestTeamMember.setNew(true);

        contestTeamMember = contestTeamMemberPersistence.update(contestTeamMember,
                false);

        Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

        if (indexer != null) {
            try {
                indexer.reindex(contestTeamMember);
            } catch (SearchException se) {
                if (_log.isWarnEnabled()) {
                    _log.warn(se, se);
                }
            }
        }

        return contestTeamMember;
    }

    /**
     * Creates a new contest team member with the primary key. Does not add the contest team member to the database.
     *
     * @param id the primary key for the new contest team member
     * @return the new contest team member
     */
    public ContestTeamMember createContestTeamMember(Long id) {
        return contestTeamMemberPersistence.create(id);
    }

    /**
     * Deletes the contest team member with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the contest team member
     * @throws PortalException if a contest team member with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public void deleteContestTeamMember(Long id)
        throws PortalException, SystemException {
        ContestTeamMember contestTeamMember = contestTeamMemberPersistence.remove(id);

        Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

        if (indexer != null) {
            try {
                indexer.delete(contestTeamMember);
            } catch (SearchException se) {
                if (_log.isWarnEnabled()) {
                    _log.warn(se, se);
                }
            }
        }
    }

    /**
     * Deletes the contest team member from the database. Also notifies the appropriate model listeners.
     *
     * @param contestTeamMember the contest team member
     * @throws SystemException if a system exception occurred
     */
    public void deleteContestTeamMember(ContestTeamMember contestTeamMember)
        throws SystemException {
        contestTeamMemberPersistence.remove(contestTeamMember);

        Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

        if (indexer != null) {
            try {
                indexer.delete(contestTeamMember);
            } catch (SearchException se) {
                if (_log.isWarnEnabled()) {
                    _log.warn(se, se);
                }
            }
        }
    }

    /**
     * Performs a dynamic query on the database and returns the matching rows.
     *
     * @param dynamicQuery the dynamic query
     * @return the matching rows
     * @throws SystemException if a system exception occurred
     */
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return contestTeamMemberPersistence.findWithDynamicQuery(dynamicQuery);
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
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return contestTeamMemberPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
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
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return contestTeamMemberPersistence.findWithDynamicQuery(dynamicQuery,
            start, end, orderByComparator);
    }

    /**
     * Returns the number of rows that match the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @return the number of rows that match the dynamic query
     * @throws SystemException if a system exception occurred
     */
    public long dynamicQueryCount(DynamicQuery dynamicQuery)
        throws SystemException {
        return contestTeamMemberPersistence.countWithDynamicQuery(dynamicQuery);
    }

    public ContestTeamMember fetchContestTeamMember(Long id)
        throws SystemException {
        return contestTeamMemberPersistence.fetchByPrimaryKey(id);
    }

    /**
     * Returns the contest team member with the primary key.
     *
     * @param id the primary key of the contest team member
     * @return the contest team member
     * @throws PortalException if a contest team member with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public ContestTeamMember getContestTeamMember(Long id)
        throws PortalException, SystemException {
        return contestTeamMemberPersistence.findByPrimaryKey(id);
    }

    public PersistedModel getPersistedModel(Serializable primaryKeyObj)
        throws PortalException, SystemException {
        return contestTeamMemberPersistence.findByPrimaryKey(primaryKeyObj);
    }

    /**
     * Returns a range of all the contest team members.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of contest team members
     * @param end the upper bound of the range of contest team members (not inclusive)
     * @return the range of contest team members
     * @throws SystemException if a system exception occurred
     */
    public List<ContestTeamMember> getContestTeamMembers(int start, int end)
        throws SystemException {
        return contestTeamMemberPersistence.findAll(start, end);
    }

    /**
     * Returns the number of contest team members.
     *
     * @return the number of contest team members
     * @throws SystemException if a system exception occurred
     */
    public int getContestTeamMembersCount() throws SystemException {
        return contestTeamMemberPersistence.countAll();
    }

    /**
     * Updates the contest team member in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
     *
     * @param contestTeamMember the contest team member
     * @return the contest team member that was updated
     * @throws SystemException if a system exception occurred
     */
    public ContestTeamMember updateContestTeamMember(
        ContestTeamMember contestTeamMember) throws SystemException {
        return updateContestTeamMember(contestTeamMember, true);
    }

    /**
     * Updates the contest team member in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
     *
     * @param contestTeamMember the contest team member
     * @param merge whether to merge the contest team member with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
     * @return the contest team member that was updated
     * @throws SystemException if a system exception occurred
     */
    public ContestTeamMember updateContestTeamMember(
        ContestTeamMember contestTeamMember, boolean merge)
        throws SystemException {
        contestTeamMember.setNew(false);

        contestTeamMember = contestTeamMemberPersistence.update(contestTeamMember,
                merge);

        Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

        if (indexer != null) {
            try {
                indexer.reindex(contestTeamMember);
            } catch (SearchException se) {
                if (_log.isWarnEnabled()) {
                    _log.warn(se, se);
                }
            }
        }

        return contestTeamMember;
    }

    /**
     * Returns the contest local service.
     *
     * @return the contest local service
     */
    public ContestLocalService getContestLocalService() {
        return contestLocalService;
    }

    /**
     * Sets the contest local service.
     *
     * @param contestLocalService the contest local service
     */
    public void setContestLocalService(ContestLocalService contestLocalService) {
        this.contestLocalService = contestLocalService;
    }

    /**
     * Returns the contest remote service.
     *
     * @return the contest remote service
     */
    public ContestService getContestService() {
        return contestService;
    }

    /**
     * Sets the contest remote service.
     *
     * @param contestService the contest remote service
     */
    public void setContestService(ContestService contestService) {
        this.contestService = contestService;
    }

    /**
     * Returns the contest persistence.
     *
     * @return the contest persistence
     */
    public ContestPersistence getContestPersistence() {
        return contestPersistence;
    }

    /**
     * Sets the contest persistence.
     *
     * @param contestPersistence the contest persistence
     */
    public void setContestPersistence(ContestPersistence contestPersistence) {
        this.contestPersistence = contestPersistence;
    }

    /**
     * Returns the contest debate local service.
     *
     * @return the contest debate local service
     */
    public ContestDebateLocalService getContestDebateLocalService() {
        return contestDebateLocalService;
    }

    /**
     * Sets the contest debate local service.
     *
     * @param contestDebateLocalService the contest debate local service
     */
    public void setContestDebateLocalService(
        ContestDebateLocalService contestDebateLocalService) {
        this.contestDebateLocalService = contestDebateLocalService;
    }

    /**
     * Returns the contest debate remote service.
     *
     * @return the contest debate remote service
     */
    public ContestDebateService getContestDebateService() {
        return contestDebateService;
    }

    /**
     * Sets the contest debate remote service.
     *
     * @param contestDebateService the contest debate remote service
     */
    public void setContestDebateService(
        ContestDebateService contestDebateService) {
        this.contestDebateService = contestDebateService;
    }

    /**
     * Returns the contest debate persistence.
     *
     * @return the contest debate persistence
     */
    public ContestDebatePersistence getContestDebatePersistence() {
        return contestDebatePersistence;
    }

    /**
     * Sets the contest debate persistence.
     *
     * @param contestDebatePersistence the contest debate persistence
     */
    public void setContestDebatePersistence(
        ContestDebatePersistence contestDebatePersistence) {
        this.contestDebatePersistence = contestDebatePersistence;
    }

    /**
     * Returns the contest phase local service.
     *
     * @return the contest phase local service
     */
    public ContestPhaseLocalService getContestPhaseLocalService() {
        return contestPhaseLocalService;
    }

    /**
     * Sets the contest phase local service.
     *
     * @param contestPhaseLocalService the contest phase local service
     */
    public void setContestPhaseLocalService(
        ContestPhaseLocalService contestPhaseLocalService) {
        this.contestPhaseLocalService = contestPhaseLocalService;
    }

    /**
     * Returns the contest phase remote service.
     *
     * @return the contest phase remote service
     */
    public ContestPhaseService getContestPhaseService() {
        return contestPhaseService;
    }

    /**
     * Sets the contest phase remote service.
     *
     * @param contestPhaseService the contest phase remote service
     */
    public void setContestPhaseService(ContestPhaseService contestPhaseService) {
        this.contestPhaseService = contestPhaseService;
    }

    /**
     * Returns the contest phase persistence.
     *
     * @return the contest phase persistence
     */
    public ContestPhasePersistence getContestPhasePersistence() {
        return contestPhasePersistence;
    }

    /**
     * Sets the contest phase persistence.
     *
     * @param contestPhasePersistence the contest phase persistence
     */
    public void setContestPhasePersistence(
        ContestPhasePersistence contestPhasePersistence) {
        this.contestPhasePersistence = contestPhasePersistence;
    }

    /**
     * Returns the contest phase column local service.
     *
     * @return the contest phase column local service
     */
    public ContestPhaseColumnLocalService getContestPhaseColumnLocalService() {
        return contestPhaseColumnLocalService;
    }

    /**
     * Sets the contest phase column local service.
     *
     * @param contestPhaseColumnLocalService the contest phase column local service
     */
    public void setContestPhaseColumnLocalService(
        ContestPhaseColumnLocalService contestPhaseColumnLocalService) {
        this.contestPhaseColumnLocalService = contestPhaseColumnLocalService;
    }

    /**
     * Returns the contest phase column remote service.
     *
     * @return the contest phase column remote service
     */
    public ContestPhaseColumnService getContestPhaseColumnService() {
        return contestPhaseColumnService;
    }

    /**
     * Sets the contest phase column remote service.
     *
     * @param contestPhaseColumnService the contest phase column remote service
     */
    public void setContestPhaseColumnService(
        ContestPhaseColumnService contestPhaseColumnService) {
        this.contestPhaseColumnService = contestPhaseColumnService;
    }

    /**
     * Returns the contest phase column persistence.
     *
     * @return the contest phase column persistence
     */
    public ContestPhaseColumnPersistence getContestPhaseColumnPersistence() {
        return contestPhaseColumnPersistence;
    }

    /**
     * Sets the contest phase column persistence.
     *
     * @param contestPhaseColumnPersistence the contest phase column persistence
     */
    public void setContestPhaseColumnPersistence(
        ContestPhaseColumnPersistence contestPhaseColumnPersistence) {
        this.contestPhaseColumnPersistence = contestPhaseColumnPersistence;
    }

    /**
     * Returns the contest team member local service.
     *
     * @return the contest team member local service
     */
    public ContestTeamMemberLocalService getContestTeamMemberLocalService() {
        return contestTeamMemberLocalService;
    }

    /**
     * Sets the contest team member local service.
     *
     * @param contestTeamMemberLocalService the contest team member local service
     */
    public void setContestTeamMemberLocalService(
        ContestTeamMemberLocalService contestTeamMemberLocalService) {
        this.contestTeamMemberLocalService = contestTeamMemberLocalService;
    }

    /**
     * Returns the contest team member remote service.
     *
     * @return the contest team member remote service
     */
    public ContestTeamMemberService getContestTeamMemberService() {
        return contestTeamMemberService;
    }

    /**
     * Sets the contest team member remote service.
     *
     * @param contestTeamMemberService the contest team member remote service
     */
    public void setContestTeamMemberService(
        ContestTeamMemberService contestTeamMemberService) {
        this.contestTeamMemberService = contestTeamMemberService;
    }

    /**
     * Returns the contest team member persistence.
     *
     * @return the contest team member persistence
     */
    public ContestTeamMemberPersistence getContestTeamMemberPersistence() {
        return contestTeamMemberPersistence;
    }

    /**
     * Sets the contest team member persistence.
     *
     * @param contestTeamMemberPersistence the contest team member persistence
     */
    public void setContestTeamMemberPersistence(
        ContestTeamMemberPersistence contestTeamMemberPersistence) {
        this.contestTeamMemberPersistence = contestTeamMemberPersistence;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the resource remote service.
     *
     * @return the resource remote service
     */
    public ResourceService getResourceService() {
        return resourceService;
    }

    /**
     * Sets the resource remote service.
     *
     * @param resourceService the resource remote service
     */
    public void setResourceService(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    /**
     * Returns the resource persistence.
     *
     * @return the resource persistence
     */
    public ResourcePersistence getResourcePersistence() {
        return resourcePersistence;
    }

    /**
     * Sets the resource persistence.
     *
     * @param resourcePersistence the resource persistence
     */
    public void setResourcePersistence(ResourcePersistence resourcePersistence) {
        this.resourcePersistence = resourcePersistence;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public void afterPropertiesSet() {
        PersistedModelLocalServiceRegistryUtil.register("com.ext.portlet.contests.model.ContestTeamMember",
            contestTeamMemberLocalService);
    }

    public void destroy() {
        PersistedModelLocalServiceRegistryUtil.unregister(
            "com.ext.portlet.contests.model.ContestTeamMember");
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    protected Class<?> getModelClass() {
        return ContestTeamMember.class;
    }

    protected String getModelClassName() {
        return ContestTeamMember.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = contestTeamMemberPersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
