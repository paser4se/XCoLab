package com.ext.portlet.plans.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the plan position item local service. This utility wraps {@link com.ext.portlet.plans.service.impl.PlanPositionItemLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlanPositionItemLocalService
 * @see com.ext.portlet.plans.service.base.PlanPositionItemLocalServiceBaseImpl
 * @see com.ext.portlet.plans.service.impl.PlanPositionItemLocalServiceImpl
 * @generated
 */
public class PlanPositionItemLocalServiceUtil {
    private static PlanPositionItemLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.ext.portlet.plans.service.impl.PlanPositionItemLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the plan position item to the database. Also notifies the appropriate model listeners.
    *
    * @param planPositionItem the plan position item
    * @return the plan position item that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.plans.model.PlanPositionItem addPlanPositionItem(
        com.ext.portlet.plans.model.PlanPositionItem planPositionItem)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addPlanPositionItem(planPositionItem);
    }

    /**
    * Creates a new plan position item with the primary key. Does not add the plan position item to the database.
    *
    * @param planPositionItemPK the primary key for the new plan position item
    * @return the new plan position item
    */
    public static com.ext.portlet.plans.model.PlanPositionItem createPlanPositionItem(
        com.ext.portlet.plans.service.persistence.PlanPositionItemPK planPositionItemPK) {
        return getService().createPlanPositionItem(planPositionItemPK);
    }

    /**
    * Deletes the plan position item with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param planPositionItemPK the primary key of the plan position item
    * @throws PortalException if a plan position item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static void deletePlanPositionItem(
        com.ext.portlet.plans.service.persistence.PlanPositionItemPK planPositionItemPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().deletePlanPositionItem(planPositionItemPK);
    }

    /**
    * Deletes the plan position item from the database. Also notifies the appropriate model listeners.
    *
    * @param planPositionItem the plan position item
    * @throws SystemException if a system exception occurred
    */
    public static void deletePlanPositionItem(
        com.ext.portlet.plans.model.PlanPositionItem planPositionItem)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deletePlanPositionItem(planPositionItem);
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

    public static com.ext.portlet.plans.model.PlanPositionItem fetchPlanPositionItem(
        com.ext.portlet.plans.service.persistence.PlanPositionItemPK planPositionItemPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchPlanPositionItem(planPositionItemPK);
    }

    /**
    * Returns the plan position item with the primary key.
    *
    * @param planPositionItemPK the primary key of the plan position item
    * @return the plan position item
    * @throws PortalException if a plan position item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.plans.model.PlanPositionItem getPlanPositionItem(
        com.ext.portlet.plans.service.persistence.PlanPositionItemPK planPositionItemPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPlanPositionItem(planPositionItemPK);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the plan position items.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of plan position items
    * @param end the upper bound of the range of plan position items (not inclusive)
    * @return the range of plan position items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.plans.model.PlanPositionItem> getPlanPositionItems(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getPlanPositionItems(start, end);
    }

    /**
    * Returns the number of plan position items.
    *
    * @return the number of plan position items
    * @throws SystemException if a system exception occurred
    */
    public static int getPlanPositionItemsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getPlanPositionItemsCount();
    }

    /**
    * Updates the plan position item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param planPositionItem the plan position item
    * @return the plan position item that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.plans.model.PlanPositionItem updatePlanPositionItem(
        com.ext.portlet.plans.model.PlanPositionItem planPositionItem)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updatePlanPositionItem(planPositionItem);
    }

    /**
    * Updates the plan position item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param planPositionItem the plan position item
    * @param merge whether to merge the plan position item with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the plan position item that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.plans.model.PlanPositionItem updatePlanPositionItem(
        com.ext.portlet.plans.model.PlanPositionItem planPositionItem,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updatePlanPositionItem(planPositionItem, merge);
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

    public static java.util.List<com.ext.portlet.plans.model.PlanPositionItem> getAllIdsForPlanPositions(
        com.ext.portlet.plans.model.PlanPositions planPositions)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAllIdsForPlanPositions(planPositions);
    }

    public static void clearService() {
        _service = null;
    }

    public static PlanPositionItemLocalService getService() {
        if (_service == null) {
            Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    PlanPositionItemLocalService.class.getName());
            ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    "portletClassLoader");

            ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
                    PlanPositionItemLocalService.class.getName(),
                    portletClassLoader);

            _service = new PlanPositionItemLocalServiceClp(classLoaderProxy);

            ClpSerializer.setClassLoader(portletClassLoader);

            ReferenceRegistry.registerReference(PlanPositionItemLocalServiceUtil.class,
                "_service");
            MethodCache.remove(PlanPositionItemLocalService.class);
        }

        return _service;
    }

    public void setService(PlanPositionItemLocalService service) {
        MethodCache.remove(PlanPositionItemLocalService.class);

        _service = service;

        ReferenceRegistry.registerReference(PlanPositionItemLocalServiceUtil.class,
            "_service");
        MethodCache.remove(PlanPositionItemLocalService.class);
    }
}
