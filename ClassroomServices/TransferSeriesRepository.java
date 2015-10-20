/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.abharana.services.infrastructure.persistence.hibernate;

import org.springframework.stereotype.Repository;

import com.abharana.services.domain.model.TransferSeries;
import com.abharana.services.domain.repositories.ITransferSeriesRepository;
import com.abharana.services.domain.repositories.criteria.TransferSearchCriteria;

@Repository
public class TransferSeriesRepository extends
        BaseRepository<TransferSeries, TransferSearchCriteria> implements
        ITransferSeriesRepository {

}
