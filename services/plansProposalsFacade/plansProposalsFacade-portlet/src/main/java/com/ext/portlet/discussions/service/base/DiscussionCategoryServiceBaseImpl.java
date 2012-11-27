package com.ext.portlet.discussions.service.base;

import com.ext.portlet.discussions.model.DiscussionCategory;
import com.ext.portlet.discussions.service.DiscussionCategoryGroupLocalService;
import com.ext.portlet.discussions.service.DiscussionCategoryGroupService;
import com.ext.portlet.discussions.service.DiscussionCategoryLocalService;
import com.ext.portlet.discussions.service.DiscussionCategoryService;
import com.ext.portlet.discussions.service.DiscussionMessageFlagLocalService;
import com.ext.portlet.discussions.service.DiscussionMessageFlagService;
import com.ext.portlet.discussions.service.DiscussionMessageLocalService;
import com.ext.portlet.discussions.service.DiscussionMessageService;
import com.ext.portlet.discussions.service.persistence.DiscussionCategoryGroupPersistence;
import com.ext.portlet.discussions.service.persistence.DiscussionCategoryPersistence;
import com.ext.portlet.discussions.service.persistence.DiscussionMessageFlagPersistence;
import com.ext.portlet.discussions.service.persistence.DiscussionMessagePersistence;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import javax.sql.DataSource;

/**
 * The base implementation of the discussion category remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.ext.portlet.discussions.service.impl.DiscussionCategoryServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ext.portlet.discussions.service.impl.DiscussionCategoryServiceImpl
 * @see com.ext.portlet.discussions.service.DiscussionCategoryServiceUtil
 * @generated
 */
public abstract class DiscussionCategoryServiceBaseImpl extends PrincipalBean
    implements DiscussionCategoryService, IdentifiableBean {
    @BeanReference(type = DiscussionCategoryLocalService.class)
    protected DiscussionCategoryLocalService discussionCategoryLocalService;
    @BeanReference(type = DiscussionCategoryService.class)
    protected DiscussionCategoryService discussionCategoryService;
    @BeanReference(type = DiscussionCategoryPersistence.class)
    protected DiscussionCategoryPersistence discussionCategoryPersistence;
    @BeanReference(type = DiscussionCategoryGroupLocalService.class)
    protected DiscussionCategoryGroupLocalService discussionCategoryGroupLocalService;
    @BeanReference(type = DiscussionCategoryGroupService.class)
    protected DiscussionCategoryGroupService discussionCategoryGroupService;
    @BeanReference(type = DiscussionCategoryGroupPersistence.class)
    protected DiscussionCategoryGroupPersistence discussionCategoryGroupPersistence;
    @BeanReference(type = DiscussionMessageLocalService.class)
    protected DiscussionMessageLocalService discussionMessageLocalService;
    @BeanReference(type = DiscussionMessageService.class)
    protected DiscussionMessageService discussionMessageService;
    @BeanReference(type = DiscussionMessagePersistence.class)
    protected DiscussionMessagePersistence discussionMessagePersistence;
    @BeanReference(type = DiscussionMessageFlagLocalService.class)
    protected DiscussionMessageFlagLocalService discussionMessageFlagLocalService;
    @BeanReference(type = DiscussionMessageFlagService.class)
    protected DiscussionMessageFlagService discussionMessageFlagService;
    @BeanReference(type = DiscussionMessageFlagPersistence.class)
    protected DiscussionMessageFlagPersistence discussionMessageFlagPersistence;
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
     * Never modify or reference this class directly. Always use {@link com.ext.portlet.discussions.service.DiscussionCategoryServiceUtil} to access the discussion category remote service.
     */

    /**
     * Returns the discussion category local service.
     *
     * @return the discussion category local service
     */
    public DiscussionCategoryLocalService getDiscussionCategoryLocalService() {
        return discussionCategoryLocalService;
    }

    /**
     * Sets the discussion category local service.
     *
     * @param discussionCategoryLocalService the discussion category local service
     */
    public void setDiscussionCategoryLocalService(
        DiscussionCategoryLocalService discussionCategoryLocalService) {
        this.discussionCategoryLocalService = discussionCategoryLocalService;
    }

    /**
     * Returns the discussion category remote service.
     *
     * @return the discussion category remote service
     */
    public DiscussionCategoryService getDiscussionCategoryService() {
        return discussionCategoryService;
    }

    /**
     * Sets the discussion category remote service.
     *
     * @param discussionCategoryService the discussion category remote service
     */
    public void setDiscussionCategoryService(
        DiscussionCategoryService discussionCategoryService) {
        this.discussionCategoryService = discussionCategoryService;
    }

    /**
     * Returns the discussion category persistence.
     *
     * @return the discussion category persistence
     */
    public DiscussionCategoryPersistence getDiscussionCategoryPersistence() {
        return discussionCategoryPersistence;
    }

    /**
     * Sets the discussion category persistence.
     *
     * @param discussionCategoryPersistence the discussion category persistence
     */
    public void setDiscussionCategoryPersistence(
        DiscussionCategoryPersistence discussionCategoryPersistence) {
        this.discussionCategoryPersistence = discussionCategoryPersistence;
    }

    /**
     * Returns the discussion category group local service.
     *
     * @return the discussion category group local service
     */
    public DiscussionCategoryGroupLocalService getDiscussionCategoryGroupLocalService() {
        return discussionCategoryGroupLocalService;
    }

    /**
     * Sets the discussion category group local service.
     *
     * @param discussionCategoryGroupLocalService the discussion category group local service
     */
    public void setDiscussionCategoryGroupLocalService(
        DiscussionCategoryGroupLocalService discussionCategoryGroupLocalService) {
        this.discussionCategoryGroupLocalService = discussionCategoryGroupLocalService;
    }

    /**
     * Returns the discussion category group remote service.
     *
     * @return the discussion category group remote service
     */
    public DiscussionCategoryGroupService getDiscussionCategoryGroupService() {
        return discussionCategoryGroupService;
    }

    /**
     * Sets the discussion category group remote service.
     *
     * @param discussionCategoryGroupService the discussion category group remote service
     */
    public void setDiscussionCategoryGroupService(
        DiscussionCategoryGroupService discussionCategoryGroupService) {
        this.discussionCategoryGroupService = discussionCategoryGroupService;
    }

    /**
     * Returns the discussion category group persistence.
     *
     * @return the discussion category group persistence
     */
    public DiscussionCategoryGroupPersistence getDiscussionCategoryGroupPersistence() {
        return discussionCategoryGroupPersistence;
    }

    /**
     * Sets the discussion category group persistence.
     *
     * @param discussionCategoryGroupPersistence the discussion category group persistence
     */
    public void setDiscussionCategoryGroupPersistence(
        DiscussionCategoryGroupPersistence discussionCategoryGroupPersistence) {
        this.discussionCategoryGroupPersistence = discussionCategoryGroupPersistence;
    }

    /**
     * Returns the discussion message local service.
     *
     * @return the discussion message local service
     */
    public DiscussionMessageLocalService getDiscussionMessageLocalService() {
        return discussionMessageLocalService;
    }

    /**
     * Sets the discussion message local service.
     *
     * @param discussionMessageLocalService the discussion message local service
     */
    public void setDiscussionMessageLocalService(
        DiscussionMessageLocalService discussionMessageLocalService) {
        this.discussionMessageLocalService = discussionMessageLocalService;
    }

    /**
     * Returns the discussion message remote service.
     *
     * @return the discussion message remote service
     */
    public DiscussionMessageService getDiscussionMessageService() {
        return discussionMessageService;
    }

    /**
     * Sets the discussion message remote service.
     *
     * @param discussionMessageService the discussion message remote service
     */
    public void setDiscussionMessageService(
        DiscussionMessageService discussionMessageService) {
        this.discussionMessageService = discussionMessageService;
    }

    /**
     * Returns the discussion message persistence.
     *
     * @return the discussion message persistence
     */
    public DiscussionMessagePersistence getDiscussionMessagePersistence() {
        return discussionMessagePersistence;
    }

    /**
     * Sets the discussion message persistence.
     *
     * @param discussionMessagePersistence the discussion message persistence
     */
    public void setDiscussionMessagePersistence(
        DiscussionMessagePersistence discussionMessagePersistence) {
        this.discussionMessagePersistence = discussionMessagePersistence;
    }

    /**
     * Returns the discussion message flag local service.
     *
     * @return the discussion message flag local service
     */
    public DiscussionMessageFlagLocalService getDiscussionMessageFlagLocalService() {
        return discussionMessageFlagLocalService;
    }

    /**
     * Sets the discussion message flag local service.
     *
     * @param discussionMessageFlagLocalService the discussion message flag local service
     */
    public void setDiscussionMessageFlagLocalService(
        DiscussionMessageFlagLocalService discussionMessageFlagLocalService) {
        this.discussionMessageFlagLocalService = discussionMessageFlagLocalService;
    }

    /**
     * Returns the discussion message flag remote service.
     *
     * @return the discussion message flag remote service
     */
    public DiscussionMessageFlagService getDiscussionMessageFlagService() {
        return discussionMessageFlagService;
    }

    /**
     * Sets the discussion message flag remote service.
     *
     * @param discussionMessageFlagService the discussion message flag remote service
     */
    public void setDiscussionMessageFlagService(
        DiscussionMessageFlagService discussionMessageFlagService) {
        this.discussionMessageFlagService = discussionMessageFlagService;
    }

    /**
     * Returns the discussion message flag persistence.
     *
     * @return the discussion message flag persistence
     */
    public DiscussionMessageFlagPersistence getDiscussionMessageFlagPersistence() {
        return discussionMessageFlagPersistence;
    }

    /**
     * Sets the discussion message flag persistence.
     *
     * @param discussionMessageFlagPersistence the discussion message flag persistence
     */
    public void setDiscussionMessageFlagPersistence(
        DiscussionMessageFlagPersistence discussionMessageFlagPersistence) {
        this.discussionMessageFlagPersistence = discussionMessageFlagPersistence;
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
    }

    public void destroy() {
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
        return DiscussionCategory.class;
    }

    protected String getModelClassName() {
        return DiscussionCategory.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = discussionCategoryPersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
