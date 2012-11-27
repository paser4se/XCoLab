package com.ext.portlet.models.model;

import com.ext.portlet.models.service.ModelDiscussionLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;


public class ModelDiscussionClp extends BaseModelImpl<ModelDiscussion>
    implements ModelDiscussion {
    private Long _modelDiscussionId;
    private Long _modelId;
    private Long _categoryId;

    public ModelDiscussionClp() {
    }

    public Class<?> getModelClass() {
        return ModelDiscussion.class;
    }

    public String getModelClassName() {
        return ModelDiscussion.class.getName();
    }

    public Long getPrimaryKey() {
        return _modelDiscussionId;
    }

    public void setPrimaryKey(Long primaryKey) {
        setModelDiscussionId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_modelDiscussionId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    public Long getModelDiscussionId() {
        return _modelDiscussionId;
    }

    public void setModelDiscussionId(Long modelDiscussionId) {
        _modelDiscussionId = modelDiscussionId;
    }

    public Long getModelId() {
        return _modelId;
    }

    public void setModelId(Long modelId) {
        _modelId = modelId;
    }

    public Long getCategoryId() {
        return _categoryId;
    }

    public void setCategoryId(Long categoryId) {
        _categoryId = categoryId;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            ModelDiscussionLocalServiceUtil.addModelDiscussion(this);
        } else {
            ModelDiscussionLocalServiceUtil.updateModelDiscussion(this);
        }
    }

    @Override
    public ModelDiscussion toEscapedModel() {
        return (ModelDiscussion) Proxy.newProxyInstance(ModelDiscussion.class.getClassLoader(),
            new Class[] { ModelDiscussion.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ModelDiscussionClp clone = new ModelDiscussionClp();

        clone.setModelDiscussionId(getModelDiscussionId());
        clone.setModelId(getModelId());
        clone.setCategoryId(getCategoryId());

        return clone;
    }

    public int compareTo(ModelDiscussion modelDiscussion) {
        Long primaryKey = modelDiscussion.getPrimaryKey();

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

        ModelDiscussionClp modelDiscussion = null;

        try {
            modelDiscussion = (ModelDiscussionClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        Long primaryKey = modelDiscussion.getPrimaryKey();

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

        sb.append("{modelDiscussionId=");
        sb.append(getModelDiscussionId());
        sb.append(", modelId=");
        sb.append(getModelId());
        sb.append(", categoryId=");
        sb.append(getCategoryId());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.models.model.ModelDiscussion");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>modelDiscussionId</column-name><column-value><![CDATA[");
        sb.append(getModelDiscussionId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modelId</column-name><column-value><![CDATA[");
        sb.append(getModelId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>categoryId</column-name><column-value><![CDATA[");
        sb.append(getCategoryId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
