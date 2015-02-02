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

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import java.io.Serializable;

/**
 * Description: JavaMail和邮件服务器之间的认证器
 * Author: tomaer
 * Version: 1.0
 * Date: 2015/2/2 15:29
 */
public class MailAuthenticator extends Authenticator implements Serializable {

    private static final long serialVersionUID = 4177380060749627922L;

    /**
     * 认证账号,一般指邮件全地址,例如abc@xxx.com 
     */
    private String account;
    
    /**
     * 认证密码
     */
    private String password;

    /**
     * 默认构造方法
     */
    public MailAuthenticator() {
        
    }

    /**
     * 参数化构造方法,只要是用来初始化认证器用
     * @param account 认证账号
     * @param password 认证密码
     */
    public MailAuthenticator(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Called when password authentication is needed.  Subclasses should
     * override the default implementation, which returns null. <p>
     * <p/>
     * Note that if this method uses a dialog to prompt the user for this
     * information, the dialog needs to block until the user supplies the
     * information.  This method can not simply return after showing the
     * dialog.
     * @return The PasswordAuthentication collected from the
     * user, or null if none is provided.
     */
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(this.account,this.password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MailAuthenticator)) return false;

        MailAuthenticator that = (MailAuthenticator) o;

        if (!account.equals(that.account)) return false;
        if (!password.equals(that.password)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = account.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "MailAuthenticator{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
