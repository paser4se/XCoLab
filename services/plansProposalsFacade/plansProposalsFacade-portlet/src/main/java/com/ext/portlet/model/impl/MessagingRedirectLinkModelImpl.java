package com.ext.portlet.model.impl;

import com.ext.portlet.model.MessagingRedirectLink;
import com.ext.portlet.model.MessagingRedirectLinkModel;
import com.ext.portlet.model.MessagingRedirectLinkSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the MessagingRedirectLink service. Represents a row in the &quot;xcolab_MessagingRedirectLink&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.model.MessagingRedirectLinkModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MessagingRedirectLinkImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MessagingRedirectLinkImpl
 * @see com.ext.portlet.model.MessagingRedirectLink
 * @see com.ext.portlet.model.MessagingRedirectLinkModel
 * @generated
 */
@JSON(strict = true)
public class MessagingRedirectLinkModelImpl extends BaseModelImpl<MessagingRedirectLink>
    implements MessagingRedirectLinkModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a messaging redirect link model instance should use the {@link com.ext.portlet.model.MessagingRedirectLink} interface instead.
     */
    public static final String TABLE_NAME = "xcolab_MessagingRedirectLink";
    public static final Object[][] TABLE_COLUMNS = {
            { "redirectId", Types.BIGINT },
            { "link", Types.VARCHAR },
            { "messageId", Types.BIGINT },
            { "createDate", Types.TIMESTAMP }
        };
    public static final String TABLE_SQL_CREATE = "create table xcolab_MessagingRedirectLink (redirectId LONG not null primary key,link VARCHAR(75) null,messageId LONG,createDate DATE null)";
    public static final String TABLE_SQL_DROP = "drop table xcolab_MessagingRedirectLink";
    public static final String ORDER_BY_JPQL = " ORDER BY messagingRedirectLink.redirectId ASC";
    public static final String ORDER_BY_SQL = " ORDER BY xcolab_MessagingRedirectLink.redirectId ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.ext.portlet.model.MessagingRedirectLink"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.ext.portlet.model.MessagingRedirectLink"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = false;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.ext.portlet.model.MessagingRedirectLink"));
    private static ClassLoader _classLoader = MessagingRedirectLink.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            MessagingRedirectLink.class
        };
    private long _redirectId;
    private String _link;
    private long _messageId;
    private Date _createDate;
    private MessagingRedirectLink _escapedModel;

    public MessagingRedirectLinkModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static MessagingRedirectLink toModel(
        MessagingRedirectLinkSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        MessagingRedirectLink model = new MessagingRedirectLinkImpl();

        model.setRedirectId(soapModel.getRedirectId());
        model.setLink(soapModel.getLink());
        model.setMessageId(soapModel.getMessageId());
        model.setCreateDate(soapModel.getCreateDate());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<MessagingRedirectLink> toModels(
        MessagingRedirectLinkSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<MessagingRedirectLink> models = new ArrayList<MessagingRedirectLink>(soapModels.length);

        for (MessagingRedirectLinkSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    @Override
    public long getPrimaryKey() {
        return _redirectId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setRedirectId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _redirectId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Class<?> getModelClass() {
        return MessagingRedirectLink.class;
    }

    @Override
    public String getModelClassName() {
        return MessagingRedirectLink.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("redirectId", getRedirectId());
        attributes.put("link", getLink());
        attributes.put("messageId", getMessageId());
        attributes.put("createDate", getCreateDate());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long redirectId = (Long) attributes.get("redirectId");

        if (redirectId != null) {
            setRedirectId(redirectId);
        }

        String link = (String) attributes.get("link");

        if (link != null) {
            setLink(link);
        }

        Long messageId = (Long) attributes.get("messageId");

        if (messageId != null) {
            setMessageId(messageId);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }
    }

    @JSON
    @Override
    public long getRedirectId() {
        return _redirectId;
    }

    @Override
    public void setRedirectId(long redirectId) {
        _redirectId = redirectId;
    }

    @JSON
    @Override
    public String getLink() {
        if (_link == null) {
            return StringPool.BLANK;
        } else {
            return _link;
        }
    }

    @Override
    public void setLink(String link) {
        _link = link;
    }

    @JSON
    @Override
    public long getMessageId() {
        return _messageId;
    }

    @Override
    public void setMessageId(long messageId) {
        _messageId = messageId;
    }

    @JSON
    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            MessagingRedirectLink.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public MessagingRedirectLink toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (MessagingRedirectLink) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        MessagingRedirectLinkImpl messagingRedirectLinkImpl = new MessagingRedirectLinkImpl();

        messagingRedirectLinkImpl.setRedirectId(getRedirectId());
        messagingRedirectLinkImpl.setLink(getLink());
        messagingRedirectLinkImpl.setMessageId(getMessageId());
        messagingRedirectLinkImpl.setCreateDate(getCreateDate());

        messagingRedirectLinkImpl.resetOriginalValues();

        return messagingRedirectLinkImpl;
    }

    @Override
    public int compareTo(MessagingRedirectLink messagingRedirectLink) {
        long primaryKey = messagingRedirectLink.getPrimaryKey();

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
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof MessagingRedirectLink)) {
            return false;
        }

        MessagingRedirectLink messagingRedirectLink = (MessagingRedirectLink) obj;

        long primaryKey = messagingRedirectLink.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
    }

    @Override
    public CacheModel<MessagingRedirectLink> toCacheModel() {
        MessagingRedirectLinkCacheModel messagingRedirectLinkCacheModel = new MessagingRedirectLinkCacheModel();

        messagingRedirectLinkCacheModel.redirectId = getRedirectId();

        messagingRedirectLinkCacheModel.link = getLink();

        String link = messagingRedirectLinkCacheModel.link;

        if ((link != null) && (link.length() == 0)) {
            messagingRedirectLinkCacheModel.link = null;
        }

        messagingRedirectLinkCacheModel.messageId = getMessageId();

        Date createDate = getCreateDate();

        if (createDate != null) {
            messagingRedirectLinkCacheModel.createDate = createDate.getTime();
        } else {
            messagingRedirectLinkCacheModel.createDate = Long.MIN_VALUE;
        }

        return messagingRedirectLinkCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{redirectId=");
        sb.append(getRedirectId());
        sb.append(", link=");
        sb.append(getLink());
        sb.append(", messageId=");
        sb.append(getMessageId());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.model.MessagingRedirectLink");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>redirectId</column-name><column-value><![CDATA[");
        sb.append(getRedirectId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>link</column-name><column-value><![CDATA[");
        sb.append(getLink());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>messageId</column-name><column-value><![CDATA[");
        sb.append(getMessageId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
