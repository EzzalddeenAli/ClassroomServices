/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.classroom.services.facade.dto.entities;

import java.util.UUID;

import com.classroom.services.facade.dto.IUserDependent;


/**
 * Transfer object for user id
 */
public class UserIdDTO implements IUserDependent {
    private UUID userId;

    /**
     * The Constructor.
     * 
     * @param userId
     *            the user id
     */
    public UserIdDTO(UUID userId) {
        super();
        this.userId = userId;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.classroom.services.facade.dto.IUserDependent#getUserId()
     */
    public UUID getUserId() {
        return userId;
    }
}
