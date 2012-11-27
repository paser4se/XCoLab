package com.ext.portlet.plans.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the PlanSectionPlanMap service. Represents a row in the &quot;Plans_PlanSectionPlanMap&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see PlanSectionPlanMapModel
 * @see com.ext.portlet.plans.model.impl.PlanSectionPlanMapImpl
 * @see com.ext.portlet.plans.model.impl.PlanSectionPlanMapModelImpl
 * @generated
 */
public interface PlanSectionPlanMap extends PlanSectionPlanMapModel,
    PersistedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this interface directly. Add methods to {@link com.ext.portlet.plans.model.impl.PlanSectionPlanMapImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */
    public void store()
        throws com.liferay.portal.kernel.exception.SystemException;
}
