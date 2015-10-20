/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.abharana.services.web.security.permissions.expression;

import java.io.Serializable;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;

import com.abharana.services.web.security.permissions.IPermissionEvaluator;


/**
 * Root object for use in Spring Security custom expression evaluations.
 */
public class MethodSecurityExpressionRoot extends SecurityExpressionRoot
        implements MethodSecurityExpressionOperations {
    private Object filterObject;
    private Object returnObject;
    private MethodInvocation method;

    private IPermissionEvaluator restPermissionEvaluator;

    /**
     * The Constructor.
     * 
     * @param a
     *            the a
     */
    MethodSecurityExpressionRoot(Authentication a) {
        super(a);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.access.expression.method.
     * MethodSecurityExpressionOperations#setFilterObject(java.lang.Object)
     */
    public void setFilterObject(Object filterObject) {
        this.filterObject = filterObject;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.access.expression.method.
     * MethodSecurityExpressionOperations#getFilterObject()
     */
    public Object getFilterObject() {
        return filterObject;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.access.expression.method.
     * MethodSecurityExpressionOperations#setReturnObject(java.lang.Object)
     */
    public void setReturnObject(Object returnObject) {
        this.returnObject = returnObject;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.access.expression.method.
     * MethodSecurityExpressionOperations#getReturnObject()
     */
    public Object getReturnObject() {
        return returnObject;
    }

    /**
     * Sets the "this" property for use in expressions. Typically this will be
     * the "this" property of the {@code JoinPoint} representing the method
     * invocation which is being protected.
     * 
     * @param method
     *            the this
     */
    void setThis(MethodInvocation method) {
        this.method = method;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.access.expression.method.
     * MethodSecurityExpressionOperations#getThis()
     */
    public Object getThis() {
        return method;
    }

    /**
     * Checks for permission.
     * 
     * @param permission
     *            the permission
     * @return true, if checks for permission
     */
    public boolean hasPermission(Object permission) {
        return restPermissionEvaluator
                .hasPermission(authentication, permission);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.security.access.expression.SecurityExpressionRoot
     * #hasPermission(java.lang.Object, java.lang.Object)
     */
    @Override
    public boolean hasPermission(Object target, Object permission) {
        return restPermissionEvaluator.hasPermission(authentication, target,
                permission);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.security.access.expression.SecurityExpressionRoot
     * #hasPermission(java.lang.Object, java.lang.String, java.lang.Object)
     */
    @Override
    public boolean hasPermission(Object targetId, String targetType,
            Object permission) {
        return restPermissionEvaluator.hasPermission(authentication,
                (Serializable) targetId, targetType, permission);
    }

    /**
     * Sets the rest permission evaluator.
     * 
     * @param permissionEvaluator
     *            the rest permission evaluator
     */
    public void setRestPermissionEvaluator(
            IPermissionEvaluator permissionEvaluator) {
        this.restPermissionEvaluator = permissionEvaluator;
    }
}
