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

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.text.MessageFormat;

/**
 * Description: Author: tomaer Version: 1.0 Date: 2015/2/2 21:30
 */
public abstract class AbstractLogger implements Logger, Serializable {

	private static final long serialVersionUID = -964113662309196432L;

	public void setLogger(Logger log) {
		
	}

	private static final int RANDOM_KEY_LENGTH = 6;
	private static final String POSSIBLE_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

	private static ThreadLocal<Object> threadlocal_UniqueKey = new ThreadLocal<Object>() {
		@Override
		protected synchronized Object initialValue() {
			return RandomStringUtils.random(RANDOM_KEY_LENGTH, POSSIBLE_CHARS);
		}
	};

	public static String getUniqueKey() {
		return ((String) threadlocal_UniqueKey.get());
	}

	public static void setUniqueKey() {
		threadlocal_UniqueKey.set(RandomStringUtils.random(RANDOM_KEY_LENGTH,
				POSSIBLE_CHARS));
	}

	public static void destoryUniqueKey() {
		threadlocal_UniqueKey.set(null);
	}

	protected String formatMessage(final Object message,
			final Object... objects) {
		String msg = "";
		if (message == null || StringUtils.isBlank(message.toString())) {
			return msg;
		}
		msg = message.toString().replace("'", "''");
		msg = MessageFormat.format(msg, objects);
		return msg;
	}
}
