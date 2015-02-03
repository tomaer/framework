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

import com.tomaer.framework.common.logger.Logger;
import com.tomaer.framework.common.logger.LoggerExt;

/**
 * Description:
 * Author: tomaer
 * Version: 1.0
 * Date: 2015/2/2 21:36
 */
public class SLF4jLogger extends LoggerExt{

	private static final long serialVersionUID = -8707815585569912867L;
	public SLF4jLogger(org.slf4j.Logger logger) {
		super((Logger) logger);
	}
	
}
