/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.abharana.services.web.security.permissions;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

public interface IPermissionEvaluator extends PermissionEvaluator {
    /**
     * Alternative method for evaluating a permission with target method name.
     * 
     * @param authentication
     *            represents the user in question. Should not be null.
     * @param permission
     *            a representation of the permission object as supplied by the
     *            expression system. Not null.
     * @return true if the permission is granted, false otherwise
     */
    boolean hasPermission(Authentication authentication, Object permission);
}
