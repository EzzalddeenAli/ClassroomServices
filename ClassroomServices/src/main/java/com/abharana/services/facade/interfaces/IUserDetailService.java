/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.abharana.services.facade.interfaces;

import java.util.UUID;

import org.springframework.security.access.prepost.PreAuthorize;

import com.abharana.services.facade.dto.entities.UserDetailDTO;
import com.abharana.services.facade.exceptions.FacadeAlreadyExistsException;
import com.abharana.services.facade.exceptions.FacadeEntityNotFoundException;
import com.abharana.services.facade.exceptions.FacadeIllegalArgumentException;


public interface IUserDetailService {

    /**
     * Create user details.
     * 
     * @param detail
     *            - {@link UserDetailDTO}
     * @return TODO is there any needs to get created id? it is not used
     *         anywhere
     * @throws FacadeEntityNotFoundException
     *             the facade entity not found exception
     * @throws FacadeIllegalArgumentException
     *             the facade illegal argument exception
     * @throws FacadeAlreadyExistsException
     *             the facade already exists exception
     */
    void createUserDetail(UserDetailDTO detail)
            throws FacadeEntityNotFoundException,
            FacadeIllegalArgumentException, FacadeAlreadyExistsException;

    /**
     * Get user detail information.
     * 
     * @param userId
     *            - user id
     * @return {@link UserDetailDTO}
     * @throws FacadeEntityNotFoundException
     *             the facade entity not found exception
     */
    @PreAuthorize("hasPermission(#userId, 'getUser')")
    UserDetailDTO getUserDetail(UUID userId)
            throws FacadeEntityNotFoundException;

    /**
     * Update user detail information.
     * 
     * @param userDetail
     *            - {@link UserDetailDTO}
     * @throws FacadeEntityNotFoundException
     *             the facade entity not found exception
     * @throws FacadeIllegalArgumentException
     *             the facade illegal argument exception
     */
    void updateUserDetail(UserDetailDTO userDetail)
            throws FacadeEntityNotFoundException,
            FacadeIllegalArgumentException;

    /**
     * Delete user detail information.
     * 
     * @param userId
     *            - user id
     * @throws FacadeEntityNotFoundException
     *             the facade entity not found exception
     */
    void deleteUserDetail(UUID userId)
            throws FacadeEntityNotFoundException;
}
