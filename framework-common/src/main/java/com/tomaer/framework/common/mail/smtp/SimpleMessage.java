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
package com.tomaer.framework.common.mail.smtp;

/**
 * Description:简单格式的邮件信息主体,常用于简单的文本格式
 * Author: tomaer
 * Version: 1.0
 * Date: 2015/2/2 16:23
 */
public class SimpleMessage extends Message {

    private static final long serialVersionUID = -2966915199420419977L;

    /**
     * 默认构造方法
     */
    public SimpleMessage() {
        
    }

    /**
     * 参数化构造方法
     * @param from
     * @param fromAlias
     * @param subject
     * @param tos
     * @param ccs
     * @param bccs
     * @param replys
     * @param content
     */
    public SimpleMessage(String from, String fromAlias, String subject, String[] tos, String[] ccs, String[] bccs, String[] replys, String content) {
        super(from, fromAlias, subject, tos, ccs, bccs, replys, content);
    }
}
