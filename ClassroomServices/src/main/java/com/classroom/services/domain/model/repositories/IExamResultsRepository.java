package com.classroom.services.domain.model.repositories;

import java.util.List;


import com.classroom.services.domain.model.ExamResults;
import com.classroom.services.domain.model.Exams;



public interface IExamResultsRepository extends IBaseRepository<ExamResults>{
	ExamResults getExamResultDetails(Integer studentId);
	
}
