/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.abharana.services.web.security;

import java.util.UUID;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.Assert;

import com.abharana.services.web.security.services.IUserSecurityService;


/**
 * 
 * @author mkol
 * 
 */
public class RESTDaoAuthenticationProvider extends
        AbstractUserDetailsAuthenticationProvider {
    @Value("${security.login.token.lifetime.hours}")
    private final int credentialsLifeHours = 24;

    private IUserSecurityService userSecurityService;

    /**
     * This is the method which actually performs the check to see whether the
     * user is indeed the correct user.
     * 
     * @param userDetails
     *            the user details
     * @param authentication
     *            the authentication
     * @throws AuthenticationException
     *             the authentication exception
     */
    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails,
            UsernamePasswordAuthenticationToken authentication)
            throws AuthenticationException {
        RESTUser user = (RESTUser) userDetails;
        boolean isCredentialsExpired = user.getSecurityTokenCreation()
                .isBefore(LocalDateTime.now().minusHours(credentialsLifeHours));
        if (isCredentialsExpired) {
            throw new CredentialsExpiredException("Secure token has expired");
        }
    }

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    	if(authentication == null || authentication.getPrincipal()==null){
    		return new UsernamePasswordAuthenticationToken(null, null, null);
    	}
        Assert.isInstanceOf(UsernamePasswordAuthenticationToken.class, authentication,
            messages.getMessage("AbstractUserDetailsAuthenticationProvider.onlySupports",
                "Only UsernamePasswordAuthenticationToken is supported"));

        // Determine username
        String username = (authentication.getPrincipal() == null) ? "NONE_PROVIDED" : authentication.getName();

        boolean cacheWasUsed = true;
        UserDetails user = this.getUserCache().getUserFromCache(username);

        if (user == null) {
            cacheWasUsed = false;

            try {
                user = retrieveUser(username, (UsernamePasswordAuthenticationToken) authentication);
            } catch (UsernameNotFoundException notFound) {
                logger.debug("User '" + username + "' not found");

                if (hideUserNotFoundExceptions) {
                    throw new BadCredentialsException(messages.getMessage(
                            "AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
                } else {
                    throw notFound;
                }
            }

            Assert.notNull(user, "retrieveUser returned null - a violation of the interface contract");
        }

        try {
            this.getPreAuthenticationChecks().check(user);
            additionalAuthenticationChecks(user, (UsernamePasswordAuthenticationToken) authentication);
        } catch (AuthenticationException exception) {
            if (cacheWasUsed) {
                // There was a problem, so try again after checking
                // we're using latest data (i.e. not from the cache)
                cacheWasUsed = false;
                user = retrieveUser(username, (UsernamePasswordAuthenticationToken) authentication);
                getPreAuthenticationChecks().check(user);
                additionalAuthenticationChecks(user, (UsernamePasswordAuthenticationToken) authentication);
            } else {
                throw exception;
            }
        }

        getPreAuthenticationChecks().check(user);

        if (!cacheWasUsed) {
            this.getUserCache().putUserInCache(user);
        }

        Object principalToReturn = user;

        if (isForcePrincipalAsString()) {
            principalToReturn = user.getUsername();
        }

        return createSuccessAuthentication(principalToReturn, authentication, user);
    }
    
    
    /**
     * Retrieve user.
     * 
     * @param token
     *            This is the security token that was generated by the user.
     * @param authentication
     *            The authentication request, which subclasses <em>may</em> need
     *            to perform a binding-based retrieval of the
     *            <code>UserDetails</code>
     * @return the user information (never <code>null</code> - instead an
     *         exception should the thrown)
     * @throws AuthenticationException
     *             if the credentials could not be validated (generally a
     *             <code>BadCredentialsException</code>, an
     *             <code>AuthenticationServiceException</code> or
     *             <code>UsernameNotFoundException</code>)
     */
    @Override
    protected UserDetails retrieveUser(String token,
            UsernamePasswordAuthenticationToken authentication)
            throws AuthenticationException {
        UserDetails loadedUser;

        try {
            loadedUser = getUserSecurityService().getUserBySecurityToken(
                    UUID.fromString(token));
        } catch (UsernameNotFoundException notFound) {
            throw notFound;
        } catch (Exception repositoryProblem) {
            throw new AuthenticationServiceException(
                    repositoryProblem.getMessage(), repositoryProblem);
        }

        if (loadedUser == null) {
            throw new AuthenticationServiceException(
                    "UserSecurityService returned null, which is an interface contract violation");
        }
        return loadedUser;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.authentication.dao.
     * AbstractUserDetailsAuthenticationProvider#doAfterPropertiesSet()
     */
    @Override
    protected void doAfterPropertiesSet() {
        Assert.notNull(this.userSecurityService,
                "A UserSecurityServiceImpl must be set");
    }

    /**
     * Gets the user security service.
     * 
     * @return the user security service
     */
    public IUserSecurityService getUserSecurityService() {
        return userSecurityService;
    }

    /**
     * Sets the user security service.
     * 
     * @param userSecurityService
     *            the user security service
     */
    public void setUserSecurityService(IUserSecurityService userSecurityService) {
        this.userSecurityService = userSecurityService;
    }

}
