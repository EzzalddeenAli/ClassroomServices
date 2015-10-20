/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.abharana.services.infrastructure.persistence.hibernate;

import org.springframework.stereotype.Repository;

import com.abharana.services.domain.model.Account;
import com.abharana.services.domain.model.repositories.IAccountRepository;
import com.abharana.services.domain.model.repositories.criteria.BaseSearchCriteria;

@Repository
public class AccountRepository extends
        BaseRepository<Account, BaseSearchCriteria> implements
        IAccountRepository {
}
