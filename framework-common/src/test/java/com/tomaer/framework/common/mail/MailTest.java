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
package com.tomaer.framework.common.mail;

import com.tomaer.framework.common.mail.smtp.MailSender;
import com.tomaer.framework.common.mail.smtp.SimpleMessage;

import javax.mail.MessagingException;

/**
 * Description:
 * Author: tomaer
 * Version: 1.0
 * Date: 2015/2/2 20:34
 */
public class MailTest {
    
//    @Auto
    private MailSender mailSender;
//    @Test
    public void testSendSimpleMessage(){
        SimpleMessage message = new SimpleMessage();
        message.setFrom("");
        message.setFromAlias("tomaer");
        message.setSubject("");
        message.setTos(new String[]{"tomaer@126.com","tomaer@foxmail.com"});
        message.setContent("This is a test email by javamail");
        try {
            mailSender.sendSimpleMail(message);
        } catch (MessagingException ex) {
            e.printStackTrace();
        }
    }
}
