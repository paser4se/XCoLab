package com.ext.portlet.plans.model.impl;

import com.ext.portlet.plans.model.PlansFilter;
import com.ext.portlet.plans.model.PlansFilterModel;
import com.ext.portlet.plans.model.PlansFilterSoap;
import com.ext.portlet.plans.service.persistence.PlansFilterPK;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The base model implementation for the PlansFilter service. Represents a row in the &quot;Plans_PlansFilter&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.plans.model.PlansFilterModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PlansFilterImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlansFilterImpl
 * @see com.ext.portlet.plans.model.PlansFilter
 * @see com.ext.portlet.plans.model.PlansFilterModel
 * @generated
 */
@JSON(strict = true)
public class PlansFilterModelImpl extends BaseModelImpl<PlansFilter>
    implements PlansFilterModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a plans filter model instance should use the {@link com.ext.portlet.plans.model.PlansFilter} interface instead.
     */
    public static final String TABLE_NAME = "Plans_PlansFilter";
    public static final Object[][] TABLE_COLUMNS = {
            { "userId", Types.BIGINT },
            { "planTypeId", Types.BIGINT },
            { "name", Types.VARCHAR },
            { "creator", Types.VARCHAR },
            { "description", Types.VARCHAR },
            { "CO2From", Types.DOUBLE },
            { "CO2To", Types.DOUBLE },
            { "votesFrom", Types.DOUBLE },
            { "votesTo", Types.DOUBLE },
            { "damageFrom", Types.DOUBLE },
            { "damageTo", Types.DOUBLE },
            { "mitigationFrom", Types.DOUBLE },
            { "mitigationTo", Types.DOUBLE },
            { "dateFrom", Types.TIMESTAMP },
            { "dateTo", Types.TIMESTAMP },
            { "filterPositionsAll", Types.BOOLEAN },
            { "enabled", Types.BOOLEAN }
        };
    public static final String TABLE_SQL_CREATE = "create table Plans_PlansFilter (userId LONG not null,planTypeId LONG not null,name VARCHAR(75) null,creator VARCHAR(75) null,description VARCHAR(75) null,CO2From DOUBLE,CO2To DOUBLE,votesFrom DOUBLE,votesTo DOUBLE,damageFrom DOUBLE,damageTo DOUBLE,mitigationFrom DOUBLE,mitigationTo DOUBLE,dateFrom DATE null,dateTo DATE null,filterPositionsAll BOOLEAN,enabled BOOLEAN,primary key (userId, planTypeId))";
    public static final String TABLE_SQL_DROP = "drop table Plans_PlansFilter";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.ext.portlet.plans.model.PlansFilter"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.ext.portlet.plans.model.PlansFilter"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = false;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.ext.portlet.plans.model.PlansFilter"));
    private static ClassLoader _classLoader = PlansFilter.class.getClassLoader();
    private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
            PlansFilter.class
        };
    private Long _userId;
    private Long _planTypeId;
    private String _name;
    private String _creator;
    private String _description;
    private Double _CO2From;
    private Double _CO2To;
    private Double _votesFrom;
    private Double _votesTo;
    private Double _damageFrom;
    private Double _damageTo;
    private Double _mitigationFrom;
    private Double _mitigationTo;
    private Date _dateFrom;
    private Date _dateTo;
    private Boolean _filterPositionsAll;
    private Boolean _enabled;
    private PlansFilter _escapedModelProxy;

    public PlansFilterModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static PlansFilter toModel(PlansFilterSoap soapModel) {
        PlansFilter model = new PlansFilterImpl();

        model.setUserId(soapModel.getUserId());
        model.setPlanTypeId(soapModel.getPlanTypeId());
        model.setName(soapModel.getName());
        model.setCreator(soapModel.getCreator());
        model.setDescription(soapModel.getDescription());
        model.setCO2From(soapModel.getCO2From());
        model.setCO2To(soapModel.getCO2To());
        model.setVotesFrom(soapModel.getVotesFrom());
        model.setVotesTo(soapModel.getVotesTo());
        model.setDamageFrom(soapModel.getDamageFrom());
        model.setDamageTo(soapModel.getDamageTo());
        model.setMitigationFrom(soapModel.getMitigationFrom());
        model.setMitigationTo(soapModel.getMitigationTo());
        model.setDateFrom(soapModel.getDateFrom());
        model.setDateTo(soapModel.getDateTo());
        model.setFilterPositionsAll(soapModel.getFilterPositionsAll());
        model.setEnabled(soapModel.getEnabled());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<PlansFilter> toModels(PlansFilterSoap[] soapModels) {
        List<PlansFilter> models = new ArrayList<PlansFilter>(soapModels.length);

        for (PlansFilterSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public PlansFilterPK getPrimaryKey() {
        return new PlansFilterPK(_userId, _planTypeId);
    }

    public void setPrimaryKey(PlansFilterPK primaryKey) {
        setUserId(primaryKey.userId);
        setPlanTypeId(primaryKey.planTypeId);
    }

    public Serializable getPrimaryKeyObj() {
        return new PlansFilterPK(_userId, _planTypeId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey((PlansFilterPK) primaryKeyObj);
    }

    public Class<?> getModelClass() {
        return PlansFilter.class;
    }

    public String getModelClassName() {
        return PlansFilter.class.getName();
    }

    @JSON
    public Long getUserId() {
        return _userId;
    }

    public void setUserId(Long userId) {
        _userId = userId;
    }

    @JSON
    public Long getPlanTypeId() {
        return _planTypeId;
    }

    public void setPlanTypeId(Long planTypeId) {
        _planTypeId = planTypeId;
    }

    @JSON
    public String getName() {
        if (_name == null) {
            return StringPool.BLANK;
        } else {
            return _name;
        }
    }

    public void setName(String name) {
        _name = name;
    }

    @JSON
    public String getCreator() {
        if (_creator == null) {
            return StringPool.BLANK;
        } else {
            return _creator;
        }
    }

    public void setCreator(String creator) {
        _creator = creator;
    }

    @JSON
    public String getDescription() {
        if (_description == null) {
            return StringPool.BLANK;
        } else {
            return _description;
        }
    }

    public void setDescription(String description) {
        _description = description;
    }

    @JSON
    public Double getCO2From() {
        return _CO2From;
    }

    public void setCO2From(Double CO2From) {
        _CO2From = CO2From;
    }

    @JSON
    public Double getCO2To() {
        return _CO2To;
    }

    public void setCO2To(Double CO2To) {
        _CO2To = CO2To;
    }

    @JSON
    public Double getVotesFrom() {
        return _votesFrom;
    }

    public void setVotesFrom(Double votesFrom) {
        _votesFrom = votesFrom;
    }

    @JSON
    public Double getVotesTo() {
        return _votesTo;
    }

    public void setVotesTo(Double votesTo) {
        _votesTo = votesTo;
    }

    @JSON
    public Double getDamageFrom() {
        return _damageFrom;
    }

    public void setDamageFrom(Double damageFrom) {
        _damageFrom = damageFrom;
    }

    @JSON
    public Double getDamageTo() {
        return _damageTo;
    }

    public void setDamageTo(Double damageTo) {
        _damageTo = damageTo;
    }

    @JSON
    public Double getMitigationFrom() {
        return _mitigationFrom;
    }

    public void setMitigationFrom(Double mitigationFrom) {
        _mitigationFrom = mitigationFrom;
    }

    @JSON
    public Double getMitigationTo() {
        return _mitigationTo;
    }

    public void setMitigationTo(Double mitigationTo) {
        _mitigationTo = mitigationTo;
    }

    @JSON
    public Date getDateFrom() {
        return _dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        _dateFrom = dateFrom;
    }

    @JSON
    public Date getDateTo() {
        return _dateTo;
    }

    public void setDateTo(Date dateTo) {
        _dateTo = dateTo;
    }

    @JSON
    public Boolean getFilterPositionsAll() {
        return _filterPositionsAll;
    }

    public void setFilterPositionsAll(Boolean filterPositionsAll) {
        _filterPositionsAll = filterPositionsAll;
    }

    @JSON
    public Boolean getEnabled() {
        return _enabled;
    }

    public void setEnabled(Boolean enabled) {
        _enabled = enabled;
    }

    @Override
    public PlansFilter toEscapedModel() {
        if (_escapedModelProxy == null) {
            _escapedModelProxy = (PlansFilter) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelProxyInterfaces,
                    new AutoEscapeBeanHandler(this));
        }

        return _escapedModelProxy;
    }

    @Override
    public Object clone() {
        PlansFilterImpl plansFilterImpl = new PlansFilterImpl();

        plansFilterImpl.setUserId(getUserId());
        plansFilterImpl.setPlanTypeId(getPlanTypeId());
        plansFilterImpl.setName(getName());
        plansFilterImpl.setCreator(getCreator());
        plansFilterImpl.setDescription(getDescription());
        plansFilterImpl.setCO2From(getCO2From());
        plansFilterImpl.setCO2To(getCO2To());
        plansFilterImpl.setVotesFrom(getVotesFrom());
        plansFilterImpl.setVotesTo(getVotesTo());
        plansFilterImpl.setDamageFrom(getDamageFrom());
        plansFilterImpl.setDamageTo(getDamageTo());
        plansFilterImpl.setMitigationFrom(getMitigationFrom());
        plansFilterImpl.setMitigationTo(getMitigationTo());
        plansFilterImpl.setDateFrom(getDateFrom());
        plansFilterImpl.setDateTo(getDateTo());
        plansFilterImpl.setFilterPositionsAll(getFilterPositionsAll());
        plansFilterImpl.setEnabled(getEnabled());

        plansFilterImpl.resetOriginalValues();

        return plansFilterImpl;
    }

    public int compareTo(PlansFilter plansFilter) {
        PlansFilterPK primaryKey = plansFilter.getPrimaryKey();

        return getPrimaryKey().compareTo(primaryKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PlansFilter plansFilter = null;

        try {
            plansFilter = (PlansFilter) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        PlansFilterPK primaryKey = plansFilter.getPrimaryKey();

        if (getPrimaryKey().equals(primaryKey)) {
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
    }

    @Override
    public CacheModel<PlansFilter> toCacheModel() {
        PlansFilterCacheModel plansFilterCacheModel = new PlansFilterCacheModel();

        plansFilterCacheModel.userId = getUserId();

        plansFilterCacheModel.planTypeId = getPlanTypeId();

        plansFilterCacheModel.name = getName();

        String name = plansFilterCacheModel.name;

        if ((name != null) && (name.length() == 0)) {
            plansFilterCacheModel.name = null;
        }

        plansFilterCacheModel.creator = getCreator();

        String creator = plansFilterCacheModel.creator;

        if ((creator != null) && (creator.length() == 0)) {
            plansFilterCacheModel.creator = null;
        }

        plansFilterCacheModel.description = getDescription();

        String description = plansFilterCacheModel.description;

        if ((description != null) && (description.length() == 0)) {
            plansFilterCacheModel.description = null;
        }

        plansFilterCacheModel.CO2From = getCO2From();

        plansFilterCacheModel.CO2To = getCO2To();

        plansFilterCacheModel.votesFrom = getVotesFrom();

        plansFilterCacheModel.votesTo = getVotesTo();

        plansFilterCacheModel.damageFrom = getDamageFrom();

        plansFilterCacheModel.damageTo = getDamageTo();

        plansFilterCacheModel.mitigationFrom = getMitigationFrom();

        plansFilterCacheModel.mitigationTo = getMitigationTo();

        Date dateFrom = getDateFrom();

        if (dateFrom != null) {
            plansFilterCacheModel.dateFrom = dateFrom.getTime();
        } else {
            plansFilterCacheModel.dateFrom = Long.MIN_VALUE;
        }

        Date dateTo = getDateTo();

        if (dateTo != null) {
            plansFilterCacheModel.dateTo = dateTo.getTime();
        } else {
            plansFilterCacheModel.dateTo = Long.MIN_VALUE;
        }

        plansFilterCacheModel.filterPositionsAll = getFilterPositionsAll();

        plansFilterCacheModel.enabled = getEnabled();

        return plansFilterCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(35);

        sb.append("{userId=");
        sb.append(getUserId());
        sb.append(", planTypeId=");
        sb.append(getPlanTypeId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", creator=");
        sb.append(getCreator());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", CO2From=");
        sb.append(getCO2From());
        sb.append(", CO2To=");
        sb.append(getCO2To());
        sb.append(", votesFrom=");
        sb.append(getVotesFrom());
        sb.append(", votesTo=");
        sb.append(getVotesTo());
        sb.append(", damageFrom=");
        sb.append(getDamageFrom());
        sb.append(", damageTo=");
        sb.append(getDamageTo());
        sb.append(", mitigationFrom=");
        sb.append(getMitigationFrom());
        sb.append(", mitigationTo=");
        sb.append(getMitigationTo());
        sb.append(", dateFrom=");
        sb.append(getDateFrom());
        sb.append(", dateTo=");
        sb.append(getDateTo());
        sb.append(", filterPositionsAll=");
        sb.append(getFilterPositionsAll());
        sb.append(", enabled=");
        sb.append(getEnabled());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(55);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.plans.model.PlansFilter");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>planTypeId</column-name><column-value><![CDATA[");
        sb.append(getPlanTypeId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>creator</column-name><column-value><![CDATA[");
        sb.append(getCreator());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>CO2From</column-name><column-value><![CDATA[");
        sb.append(getCO2From());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>CO2To</column-name><column-value><![CDATA[");
        sb.append(getCO2To());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>votesFrom</column-name><column-value><![CDATA[");
        sb.append(getVotesFrom());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>votesTo</column-name><column-value><![CDATA[");
        sb.append(getVotesTo());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>damageFrom</column-name><column-value><![CDATA[");
        sb.append(getDamageFrom());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>damageTo</column-name><column-value><![CDATA[");
        sb.append(getDamageTo());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>mitigationFrom</column-name><column-value><![CDATA[");
        sb.append(getMitigationFrom());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>mitigationTo</column-name><column-value><![CDATA[");
        sb.append(getMitigationTo());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>dateFrom</column-name><column-value><![CDATA[");
        sb.append(getDateFrom());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>dateTo</column-name><column-value><![CDATA[");
        sb.append(getDateTo());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>filterPositionsAll</column-name><column-value><![CDATA[");
        sb.append(getFilterPositionsAll());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>enabled</column-name><column-value><![CDATA[");
        sb.append(getEnabled());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
