/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.classroom.services.infrastructure.persistence.hibernate;

import java.util.UUID;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.classroom.services.domain.model.UserDetail;
import com.classroom.services.domain.model.repositories.IUserDetailRepository;
import com.classroom.services.domain.model.repositories.criteria.BaseSearchCriteria;

/**
 * 
 * @author mkol
 * 
 */
@Repository
public class UserDetailRepository extends
        BaseRepository<UserDetail, BaseSearchCriteria> implements
        IUserDetailRepository {

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.kony.es.repositories.IUserDetailRepository#getUserDetail(java.util
     * .UUID)
     */
    public UserDetail getUserDetail(UUID userId) {
        CriteriaQuery<UserDetail> query = getCriteriaBuilder().createQuery(
                UserDetail.class);
        Root<UserDetail> from = query.from(UserDetail.class);
        query.where(getCriteriaBuilder().equal(from.get("user").get("id"),
                userId));
        query.select(from);

        return getSingleResult(query);
    }

}
