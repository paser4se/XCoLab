package com.ext.portlet.plans.model.impl;

import com.ext.portlet.plans.model.PlanPositions;
import com.ext.portlet.plans.model.PlanPositionsModel;
import com.ext.portlet.plans.model.PlanPositionsSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The base model implementation for the PlanPositions service. Represents a row in the &quot;Plans_PlanPositions&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.plans.model.PlanPositionsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PlanPositionsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlanPositionsImpl
 * @see com.ext.portlet.plans.model.PlanPositions
 * @see com.ext.portlet.plans.model.PlanPositionsModel
 * @generated
 */
@JSON(strict = true)
public class PlanPositionsModelImpl extends BaseModelImpl<PlanPositions>
    implements PlanPositionsModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a plan positions model instance should use the {@link com.ext.portlet.plans.model.PlanPositions} interface instead.
     */
    public static final String TABLE_NAME = "Plans_PlanPositions";
    public static final Object[][] TABLE_COLUMNS = {
            { "id_", Types.BIGINT },
            { "planId", Types.BIGINT },
            { "planVersion", Types.BIGINT },
            { "version", Types.BIGINT },
            { "created", Types.TIMESTAMP },
            { "updateAuthorId", Types.BIGINT }
        };
    public static final String TABLE_SQL_CREATE = "create table Plans_PlanPositions (id_ LONG not null primary key,planId LONG,planVersion LONG,version LONG,created DATE null,updateAuthorId LONG)";
    public static final String TABLE_SQL_DROP = "drop table Plans_PlanPositions";
    public static final String ORDER_BY_JPQL = " ORDER BY planPositions.id DESC";
    public static final String ORDER_BY_SQL = " ORDER BY Plans_PlanPositions.id_ DESC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.ext.portlet.plans.model.PlanPositions"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.ext.portlet.plans.model.PlanPositions"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.ext.portlet.plans.model.PlanPositions"),
            true);
    public static long PLANID_COLUMN_BITMASK = 1L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.ext.portlet.plans.model.PlanPositions"));
    private static ClassLoader _classLoader = PlanPositions.class.getClassLoader();
    private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
            PlanPositions.class
        };
    private Long _id;
    private Long _planId;
    private Long _originalPlanId;
    private boolean _setOriginalPlanId;
    private Long _planVersion;
    private Long _version;
    private Date _created;
    private Long _updateAuthorId;
    private long _columnBitmask;
    private PlanPositions _escapedModelProxy;

    public PlanPositionsModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static PlanPositions toModel(PlanPositionsSoap soapModel) {
        PlanPositions model = new PlanPositionsImpl();

        model.setId(soapModel.getId());
        model.setPlanId(soapModel.getPlanId());
        model.setPlanVersion(soapModel.getPlanVersion());
        model.setVersion(soapModel.getVersion());
        model.setCreated(soapModel.getCreated());
        model.setUpdateAuthorId(soapModel.getUpdateAuthorId());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<PlanPositions> toModels(PlanPositionsSoap[] soapModels) {
        List<PlanPositions> models = new ArrayList<PlanPositions>(soapModels.length);

        for (PlanPositionsSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public Long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(Long primaryKey) {
        setId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_id);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    public Class<?> getModelClass() {
        return PlanPositions.class;
    }

    public String getModelClassName() {
        return PlanPositions.class.getName();
    }

    @JSON
    public Long getId() {
        return _id;
    }

    public void setId(Long id) {
        _columnBitmask = -1L;

        _id = id;
    }

    @JSON
    public Long getPlanId() {
        return _planId;
    }

    public void setPlanId(Long planId) {
        _columnBitmask |= PLANID_COLUMN_BITMASK;

        if (!_setOriginalPlanId) {
            _setOriginalPlanId = true;

            _originalPlanId = _planId;
        }

        _planId = planId;
    }

    public Long getOriginalPlanId() {
        return _originalPlanId;
    }

    @JSON
    public Long getPlanVersion() {
        return _planVersion;
    }

    public void setPlanVersion(Long planVersion) {
        _planVersion = planVersion;
    }

    @JSON
    public Long getVersion() {
        return _version;
    }

    public void setVersion(Long version) {
        _version = version;
    }

    @JSON
    public Date getCreated() {
        return _created;
    }

    public void setCreated(Date created) {
        _created = created;
    }

    @JSON
    public Long getUpdateAuthorId() {
        return _updateAuthorId;
    }

    public void setUpdateAuthorId(Long updateAuthorId) {
        _updateAuthorId = updateAuthorId;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public PlanPositions toEscapedModel() {
        if (_escapedModelProxy == null) {
            _escapedModelProxy = (PlanPositions) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelProxyInterfaces,
                    new AutoEscapeBeanHandler(this));
        }

        return _escapedModelProxy;
    }

    @Override
    public Object clone() {
        PlanPositionsImpl planPositionsImpl = new PlanPositionsImpl();

        planPositionsImpl.setId(getId());
        planPositionsImpl.setPlanId(getPlanId());
        planPositionsImpl.setPlanVersion(getPlanVersion());
        planPositionsImpl.setVersion(getVersion());
        planPositionsImpl.setCreated(getCreated());
        planPositionsImpl.setUpdateAuthorId(getUpdateAuthorId());

        planPositionsImpl.resetOriginalValues();

        return planPositionsImpl;
    }

    public int compareTo(PlanPositions planPositions) {
        int value = 0;

        if (getId() < planPositions.getId()) {
            value = -1;
        } else if (getId() > planPositions.getId()) {
            value = 1;
        } else {
            value = 0;
        }

        value = value * -1;

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PlanPositions planPositions = null;

        try {
            planPositions = (PlanPositions) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        Long primaryKey = planPositions.getPrimaryKey();

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
    public void resetOriginalValues() {
        PlanPositionsModelImpl planPositionsModelImpl = this;

        planPositionsModelImpl._originalPlanId = planPositionsModelImpl._planId;

        planPositionsModelImpl._setOriginalPlanId = false;

        planPositionsModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<PlanPositions> toCacheModel() {
        PlanPositionsCacheModel planPositionsCacheModel = new PlanPositionsCacheModel();

        planPositionsCacheModel.id = getId();

        planPositionsCacheModel.planId = getPlanId();

        planPositionsCacheModel.planVersion = getPlanVersion();

        planPositionsCacheModel.version = getVersion();

        Date created = getCreated();

        if (created != null) {
            planPositionsCacheModel.created = created.getTime();
        } else {
            planPositionsCacheModel.created = Long.MIN_VALUE;
        }

        planPositionsCacheModel.updateAuthorId = getUpdateAuthorId();

        return planPositionsCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", planId=");
        sb.append(getPlanId());
        sb.append(", planVersion=");
        sb.append(getPlanVersion());
        sb.append(", version=");
        sb.append(getVersion());
        sb.append(", created=");
        sb.append(getCreated());
        sb.append(", updateAuthorId=");
        sb.append(getUpdateAuthorId());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.plans.model.PlanPositions");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>planId</column-name><column-value><![CDATA[");
        sb.append(getPlanId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>planVersion</column-name><column-value><![CDATA[");
        sb.append(getPlanVersion());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>version</column-name><column-value><![CDATA[");
        sb.append(getVersion());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>created</column-name><column-value><![CDATA[");
        sb.append(getCreated());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>updateAuthorId</column-name><column-value><![CDATA[");
        sb.append(getUpdateAuthorId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
