package com.tomaer.framework.common.entity;

import java.util.Date;

/**
 * Created by tomaer on 2015/8/23.
 */
public abstract class AbstractEntity implements Persistable {

    private static final long serialVersionUID = 2983524083069337341L;

    protected String createBy;
    protected String createByName;
    protected Date createDate;

    protected String modifyBy;
    protected String modifyByName;
    protected Date modifyDate;

    protected Long version = -1L;

    public abstract Long getId();

    public abstract void setId(final Long id);

    public boolean isNew() {
        return null == getId();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateByName() {
        return createByName;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public String getModifyByName() {
        return modifyByName;
    }

    public void setModifyByName(String modifyByName) {
        this.modifyByName = modifyByName;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

}
