package com.tomaer.framework.common.entity;

/**
 * Created by tomaer on 2015/8/23.
 */
public abstract class LogicDeleteable extends IdEntity {

    private static final long serialVersionUID = -5477112730221082444L;

    private Boolean deleted;

    public void markDeleted() {
        this.deleted = Boolean.TRUE;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
