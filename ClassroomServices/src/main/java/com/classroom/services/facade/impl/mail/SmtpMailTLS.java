/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.classroom.services.facade.impl.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.classroom.services.facade.AppConfiguration;


/**
 * Provides functionality for email sending
 */
public class SmtpMailTLS {
    private final String isAuth;
    private final String host;
    private final String port;

    private final String senderEmail;

    /**
     * The Constructor.
     */
    public SmtpMailTLS() {
        super();
        this.isAuth = AppConfiguration.getProperty("facade.mail.smtp.auth");
        this.host = AppConfiguration.getProperty("facade.mail.smtp.host");
        this.port = AppConfiguration.getProperty("facade.mail.smtp.port");
        this.senderEmail = AppConfiguration
                .getProperty("facade.mail.sender.email");

    }

    /**
     * Gets the session.
     * 
     * @return the session
     */
    private Session getSession() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", this.isAuth);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", this.host);
        props.put("mail.smtp.port", this.port);

        if (this.isAuth.equals(Boolean.TRUE.toString())) {
            final String username = AppConfiguration
                    .getProperty("facade.mail.smtp.username");
            final String password = AppConfiguration
                    .getProperty("facade.mail.smtp.password");

            return Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
        } else {
            return Session.getInstance(props);
        }
    }

    /**
     * Send a message.
     * 
     * @param data
     *            - {@link MessageData}
     */
    public void sendEmail(MessageData data) {
        try {
            Message message = new MimeMessage(getSession());
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(data.getRecipientEmail()));
            message.setSubject(data.getSubject());
            message.setText(data.getBody());

            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
