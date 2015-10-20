/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.classroom.services.infrastructure.persistence.hibernate;

import org.springframework.stereotype.Repository;

import com.classroom.services.domain.model.Account;
import com.classroom.services.domain.model.repositories.IAccountRepository;
import com.classroom.services.domain.model.repositories.criteria.BaseSearchCriteria;

@Repository
public class AccountRepository extends
        BaseRepository<Account, BaseSearchCriteria> implements
        IAccountRepository {
}
