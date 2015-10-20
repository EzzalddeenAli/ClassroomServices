/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.classroom.services.util;

import com.classroom.services.facade.exceptions.FacadeAlreadyExistsException;
import com.classroom.services.facade.exceptions.FacadeEntityNotFoundException;
import com.classroom.services.facade.exceptions.FacadeIllegalArgumentException;

public interface ITestDataBootstrap {

    /**
     * Creates the test data.
     * 
     * @throws FacadeIllegalArgumentException
     *             the facade illegal argument exception
     * @throws FacadeAlreadyExistsException
     *             the facade already exists exception
     * @throws FacadeEntityNotFoundException
     *             the facade entity not found exception
     */
    void createTestData() throws FacadeIllegalArgumentException,
            FacadeAlreadyExistsException, FacadeEntityNotFoundException;

}
