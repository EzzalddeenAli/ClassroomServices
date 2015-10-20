/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.abharana.services.web.security;

import java.util.Collection;

import org.joda.time.LocalDateTime;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;


/**
 * 
 * @author mkol
 * 
 */
public class RESTUser extends User {
    private static final long serialVersionUID = 1L;

    private String id;
    private String securityToken;
    private LocalDateTime securityTokenCreation;

    /**
     * The Constructor.
     * 
     * @param username
     *            the username
     * @param password
     *            the password
     * @param id
     *            the id
     * @param apiKey
     *            the api key
     * @param apiKeyCreationDate
     *            the api key creation date
     * @param authorities
     *            the authorities
     */
    public RESTUser(String username, String password, String id, String apiKey,
            LocalDateTime apiKeyCreationDate,
            Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.securityToken = apiKey;
        this.securityTokenCreation = apiKeyCreationDate;
        this.id = id;
    }

    /**
     * The Constructor.
     * 
     * @param username
     *            the username
     * @param password
     *            the password
     * @param id
     *            the id
     * @param apiKey
     *            the api key
     * @param apiKeyCreationDate
     *            the api key creation date
     * @param enabled
     *            the enabled
     * @param accountNonExpired
     *            the account non expired
     * @param credentialsNonExpired
     *            the credentials non expired
     * @param accountNonLocked
     *            the account non locked
     * @param authorities
     *            the authorities
     */
    public RESTUser(String username, String password, String id, String apiKey,
            LocalDateTime apiKeyCreationDate, boolean enabled,
            boolean accountNonExpired, boolean credentialsNonExpired,
            boolean accountNonLocked,
            Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired,
                credentialsNonExpired, accountNonLocked, authorities);
        this.securityToken = apiKey;
        this.securityTokenCreation = apiKeyCreationDate;
        this.id = id;
    }

    /**
     * Sets the id.
     * 
     * @param id
     *            the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the id.
     * 
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the security token.
     * 
     * @return the security token
     */
    public String getSecurityToken() {
        return securityToken;
    }

    /**
     * Sets the security token.
     * 
     * @param apiKey
     *            the security token
     */
    public void setSecurityToken(String apiKey) {
        this.securityToken = apiKey;
    }

    /**
     * Gets the security token creation.
     * 
     * @return the security token creation
     */
    public LocalDateTime getSecurityTokenCreation() {
        return securityTokenCreation;
    }

    /**
     * Sets the security token creation.
     * 
     * @param securityTokenCreation
     *            the security token creation
     */
    public void setSecurityTokenCreation(LocalDateTime securityTokenCreation) {
        this.securityTokenCreation = securityTokenCreation;
    }
}
