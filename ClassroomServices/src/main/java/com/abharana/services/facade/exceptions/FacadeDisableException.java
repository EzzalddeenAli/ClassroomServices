/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.abharana.services.facade.exceptions;


public class FacadeDisableException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * The Constructor.
     * 
     * @param message
     *            the message
     * @param cause
     *            the cause
     */
    public FacadeDisableException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * The Constructor.
     * 
     * @param message
     *            the message
     */
    public FacadeDisableException(String message) {
        super(message);
    }
}
