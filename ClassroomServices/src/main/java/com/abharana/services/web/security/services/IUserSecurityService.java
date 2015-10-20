/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.abharana.services.web.security.services;

import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 
 * @author mkol
 * 
 */
public interface IUserSecurityService extends UserDetailsService {

    /**
     * Gets the user by security token.
     * 
     * @param loginToken
     *            the login token
     * @return the user by security token
     */
    UserDetails getUserBySecurityToken(UUID loginToken);
}
