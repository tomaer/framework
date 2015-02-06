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
package com.tomaer.framework.common.logger.slf4j;

import java.io.File;
import java.util.List;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;

import com.tomaer.framework.common.logger.Level;
import com.tomaer.framework.common.logger.Logger;
import com.tomaer.framework.common.logger.LoggerAdapter;

/**
 * Description:
 * Author: tomaer
 * Version: 1.0
 * Date: 2015/2/2 21:36
 */
public class SLF4jLoggerAdapter implements LoggerAdapter {

	@SuppressWarnings("unused")
	private Level level;
	private File file;

	public Logger getLogger(Class<?> clazz) {
		return new SLF4jLogger(org.slf4j.LoggerFactory.getLogger(clazz));
	}

	public Logger getLogger(String name) {
		return new SLF4jLogger(org.slf4j.LoggerFactory.getLogger(name));
	}

	public Level getLevel() {
		LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
		List<ch.qos.logback.classic.Logger> loggers = context.getLoggerList();
		for (ch.qos.logback.classic.Logger l : loggers) {
			ch.qos.logback.classic.Level level = l.getLevel();
			if (null != level) {
				return toWiShareLevel(level);
			}
		}
		return Level.ERROR;
	}

	public void setLevel(Level level) {
		LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
		List<ch.qos.logback.classic.Logger> loggers = context.getLoggerList();
		for (ch.qos.logback.classic.Logger l : loggers) {
			l.setLevel(toSLF4jLevel(level));
		}
		this.level = level;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	private ch.qos.logback.classic.Level toSLF4jLevel(Level level) {
		if (null == level)
			return ch.qos.logback.classic.Level.OFF;
		if (level == Level.ALL)
			return ch.qos.logback.classic.Level.ALL;
		if (level == Level.TRACE)
			return ch.qos.logback.classic.Level.TRACE;
		if (level == Level.DEBUG)
			return ch.qos.logback.classic.Level.DEBUG;
		if (level == Level.INFO)
			return ch.qos.logback.classic.Level.INFO;
		if (level == Level.WARN)
			return ch.qos.logback.classic.Level.WARN;
		if (level == Level.ERROR)
			return ch.qos.logback.classic.Level.ERROR;
		return ch.qos.logback.classic.Level.OFF;
	}

	private Level toWiShareLevel(ch.qos.logback.classic.Level level) {
		if (null == level)
			return Level.OFF;
		if (level == ch.qos.logback.classic.Level.ALL)
			return Level.ALL;
		if (level == ch.qos.logback.classic.Level.TRACE)
			return Level.TRACE;
		if (level == ch.qos.logback.classic.Level.DEBUG)
			return Level.DEBUG;
		if (level == ch.qos.logback.classic.Level.INFO)
			return Level.INFO;
		if (level == ch.qos.logback.classic.Level.WARN)
			return Level.WARN;
		if (level == ch.qos.logback.classic.Level.ERROR)
			return Level.ERROR;
		return Level.OFF;
	}
}
