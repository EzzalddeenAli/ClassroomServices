/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.classroom.services.facade.interfaces;

import java.util.UUID;

import org.springframework.security.access.prepost.PreAuthorize;

import com.classroom.services.facade.dto.entities.UserIdDTO;
import com.classroom.services.facade.dto.entities.UserProfileDTO;
import com.classroom.services.facade.exceptions.FacadeAlreadyExistsException;
import com.classroom.services.facade.exceptions.FacadeBadCredentialsException;
import com.classroom.services.facade.exceptions.FacadeEntityNotFoundException;
import com.classroom.services.facade.exceptions.FacadeIllegalArgumentException;


public interface IUserService {

    /**
     * Create new user.
     * 
     * @param username
     *            - login
     * @param password
     *            - user password
     * @param email
     *            - email
     * @return created user id
     * @throws FacadeIllegalArgumentException
     *             the facade illegal argument exception
     * @throws FacadeAlreadyExistsException
     *             the facade already exists exception
     */
    @PreAuthorize("hasPermission('createUser')")
    UUID createUser(String username, String password, String email)
            throws FacadeIllegalArgumentException, FacadeAlreadyExistsException;

    /**
     * Delete user.
     * 
     * @param userId
     *            the user id
     * @throws FacadeEntityNotFoundException
     *             the facade entity not found exception {@link UserIdDTO}
     */
    @PreAuthorize("hasPermission(#userId, 'deleteUser')")
    void deleteUser(UserIdDTO userId)
            throws FacadeEntityNotFoundException;

    /**
     * Update user data and details.
     * 
     * @param userId
     *            the user id
     * @param username
     *            new username
     * @param email
     *            new email
     * @param status
     *            new status
     * @throws FacadeIllegalArgumentException
     *             the facade illegal argument exception
     * @throws FacadeEntityNotFoundException
     *             the facade entity not found exception {@link UserIdDTO}
     */
    @PreAuthorize("hasPermission(#userId, 'updateUser')")
    void updateUser(UserIdDTO userId, String username, String email,
            String status) throws FacadeIllegalArgumentException,
            FacadeEntityNotFoundException;

    /**
     * Get user.
     * 
     * @param userId
     *            the user id
     * @return {@link UserProfileDTO}
     * @throws FacadeEntityNotFoundException
     *             the facade entity not found exception {@link UserIdDTO}
     */
    @PreAuthorize("hasPermission(#userId, 'getUser')")
    UserProfileDTO getUser(UserIdDTO userId)
            throws FacadeEntityNotFoundException;

    /**
     * Get user from login token.
     * 
     * @param loginToken
     *            the login token
     * @return {@link UserProfileDTO}
     * @throws FacadeEntityNotFoundException
     *             the facade entity not found exception
     */
    @PreAuthorize("hasPermission(#loginToken, 'getUser')")
    UserProfileDTO getUserFromLoginToken(UUID loginToken)
            throws FacadeEntityNotFoundException;

    /**
     * Update user password.
     * 
     * @param userId
     *            the user id
     * @param oldPassword
     *            - old password
     * @param newPassword
     *            - password to set
     * @throws FacadeEntityNotFoundException
     *             the facade entity not found exception
     * @throws FacadeIllegalArgumentException
     *             the facade illegal argument exception
     * @throws FacadeBadCredentialsException
     *             the facade bad credentials exception {@link UserIdDTO}
     */
    @PreAuthorize("hasPermission(#userId, 'updateUserPassword')")
    void updateUserPassword(UserIdDTO userId, String oldPassword,
            String newPassword) throws FacadeEntityNotFoundException,
            FacadeIllegalArgumentException, FacadeBadCredentialsException;

    /**
     * Update user password by admin.
     * 
     * @param userId
     *            the user id
     * @param newPassword
     *            - password to set
     * @throws FacadeEntityNotFoundException
     *             the facade entity not found exception
     * @throws FacadeIllegalArgumentException
     *             the facade illegal argument exception {@link UserIdDTO}
     */
    void updatePassword(UserIdDTO userId, String newPassword)
            throws FacadeEntityNotFoundException,
            FacadeIllegalArgumentException;

}
