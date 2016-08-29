/**
 * This class is generated by jOOQ
 */
package org.xcolab.client.contest.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.core.ParameterizedTypeReference;
import org.xcolab.util.http.client.types.TypeProvider;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContestSchedule implements Serializable {

    private static final long serialVersionUID = -26896638;

    public static final TypeProvider<ContestSchedule> TYPES =
            new TypeProvider<>(ContestSchedule.class,
                    new ParameterizedTypeReference<List<ContestSchedule>>() {
                    });

    private Long   id_;
    private String name;
    private String description;
    private String status;
    private Long   basescheduleid;

    public ContestSchedule() {}

    public ContestSchedule(ContestSchedule value) {
        this.id_ = value.id_;
        this.name = value.name;
        this.description = value.description;
        this.status = value.status;
        this.basescheduleid = value.basescheduleid;
    }

    public ContestSchedule(
        Long   id_,
        String name,
        String description,
        String status,
        Long   basescheduleid
    ) {
        this.id_ = id_;
        this.name = name;
        this.description = description;
        this.status = status;
        this.basescheduleid = basescheduleid;
    }

    public Long getId_() {
        return this.id_;
    }

    public void setId_(Long id_) {
        this.id_ = id_;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getBaseScheduleId() {
        return this.basescheduleid;
    }

    public void setBaseScheduleId(Long basescheduleid) {
        this.basescheduleid = basescheduleid;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final ContestSchedule other = (ContestSchedule) obj;
        if (id_ == null) {
            if (other.id_ != null)
                return false;
        }
        else if (!id_.equals(other.id_))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        }
        else if (!name.equals(other.name))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        }
        else if (!description.equals(other.description))
            return false;
        if (status == null) {
            if (other.status != null)
                return false;
        }
        else if (!status.equals(other.status))
            return false;
        if (basescheduleid == null) {
            if (other.basescheduleid != null)
                return false;
        }
        else if (!basescheduleid.equals(other.basescheduleid))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_ == null) ? 0 : id_.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((basescheduleid == null) ? 0 : basescheduleid.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ContestSchedule (");

        sb.append(id_);
        sb.append(", ").append(name);
        sb.append(", ").append(description);
        sb.append(", ").append(status);
        sb.append(", ").append(basescheduleid);

        sb.append(")");
        return sb.toString();
    }
}