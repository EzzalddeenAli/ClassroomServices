/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.classroom.services.facade.exceptions;

import java.io.Serializable;


/**
 * Thrown if record was not found in the repository.
 */
public class FacadeEntityNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    private final Class<?> clazz;

    private final Serializable id;

    /**
     * Contructor.
     * 
     * @param clazz
     *            the clazz
     * @param id
     *            the id
     */
    public FacadeEntityNotFoundException(Class<?> clazz, Serializable id) {
        this.clazz = clazz;
        this.id = id;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Throwable#getMessage()
     */
    @Override
    public String getMessage() {
        return "Entity " + clazz.getSimpleName() + " #" + id.toString()
                + " hasn't been found.";
    }
}
