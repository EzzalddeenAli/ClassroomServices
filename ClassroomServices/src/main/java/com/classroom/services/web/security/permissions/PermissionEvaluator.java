/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.classroom.services.web.security.permissions;

import java.io.Serializable;

import org.springframework.security.core.Authentication;

import com.classroom.services.facade.dto.IUserDependent;
import com.classroom.services.web.security.RESTUser;
import com.classroom.services.web.security.http.sso.SSOUtil;


public class PermissionEvaluator implements IPermissionEvaluator {

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.security.access.PermissionEvaluator#hasPermission
     * (org.springframework.security.core.Authentication, java.lang.Object,
     * java.lang.Object)
     */
    public boolean hasPermission(Authentication authentication,
            Object targetDomainObject, Object permission) {
        // Remember SSO users have SUPER_ADMIN role which is not persisted in
        // UPS DB and always has all permissions.

        if (SSOUtil.isSSOAuthenticated(authentication)) {
            return true;
        }

        String permissionFinal = (String) permission;
        if (IUserDependent.class
                .isAssignableFrom(targetDomainObject.getClass())) {
            IUserDependent userId = (IUserDependent) targetDomainObject;
            RESTUser user = (RESTUser) authentication.getPrincipal();

            if (!user.getId().equals(userId.getUserId().toString())) {
                permissionFinal += "All";
            }
        }

        return hasPermission(authentication, permissionFinal);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.security.access.PermissionEvaluator#hasPermission
     * (org.springframework.security.core.Authentication, java.io.Serializable,
     * java.lang.String, java.lang.Object)
     */
    public boolean hasPermission(Authentication authentication,
            Serializable targetId, String targetType, Object permission) {
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.classroom.services.web.security.permissions.IRestPermissionEvaluator#
     * hasPermission (org.springframework.security.core.Authentication,
     * java.lang.Object)
     */
    public boolean hasPermission(Authentication authentication,
            Object permission) {
        return true;
    }

}
