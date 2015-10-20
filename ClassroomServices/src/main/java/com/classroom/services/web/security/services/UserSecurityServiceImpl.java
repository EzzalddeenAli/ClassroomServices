/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.classroom.services.web.security.services;

import java.util.Arrays;
import java.util.UUID;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.classroom.services.domain.model.UserProfile;
import com.classroom.services.domain.model.UserProfile.UserStatus;
import com.classroom.services.domain.model.repositories.IUserProfileRepository;
import com.classroom.services.web.security.RESTUser;
import com.classroom.services.web.security.UserNotFoundException;


/**
 * 
 * @author mkol
 * 
 */
@Service
public class UserSecurityServiceImpl implements IUserSecurityService {
    @Value("${security.login.token.lifetime.hours}")
    private int credentialsLifeHours = 24;

    @Autowired
    private IUserProfileRepository userRepository;

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.core.userdetails.UserDetailsService#
     * loadUserByUsername(java.lang.String)
     */
    public UserDetails loadUserByUsername(String s)
            throws UsernameNotFoundException {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.classroom.services.web.security.services.IUserSecurityService#
     * getUserBySecurityToken(java.util.UUID)
     */
    public UserDetails getUserBySecurityToken(UUID token) {
        UserProfile user = userRepository.getUserByLoginToken(token);
        if (user == null) {
            throw new UserNotFoundException(
                    "UserProfile could not be found with the supplied security token.");
        }

        boolean isEnabled = (user.getStatus() != UserStatus.LOCKED)
                && (user.getStatus() != UserStatus.DELETED);
        boolean isAccountNonExpired = user.getStatus() != UserStatus.EXPIRED;

        boolean isCredentialsNonExpired = user.getLastLogin().isAfter(
                LocalDateTime.now().minusHours(credentialsLifeHours));
        boolean isAccountNonLocked = user.getStatus() != UserStatus.LOCKED;

        RESTUser userDetails = new RESTUser(user.getUsername(),
                user.getPassword(), user.getId().toString(), user
                        .getLoginToken().toString(), user.getLastLogin(),
                isEnabled, isAccountNonExpired, isCredentialsNonExpired,
                isAccountNonLocked, Arrays.asList(new SimpleGrantedAuthority(
                        "USER")));

        return userDetails;
    }
}
