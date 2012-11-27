package com.ext.portlet.plans.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the plan type column local service. This utility wraps {@link com.ext.portlet.plans.service.impl.PlanTypeColumnLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlanTypeColumnLocalService
 * @see com.ext.portlet.plans.service.base.PlanTypeColumnLocalServiceBaseImpl
 * @see com.ext.portlet.plans.service.impl.PlanTypeColumnLocalServiceImpl
 * @generated
 */
public class PlanTypeColumnLocalServiceUtil {
    private static PlanTypeColumnLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.ext.portlet.plans.service.impl.PlanTypeColumnLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the plan type column to the database. Also notifies the appropriate model listeners.
    *
    * @param planTypeColumn the plan type column
    * @return the plan type column that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.plans.model.PlanTypeColumn addPlanTypeColumn(
        com.ext.portlet.plans.model.PlanTypeColumn planTypeColumn)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addPlanTypeColumn(planTypeColumn);
    }

    /**
    * Creates a new plan type column with the primary key. Does not add the plan type column to the database.
    *
    * @param planTypeColumnId the primary key for the new plan type column
    * @return the new plan type column
    */
    public static com.ext.portlet.plans.model.PlanTypeColumn createPlanTypeColumn(
        java.lang.Long planTypeColumnId) {
        return getService().createPlanTypeColumn(planTypeColumnId);
    }

    /**
    * Deletes the plan type column with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param planTypeColumnId the primary key of the plan type column
    * @throws PortalException if a plan type column with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static void deletePlanTypeColumn(java.lang.Long planTypeColumnId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().deletePlanTypeColumn(planTypeColumnId);
    }

    /**
    * Deletes the plan type column from the database. Also notifies the appropriate model listeners.
    *
    * @param planTypeColumn the plan type column
    * @throws SystemException if a system exception occurred
    */
    public static void deletePlanTypeColumn(
        com.ext.portlet.plans.model.PlanTypeColumn planTypeColumn)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deletePlanTypeColumn(planTypeColumn);
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
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
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
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
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    public static com.ext.portlet.plans.model.PlanTypeColumn fetchPlanTypeColumn(
        java.lang.Long planTypeColumnId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchPlanTypeColumn(planTypeColumnId);
    }

    /**
    * Returns the plan type column with the primary key.
    *
    * @param planTypeColumnId the primary key of the plan type column
    * @return the plan type column
    * @throws PortalException if a plan type column with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.plans.model.PlanTypeColumn getPlanTypeColumn(
        java.lang.Long planTypeColumnId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPlanTypeColumn(planTypeColumnId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the plan type columns.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of plan type columns
    * @param end the upper bound of the range of plan type columns (not inclusive)
    * @return the range of plan type columns
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.plans.model.PlanTypeColumn> getPlanTypeColumns(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getPlanTypeColumns(start, end);
    }

    /**
    * Returns the number of plan type columns.
    *
    * @return the number of plan type columns
    * @throws SystemException if a system exception occurred
    */
    public static int getPlanTypeColumnsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getPlanTypeColumnsCount();
    }

    /**
    * Updates the plan type column in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param planTypeColumn the plan type column
    * @return the plan type column that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.plans.model.PlanTypeColumn updatePlanTypeColumn(
        com.ext.portlet.plans.model.PlanTypeColumn planTypeColumn)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updatePlanTypeColumn(planTypeColumn);
    }

    /**
    * Updates the plan type column in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param planTypeColumn the plan type column
    * @param merge whether to merge the plan type column with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the plan type column that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.plans.model.PlanTypeColumn updatePlanTypeColumn(
        com.ext.portlet.plans.model.PlanTypeColumn planTypeColumn, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updatePlanTypeColumn(planTypeColumn, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static void clearService() {
        _service = null;
    }

    public static PlanTypeColumnLocalService getService() {
        if (_service == null) {
            Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    PlanTypeColumnLocalService.class.getName());
            ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    "portletClassLoader");

            ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
                    PlanTypeColumnLocalService.class.getName(),
                    portletClassLoader);

            _service = new PlanTypeColumnLocalServiceClp(classLoaderProxy);

            ClpSerializer.setClassLoader(portletClassLoader);

            ReferenceRegistry.registerReference(PlanTypeColumnLocalServiceUtil.class,
                "_service");
            MethodCache.remove(PlanTypeColumnLocalService.class);
        }

        return _service;
    }

    public void setService(PlanTypeColumnLocalService service) {
        MethodCache.remove(PlanTypeColumnLocalService.class);

        _service = service;

        ReferenceRegistry.registerReference(PlanTypeColumnLocalServiceUtil.class,
            "_service");
        MethodCache.remove(PlanTypeColumnLocalService.class);
    }
}
