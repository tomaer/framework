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
package com.tomaer.framework.common.logger.log4j;

import com.tomaer.framework.common.logger.AbstractLogger;

/**
 * Description:
 * Author: tomaer
 * Version: 1.0
 * Date: 2015/2/3 13:17
 */
public class Log4jLogger extends AbstractLogger {

    private static final long serialVersionUID = 5372819448041684247L;

    private org.apache.log4j.Logger logger;

	public Log4jLogger(org.apache.log4j.Logger logger) {
		this.logger = logger;
	}

	public void setLogger(org.apache.log4j.Logger logger) {
		this.logger = logger;
	}

	public org.apache.log4j.Logger getLogger() {
		return logger;
	}
	
	public void trace(String message) {
		if (logger.isTraceEnabled())
			logger.trace(getUniqueKey() + " - " + message);
	}

	public void trace(String message, Throwable e) {
		if (logger.isTraceEnabled())
			logger.trace(getUniqueKey() + " - " + message, e);
	}

	public void trace(String message, Object... obj) {
		if (logger.isTraceEnabled())
			logger.trace(getUniqueKey() + " - " + formatMessage(message, obj));
	}

	public void trace(String message, Throwable e, Object... obj) {
		if (logger.isTraceEnabled())
			logger.trace(getUniqueKey() + " - " + formatMessage(message, obj), e);
	}

	public void trace(Throwable e) {
		if (logger.isTraceEnabled())
			logger.trace(e);
	}

	public void debug(String message) {
		if (logger.isDebugEnabled())
			logger.debug(getUniqueKey() + " - " + message);
	}

	public void debug(String message, Throwable e) {
		if (logger.isDebugEnabled())
			logger.debug(getUniqueKey() + " - " + message, e);
	}

	public void debug(String message, Object... obj) {
		if (logger.isDebugEnabled())
			logger.debug(getUniqueKey() + " - " + formatMessage(message, obj));
	}

	public void debug(String message, Throwable e, Object... obj) {
		if (logger.isDebugEnabled())
			logger.debug(getUniqueKey() + " - " + formatMessage(message, obj), e);
	}

	public void debug(Throwable e) {
		if (logger.isDebugEnabled())
			logger.debug(e);
	}

	public void info(String message) {
		if (logger.isInfoEnabled())
			logger.info(getUniqueKey() + " - " + message);
	}

	public void info(String message, Throwable e) {
		if (logger.isInfoEnabled())
			logger.info(getUniqueKey() + " - " + message, e);
	}

	public void info(String message, Object... obj) {
		if (logger.isInfoEnabled())
			logger.info(getUniqueKey() + " - " + formatMessage(message, obj));
	}

	public void info(String message, Throwable e, Object... obj) {
		if (logger.isInfoEnabled())
			logger.info(getUniqueKey() + " - " + formatMessage(message, obj), e);
	}

	public void info(Throwable e) {
		if (logger.isInfoEnabled())
			logger.info(e);
	}

	public void warn(String message) {
		logger.warn(getUniqueKey() + " - " + message);
	}

	public void warn(String message, Throwable e) {
		logger.warn(getUniqueKey() + " - " + message, e);
	}

	public void warn(String message, Object... obj) {
		logger.warn(getUniqueKey() + " - " + formatMessage(message, obj));
	}

	public void warn(String message, Throwable e, Object... obj) {
		logger.warn(getUniqueKey() + " - " + formatMessage(message, obj), e);
	}

	public void warn(Throwable e) {
		logger.warn(e);
	}

	public void error(String message) {
		logger.error(getUniqueKey() + " - " + message);
	}

	public void error(String message, Throwable e) {
		logger.error(getUniqueKey() + " - " + message, e);
	}

	public void error(String message, Object... obj) {
		logger.error(getUniqueKey() + " - " + formatMessage(message, obj));
	}

	public void error(String message, Throwable e, Object... obj) {
		logger.error(getUniqueKey() + " - " + formatMessage(message, obj), e);
	}

	public void error(Throwable e) {
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
		return true;
	}

	public boolean isErrorEnabled() {
		return true;
	}
}
