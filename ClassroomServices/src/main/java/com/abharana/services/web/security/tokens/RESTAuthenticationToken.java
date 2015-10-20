/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.abharana.services.web.security.tokens;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;


/**
 * Security token
 * 
 * @author mkol
 * 
 */
public class RESTAuthenticationToken extends
        UsernamePasswordAuthenticationToken {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * The Constructor.
     * 
     * @param principal
     *            the principal
     * @param credentials
     *            the credentials
     */
    public RESTAuthenticationToken(Object principal, Object credentials) {
        super(principal, credentials);
    }

    /**
     * The Constructor.
     * 
     * @param principal
     *            the principal
     * @param credentials
     *            the credentials
     * @param authorities
     *            the authorities
     */
    public RESTAuthenticationToken(Object principal, Object credentials,
            Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }
}
