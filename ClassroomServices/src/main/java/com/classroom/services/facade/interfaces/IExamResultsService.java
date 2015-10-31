package com.classroom.services.facade.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.classroom.services.facade.dto.entities.ExamMarksDTO;
import com.classroom.services.facade.dto.entities.ExamResultsDTO;




public interface IExamResultsService {

	ExamResultsDTO getExamResultDetails(Integer studentId);

	ExamMarksDTO getExamMarks(Integer examId);
}
