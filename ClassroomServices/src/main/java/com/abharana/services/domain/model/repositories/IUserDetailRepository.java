/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.abharana.services.domain.model.repositories;

import java.util.UUID;

import com.abharana.services.domain.model.UserDetail;

/**
 * 
 * @author mkol
 * 
 */
public interface IUserDetailRepository extends IBaseRepository<UserDetail> {

    /**
     * Get user details for given user id.
     * 
     * @param userId
     *            the user id
     * @return the user detail
     */
    UserDetail getUserDetail(UUID userId);

}
