/**
 * This class is generated by jOOQ
 */
package org.xcolab.client.contest.pojo;


import java.io.Serializable;

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
public class OntologyTerm implements Serializable {

    private static final long serialVersionUID = 158059106;

    private Long    id_;
    private Long    parentid;
    private Long    ontologyspaceid;
    private String  name;
    private String  descriptionurl;
    private Integer order_;

    public OntologyTerm() {}

    public OntologyTerm(OntologyTerm value) {
        this.id_ = value.id_;
        this.parentid = value.parentid;
        this.ontologyspaceid = value.ontologyspaceid;
        this.name = value.name;
        this.descriptionurl = value.descriptionurl;
        this.order_ = value.order_;
    }

    public OntologyTerm(
        Long    id_,
        Long    parentid,
        Long    ontologyspaceid,
        String  name,
        String  descriptionurl,
        Integer order_
    ) {
        this.id_ = id_;
        this.parentid = parentid;
        this.ontologyspaceid = ontologyspaceid;
        this.name = name;
        this.descriptionurl = descriptionurl;
        this.order_ = order_;
    }

    public Long getId_() {
        return this.id_;
    }

    public void setId_(Long id_) {
        this.id_ = id_;
    }

    public Long getParentId() {
        return this.parentid;
    }

    public void setParentId(Long parentid) {
        this.parentid = parentid;
    }

    public Long getOntologySpaceId() {
        return this.ontologyspaceid;
    }

    public void setOntologySpaceId(Long ontologyspaceid) {
        this.ontologyspaceid = ontologyspaceid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptionUrl() {
        return this.descriptionurl;
    }

    public void setDescriptionUrl(String descriptionurl) {
        this.descriptionurl = descriptionurl;
    }

    public Integer getOrder_() {
        return this.order_;
    }

    public void setOrder_(Integer order_) {
        this.order_ = order_;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final OntologyTerm other = (OntologyTerm) obj;
        if (id_ == null) {
            if (other.id_ != null)
                return false;
        }
        else if (!id_.equals(other.id_))
            return false;
        if (parentid == null) {
            if (other.parentid != null)
                return false;
        }
        else if (!parentid.equals(other.parentid))
            return false;
        if (ontologyspaceid == null) {
            if (other.ontologyspaceid != null)
                return false;
        }
        else if (!ontologyspaceid.equals(other.ontologyspaceid))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        }
        else if (!name.equals(other.name))
            return false;
        if (descriptionurl == null) {
            if (other.descriptionurl != null)
                return false;
        }
        else if (!descriptionurl.equals(other.descriptionurl))
            return false;
        if (order_ == null) {
            if (other.order_ != null)
                return false;
        }
        else if (!order_.equals(other.order_))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_ == null) ? 0 : id_.hashCode());
        result = prime * result + ((parentid == null) ? 0 : parentid.hashCode());
        result = prime * result + ((ontologyspaceid == null) ? 0 : ontologyspaceid.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((descriptionurl == null) ? 0 : descriptionurl.hashCode());
        result = prime * result + ((order_ == null) ? 0 : order_.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("OntologyTerm (");

        sb.append(id_);
        sb.append(", ").append(parentid);
        sb.append(", ").append(ontologyspaceid);
        sb.append(", ").append(name);
        sb.append(", ").append(descriptionurl);
        sb.append(", ").append(order_);

        sb.append(")");
        return sb.toString();
    }
}
