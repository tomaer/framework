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

/**
 * Description:
 * Author: tomaer
 * Version: 1.0
 * Date: 2015/2/2 16:33
 */
public interface Logger {

    void trace(final String message);

    void trace(final String message, final Throwable e);

    void trace(final String message, final Object... obj);

    void trace(final String message, final Throwable e, final Object... obj);

    void trace(final Throwable e);

    void debug(final String message);

    void debug(final String message, final Throwable e);

    void debug(final String message, final Object... obj);

    void debug(final String message, final Throwable e, final Object... obj);

    void debug(final Throwable e);

    void info(final String message);

    void info(final String message, final Throwable e);

    void info(final String message, final Object... obj);

    void info(final String message, final Throwable e, final Object... obj);

    void info(final Throwable e);

    void warn(final String message);

    void warn(final String message, final Throwable e);

    void warn(final String message, final Object... obj);

    void warn(final String message, final Throwable e, final Object... obj);

    void warn(final Throwable e);

    void error(final String message);

    void error(final String message, final Throwable e);

    void error(final String message, final Object... obj);

    void error(final String message, final Throwable e, final Object... obj);

    void error(final Throwable e);

    boolean isTraceEnabled();

    boolean isDebugEnabled();

    boolean isInfoEnabled();

    boolean isWarnEnabled();

    boolean isErrorEnabled();
}
