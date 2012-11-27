package com.ext.portlet.ontology.service.base;

import com.ext.portlet.ontology.model.OntologyTerm;
import com.ext.portlet.ontology.service.FocusAreaLocalService;
import com.ext.portlet.ontology.service.FocusAreaOntologyTermLocalService;
import com.ext.portlet.ontology.service.FocusAreaOntologyTermService;
import com.ext.portlet.ontology.service.FocusAreaService;
import com.ext.portlet.ontology.service.OntologySpaceLocalService;
import com.ext.portlet.ontology.service.OntologySpaceService;
import com.ext.portlet.ontology.service.OntologyTermEntityLocalService;
import com.ext.portlet.ontology.service.OntologyTermEntityService;
import com.ext.portlet.ontology.service.OntologyTermLocalService;
import com.ext.portlet.ontology.service.OntologyTermService;
import com.ext.portlet.ontology.service.persistence.FocusAreaOntologyTermPersistence;
import com.ext.portlet.ontology.service.persistence.FocusAreaPersistence;
import com.ext.portlet.ontology.service.persistence.OntologySpacePersistence;
import com.ext.portlet.ontology.service.persistence.OntologyTermEntityPersistence;
import com.ext.portlet.ontology.service.persistence.OntologyTermPersistence;

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
 * The base implementation of the ontology term remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.ext.portlet.ontology.service.impl.OntologyTermServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ext.portlet.ontology.service.impl.OntologyTermServiceImpl
 * @see com.ext.portlet.ontology.service.OntologyTermServiceUtil
 * @generated
 */
public abstract class OntologyTermServiceBaseImpl extends PrincipalBean
    implements OntologyTermService, IdentifiableBean {
    @BeanReference(type = FocusAreaLocalService.class)
    protected FocusAreaLocalService focusAreaLocalService;
    @BeanReference(type = FocusAreaService.class)
    protected FocusAreaService focusAreaService;
    @BeanReference(type = FocusAreaPersistence.class)
    protected FocusAreaPersistence focusAreaPersistence;
    @BeanReference(type = FocusAreaOntologyTermLocalService.class)
    protected FocusAreaOntologyTermLocalService focusAreaOntologyTermLocalService;
    @BeanReference(type = FocusAreaOntologyTermService.class)
    protected FocusAreaOntologyTermService focusAreaOntologyTermService;
    @BeanReference(type = FocusAreaOntologyTermPersistence.class)
    protected FocusAreaOntologyTermPersistence focusAreaOntologyTermPersistence;
    @BeanReference(type = OntologySpaceLocalService.class)
    protected OntologySpaceLocalService ontologySpaceLocalService;
    @BeanReference(type = OntologySpaceService.class)
    protected OntologySpaceService ontologySpaceService;
    @BeanReference(type = OntologySpacePersistence.class)
    protected OntologySpacePersistence ontologySpacePersistence;
    @BeanReference(type = OntologyTermLocalService.class)
    protected OntologyTermLocalService ontologyTermLocalService;
    @BeanReference(type = OntologyTermService.class)
    protected OntologyTermService ontologyTermService;
    @BeanReference(type = OntologyTermPersistence.class)
    protected OntologyTermPersistence ontologyTermPersistence;
    @BeanReference(type = OntologyTermEntityLocalService.class)
    protected OntologyTermEntityLocalService ontologyTermEntityLocalService;
    @BeanReference(type = OntologyTermEntityService.class)
    protected OntologyTermEntityService ontologyTermEntityService;
    @BeanReference(type = OntologyTermEntityPersistence.class)
    protected OntologyTermEntityPersistence ontologyTermEntityPersistence;
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
     * Never modify or reference this class directly. Always use {@link com.ext.portlet.ontology.service.OntologyTermServiceUtil} to access the ontology term remote service.
     */

    /**
     * Returns the focus area local service.
     *
     * @return the focus area local service
     */
    public FocusAreaLocalService getFocusAreaLocalService() {
        return focusAreaLocalService;
    }

    /**
     * Sets the focus area local service.
     *
     * @param focusAreaLocalService the focus area local service
     */
    public void setFocusAreaLocalService(
        FocusAreaLocalService focusAreaLocalService) {
        this.focusAreaLocalService = focusAreaLocalService;
    }

    /**
     * Returns the focus area remote service.
     *
     * @return the focus area remote service
     */
    public FocusAreaService getFocusAreaService() {
        return focusAreaService;
    }

    /**
     * Sets the focus area remote service.
     *
     * @param focusAreaService the focus area remote service
     */
    public void setFocusAreaService(FocusAreaService focusAreaService) {
        this.focusAreaService = focusAreaService;
    }

    /**
     * Returns the focus area persistence.
     *
     * @return the focus area persistence
     */
    public FocusAreaPersistence getFocusAreaPersistence() {
        return focusAreaPersistence;
    }

    /**
     * Sets the focus area persistence.
     *
     * @param focusAreaPersistence the focus area persistence
     */
    public void setFocusAreaPersistence(
        FocusAreaPersistence focusAreaPersistence) {
        this.focusAreaPersistence = focusAreaPersistence;
    }

    /**
     * Returns the focus area ontology term local service.
     *
     * @return the focus area ontology term local service
     */
    public FocusAreaOntologyTermLocalService getFocusAreaOntologyTermLocalService() {
        return focusAreaOntologyTermLocalService;
    }

    /**
     * Sets the focus area ontology term local service.
     *
     * @param focusAreaOntologyTermLocalService the focus area ontology term local service
     */
    public void setFocusAreaOntologyTermLocalService(
        FocusAreaOntologyTermLocalService focusAreaOntologyTermLocalService) {
        this.focusAreaOntologyTermLocalService = focusAreaOntologyTermLocalService;
    }

    /**
     * Returns the focus area ontology term remote service.
     *
     * @return the focus area ontology term remote service
     */
    public FocusAreaOntologyTermService getFocusAreaOntologyTermService() {
        return focusAreaOntologyTermService;
    }

    /**
     * Sets the focus area ontology term remote service.
     *
     * @param focusAreaOntologyTermService the focus area ontology term remote service
     */
    public void setFocusAreaOntologyTermService(
        FocusAreaOntologyTermService focusAreaOntologyTermService) {
        this.focusAreaOntologyTermService = focusAreaOntologyTermService;
    }

    /**
     * Returns the focus area ontology term persistence.
     *
     * @return the focus area ontology term persistence
     */
    public FocusAreaOntologyTermPersistence getFocusAreaOntologyTermPersistence() {
        return focusAreaOntologyTermPersistence;
    }

    /**
     * Sets the focus area ontology term persistence.
     *
     * @param focusAreaOntologyTermPersistence the focus area ontology term persistence
     */
    public void setFocusAreaOntologyTermPersistence(
        FocusAreaOntologyTermPersistence focusAreaOntologyTermPersistence) {
        this.focusAreaOntologyTermPersistence = focusAreaOntologyTermPersistence;
    }

    /**
     * Returns the ontology space local service.
     *
     * @return the ontology space local service
     */
    public OntologySpaceLocalService getOntologySpaceLocalService() {
        return ontologySpaceLocalService;
    }

    /**
     * Sets the ontology space local service.
     *
     * @param ontologySpaceLocalService the ontology space local service
     */
    public void setOntologySpaceLocalService(
        OntologySpaceLocalService ontologySpaceLocalService) {
        this.ontologySpaceLocalService = ontologySpaceLocalService;
    }

    /**
     * Returns the ontology space remote service.
     *
     * @return the ontology space remote service
     */
    public OntologySpaceService getOntologySpaceService() {
        return ontologySpaceService;
    }

    /**
     * Sets the ontology space remote service.
     *
     * @param ontologySpaceService the ontology space remote service
     */
    public void setOntologySpaceService(
        OntologySpaceService ontologySpaceService) {
        this.ontologySpaceService = ontologySpaceService;
    }

    /**
     * Returns the ontology space persistence.
     *
     * @return the ontology space persistence
     */
    public OntologySpacePersistence getOntologySpacePersistence() {
        return ontologySpacePersistence;
    }

    /**
     * Sets the ontology space persistence.
     *
     * @param ontologySpacePersistence the ontology space persistence
     */
    public void setOntologySpacePersistence(
        OntologySpacePersistence ontologySpacePersistence) {
        this.ontologySpacePersistence = ontologySpacePersistence;
    }

    /**
     * Returns the ontology term local service.
     *
     * @return the ontology term local service
     */
    public OntologyTermLocalService getOntologyTermLocalService() {
        return ontologyTermLocalService;
    }

    /**
     * Sets the ontology term local service.
     *
     * @param ontologyTermLocalService the ontology term local service
     */
    public void setOntologyTermLocalService(
        OntologyTermLocalService ontologyTermLocalService) {
        this.ontologyTermLocalService = ontologyTermLocalService;
    }

    /**
     * Returns the ontology term remote service.
     *
     * @return the ontology term remote service
     */
    public OntologyTermService getOntologyTermService() {
        return ontologyTermService;
    }

    /**
     * Sets the ontology term remote service.
     *
     * @param ontologyTermService the ontology term remote service
     */
    public void setOntologyTermService(OntologyTermService ontologyTermService) {
        this.ontologyTermService = ontologyTermService;
    }

    /**
     * Returns the ontology term persistence.
     *
     * @return the ontology term persistence
     */
    public OntologyTermPersistence getOntologyTermPersistence() {
        return ontologyTermPersistence;
    }

    /**
     * Sets the ontology term persistence.
     *
     * @param ontologyTermPersistence the ontology term persistence
     */
    public void setOntologyTermPersistence(
        OntologyTermPersistence ontologyTermPersistence) {
        this.ontologyTermPersistence = ontologyTermPersistence;
    }

    /**
     * Returns the ontology term entity local service.
     *
     * @return the ontology term entity local service
     */
    public OntologyTermEntityLocalService getOntologyTermEntityLocalService() {
        return ontologyTermEntityLocalService;
    }

    /**
     * Sets the ontology term entity local service.
     *
     * @param ontologyTermEntityLocalService the ontology term entity local service
     */
    public void setOntologyTermEntityLocalService(
        OntologyTermEntityLocalService ontologyTermEntityLocalService) {
        this.ontologyTermEntityLocalService = ontologyTermEntityLocalService;
    }

    /**
     * Returns the ontology term entity remote service.
     *
     * @return the ontology term entity remote service
     */
    public OntologyTermEntityService getOntologyTermEntityService() {
        return ontologyTermEntityService;
    }

    /**
     * Sets the ontology term entity remote service.
     *
     * @param ontologyTermEntityService the ontology term entity remote service
     */
    public void setOntologyTermEntityService(
        OntologyTermEntityService ontologyTermEntityService) {
        this.ontologyTermEntityService = ontologyTermEntityService;
    }

    /**
     * Returns the ontology term entity persistence.
     *
     * @return the ontology term entity persistence
     */
    public OntologyTermEntityPersistence getOntologyTermEntityPersistence() {
        return ontologyTermEntityPersistence;
    }

    /**
     * Sets the ontology term entity persistence.
     *
     * @param ontologyTermEntityPersistence the ontology term entity persistence
     */
    public void setOntologyTermEntityPersistence(
        OntologyTermEntityPersistence ontologyTermEntityPersistence) {
        this.ontologyTermEntityPersistence = ontologyTermEntityPersistence;
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
        return OntologyTerm.class;
    }

    protected String getModelClassName() {
        return OntologyTerm.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = ontologyTermPersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
