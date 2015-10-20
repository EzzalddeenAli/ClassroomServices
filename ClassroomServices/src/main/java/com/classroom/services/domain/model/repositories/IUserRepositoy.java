/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.classroom.services.domain.model.repositories;

import com.classroom.services.domain.model.User;

public interface IUserRepositoy extends IBaseRepository<User> {

    /**
     * Gets the user by loign name.
     * 
     * @param login
     *            the login
     * @return the user by loign name
     */
    User getUserByLoignName(String login);

}
