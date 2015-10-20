/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.classroom.services.infrastructure.persistence.hibernate;

import org.springframework.stereotype.Repository;

import com.classroom.services.domain.model.TransferSeries;
import com.classroom.services.domain.repositories.ITransferSeriesRepository;
import com.classroom.services.domain.repositories.criteria.TransferSearchCriteria;

@Repository
public class TransferSeriesRepository extends
        BaseRepository<TransferSeries, TransferSearchCriteria> implements
        ITransferSeriesRepository {

}
