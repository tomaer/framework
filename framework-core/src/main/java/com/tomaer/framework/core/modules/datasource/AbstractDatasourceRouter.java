package com.tomaer.framework.core.modules.datasource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by tomaer on 2015/8/23.
 */
public abstract class AbstractDatasourceRouter extends AbstractRoutingDataSource implements InitializingBean {

    protected abstract Object determineCurrentLookupKey();
}
