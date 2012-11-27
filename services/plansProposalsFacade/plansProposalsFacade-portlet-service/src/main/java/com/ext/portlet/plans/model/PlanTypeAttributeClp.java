package com.ext.portlet.plans.model;

import com.ext.portlet.plans.service.PlanTypeAttributeLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;


public class PlanTypeAttributeClp extends BaseModelImpl<PlanTypeAttribute>
    implements PlanTypeAttribute {
    private Long _planTypeAttributeId;
    private Long _planTypeId;
    private String _attributeName;

    public PlanTypeAttributeClp() {
    }

    public Class<?> getModelClass() {
        return PlanTypeAttribute.class;
    }

    public String getModelClassName() {
        return PlanTypeAttribute.class.getName();
    }

    public Long getPrimaryKey() {
        return _planTypeAttributeId;
    }

    public void setPrimaryKey(Long primaryKey) {
        setPlanTypeAttributeId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_planTypeAttributeId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    public Long getPlanTypeAttributeId() {
        return _planTypeAttributeId;
    }

    public void setPlanTypeAttributeId(Long planTypeAttributeId) {
        _planTypeAttributeId = planTypeAttributeId;
    }

    public Long getPlanTypeId() {
        return _planTypeId;
    }

    public void setPlanTypeId(Long planTypeId) {
        _planTypeId = planTypeId;
    }

    public String getAttributeName() {
        return _attributeName;
    }

    public void setAttributeName(String attributeName) {
        _attributeName = attributeName;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            PlanTypeAttributeLocalServiceUtil.addPlanTypeAttribute(this);
        } else {
            PlanTypeAttributeLocalServiceUtil.updatePlanTypeAttribute(this);
        }
    }

    @Override
    public PlanTypeAttribute toEscapedModel() {
        return (PlanTypeAttribute) Proxy.newProxyInstance(PlanTypeAttribute.class.getClassLoader(),
            new Class[] { PlanTypeAttribute.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        PlanTypeAttributeClp clone = new PlanTypeAttributeClp();

        clone.setPlanTypeAttributeId(getPlanTypeAttributeId());
        clone.setPlanTypeId(getPlanTypeId());
        clone.setAttributeName(getAttributeName());

        return clone;
    }

    public int compareTo(PlanTypeAttribute planTypeAttribute) {
        Long primaryKey = planTypeAttribute.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PlanTypeAttributeClp planTypeAttribute = null;

        try {
            planTypeAttribute = (PlanTypeAttributeClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        Long primaryKey = planTypeAttribute.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return getPrimaryKey().hashCode();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{planTypeAttributeId=");
        sb.append(getPlanTypeAttributeId());
        sb.append(", planTypeId=");
        sb.append(getPlanTypeId());
        sb.append(", attributeName=");
        sb.append(getAttributeName());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.plans.model.PlanTypeAttribute");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>planTypeAttributeId</column-name><column-value><![CDATA[");
        sb.append(getPlanTypeAttributeId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>planTypeId</column-name><column-value><![CDATA[");
        sb.append(getPlanTypeId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>attributeName</column-name><column-value><![CDATA[");
        sb.append(getAttributeName());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
