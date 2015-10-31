package com.classroom.services.domain.model.repositories;

import java.util.List;


import com.classroom.services.domain.model.ExamResults;
import com.classroom.services.domain.model.Exams;

import ch.qos.logback.core.net.SyslogOutputStream;



public interface IExamMarksRepository extends IBaseRepository<Exams>{
	
	Exams getExamMarks(Integer examId);
}
