/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.abharana.services.domain.exceptions;

/**
 * Thrown to indicate that a method has been passed an illegal or inappropriate
 * argument.
 */
public class DomainIllegalArgumentException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * The Constructor.
     * 
     * @param message
     *            the message
     */
    public DomainIllegalArgumentException(String message) {
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
    public DomainIllegalArgumentException(String message, Throwable cause) {
        super(message, cause);
    }
}
