/*
 * Copyright (c) 2009 Tomaer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tomaer.framework.common.logger;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Description:
 * Author: tomaer
 * Version: 1.0
 * Date: 2015/2/2 16:35
 */
public class LoggerFactory {

    private static volatile LoggerAdapter LOGGER_ADAPTER;
    private static final ConcurrentMap<String, AbstractLogger> LOGGERS = new ConcurrentHashMap<String, AbstractLogger>();

    private LoggerFactory() {

    }

    public static void setAdapter(LoggerAdapter adapter) {
        if (adapter != null) {
            Logger logger = adapter.getLogger(LoggerFactory.class);
            logger.debug("Useing Logger Adapter : " + adapter.getClass().getName());
            logger.debug("Useing Logger Provider : " + logger.getClass().getName());
            LoggerFactory.LOGGER_ADAPTER = adapter;
            for (Map.Entry<String, AbstractLogger> entry : LOGGERS.entrySet()) {
                entry.getValue().setLogger(LOGGER_ADAPTER.getLogger(entry.getKey()));
            }
        }
    }

    public static Logger getLogger(Class<?> clazz) {
        return getLogger(clazz.getName());
    }

    public static Logger getLogger(String name) {
        AbstractLogger logger = LOGGERS.get(name);
        if (logger == null) {
            LOGGERS.putIfAbsent(name, new LoggerExt(LOGGER_ADAPTER.getLogger(name)));
            logger = LOGGERS.get(name);
        }
        return logger;
    }

    public static void setLevel(Level level) {
        LOGGER_ADAPTER.setLevel(level);
    }

    public static Level getLevel() {
        Level level = LOGGER_ADAPTER.getLevel();
        if (null == level) {
            setLevel(Level.ERROR);
        }
        return LOGGER_ADAPTER.getLevel();
    }

    public static File getFile() {
        return LOGGER_ADAPTER.getFile();
    }
    
}
