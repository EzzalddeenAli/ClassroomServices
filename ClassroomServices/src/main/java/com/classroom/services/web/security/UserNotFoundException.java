/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.classroom.services.web.security;


/**
 * 
 * @author mkol
 * 
 */
public class UserNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new runtime exception with the specified detail message. The
     * cause is not initialized, and may subsequently be initialized by a call
     * to {@link #initCause}.
     * 
     * @param message
     *            the detail message. The detail message is saved for later
     *            retrieval by the {@link #getMessage()} method.
     */
    public UserNotFoundException(String message) {
        // To change body of overridden methods use File |
        // Settings | File Templates.
        super(message); 
    }

    /**
     * Constructs a new runtime exception with the specified detail message and
     * cause.
     * <p>
     * Note that the detail message associated with <code>cause</code> is
     * <i>not</i> automatically incorporated in this runtime exception's detail
     * message.
     * 
     * @param message
     *            the detail message (which is saved for later retrieval by the
     * @param cause
     *            the cause (which is saved for later retrieval by the
     *            {@link #getMessage()} method). {@link #getCause()} method). (A
     *            <tt>null</tt> value is permitted, and indicates that the cause
     *            is nonexistent or unknown.)
     * @since 1.4
     */
    public UserNotFoundException(String message, Throwable cause) {
        // To change body of overridden methods use File
        // | Settings | File Templates.
        super(message, cause); 
    }

    /**
     * Constructs a new runtime exception with the specified cause and a detail
     * message of <tt>(cause==null ? null : cause.toString())</tt> (which
     * typically contains the class and detail message of <tt>cause</tt>). This
     * constructor is useful for runtime exceptions that are little more than
     * wrappers for other throwables.
     * 
     * @param cause
     *            the cause (which is saved for later retrieval by the
     *            {@link #getCause()} method). (A <tt>null</tt> value is
     *            permitted, and indicates that the cause is nonexistent or
     *            unknown.)
     * @since 1.4
     */
    public UserNotFoundException(Throwable cause) {
        // To change body of overridden methods use File |
        // Settings | File Templates.
        super(cause); 
    }
}
