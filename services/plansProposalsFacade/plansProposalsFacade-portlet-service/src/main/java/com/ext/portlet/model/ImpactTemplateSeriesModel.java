package com.ext.portlet.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the ImpactTemplateSeries service. Represents a row in the &quot;xcolab_ImpactTemplateSeries&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ext.portlet.model.impl.ImpactTemplateSeriesModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ext.portlet.model.impl.ImpactTemplateSeriesImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ImpactTemplateSeries
 * @see com.ext.portlet.model.impl.ImpactTemplateSeriesImpl
 * @see com.ext.portlet.model.impl.ImpactTemplateSeriesModelImpl
 * @generated
 */
public interface ImpactTemplateSeriesModel extends BaseModel<ImpactTemplateSeries> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a impact template series model instance should use the {@link ImpactTemplateSeries} interface instead.
     */

    /**
     * Returns the primary key of this impact template series.
     *
     * @return the primary key of this impact template series
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this impact template series.
     *
     * @param primaryKey the primary key of this impact template series
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the series ID of this impact template series.
     *
     * @return the series ID of this impact template series
     */
    public long getSeriesId();

    /**
     * Sets the series ID of this impact template series.
     *
     * @param seriesId the series ID of this impact template series
     */
    public void setSeriesId(long seriesId);

    /**
     * Returns the iteration ID of this impact template series.
     *
     * @return the iteration ID of this impact template series
     */
    public long getIterationId();

    /**
     * Sets the iteration ID of this impact template series.
     *
     * @param iterationId the iteration ID of this impact template series
     */
    public void setIterationId(long iterationId);

    /**
     * Returns the name of this impact template series.
     *
     * @return the name of this impact template series
     */
    @AutoEscape
    public String getName();

    /**
     * Sets the name of this impact template series.
     *
     * @param name the name of this impact template series
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
    public int compareTo(
        com.ext.portlet.model.ImpactTemplateSeries impactTemplateSeries);

    @Override
    public int hashCode();

    @Override
    public CacheModel<com.ext.portlet.model.ImpactTemplateSeries> toCacheModel();

    @Override
    public com.ext.portlet.model.ImpactTemplateSeries toEscapedModel();

    @Override
    public com.ext.portlet.model.ImpactTemplateSeries toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
