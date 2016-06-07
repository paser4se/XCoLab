/**
 * This class is generated by jOOQ
 */
package org.xcolab.client.files.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class FileEntry implements Serializable {

    private static final long serialVersionUID = -863924807;

    private Long      fileentryid;
    private Timestamp createdate;
    private String    fileentryextension;
    private String    fileentryname;
    private Integer   fileentrysize;

    public FileEntry() {}

    public FileEntry(FileEntry value) {
        this.fileentryid = value.fileentryid;
        this.createdate = value.createdate;
        this.fileentryextension = value.fileentryextension;
        this.fileentryname = value.fileentryname;
        this.fileentrysize = value.fileentrysize;
    }

    public FileEntry(
        Long      fileentryid,
        Timestamp createdate,
        String    fileentryextension,
        String    fileentryname,
        Integer   fileentrysize
    ) {
        this.fileentryid = fileentryid;
        this.createdate = createdate;
        this.fileentryextension = fileentryextension;
        this.fileentryname = fileentryname;
        this.fileentrysize = fileentrysize;
    }

    public Long getFileEntryId() {
        return this.fileentryid;
    }

    public void setFileEntryId(Long fileentryid) {
        this.fileentryid = fileentryid;
    }

    public Timestamp getCreateDate() {
        return this.createdate;
    }

    public void setCreateDate(Timestamp createdate) {
        this.createdate = createdate;
    }

    public String getFileEntryExtension() {
        return this.fileentryextension;
    }

    public void setFileEntryExtension(String fileentryextension) {
        this.fileentryextension = fileentryextension;
    }

    public String getFileEntryName() {
        return this.fileentryname;
    }

    public void setFileEntryName(String fileentryname) {
        this.fileentryname = fileentryname;
    }

    public Integer getFileEntrySize() {
        return this.fileentrysize;
    }

    public void setFileEntrySize(Integer fileentrysize) {
        this.fileentrysize = fileentrysize;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("FileEntry (");

        sb.append(fileentryid);
        sb.append(", ").append(createdate);
        sb.append(", ").append(fileentryextension);
        sb.append(", ").append(fileentryname);
        sb.append(", ").append(fileentrysize);

        sb.append(")");
        return sb.toString();
    }
}
