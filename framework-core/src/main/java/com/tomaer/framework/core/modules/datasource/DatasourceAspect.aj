package com.tomaer.framework.core.modules.datasource;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by tomaer on 2015/8/23.
 */
@Aspect
@Component
public class DatasourceAspect {
    private static int access = 0;

}
