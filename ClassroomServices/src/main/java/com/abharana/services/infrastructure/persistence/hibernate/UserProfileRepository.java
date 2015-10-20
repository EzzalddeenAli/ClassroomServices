/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.abharana.services.infrastructure.persistence.hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.google.common.base.Strings;
import com.abharana.services.domain.model.UserProfile;
import com.abharana.services.domain.model.repositories.IUserProfileRepository;
import com.abharana.services.domain.model.repositories.criteria.UserSearchCriteria;


@Repository
public class UserProfileRepository extends
        BaseRepository<UserProfile, UserSearchCriteria> implements
        IUserProfileRepository {

    @Value("${infrastructure.persistence.rowLimit}")
    private int rowLimit;
    private static final String DETAIL = "detail";

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.kony.es.repositories.IUserRepository#getUserByName(java.lang.String)
     */
    public UserProfile getUserByName(String username) {
        UserSearchCriteria criteria = new UserSearchCriteria();
        criteria.setUsername(username);

        return getSingleResult(searchByCriteria(criteria));
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.abharana.services.domain.repositories.IUserProfileRepository#
     * getUserByEmailOrMobile(java.lang.String)
     */
    public UserProfile getUserByEmailOrMobile(String mail) {
        UserSearchCriteria criteria = new UserSearchCriteria();
        criteria.setEmail(mail);

        return getSingleResult(searchByCriteria(criteria));
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.kony.es.repositories.IUserRepository#getUserByRecoverToken(java.util
     * .UUID)
     */
    public UserProfile getUserByRecoverToken(UUID recoverToken) {
        UserSearchCriteria criteria = new UserSearchCriteria();
        criteria.setRecoverToken(recoverToken);

        return getSingleResult(searchByCriteria(criteria));
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.kony.es.repositories.IUserRepository#searchUsers(com.abharana.services
     * .domain .repositories.criteria.UserSearchCriteria)
     */
    /**
     * Search users.
     * 
     * @param criteria
     *            the criteria
     * @return the list< user profile>
     */
    public List<UserProfile> searchUsers(UserSearchCriteria criteria) {
        CriteriaQuery<UserProfile> query = getCriteriaBuilder().createQuery(
                getEntityClass());
        Root<UserProfile> from = query.from(getEntityClass());
        query.select(from);

        // Eager fetch

        from.fetch(DETAIL, JoinType.LEFT);

        List<Predicate> predicateList = buildConditions(from, criteria);
        if (predicateList != null) {
            Predicate[] predicates = new Predicate[predicateList.size()];
            predicateList.toArray(predicates);
            query.where(predicates);
        }

        if (!Strings.isNullOrEmpty(criteria.getOrderField())) {
            if (!Strings.isNullOrEmpty(criteria.getOrderType())) {
                if ("asc".equals(criteria.getOrderType().toLowerCase())) {
                    query.orderBy(getCriteriaBuilder().asc(
                            from.get(criteria.getOrderField())));
                } else {
                    query.orderBy(getCriteriaBuilder().desc(
                            from.get(criteria.getOrderField())));
                }
            } else {
                query.orderBy(getCriteriaBuilder().asc(
                        from.get(criteria.getOrderField())));
            }

        }

        TypedQuery<UserProfile> typedQuery = getEntityManager().createQuery(
                query);
        if (criteria.getStartIndex() != null) {
            typedQuery.setFirstResult(criteria.getStartIndex());
            typedQuery.setMaxResults(criteria.getPageSize());
        } else {
            typedQuery.setFirstResult(0);
            typedQuery.setMaxResults(rowLimit);
        }

        return typedQuery.getResultList();


    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.kony.es.repositories.IUserRepository#searchUsersCount(com.kony.es
     * .dto.entities.UserDTO)
     */
    /**
     * Search users count.
     * 
     * @param criteria
     *            the criteria
     * @return the long
     */
    public Long searchUsersCount(UserSearchCriteria criteria) {
        return searchByCriteriaCount(criteria);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.abharana.services.domain.repositories.IUserProfileRepository#
     * getUserBySecurityToken (java.util.UUID)
     */
    public UserProfile getUserByLoginToken(UUID loginToken) {
        UserSearchCriteria criteria = new UserSearchCriteria();
        criteria.setLoginToken(loginToken);

        return getSingleResult(searchByCriteria(criteria));

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.kony.es.repositories.IBaseRepository#getAll(int, int,
     * java.lang.String)
     */

    @Override
    public List<UserProfile> getAll(int startIndex, int pageSize,
            String orderField) {
        UserSearchCriteria criteria = new UserSearchCriteria();
        criteria.setStartIndex(startIndex);
        criteria.setPageSize(pageSize);
        criteria.setOrderField(orderField);

        return searchByCriteria(criteria);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.kony.es.repositories.IBaseRepository#getCount()
     */
    @Override
    public Long getCount() {
        UserSearchCriteria criteria = new UserSearchCriteria();

        return searchByCriteriaCount(criteria);
    }

    /**
     * Build list of Predicate using search criteria.
     * 
     * @param u
     *            the u
     * @param criteria
     *            the criteria
     * @return the list< predicate>
     */
    @Override
    protected List<Predicate> buildConditions(Root<UserProfile> u,
            UserSearchCriteria criteria) {
        List<Predicate> predicateList = new ArrayList<Predicate>();

        CriteriaBuilder cb = getCriteriaBuilder();
        if (criteria.getUsername() != null) {
            predicateList.add(cb.equal(u.get("username"),
                    criteria.getUsername()));
        }
        if (criteria.getEmail() != null) {
            predicateList.add(cb.or(
                    cb.equal(u.get("email"), criteria.getEmail()),
                    cb.equal(u.get(DETAIL).get("mobilePhone"),
                            criteria.getEmail())));
        }
        if (criteria.getLastLogin() != null) {
            predicateList.add(cb.equal(u.get("lastLogin"),
                    criteria.getLastLogin()));
        }
        if (criteria.getStatus() != null) {
            predicateList.add(cb.equal(u.get("status"),
                    UserProfile.UserStatus.fromString(criteria.getStatus())));
        } else {
            predicateList.add(cb.notEqual(u.get("status"),
                    UserProfile.UserStatus.DELETED));
        }
        if (criteria.getRecoverDate() != null) {
            predicateList.add(cb.equal(u.get("recoverDate"),
                    criteria.getRecoverDate()));
        }
        if (criteria.getLoginToken() != null) {
            predicateList.add(cb.equal(u.get("loginToken"),
                    criteria.getLoginToken()));
        }
        if (criteria.getRecoverToken() != null) {
            predicateList.add(cb.equal(u.get("recoverToken"),
                    criteria.getRecoverToken()));
        }

        if (criteria.getFirstName() != null) {

            String param = "%" + criteria.getFirstName().toUpperCase() + "%";
            Predicate firstNamePredicate = cb.like(cb.upper(u.<String>get(
                    DETAIL).<String>get("firstName")), param);
            predicateList.add(firstNamePredicate);
        }

        if (criteria.getLastName() != null) {
            String param = "%" + criteria.getLastName().toUpperCase() + "%";
            Predicate predicate = cb
                    .like(cb.upper(u.<String>get(DETAIL).<String>get(
                            "lastName")), param);
            predicateList.add(predicate);
        }

        if (criteria.getMiddleName() != null) {
            String param = "%" + criteria.getMiddleName().toUpperCase() + "%";
            Predicate predicate = cb.like(cb.upper(u.<String>get(DETAIL)
                    .<String>get("middleName")), param);
            predicateList.add(predicate);
        }

        return predicateList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.abharana.services.domain.repositories.IUserProfileRepository#flush()
     */
    public void flush() {
        getEntityManager().flush();
        getEntityManager().clear();
    }

}
