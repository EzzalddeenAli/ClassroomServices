/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.abharana.services.web.security.http.sso;

import javax.servlet.ServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth.consumer.OAuthSecurityContextHolder;


/**
 * Now supports OAuth 1.0 implementation only. Please extend this filter with
 * any SSO frameworks(e.g. CAS).
 * 
 * @author mkol
 * 
 */
public class SSOUtil {
    public static final String SSO_USER = "SSO_USER";

    public static final String SSO_ADMIN_ROLE = "SUPER_ADMIN";

    /**
     * Checks for sso token.
     * 
     * @return true if SSO token was received
     */
    public static boolean hasSSOToken() {
        return OAuthSecurityContextHolder.getContext() != null;
    }

    /**
     * Check for SSO authentication.
     * 
     * @param request
     *            the request
     * @return true if request was supposed to be SSO-authenticated
     */
    public static boolean isSSOAuthentication(ServletRequest request) {
        return request.getParameter("sso") != null;
    }

    /**
     * Checks is user SSO-authenticated.
     * 
     * @param authentication
     *            the authentication
     * @return true, if checks if is sso authenticated
     */
    public static boolean isSSOAuthenticated(Authentication authentication) {
        return authentication != null
                && authentication.isAuthenticated()
                && SSO_USER.equals(authentication.getPrincipal())
                && authentication.getAuthorities().size() == 1
                && SSO_ADMIN_ROLE.equals(authentication.getAuthorities()
                        .iterator().next().getAuthority());
    }
}
