package com.tomaer.framework.common.entity;

/**
 * Created by tomaer on 2015/8/23.
 */
public class IdEntity extends AbstractEntity {

    private static final long serialVersionUID = -2810946929853934840L;

    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

}
