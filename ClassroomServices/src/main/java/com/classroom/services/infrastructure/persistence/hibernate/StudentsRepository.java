package com.classroom.services.infrastructure.persistence.hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Repository;

import com.classroom.services.domain.model.Students;
import com.classroom.services.domain.model.repositories.IBaseRepository;

import com.classroom.services.domain.model.repositories.IStudentsRepository;
import com.classroom.services.domain.model.repositories.criteria.StudentsSearchCriteria;

@Repository
public class StudentsRepository extends BaseRepository<Students, StudentsSearchCriteria> implements IStudentsRepository{

    
}
