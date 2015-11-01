package com.classroom.services.facade.interfaces;

import com.classroom.services.facade.dto.entities.ExamMarksDTO;
import com.classroom.services.facade.dto.entities.ExamResultsDTO;




public interface IExamResultsService {

	ExamResultsDTO getExamResultDetails(Integer studentId);

	ExamMarksDTO getExamMarks(Integer examId);
}
