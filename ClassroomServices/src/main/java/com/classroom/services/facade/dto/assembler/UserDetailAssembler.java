/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.classroom.services.facade.dto.assembler;

import java.util.UUID;

import com.classroom.services.domain.model.UserDetail;
import com.classroom.services.facade.dto.entities.UserDetailDTO;


public final class UserDetailAssembler {

    /**
     * The Constructor.
     */
    private UserDetailAssembler() {
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
    public static void objectDTO2Domain(UserDetailDTO dtoObject,
            UserDetail domainObject) {
        domainObject.setFirstName(dtoObject.getFirstName());
        domainObject.setMiddleName(dtoObject.getMiddleName());
        domainObject.setLastName(dtoObject.getLastName());

        domainObject.setHomePhone(dtoObject.getHomePhone());
        domainObject.setWorkPhone(dtoObject.getWorkPhone());
        domainObject.setPrimaryPhone(dtoObject.getPrimaryPhone());
        domainObject.setMobilePhone(dtoObject.getMobilePhone());
        domainObject.setFax(dtoObject.getFax());

        String dtoGender = dtoObject.getGender();
        if (dtoGender != null) {
            domainObject.setGender(UserDetail.Gender.fromString(dtoGender));
        }
        domainObject.setUniqueIdentifier(dtoObject.getUniqueId());
    }

    /**
     * Builds DTO object based on domain object.
     * 
     * @param domainObject
     *            the domain object
     * @return the user detail dto
     */
    public static UserDetailDTO objectDomain2DTO(UserDetail domainObject) {
        String gender = domainObject.getGender() == null ? null : domainObject
                .getGender().toString();
        UUID id = domainObject.getId();
        return new UserDetailDTO(domainObject.getFirstName(),
                domainObject.getMiddleName(), domainObject.getLastName(),
                domainObject.getPrimaryPhone(), domainObject.getMobilePhone(),
                domainObject.getHomePhone(), domainObject.getWorkPhone(),
                domainObject.getFax(), gender,
                domainObject.getUniqueIdentifier(), id);
    }
}
