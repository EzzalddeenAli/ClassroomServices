/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.classroom.services.util;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.classroom.services.facade.exceptions.FacadeAlreadyExistsException;
import com.classroom.services.facade.exceptions.FacadeEntityNotFoundException;
import com.classroom.services.facade.exceptions.FacadeIllegalArgumentException;

/**
 * Temporal place for generating testing data that should be inserted into H2
 * in-memeory database only.
 * 
 * @author isop
 * 
 */
@Component
@Transactional
public class TestDataBootstrap implements ITestDataBootstrap {

    /*
     * (non-Javadoc)
     * 
     * @see com.classroom.services.util.ITestDataBootstrap#createTestData()
     */
    public void createTestData() throws FacadeIllegalArgumentException,
            FacadeAlreadyExistsException, FacadeEntityNotFoundException {
    }

}
