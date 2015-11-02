package com.classroom.services.infrastructure.persistence.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.criterion.CriteriaQuery;
import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Repository;

import com.classroom.services.domain.model.Circulars;
import com.classroom.services.domain.model.CircularsBatch;
import com.classroom.services.domain.model.repositories.ICircularsBatchRepository;
import com.classroom.services.domain.model.repositories.ICircularsRepository;
import com.classroom.services.domain.model.repositories.criteria.CircularsBatchSearchCriteria;
import com.classroom.services.domain.model.repositories.criteria.CircularsSearchCriteria;
import com.classroom.services.facade.dto.entities.CircularBatchSearchDTO;
import com.classroom.services.facade.dto.entities.CircularDTO;
import com.classroom.services.facade.dto.entities.CircularSearchDTO;

@Repository
public class CircularsBatchRepository extends BaseRepository<CircularsBatch, CircularsBatchSearchCriteria> implements ICircularsBatchRepository{
	

	public List<CircularsBatch> getCircularBatch(CircularBatchSearchDTO searchDTO) {
		  List<CircularsBatch> circulars = null;
	        javax.persistence.criteria.CriteriaQuery<CircularsBatch> query = getCriteriaBuilder()
	                .createQuery(CircularsBatch.class);
	        Root<CircularsBatch> from = query.from(CircularsBatch.class);
	        Predicate[] predicates = new Predicate[2];
	        predicates[0] = getCriteriaBuilder().equal(from.get("eventID"),
	        		searchDTO.getEventID());

	        predicates[1] = getCriteriaBuilder().equal(from.get("batchID"),
	        		searchDTO.getBatchID());
	        query.where(predicates);
	        query.select(from);
	       // System.out.println("before query");
	        circulars = getResultList(query);
	        //System.out.println("homework size "+ circulars.size());
	        //Homework getHomework = new Homework();
	        List<CircularsBatch> circularslist = new ArrayList<CircularsBatch>();
	        if (circulars.size() >= 1) {
	            for (Integer i = 0; i < circulars.size(); i++) {	               
	            	circularslist.add(circulars.get(i));

	            }
	        }
	        return circularslist;
	    }
	    
}
