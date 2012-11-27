package com.ext.portlet.plans.model.impl;

import com.ext.portlet.plans.model.PlanMeta;
import com.ext.portlet.plans.service.PlanMetaLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the PlanMeta service. Represents a row in the &quot;Plans_PlanMeta&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PlanMetaImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlanMetaImpl
 * @see com.ext.portlet.plans.model.PlanMeta
 * @generated
 */
public abstract class PlanMetaBaseImpl extends PlanMetaModelImpl
    implements PlanMeta {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a plan meta model instance should use the {@link PlanMeta} interface instead.
     */
    public void persist() throws SystemException {
        if (this.isNew()) {
            PlanMetaLocalServiceUtil.addPlanMeta(this);
        } else {
            PlanMetaLocalServiceUtil.updatePlanMeta(this);
        }
    }
}
