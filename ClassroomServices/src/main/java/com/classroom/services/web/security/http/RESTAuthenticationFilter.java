/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.classroom.services.web.security.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.classroom.services.web.security.http.sso.SSOUtil;
import com.classroom.services.web.security.tokens.RESTAuthenticationToken;


/**
 * 
 * @author mkol
 * 
 */
public class RESTAuthenticationFilter extends
        AbstractAuthenticationProcessingFilter {
    // TODO move to config
    private static final String SECURITY_TOKEN_PARAMETER_NAME = "token";

    /**
     * The Constructor.
     * 
     * @param defaultFilterProcessesUrl
     *            the default value for <tt>filterProcessesUrl</tt>.
     */
    protected RESTAuthenticationFilter(String defaultFilterProcessesUrl) {
        super(defaultFilterProcessesUrl);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.web.authentication.
     * AbstractAuthenticationProcessingFilter
     * #attemptAuthentication(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse)
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
            HttpServletResponse response) throws AuthenticationException,
            IOException, ServletException {
        if (SSOUtil.hasSSOToken()) {
            // NOTE: now all SSO authenticated users are impersonated and have
            // ADMIN role.Consider move this logic to separate Authentication
            // provider.
            List<GrantedAuthority> authorities = Arrays
                    .<GrantedAuthority>asList(new SimpleGrantedAuthority(
                            SSOUtil.SSO_ADMIN_ROLE));
            return new UsernamePasswordAuthenticationToken(SSOUtil.SSO_USER,
                    null, authorities);
        } else {  
            // token-based authentication
            String token = obtainSecuredTokenValue(request);

//            if (token == null) {
//                throw new AuthenticationCredentialsNotFoundException(
//                        "Expected Security Token");
//            }

            AbstractAuthenticationToken authRequest = createAuthenticationToken(token);

            // Allow subclasses to set the "details" property
            setDetails(request, authRequest);

            return this.getAuthenticationManager().authenticate(authRequest);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.web.authentication.
     * AbstractAuthenticationProcessingFilter
     * #successfulAuthentication(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain,
     * org.springframework.security.core.Authentication)
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
            HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
    }

    /**
     * Get security token from request.
     * 
     * @param request
     *            the request
     * @return the string
     * @throws UnsupportedEncodingException
     *             the unsupported encoding exception
     */
    private String obtainSecuredTokenValue(HttpServletRequest request)
            throws UnsupportedEncodingException {
        Enumeration<?> e = request.getHeaders(SECURITY_TOKEN_PARAMETER_NAME);
        String token = e.hasMoreElements() ? (String) e.nextElement() : null;
        if (!e.hasMoreElements()) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals(SECURITY_TOKEN_PARAMETER_NAME)) {
                        token = cookie.getValue();
                    }
                }
            }
        }
        return token;
    }

    /**
     * Provided so that subclasses may configure what is put into the
     * authentication request's details property.
     * 
     * @param request
     *            that an authentication request is being created for
     * @param authRequest
     *            the authentication request object that should have its details
     *            set
     */
    protected void setDetails(HttpServletRequest request,
            AbstractAuthenticationToken authRequest) {
        authRequest.setDetails(authenticationDetailsSource
                .buildDetails(request));
    }

    /**
     * Creates the authentication token.
     * 
     * @param token
     *            the token
     * @return the abstract authentication token
     */
    private AbstractAuthenticationToken createAuthenticationToken(String token) {
        return new RESTAuthenticationToken(token, null);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.web.authentication.
     * AbstractAuthenticationProcessingFilter
     * #requiresAuthentication(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse)
     */
    @Override
    /**
     * Because we require the API client to send credentials with every request, we must authenticate on every request
     */
    protected boolean requiresAuthentication(HttpServletRequest request,
            HttpServletResponse response) {
        return true;
    }
}
