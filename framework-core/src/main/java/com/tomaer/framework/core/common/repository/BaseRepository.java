package com.tomaer.framework.core.common.repository;

import org.springframework.beans.factory.InitializingBean;


/**
 * Created by tomaer on 2015/8/23.
 */
public interface BaseRepository<E extends java.io.Serializable> extends InitializingBean {

    E get(final Long id);
    int save(E entity);
    int update(E entity);
    int remove(final Long id);
}
