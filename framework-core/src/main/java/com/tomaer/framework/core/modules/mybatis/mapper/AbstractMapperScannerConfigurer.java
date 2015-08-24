/**
 * 
 */
package com.tomaer.framework.core.modules.mybatis.mapper;

import org.mybatis.spring.mapper.MapperScannerConfigurer;

/**
 * @author tomaer
 *
 */
public abstract class AbstractMapperScannerConfigurer extends MapperScannerConfigurer  {
	
	@Override
	public abstract void setBasePackage(String basePackage);

}
