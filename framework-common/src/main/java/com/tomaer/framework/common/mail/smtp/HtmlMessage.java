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
 * Description:
 * Author: tomaer
 * Version: 1.0
 * Date: 2015/2/2 17:11
 */
public class HtmlMessage extends Message {

    private static final long serialVersionUID = -7289447097442046721L;

    /**
     * 默认构造方法
     */
    public HtmlMessage() {
        super();
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
    public HtmlMessage(String from, String fromAlias, String subject, String[] tos, String[] ccs, String[] bccs, String[] replys, String content) {
        super(from, fromAlias, subject, tos, ccs, bccs, replys, content);
    }
}
