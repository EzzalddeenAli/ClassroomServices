/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.classroom.services.web.security.http;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.RedirectStrategy;

/**
 * 
 * @author mkol
 * 
 */
public class NoRedirectStrategy implements RedirectStrategy {

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.security.web.RedirectStrategy#sendRedirect(javax.
     * servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
     * java.lang.String)
     */
    public void sendRedirect(HttpServletRequest request,
            HttpServletResponse response, String url) throws IOException {
        // no redirect for rest!
    }
}
