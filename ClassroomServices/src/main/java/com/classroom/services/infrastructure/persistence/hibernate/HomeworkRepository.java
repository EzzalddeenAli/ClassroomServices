/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.classroom.services.infrastructure.persistence.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Repository;

import com.classroom.services.domain.model.Homework;
import com.classroom.services.domain.model.User;
import com.classroom.services.domain.model.repositories.IHomeworkRepository;
import com.classroom.services.domain.model.repositories.criteria.BaseSearchCriteria;

@Repository
public class HomeworkRepository extends BaseRepository<Homework,BaseSearchCriteria>
        implements IHomeworkRepository {

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.classroom.services.domain.repositories.IUserRepositoy#getUserByLoignName
     * (java.lang.String)
     */
    public List<Homework> getHomework(Integer batchId,Integer courseId) {
        List<Homework> homework = null;
        CriteriaQuery<Homework> query = getCriteriaBuilder()
                .createQuery(Homework.class);
        Root<Homework> from = query.from(Homework.class);
        Predicate[] predicates = new Predicate[2];
        predicates[0] = getCriteriaBuilder().equal(from.get("batchId"),
        		batchId);
        predicates[1] = getCriteriaBuilder().equal(from.get("courseId"),
        		courseId);
        
        query.where(predicates);
        query.select(from);

        homework = getResultList(query);
        System.out.println("homework size "+homework.size());
        //Homework getHomework = new Homework();
        List<Homework> getHomework = new ArrayList<Homework>();
        if (homework.size() >= 1) {
            for (Integer i = 0; i < homework.size(); i++) {
            	//if (homework.get(i).getStartTime().toDate().getTime() <= (new LocalDateTime())
                  //      .toDate().getTime()) {
            		getHomework.add(homework.get(i));
                //}
            		

            }
        }
        return getHomework;
    }

}
