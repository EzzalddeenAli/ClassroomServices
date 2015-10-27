package com.classroom.services.domain.model.repositories;

import java.util.List;

import org.joda.time.LocalDateTime;

import com.classroom.services.domain.model.Homework;
import com.classroom.services.domain.model.User;



public interface IHomeworkRepository extends IBaseRepository<Homework>{

	List<Homework> getHomework(Integer BatchId,Integer CourseId);
	//List<Students> getStudentsDetails(StudentsSearchCriteria criteria);

	List<Homework> getHomeworkSearch(LocalDateTime startTime);
}
