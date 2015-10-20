/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.abharana.services.facade.dto;

import java.util.UUID;

/**
 * Interface showing user ownership to identify permission to work with entity
 */
public interface IUserDependent {

    /**
     * Return owner user id.
     * 
     * @return the user id
     */
    UUID getUserId();
}
