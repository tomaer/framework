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
 * Date: 2015/2/2 21:33
 */
public class LoggerExt extends AbstractLogger {
    
    private static final long serialVersionUID = 770279067901926154L;
    
    private Logger logger;

	public LoggerExt(Logger logger) {
		this.logger = logger;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	
	public void trace(String message) {
		if (logger.isTraceEnabled())
			logger.trace(message);
	}

	public void trace(String message, Throwable e) {
		if (logger.isTraceEnabled())
			logger.trace(message, e);
	}

	public void trace(String message, Object... obj) {
		if (logger.isTraceEnabled())
			logger.trace(formatMessage(message, obj));
	}

	public void trace(String message, Throwable e, Object... obj) {
		if (logger.isTraceEnabled())
			logger.trace(formatMessage(message, obj), e);
	}

	public void trace(Throwable e) {
		if (logger.isTraceEnabled())
			logger.trace(e);
	}

	public void debug(String message) {
		if (logger.isDebugEnabled())
			logger.debug(message);
	}

	public void debug(String message, Throwable e) {
		if (logger.isDebugEnabled())
			logger.debug(message, e);
	}

	public void debug(String message, Object... obj) {
		if (logger.isDebugEnabled())
			logger.debug(formatMessage(message, obj));
	}

	public void debug(String message, Throwable e, Object... obj) {
		if (logger.isDebugEnabled())
			logger.debug(formatMessage(message, obj), e);
	}

	public void debug(Throwable e) {
		if (logger.isDebugEnabled())
			logger.debug(e);
	}

	public void info(String message) {
		if (logger.isInfoEnabled())
			logger.info(message);
	}

	public void info(String message, Throwable e) {
		if (logger.isInfoEnabled())
			logger.info(message, e);
	}

	public void info(String message, Object... obj) {
		if (logger.isInfoEnabled())
			logger.info(formatMessage(message, obj));
	}

	public void info(String message, Throwable e, Object... obj) {
		if (logger.isInfoEnabled())
			logger.info(formatMessage(message, obj), e);
	}

	public void info(Throwable e) {
		if (logger.isInfoEnabled())
			logger.info(e);
	}

	public void warn(String message) {
		if (logger.isWarnEnabled())
			logger.warn(message);
	}

	public void warn(String message, Throwable e) {
		if (logger.isWarnEnabled())
			logger.warn(message, e);
	}

	public void warn(String message, Object... obj) {
		if (logger.isWarnEnabled())
			logger.warn(formatMessage(message, obj));
	}

	public void warn(String message, Throwable e, Object... obj) {
		if (logger.isWarnEnabled())
			logger.warn(formatMessage(message, obj), e);
	}

	public void warn(Throwable e) {
		if (logger.isWarnEnabled())
			logger.warn(e);
	}

	public void error(String message) {
		if (logger.isErrorEnabled())
			logger.error(message);
	}

	public void error(String message, Throwable e) {
		if (logger.isErrorEnabled())
			logger.error(message, e);
	}

	public void error(String message, Object... obj) {
		if (logger.isErrorEnabled())
			logger.error(formatMessage(message, obj));
	}

	public void error(String message, Throwable e, Object... obj) {
		if (logger.isErrorEnabled())
			logger.error(formatMessage(message, obj), e);
	}

	public void error(Throwable e) {
		if (logger.isErrorEnabled())
			logger.error(e);
	}

	public boolean isTraceEnabled() {
		return logger.isTraceEnabled();
	}

	public boolean isDebugEnabled() {
		return logger.isDebugEnabled();
	}

	public boolean isInfoEnabled() {
		return logger.isInfoEnabled();
	}

	public boolean isWarnEnabled() {
		return logger.isWarnEnabled();
	}

	public boolean isErrorEnabled() {
		return logger.isErrorEnabled();
	}
}
