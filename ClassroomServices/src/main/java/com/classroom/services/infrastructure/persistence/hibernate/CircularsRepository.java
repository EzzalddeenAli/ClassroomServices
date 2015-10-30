package com.classroom.services.infrastructure.persistence.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.criterion.CriteriaQuery;
import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Repository;

import com.classroom.services.domain.model.Circulars;
import com.classroom.services.domain.model.repositories.ICircularsRepository;
import com.classroom.services.domain.model.repositories.criteria.CircularsSearchCriteria;
import com.classroom.services.facade.dto.entities.CircularDTO;
import com.classroom.services.facade.dto.entities.CircularSearchDTO;

@Repository
public class CircularsRepository extends BaseRepository<Circulars, CircularsSearchCriteria> implements ICircularsRepository{
	
	public List<Circulars> getCircular(CircularSearchDTO searchDTO) {
	        List<Circulars> circular = null;
	        javax.persistence.criteria.CriteriaQuery<Circulars> query = getCriteriaBuilder()
	                .createQuery(Circulars.class);
	        Root<Circulars> from = query.from(Circulars.class);
	        Predicate[] predicates = new Predicate[2];
	        predicates[0] = getCriteriaBuilder().equal(from.get("startDate"),
	        		searchDTO.getStartDate());

	        predicates[1] = getCriteriaBuilder().equal(from.get("isExam"),
	        		searchDTO.getIsExam());
	        query.where(predicates);
	        query.select(from);
	        System.out.println("before query");
	        circular = getResultList(query);
	        System.out.println("homework size "+ circular.size());
	        //Homework getHomework = new Homework();
	        List<Circulars> circulars = new ArrayList<Circulars>();
	        if (circular.size() >= 1) {
	            for (Integer i = 0; i < circular.size(); i++) {	               
	            	circulars.add(circular.get(i));

	            }
	        }
	        return circulars;
	    }

	    
}
