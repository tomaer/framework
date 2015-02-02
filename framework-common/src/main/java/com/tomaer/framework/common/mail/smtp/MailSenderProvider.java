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

import com.tomaer.framework.common.logger.Logger;
import com.tomaer.framework.common.logger.LoggerFactory;
import com.tomaer.framework.common.mail.MailAuthenticator;
import org.apache.commons.lang3.StringUtils;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;

/**
 * Description:
 * Author: tomaer
 * Version: 1.0
 * Date: 2015/2/2 17:16
 */
public class MailSenderProvider implements MailSender {
    
    private final static String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
    final Logger logger = LoggerFactory.getLogger(MailSenderProvider.class);

    private String smtpHost;
    private String smtpPort;
    private boolean requiredSSL;
    private boolean auth;
    private boolean debug;
    private String account;
    private String password;

    public String getSmtpHost() {
        return smtpHost;
    }

    @Override
    public void setSmtpHost(String smtpHost) {
        this.smtpHost = smtpHost;
    }

    public String getSmtpPort() {
        return smtpPort;
    }

    @Override
    public void setSmtpPort(String smtpPort) {
        this.smtpPort = smtpPort;
    }

    public boolean isRequiredSSL() {
        return requiredSSL;
    }

    @Override
    public void setRequiredSSL(boolean requiredSSL) {
        this.requiredSSL = requiredSSL;
    }

    public boolean isAuth() {
        return auth;
    }

    @Override
    public void setAuth(boolean auth) {
        this.auth = auth;
    }

    public boolean isDebug() {
        return debug;
    }

    @Override
    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public String getAccount() {
        return account;
    }

    @Override
    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 发送简单的电子邮件,普通的Text格式,不能发送html格式,也不能带附件
     * @param message
     *
     * @throws javax.mail.MessagingException
     */
    @Override
    public void sendSimpleMail(SimpleMessage message) throws MessagingException {
        MimeMessage msg =  getMimeMessage(message);
        msg.setContent(message.getContent(),"text/plain;charset=utf-8");
        Transport.send(msg);
    }

    /**
     * 发送Html格式的电子邮件，不能带附件
     * @param message
     *
     * @throws javax.mail.MessagingException
     */
    @Override
    public void sendHtmlMail(HtmlMessage message) throws MessagingException {
        MimeMessage msg =  getMimeMessage(message);
        msg.setContent(message.getContent(), "text/html;charset=utf-8");
        Transport.send(msg);
    }

    /**
     * 发送复合的电子邮件,可以带附件,普通的Text格式
     * @param message
     *
     * @throws javax.mail.MessagingException
     */
    @Override
    public void sendComplexSimpleMail(ComplexMessage message) throws MessagingException {
        sendComplexMail(message, "text/plain;charset=utf-8");
    }

    /**
     * 发送复合的电子邮件,可以带附件,Html格式.
     * @param message
     *
     * @throws javax.mail.MessagingException
     */
    @Override
    public void sendComplexHtmlMail(ComplexMessage message) throws MessagingException {
        sendComplexMail(message, "text/html;charset=utf-8");
    }

    private void sendComplexMail(ComplexMessage message, String mineType)
            throws MessagingException {
        MimeMessage msg =  getMimeMessage(message);
        Multipart mp = new MimeMultipart();
        MimeBodyPart mbp = new MimeBodyPart();
        mbp.setContent(message.getContent(), mineType);
        mp.addBodyPart(mbp);
        if (message.getAttachs() != null && message.getAttachs().size() > 0) {
            for (String attachmentPath : message.getAttachs()) {
                mbp = new MimeBodyPart();
                FileDataSource fds = new FileDataSource(attachmentPath);
                mbp.setDataHandler(new DataHandler(fds));
                mbp.setFileName(fds.getName());
                mp.addBodyPart(mbp);
            }
        }
        msg.setContent(mp);
        Transport.send(msg);
    }


    protected void validateSmtpProps() {
        if (StringUtils.isBlank(smtpHost)) {
            throw new IllegalArgumentException("");
        }
        if (StringUtils.isBlank(smtpPort)) {
            throw new IllegalArgumentException("");
        }
    }

    private MimeMessage getMimeMessage(Message message) throws MessagingException{
        if(null == message){
            throw new IllegalArgumentException("");
        }
        Session session = getSession(message);
        MimeMessage msg = new MimeMessage(session);
        msg.setSubject(message.getSubject());
        msg.setFrom(message.getFromAddress());
        msg.setSentDate(new Date());
        msg.setRecipients(RecipientType.TO, message.getToAddress());
        if (message.getCcAddress() != null && message.getCcAddress().length > 0) {
				logger.debug("Mail has cc address");
				for (String addr : message.getCcs())
					logger.debug("cc address : " + addr);
            msg.setRecipients(RecipientType.CC, message.getCcAddress());
        }
        if (message.getBccAddress() != null && message.getBccAddress().length > 0) {
				logger.debug("Mail has bcc address");
				for (String addr : message.getBccs())
					logger.debug("bcc address : " + addr);
            msg.setRecipients(RecipientType.BCC, message.getBccAddress());
        }
        if (message.getReplyAddress() != null && message.getReplyAddress().length > 0) {
				logger.debug("Mail has reply address");
				for (String addr : message.getReplys())
					logger.debug("reply address : " + addr);
            msg.setReplyTo(message.getReplyAddress());
        }
        return msg;
    }

    protected Session getSession(Message message) {
        validateSmtpProps();
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", smtpPort);
        Session session = null;
        if (!debug) {
            logger.debug("Mail not use debug mode");
            props.put("mail.debug", "false");
        } else {
            logger.debug("Mail use debug mode");
            props.put("mail.debug", "true");
        }
        if (requiredSSL) {
            props.put("mail.smtp.socketFactory.port", smtpPort);
            props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
            props.setProperty("mail.smtp.socketFactory.fallback", "false");
        }
        if (auth) {
            props.put("mail.smtp.auth", "true");
            if (!message.getFrom().equals(account)) {
                logger.error("Smtp account must be same as the from email address !");
                throw new IllegalArgumentException("Smtp account must be same as the from email address !");
            }
            session = Session.getInstance(props, new MailAuthenticator(account,password));
        } else {
            session = Session.getInstance(props);
        }
        return session;
    }
    
}
