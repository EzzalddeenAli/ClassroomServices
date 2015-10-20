/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.classroom.services.facade.exceptions;


/**
 * Thrown if record with the same id already exists.
 */
public class FacadeAlreadyExistsException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * The Constructor.
     * 
     * @param message
     *            the message
     */
    public FacadeAlreadyExistsException(String message) {
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
    public FacadeAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
