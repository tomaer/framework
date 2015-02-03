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

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.commons.lang3.StringUtils;

import com.tomaer.framework.common.logger.Logger;
import com.tomaer.framework.common.logger.LoggerFactory;

/**
 * Description:邮件主体信息,包括邮件中常用的属性
 * Author: tomaer
 * Version: 1.0
 * Date: 2015/2/2 16:14
 */
public class Message implements Serializable {

    private static final long serialVersionUID = 4193902402250439755L;

    final Logger logger = LoggerFactory.getLogger(Message.class);

    /**
     * 发件人
     */
    protected String from;

    /**
     * 发件人别名
     */
    protected String fromAlias;

    /**
     * 邮件标题/主题
     */
    protected String subject;

    /**
     * 收件人
     */
    protected String[] tos;

    /**
     * 抄送人
     */
    protected String[] ccs;

    /**
     * 密送人
     */
    protected String[] bccs;

    /**
     * 回复的邮箱地址
     */
    protected String[] replys;

    /**
     * 邮件正文类容
     */
    protected String content;

    /**
     * 默认构造方法
     */
    public Message() {

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
    public Message(String from, String fromAlias, String subject, String[] tos, String[] ccs, String[] bccs, String[] replys, String content) {
        this.from = from;
        this.fromAlias = fromAlias;
        this.subject = subject;
        this.tos = tos;
        this.ccs = ccs;
        this.bccs = bccs;
        this.replys = replys;
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFromAlias() {
        return fromAlias;
    }

    public void setFromAlias(String fromAlias) {
        this.fromAlias = fromAlias;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String[] getTos() {
        return tos;
    }

    public void setTos(String[] tos) {
        this.tos = tos;
    }

    public String[] getCcs() {
        return ccs;
    }

    public void setCcs(String[] ccs) {
        this.ccs = ccs;
    }

    public String[] getBccs() {
        return bccs;
    }

    public void setBccs(String[] bccs) {
        this.bccs = bccs;
    }

    public String[] getReplys() {
        return replys;
    }

    public void setReplys(String[] replys) {
        this.replys = replys;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获得发件人信息的InternetAddress格式
     * @return
     * @throws AddressException
     */
    public InternetAddress getFromAddress() throws AddressException {
        if (StringUtils.isNotBlank(from)) {
            try {
                if (StringUtils.isNotBlank(fromAlias)) {
                    logger.debug("From address is {0},Alias is {1}", from, fromAlias);
                    return new InternetAddress(from, fromAlias);
                } else {
                    logger.debug("From address is {0}", from);
                    return new InternetAddress(from);
                }

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        logger.error("From address is not allow empty");
        throw new IllegalArgumentException("From address is not allow empty");
    }

    public InternetAddress[] getToAddress() throws AddressException {
        if (null == tos && tos.length == 0) {
            logger.error("To address is not allow empty");
            throw new IllegalArgumentException("To address is not allow empty");
        }
        InternetAddress[] address = new InternetAddress[tos.length];
        for (int i = 0; i < tos.length; i++) {
            logger.debug("To address is {0}", tos[i]);
            address[i] = new InternetAddress(tos[i]);
        }
        return address;
    }

    public InternetAddress[] getCcAddress() throws AddressException {
        if (null == ccs && ccs.length == 0) {
            logger.error("CC address is not allow empty");
            throw new IllegalArgumentException("CC address is not allow empty");
        }
        InternetAddress[] address = new InternetAddress[ccs.length];
        for (int i = 0; i < ccs.length; i++) {
            logger.debug("CC address is {0}", ccs[i]);
            address[i] = new InternetAddress(ccs[i]);
        }
        return address;
    }

    public InternetAddress[] getBccAddress() throws AddressException {
        if (null == bccs && bccs.length == 0) {
            logger.error("BCC address is not allow empty");
            throw new IllegalArgumentException("BCC address is not allow empty");
        }
        InternetAddress[] address = new InternetAddress[bccs.length];
        for (int i = 0; i < bccs.length; i++) {
            logger.debug("BCC address is {0}", bccs[i]);
            address[i] = new InternetAddress(bccs[i]);
        }
        return address;
    }

    public InternetAddress[] getReplyAddress() throws AddressException {
        if (null == replys && replys.length == 0) {
            logger.error("Reply address is not allow empty");
            throw new IllegalArgumentException("Reply address is not allow empty");
        }
        InternetAddress[] address = new InternetAddress[replys.length];
        for (int i = 0; i < replys.length; i++) {
            logger.debug("Reply address is {0}", replys[i]);
            address[i] = new InternetAddress(replys[i]);
        }
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;

        Message message = (Message) o;

        if (!Arrays.equals(bccs, message.bccs)) return false;
        if (!Arrays.equals(ccs, message.ccs)) return false;
        if (content != null ? !content.equals(message.content) : message.content != null) return false;
        if (from != null ? !from.equals(message.from) : message.from != null) return false;
        if (fromAlias != null ? !fromAlias.equals(message.fromAlias) : message.fromAlias != null) return false;
        if (!Arrays.equals(replys, message.replys)) return false;
        if (subject != null ? !subject.equals(message.subject) : message.subject != null) return false;
        if (!Arrays.equals(tos, message.tos)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = from != null ? from.hashCode() : 0;
        result = 31 * result + (fromAlias != null ? fromAlias.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (tos != null ? Arrays.hashCode(tos) : 0);
        result = 31 * result + (ccs != null ? Arrays.hashCode(ccs) : 0);
        result = 31 * result + (bccs != null ? Arrays.hashCode(bccs) : 0);
        result = 31 * result + (replys != null ? Arrays.hashCode(replys) : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Message{" +
                "from='" + from + '\'' +
                ", fromAlias='" + fromAlias + '\'' +
                ", subject='" + subject + '\'' +
                ", tos=" + Arrays.toString(tos) +
                ", ccs=" + Arrays.toString(ccs) +
                ", bccs=" + Arrays.toString(bccs) +
                ", replys=" + Arrays.toString(replys) +
                ", content='" + content + '\'' +
                '}';
    }
}
