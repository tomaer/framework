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
package com.tomaer.framework.common.utils;


import com.tomaer.framework.common.logger.Logger;
import com.tomaer.framework.common.logger.LoggerFactory;
import org.apache.commons.lang3.StringUtils;


/**
 * Description:文件压缩,解压缩处理,底层使用Apache commons-compress
 * Author: tomaer
 * Version: 1.0
 * Date: 2015/2/3 17:42
 */
public class CompressUtil {
    
    static final Logger logger = LoggerFactory.getLogger(CompressUtil.class);

    /**
     * 压缩直接路径的文件为zip文件,并且放到指定位置
     * @param source 源文件路径
     * @param target zip文件存放路径
     */
    public static void compress2ZIP(String source,final String target){
        if(StringUtils.isBlank(source) || StringUtils.isBlank(target)){
            logger.error("");
            throw new IllegalArgumentException("");
        }
    }
    
    public static void compress2AR(){
        
        
    }
    
    
    public static void unZIP(String source,final String target){
    
    }
    
}
