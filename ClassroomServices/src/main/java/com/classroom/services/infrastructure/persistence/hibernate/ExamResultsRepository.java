package com.classroom.services.infrastructure.persistence.hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Repository;

import com.classroom.services.domain.model.ExamResults;
import com.classroom.services.domain.model.Homework;
import com.classroom.services.domain.model.repositories.IBaseRepository;

import com.classroom.services.domain.model.repositories.IExamResultsRepository;
import com.classroom.services.domain.model.repositories.criteria.BaseSearchCriteria;
import com.classroom.services.domain.model.repositories.criteria.ExamResultsSearchCriteria;
import com.classroom.services.domain.model.repositories.criteria.StudentsSearchCriteria;


@Repository
public class ExamResultsRepository extends BaseRepository<ExamResults, BaseSearchCriteria> implements IExamResultsRepository{
	
	public ExamResults getExamResultDetails(Integer studentId) {
	ExamResults examresults = null;
    CriteriaQuery<ExamResults> query = getCriteriaBuilder().createQuery(
    		ExamResults.class);
    Root<ExamResults> from = query.from(ExamResults.class);
    Predicate[] predicates = new Predicate[1];
    predicates[0] = getCriteriaBuilder().equal(from.get("studentId"),
    		studentId);
    query.where(predicates);
    query.select(from);
    examresults = getSingleResult(query);

    return examresults;
	}
    
}
