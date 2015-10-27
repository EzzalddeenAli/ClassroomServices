/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.classroom.services.infrastructure.persistence.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.classroom.services.domain.model.Attendances;
import com.classroom.services.domain.model.repositories.IAttendancesRepository;
import com.classroom.services.domain.model.repositories.criteria.BaseSearchCriteria;
import com.classroom.services.facade.dto.entities.AttendancesSearchDTO;

@Repository
public class AttendancesRepository extends BaseRepository<Attendances,BaseSearchCriteria>
        implements IAttendancesRepository {
    
    public List<Attendances> getAttendance(AttendancesSearchDTO searchDTO){

        List<Attendances> attendance = null;
        CriteriaQuery<Attendances> query = getCriteriaBuilder()
                .createQuery(Attendances.class);
        Root<Attendances> from = query.from(Attendances.class);
        List<Attendances> attendances = new ArrayList<Attendances>();
        Integer count = searchDTO.getCount();
        if(count != 0){
	        Predicate[] predicates = new Predicate[count];
	        Integer j = 0;
	        if(searchDTO.getStudentId() != 0){
	        	predicates[j++] = getCriteriaBuilder().equal(from.get("studentId"),searchDTO.getStudentId());       		
	        }
	        if(searchDTO.getBatchId() != 0){
	        	predicates[j++] = getCriteriaBuilder().equal(from.get("batchId"),searchDTO.getBatchId());      		
	        }
	        if(count > j){
	        	predicates[j] = getCriteriaBuilder().equal(from.get("monthDate"),searchDTO.getMonthDate());
	        }
	        query.where(predicates);
	        query.select(from);
	        System.out.println("before query");
	        attendance = getResultList(query);
	        System.out.println("attendances size "+ attendance.size());
	        if (attendance.size() >= 1) {
	            for (Integer i = 0; i < attendance.size(); i++) {	               
	            	attendances.add(attendance.get(i));
	
	            }
	        }
        }
        return attendances;
    }

}
