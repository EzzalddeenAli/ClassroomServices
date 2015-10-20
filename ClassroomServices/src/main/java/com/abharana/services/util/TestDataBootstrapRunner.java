/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.abharana.services.util;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.abharana.services.facade.exceptions.FacadeAlreadyExistsException;
import com.abharana.services.facade.exceptions.FacadeEntityNotFoundException;
import com.abharana.services.facade.exceptions.FacadeIllegalArgumentException;

//This class is needed because InitilizingBean cannot be transactional
//http://forum.springsource.org/showthread.php?36813-Transactional-annotation-in-an-InitializingBean
public class TestDataBootstrapRunner implements InitializingBean {
    @Autowired
    private ITestDataBootstrap testDataBootstrap;

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    public void afterPropertiesSet() throws FacadeIllegalArgumentException,
    FacadeAlreadyExistsException, FacadeEntityNotFoundException {
        testDataBootstrap.createTestData();

    }

}
