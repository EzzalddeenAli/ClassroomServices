/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.abharana.services.util;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.abharana.services.facade.exceptions.FacadeAlreadyExistsException;
import com.abharana.services.facade.exceptions.FacadeEntityNotFoundException;
import com.abharana.services.facade.exceptions.FacadeIllegalArgumentException;

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
     * @see com.abharana.services.util.ITestDataBootstrap#createTestData()
     */
    public void createTestData() throws FacadeIllegalArgumentException,
            FacadeAlreadyExistsException, FacadeEntityNotFoundException {
    }

}
