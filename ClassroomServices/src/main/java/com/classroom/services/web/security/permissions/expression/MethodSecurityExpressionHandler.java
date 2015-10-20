/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.classroom.services.web.security.permissions.expression;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;

import com.classroom.services.web.security.permissions.IPermissionEvaluator;

/**
 * Custom expressions handler
 */
public class MethodSecurityExpressionHandler extends
        DefaultMethodSecurityExpressionHandler {
    private final AuthenticationTrustResolver trustResolver = new AuthenticationTrustResolverImpl();

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.access.expression.method.
     * DefaultMethodSecurityExpressionHandler
     * #createSecurityExpressionRoot(org.springframework
     * .security.core.Authentication,
     * org.aopalliance.intercept.MethodInvocation)
     */
    @Override
    protected MethodSecurityExpressionOperations createSecurityExpressionRoot(
            Authentication authentication, MethodInvocation invocation) {
        MethodSecurityExpressionRoot root = new MethodSecurityExpressionRoot(
                authentication);
        root.setThis(invocation);
        root.setRestPermissionEvaluator((IPermissionEvaluator) getPermissionEvaluator());
        root.setTrustResolver(trustResolver);
        root.setRoleHierarchy(getRoleHierarchy());

        return root;
    }
}
