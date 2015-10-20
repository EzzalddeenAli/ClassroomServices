/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.classroom.services.facade.dto.assembler;

import com.google.common.base.Function;
import com.classroom.services.domain.model.UserProfile;
import com.classroom.services.domain.model.UserProfile.UserStatus;
import com.classroom.services.facade.dto.entities.UserProfileDTO;


public final class UserAssembler {

    /**
     * The Constructor.
     */
    private UserAssembler() {
        // no code
    }

    /**
     * Synchronizes domain properties with DTO.
     * 
     * @param dtoObject
     *            the dto object
     * @param domainObject
     *            the domain object
     */
    public static void objectDTO2Domain(UserProfileDTO dtoObject,
            UserProfile domainObject) {
        if (dtoObject.getId() != null) {
            domainObject.setId(dtoObject.getId());
        }
        domainObject.setUsername(dtoObject.getUsername());
        domainObject.setEmail(dtoObject.getEmail());
        String dtoStatus = dtoObject.getStatus();
        if (dtoStatus != null) {
            domainObject.setStatus(UserStatus.fromString(dtoStatus));
        }
    }

    /**
     * Builds DTO object based on domain object.
     * 
     * @param domainObject
     *            the domain object
     * @return the user profile dto
     */
    public static UserProfileDTO objectDomain2DTO(UserProfile domainObject) {
        String status = (domainObject.getStatus() == null) ? null
                : domainObject.getStatus().name();
        return new UserProfileDTO(domainObject.getId(),
                domainObject.getUsername(), domainObject.getEmail(), status,
                domainObject.getLastLogin(), domainObject.getCreationDate(),
                domainObject.getUpdateDate());
    }
    public static final Function<UserProfile, UserProfileDTO> USER_TO_DTO = new Function<UserProfile, UserProfileDTO>() {
        public UserProfileDTO apply(UserProfile from) {
            return UserAssembler.objectDomain2DTO(from);
        }

    };
}
