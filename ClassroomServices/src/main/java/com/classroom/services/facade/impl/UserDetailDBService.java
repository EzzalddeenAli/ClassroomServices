/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.classroom.services.facade.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.classroom.services.domain.exceptions.DomainIllegalArgumentException;
import com.classroom.services.domain.model.UserDetail;
import com.classroom.services.domain.model.UserProfile;
import com.classroom.services.domain.model.repositories.IUserDetailRepository;
import com.classroom.services.domain.model.repositories.IUserProfileRepository;
import com.classroom.services.facade.dto.assembler.UserDetailAssembler;
import com.classroom.services.facade.dto.entities.UserDetailDTO;
import com.classroom.services.facade.exceptions.FacadeAlreadyExistsException;
import com.classroom.services.facade.exceptions.FacadeEntityNotFoundException;
import com.classroom.services.facade.exceptions.FacadeIllegalArgumentException;
import com.classroom.services.facade.interfaces.IUserDetailService;


@Service
@Transactional
public class UserDetailDBService implements IUserDetailService {
    @Autowired
    private IUserDetailRepository userDetailRepository;
    @Autowired
    private IUserProfileRepository userRepository;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.classroom.services.facade.interfaces.IUserDetailService#createUserDetail
     * (com.classroom.services.facade.dto.entities.UserDetailDTO)
     */
    public void createUserDetail(UserDetailDTO detail)
            throws FacadeIllegalArgumentException,
            FacadeEntityNotFoundException, FacadeAlreadyExistsException {
        UUID dtoUserId = detail.getUserId();
        if (dtoUserId == null) {
            throw new FacadeIllegalArgumentException(
                    "UserProfile is not specified in DTO");
        }
        UserProfile user = userRepository.get(dtoUserId);
        if (user == null) {
            throw new FacadeEntityNotFoundException(UserProfile.class,
                    detail.getUserId());
        }
        if (userDetailRepository.getUserDetail(detail.getUserId()) != null) {
            throw new FacadeAlreadyExistsException(String.format(
                    "Detail record for UserProfile with id=%s already exists",
                    detail.getUserId()));
        }

        userDetailRepository.getUserDetail(detail.getUserId());
        UserDetail userDetail = new UserDetail();
        try {
            UserDetailAssembler.objectDTO2Domain(detail, userDetail);
        } catch (DomainIllegalArgumentException e) {
            throw new FacadeIllegalArgumentException(e.getMessage(), e);
        }

        user.setDetail(userDetail);
        

        userDetailRepository.save(userDetail);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.classroom.services.facade.interfaces.IUserDetailService#getUserDetail(java
     * .util.UUID)
     */
    public UserDetailDTO getUserDetail(UUID userId)
            throws FacadeEntityNotFoundException {
        UserDetail userDetail = userDetailRepository.getUserDetail(userId);
        if (userDetail == null) {
            throw new FacadeEntityNotFoundException(UserDetail.class,
                    "UserProfile #" + userId);
        }
        return UserDetailAssembler.objectDomain2DTO(userDetail);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.classroom.services.facade.interfaces.IUserDetailService#updateUserDetail
     * (com.classroom.services.facade.dto.entities.UserDetailDTO)
     */
    public void updateUserDetail(UserDetailDTO userDetail)
            throws FacadeEntityNotFoundException,
            FacadeIllegalArgumentException {
        UserDetail userDetailDom = userDetailRepository
                .getUserDetail(userDetail.getUserId());
        if (userDetailDom != null) {
            try {
                UserDetailAssembler.objectDTO2Domain(userDetail, userDetailDom);
            } catch (DomainIllegalArgumentException e) {
                throw new FacadeIllegalArgumentException(e.getMessage(), e);
            }
        } else {
            throw new FacadeEntityNotFoundException(UserDetail.class,
                    "UserProfile #" + userDetail.getUserId());
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.classroom.services.facade.interfaces.IUserDetailService#deleteUserDetail
     * (java.util.UUID)
     */
    public void deleteUserDetail(UUID userId) {
        UserDetail userDetailDom = userDetailRepository.getUserDetail(userId);
        if (userDetailDom != null) {
            userDetailRepository.remove(userDetailDom);
        }
    }

}
