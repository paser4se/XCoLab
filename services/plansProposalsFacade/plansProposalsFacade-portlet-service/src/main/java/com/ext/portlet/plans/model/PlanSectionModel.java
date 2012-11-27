package com.ext.portlet.plans.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the PlanSection service. Represents a row in the &quot;Plans_PlanSection&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ext.portlet.plans.model.impl.PlanSectionModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ext.portlet.plans.model.impl.PlanSectionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlanSection
 * @see com.ext.portlet.plans.model.impl.PlanSectionImpl
 * @see com.ext.portlet.plans.model.impl.PlanSectionModelImpl
 * @generated
 */
public interface PlanSectionModel extends BaseModel<PlanSection> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a plan section model instance should use the {@link PlanSection} interface instead.
     */

    /**
     * Returns the primary key of this plan section.
     *
     * @return the primary key of this plan section
     */
    public Long getPrimaryKey();

    /**
     * Sets the primary key of this plan section.
     *
     * @param primaryKey the primary key of this plan section
     */
    public void setPrimaryKey(Long primaryKey);

    /**
     * Returns the ID of this plan section.
     *
     * @return the ID of this plan section
     */
    public Long getId();

    /**
     * Sets the ID of this plan section.
     *
     * @param id the ID of this plan section
     */
    public void setId(Long id);

    /**
     * Returns the plan section definition ID of this plan section.
     *
     * @return the plan section definition ID of this plan section
     */
    public Long getPlanSectionDefinitionId();

    /**
     * Sets the plan section definition ID of this plan section.
     *
     * @param planSectionDefinitionId the plan section definition ID of this plan section
     */
    public void setPlanSectionDefinitionId(Long planSectionDefinitionId);

    /**
     * Returns the plan ID of this plan section.
     *
     * @return the plan ID of this plan section
     */
    public Long getPlanId();

    /**
     * Sets the plan ID of this plan section.
     *
     * @param planId the plan ID of this plan section
     */
    public void setPlanId(Long planId);

    /**
     * Returns the content of this plan section.
     *
     * @return the content of this plan section
     */
    @AutoEscape
    public String getContent();

    /**
     * Sets the content of this plan section.
     *
     * @param content the content of this plan section
     */
    public void setContent(String content);

    /**
     * Returns the created of this plan section.
     *
     * @return the created of this plan section
     */
    public Date getCreated();

    /**
     * Sets the created of this plan section.
     *
     * @param created the created of this plan section
     */
    public void setCreated(Date created);

    /**
     * Returns the version of this plan section.
     *
     * @return the version of this plan section
     */
    public Long getVersion();

    /**
     * Sets the version of this plan section.
     *
     * @param version the version of this plan section
     */
    public void setVersion(Long version);

    /**
     * Returns the plan version of this plan section.
     *
     * @return the plan version of this plan section
     */
    public Long getPlanVersion();

    /**
     * Sets the plan version of this plan section.
     *
     * @param planVersion the plan version of this plan section
     */
    public void setPlanVersion(Long planVersion);

    /**
     * Returns the update author ID of this plan section.
     *
     * @return the update author ID of this plan section
     */
    public Long getUpdateAuthorId();

    /**
     * Sets the update author ID of this plan section.
     *
     * @param updateAuthorId the update author ID of this plan section
     */
    public void setUpdateAuthorId(Long updateAuthorId);

    public boolean isNew();

    public void setNew(boolean n);

    public boolean isCachedModel();

    public void setCachedModel(boolean cachedModel);

    public boolean isEscapedModel();

    public Serializable getPrimaryKeyObj();

    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    public ExpandoBridge getExpandoBridge();

    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    public Object clone();

    public int compareTo(PlanSection planSection);

    public int hashCode();

    public CacheModel<PlanSection> toCacheModel();

    public PlanSection toEscapedModel();

    public String toString();

    public String toXmlString();
}
