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

import java.util.List;

/**
 * Description:
 * Author: tomaer
 * Version: 1.0
 * Date: 2015/2/2 17:12
 */
public class ComplexMessage extends Message {

    private static final long serialVersionUID = -5796193977031423052L;

    private List<String> attachs;

    public List<String> getAttachs() {
        return attachs;
    }

    public void setAttachs(List<String> attachs) {
        this.attachs = attachs;
    }

    public ComplexMessage(){
        super();
    }
    /**
     * 默认构造方法
     */
    public ComplexMessage(List<String> attachs) {
        this.attachs = attachs;
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
    public ComplexMessage(String from, String fromAlias, String subject, String[] tos, String[] ccs, String[] bccs, String[] replys, String content, List<String> attachs) {
        super(from, fromAlias, subject, tos, ccs, bccs, replys, content);
        this.attachs = attachs;
    }
}
