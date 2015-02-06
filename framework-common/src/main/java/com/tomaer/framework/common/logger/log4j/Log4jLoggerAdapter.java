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

import java.io.File;
import java.util.Enumeration;

import org.apache.log4j.LogManager;

import com.tomaer.framework.common.logger.Level;
import com.tomaer.framework.common.logger.Logger;
import com.tomaer.framework.common.logger.LoggerAdapter;

/**
 * Description:
 * Author: tomaer
 * Version: 1.0
 * Date: 2015/2/3 13:18
 */
public class Log4jLoggerAdapter implements LoggerAdapter {
    
	@SuppressWarnings("unused")
	private Level level;
	private File file;

	public Logger getLogger(Class<?> clazz) {
		return new Log4jLogger(org.apache.log4j.Logger.getLogger(clazz));
	}

	public Logger getLogger(String name) {
		return new Log4jLogger(org.apache.log4j.Logger.getLogger(name));
	}

	@SuppressWarnings("unchecked")
	public Level getLevel() {
		Enumeration<org.apache.log4j.Logger> enume = LogManager.getCurrentLoggers();
		if (null != enume && enume.hasMoreElements()) {
			while (enume.hasMoreElements()) {
				org.apache.log4j.Logger l = enume.nextElement();
				org.apache.log4j.Level level = l.getLevel();
				if (null != level) {
					return toWiShareLevel(level);
				}
			}
		}
		return Level.ERROR;
	}

	@SuppressWarnings("unchecked")
	public void setLevel(Level level) {
		Enumeration<org.apache.log4j.Logger> enume = LogManager.getCurrentLoggers();
		if (null != enume && enume.hasMoreElements()) {
			while (enume.hasMoreElements()) {
				org.apache.log4j.Logger l = enume.nextElement();
				l.setLevel(toLog4jLevel(level));
			}
		}
		this.level = level;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	private org.apache.log4j.Level toLog4jLevel(Level level) {
		if (null == level)
			return org.apache.log4j.Level.OFF;
		if (level == Level.ALL)
			return org.apache.log4j.Level.ALL;
		if (level == Level.TRACE)
			return org.apache.log4j.Level.TRACE;
		if (level == Level.DEBUG)
			return org.apache.log4j.Level.DEBUG;
		if (level == Level.INFO)
			return org.apache.log4j.Level.INFO;
		if (level == Level.WARN)
			return org.apache.log4j.Level.WARN;
		if (level == Level.ERROR)
			return org.apache.log4j.Level.ERROR;
		return org.apache.log4j.Level.OFF;
	}

	private Level toWiShareLevel(org.apache.log4j.Level level) {
		if (null == level)
			return Level.OFF;
		if (level == org.apache.log4j.Level.ALL)
			return Level.ALL;
		if (level == org.apache.log4j.Level.TRACE)
			return Level.TRACE;
		if (level == org.apache.log4j.Level.DEBUG)
			return Level.DEBUG;
		if (level == org.apache.log4j.Level.INFO)
			return Level.INFO;
		if (level == org.apache.log4j.Level.WARN)
			return Level.WARN;
		if (level == org.apache.log4j.Level.ERROR)
			return Level.ERROR;
		return Level.OFF;
	}
}
