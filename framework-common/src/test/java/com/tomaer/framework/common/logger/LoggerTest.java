/**
 * 
 */
package com.tomaer.framework.common.logger;

import org.junit.Test;

/**
 * @author tomaer
 *
 */
public class LoggerTest {
	
	final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Test
	public void testLoggerInfo(){
		logger.info("this is logger");
	}
}
