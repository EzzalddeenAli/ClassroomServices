/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.abharana.services.facade.impl;

import java.util.UUID;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abharana.services.domain.exceptions.DomainIllegalArgumentException;
import com.abharana.services.domain.model.UserDetail;
import com.abharana.services.domain.model.UserProfile;
import com.abharana.services.domain.model.repositories.IUserDetailRepository;
import com.abharana.services.domain.model.repositories.IUserProfileRepository;
import com.abharana.services.facade.dto.assembler.UserAssembler;
import com.abharana.services.facade.dto.entities.UserIdDTO;
import com.abharana.services.facade.dto.entities.UserProfileDTO;
import com.abharana.services.facade.exceptions.FacadeAlreadyExistsException;
import com.abharana.services.facade.exceptions.FacadeBadCredentialsException;
import com.abharana.services.facade.exceptions.FacadeEntityNotFoundException;
import com.abharana.services.facade.exceptions.FacadeIllegalArgumentException;
import com.abharana.services.facade.interfaces.IUserService;


@Service
@Transactional
public class UserDBService implements IUserService {

    @Autowired
    private IUserProfileRepository userRepository;
    @Autowired
    private IUserDetailRepository userDetailRepository;


    /*
     * (non-Javadoc)
     * 
     * @see
     * com.abharana.services.facade.interfaces.IUserService#createUser(java.lang.
     * String, java.lang.String, java.lang.String)
     */
    public UUID createUser(String username, String password, String email)
            throws FacadeAlreadyExistsException {
        // TODO move unique username constrain to DB schema if necessary


        UserProfile user = new UserProfile();
        user.setUsername(username);

        user.setEmail(email);
        user.setCreationDate(new LocalDateTime());
        userRepository.save(user);

        UserDetail detail = new UserDetail();
        user.setDetail(detail);
        userDetailRepository.save(detail);

        return user.getId();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.abharana.services.facade.interfaces.IUserService#deleteUser(com.abharana.services
     * .facade.dto.entities.UserIdDTO)
     */
    public void deleteUser(UserIdDTO userId) {
        UserProfile user = userRepository.get(userId.getUserId());
        if (user != null) {
            user.setStatus(UserProfile.UserStatus.DELETED);
            userRepository.save(user);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.abharana.services.facade.interfaces.IUserService#updateUser(com.abharana.services
     * .facade.dto.entities.UserIdDTO, java.lang.String, java.lang.String,
     * java.lang.String)
     */
    public void updateUser(UserIdDTO userId, String username, String email,
            String status) throws FacadeEntityNotFoundException,
            FacadeIllegalArgumentException {
        UserProfileDTO person = new UserProfileDTO();
        person.setUsername(username);
        person.setEmail(email);
        person.setStatus(status);

        UserProfile user = userRepository.get(userId.getUserId());
        if (user != null) {
            try {
                UserAssembler.objectDTO2Domain(person, user);
            } catch (DomainIllegalArgumentException e) {
                throw new FacadeIllegalArgumentException(e.getMessage(), e);
            }
        } else {
            throw new FacadeEntityNotFoundException(UserProfile.class,
                    userId.getUserId());
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.abharana.services.facade.interfaces.IUserService#getUser(com.abharana.services
     * .facade.dto.entities.UserIdDTO)
     */
    @Transactional(readOnly = true)
    public UserProfileDTO getUser(UserIdDTO userId)
            throws FacadeEntityNotFoundException {
        UserProfile user = userRepository.get(userId.getUserId());
        if (user == null) {
            throw new FacadeEntityNotFoundException(UserProfile.class,
                    userId.getUserId());
        }
        return UserAssembler.objectDomain2DTO(user);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.abharana.services.facade.interfaces.IUserService#getUserFromLoginToken
     * (java.util.UUID)
     */
    @Transactional(readOnly = true)
    public UserProfileDTO getUserFromLoginToken(UUID loginToken)
            throws FacadeEntityNotFoundException {
        UserProfile user = userRepository.getUserByLoginToken(loginToken);
        if (user == null) {
            throw new FacadeEntityNotFoundException(UserProfile.class,
                    loginToken);
        }
        return UserAssembler.objectDomain2DTO(user);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.abharana.services.facade.interfaces.IUserService#updateUserPassword(com
     * .kony.banking.facade.dto.entities.UserIdDTO, java.lang.String,
     * java.lang.String)
     */
    public void updateUserPassword(UserIdDTO userId, String oldPassword,
            String newPassword) throws FacadeEntityNotFoundException,
            FacadeBadCredentialsException {
        UserProfile user = userRepository.get(userId.getUserId());
        if (user == null) {
            throw new FacadeEntityNotFoundException(UserProfile.class,
                    userId.getUserId());
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.abharana.services.facade.interfaces.IUserService#updatePassword(com.kony
     * .banking.facade.dto.entities.UserIdDTO, java.lang.String)
     */
    public void updatePassword(UserIdDTO userId, String newPassword)
            throws FacadeEntityNotFoundException,
            FacadeIllegalArgumentException {
        if (userId == null || userId.getUserId() == null || newPassword == null) {
            throw new FacadeIllegalArgumentException(
                    "UserProfile id or new password cannot be null");
        }
        UserProfile user = userRepository.get(userId.getUserId());
        if (user == null) {
            throw new FacadeEntityNotFoundException(UserProfile.class,
                    userId.getUserId());
        }

    }

}
