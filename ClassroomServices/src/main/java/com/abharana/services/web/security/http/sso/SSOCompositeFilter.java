/**
 * 
 */
package com.abharana.services.web.security.http.sso;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.web.filter.CompositeFilter;

/**
 * @author mkol Filter for external SSO authentication.Now supports OAuth 1.0
 *         implementation only. Please extend this filter with any SSO
 *         frameworks(e.g. CAS).
 */
public class SSOCompositeFilter extends CompositeFilter {

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.web.filter.CompositeFilter#doFilter(javax.servlet
     * .ServletRequest, javax.servlet.ServletResponse,
     * javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        if (SSOUtil.isSSOAuthentication(request)) {
            super.doFilter(request, response, chain);
        } else {
            chain.doFilter(request, response);
        }
    }

}
