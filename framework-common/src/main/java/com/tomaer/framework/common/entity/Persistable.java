package com.tomaer.framework.common.entity;

/**
 * 持久化对象
 * Created by tomaer on 2015/8/23.
 */
public interface Persistable extends java.io.Serializable {

    /** 获得持久化对象Id */
    Long getId();
    /** 是否是游离状态的对象 */
    boolean isNew();
}
