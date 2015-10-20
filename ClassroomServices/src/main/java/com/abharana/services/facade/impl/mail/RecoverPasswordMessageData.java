/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.abharana.services.facade.impl.mail;

import com.abharana.services.facade.AppConfiguration;

public class RecoverPasswordMessageData extends MessageData {

    /**
     * The Constructor.
     * 
     * @param recipientEmail
     *            the recipient email
     * @param password
     *            the password
     */
    public RecoverPasswordMessageData(String recipientEmail, String password) {
        super(recipientEmail, AppConfiguration
                .getProperty("facade.mail.recovery.subject"), String.format(
                AppConfiguration.getProperty("facade.mail.recovery.text"),
                password));
    }
}
