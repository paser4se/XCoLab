package com.ext.portlet.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Role_ service. Represents a row in the &quot;xcolab_Role_&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ext.portlet.model.impl.Role_ModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ext.portlet.model.impl.Role_Impl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Role_
 * @see com.ext.portlet.model.impl.Role_Impl
 * @see com.ext.portlet.model.impl.Role_ModelImpl
 * @generated
 */
public interface Role_Model extends BaseModel<Role_> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a role_ model instance should use the {@link Role_} interface instead.
     */

    /**
     * Returns the primary key of this role_.
     *
     * @return the primary key of this role_
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this role_.
     *
     * @param primaryKey the primary key of this role_
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the role ID of this role_.
     *
     * @return the role ID of this role_
     */
    public long getRoleId();

    /**
     * Sets the role ID of this role_.
     *
     * @param roleId the role ID of this role_
     */
    public void setRoleId(long roleId);

    /**
     * Returns the name of this role_.
     *
     * @return the name of this role_
     */
    @AutoEscape
    public String getName();

    /**
     * Sets the name of this role_.
     *
     * @param name the name of this role_
     */
    public void setName(String name);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(Role_ role_);

    @Override
    public int hashCode();

    @Override
    public CacheModel<Role_> toCacheModel();

    @Override
    public Role_ toEscapedModel();

    @Override
    public Role_ toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
