/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.abharana.services.infrastructure.persistence.hibernate;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.abharana.services.domain.model.User;
import com.abharana.services.domain.model.repositories.IUserRepositoy;
import com.abharana.services.domain.model.repositories.criteria.BaseSearchCriteria;

@Repository
public class UserRepository extends BaseRepository<User, BaseSearchCriteria>
        implements IUserRepositoy {

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.abharana.services.domain.repositories.IUserRepositoy#getUserByLoignName
     * (java.lang.String)
     */
    public User getUserByLoignName(String login) {
        User user = null;
        CriteriaQuery<User> query = getCriteriaBuilder()
                .createQuery(User.class);
        Root<User> from = query.from(User.class);
        Predicate[] predicates = new Predicate[1];
        predicates[0] = getCriteriaBuilder().equal(from.get("customerId"),
                login);
        query.where(predicates);
        query.select(from);

        user = getSingleResult(query);
        return user;
    }

}
