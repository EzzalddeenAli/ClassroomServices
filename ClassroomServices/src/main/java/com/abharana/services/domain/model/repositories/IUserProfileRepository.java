/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.abharana.services.domain.model.repositories;

import java.util.UUID;

import com.abharana.services.domain.model.UserProfile;


/**
 * Base repository interface for UserProfile model
 * 
 * @author mkol
 * 
 */
public interface IUserProfileRepository extends IBaseRepository<UserProfile> {

    /**
     * Get user by name.
     * 
     * @param username
     *            the username
     * @return {@link UserProfile}
     */
    UserProfile getUserByName(String username);

    /**
     * Get owner for recover password token.
     * 
     * @param recoverToken
     *            - recover token
     * @return {@link UserProfile}
     */
    UserProfile getUserByRecoverToken(UUID recoverToken);

    /**
     * Get owner of given security token.
     * 
     * @param securityToken
     *            the security token
     * @return user of given security token
     */
    UserProfile getUserByLoginToken(UUID securityToken);

    /**
     * Flush and clear entity manager for batch operations.
     */
    void flush();

    /**
     * Gets the user by email or mobile.
     * 
     * @param mail
     *            the mail
     * @return the user by email or mobile
     */
    UserProfile getUserByEmailOrMobile(String mail);

}
