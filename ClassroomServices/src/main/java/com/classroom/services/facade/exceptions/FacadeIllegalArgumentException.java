/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.classroom.services.facade.exceptions;


/**
 * Thrown to indicate that a method has been passed an illegal or inappropriate
 * argument.
 */
public class FacadeIllegalArgumentException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * The Constructor.
     * 
     * @param message
     *            the message
     */
    public FacadeIllegalArgumentException(String message) {
        super(message);
    }

    /**
     * The Constructor.
     * 
     * @param message
     *            the message
     * @param cause
     *            the cause
     */
    public FacadeIllegalArgumentException(String message, Throwable cause) {
        super(message, cause);
    }
}
