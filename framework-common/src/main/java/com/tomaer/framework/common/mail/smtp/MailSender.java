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

import javax.mail.MessagingException;

/**
 * Description:邮件发送接口
 * Author: tomaer
 * Version: 1.0
 * Date: 2015/2/2 17:09
 */
public interface MailSender {

    void setSmtpHost(String smtpHost);

    void setSmtpPort(String smtpPort);

    void setRequiredSSL(boolean requiredSSL);

    void setDebug(boolean debug);

    void setAuth(boolean auth);

    void setAccount(String account);

    void setPassword(String password);

    /**
     * 发送简单的电子邮件,普通的Text格式,不能发送html格式,也不能带附件
     * @param message
     *
     * @throws MessagingException
     */
    void sendSimpleMail(SimpleMessage message) throws MessagingException;

    /**
     * 发送Html格式的电子邮件，不能带附件
     * @param message
     *
     * @throws MessagingException
     */
    void sendHtmlMail(HtmlMessage message) throws MessagingException;

    /**
     * 发送复合的电子邮件,可以带附件,普通的Text格式
     * @param message
     *
     * @throws MessagingException
     */
    void sendComplexSimpleMail(ComplexMessage message) throws MessagingException;

    /**
     * 发送复合的电子邮件,可以带附件,Html格式.
     * @param message
     *
     * @throws MessagingException
     */
    void sendComplexHtmlMail(ComplexMessage message) throws MessagingException;
}
