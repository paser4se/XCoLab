/**
 * This class is generated by jOOQ
 */
package org.xcolab.client.contest.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import org.springframework.core.ParameterizedTypeReference;
import org.xcolab.util.http.client.types.TypeProvider;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContestPhaseRibbonType implements Serializable {

    public static final TypeProvider<ContestPhaseRibbonType> TYPES =
            new TypeProvider<>(ContestPhaseRibbonType.class,
                    new ParameterizedTypeReference<List<ContestPhaseRibbonType>>() {
                    });

    private static final long serialVersionUID = -327147685;

    private Long    id_;
    private Integer ribbon;
    private String  hovertext;
    private String  description;
    private Boolean copyonpromote;
    private Integer sortorder;

    public ContestPhaseRibbonType() {}

    public ContestPhaseRibbonType(ContestPhaseRibbonType value) {
        this.id_ = value.id_;
        this.ribbon = value.ribbon;
        this.hovertext = value.hovertext;
        this.description = value.description;
        this.copyonpromote = value.copyonpromote;
        this.sortorder = value.sortorder;
    }

    public ContestPhaseRibbonType(
        Long    id_,
        Integer ribbon,
        String  hovertext,
        String  description,
        Boolean copyonpromote,
        Integer sortorder
    ) {
        this.id_ = id_;
        this.ribbon = ribbon;
        this.hovertext = hovertext;
        this.description = description;
        this.copyonpromote = copyonpromote;
        this.sortorder = sortorder;
    }

    public Long getId_() {
        return this.id_;
    }

    public void setId_(Long id_) {
        this.id_ = id_;
    }

    public Integer getRibbon() {
        return this.ribbon;
    }

    public void setRibbon(Integer ribbon) {
        this.ribbon = ribbon;
    }

    public String getHoverText() {
        return this.hovertext;
    }

    public void setHoverText(String hovertext) {
        this.hovertext = hovertext;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCopyOnPromote() {
        return this.copyonpromote;
    }

    public void setCopyOnPromote(Boolean copyonpromote) {
        this.copyonpromote = copyonpromote;
    }

    public Integer getSortOrder() {
        return this.sortorder;
    }

    public void setSortOrder(Integer sortorder) {
        this.sortorder = sortorder;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final ContestPhaseRibbonType other = (ContestPhaseRibbonType) obj;
        if (id_ == null) {
            if (other.id_ != null)
                return false;
        }
        else if (!id_.equals(other.id_))
            return false;
        if (ribbon == null) {
            if (other.ribbon != null)
                return false;
        }
        else if (!ribbon.equals(other.ribbon))
            return false;
        if (hovertext == null) {
            if (other.hovertext != null)
                return false;
        }
        else if (!hovertext.equals(other.hovertext))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        }
        else if (!description.equals(other.description))
            return false;
        if (copyonpromote == null) {
            if (other.copyonpromote != null)
                return false;
        }
        else if (!copyonpromote.equals(other.copyonpromote))
            return false;
        if (sortorder == null) {
            if (other.sortorder != null)
                return false;
        }
        else if (!sortorder.equals(other.sortorder))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_ == null) ? 0 : id_.hashCode());
        result = prime * result + ((ribbon == null) ? 0 : ribbon.hashCode());
        result = prime * result + ((hovertext == null) ? 0 : hovertext.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((copyonpromote == null) ? 0 : copyonpromote.hashCode());
        result = prime * result + ((sortorder == null) ? 0 : sortorder.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ContestPhaseRibbonType (");

        sb.append(id_);
        sb.append(", ").append(ribbon);
        sb.append(", ").append(hovertext);
        sb.append(", ").append(description);
        sb.append(", ").append(copyonpromote);
        sb.append(", ").append(sortorder);

        sb.append(")");
        return sb.toString();
    }
}
