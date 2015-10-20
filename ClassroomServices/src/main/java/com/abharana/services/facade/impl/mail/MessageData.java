/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.abharana.services.facade.impl.mail;


/**
 * This class models basic email message content.
 */
public class MessageData {
    private String recipientEmail;
    private String subject;
    private String body;

    /**
     * The Constructor.
     * 
     * @param recipientEmail
     *            the recipient email
     * @param subject
     *            the subject
     * @param body
     *            the body
     */
    public MessageData(String recipientEmail, String subject, String body) {
        super();
        this.recipientEmail = recipientEmail;
        this.subject = subject;
        this.body = body;
    }

    /**
     * Gets the recipient email.
     * 
     * @return the recipient email
     */
    public String getRecipientEmail() {
        return recipientEmail;
    }

    /**
     * Gets the subject.
     * 
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Gets the body.
     * 
     * @return the body
     */
    public String getBody() {
        return body;
    }
}
