package com.classroom.services.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.classroom.services.domain.model.repositories.IExamMarksRepository;
import com.classroom.services.domain.model.repositories.IExamResultsRepository;
import com.classroom.services.facade.dto.assembler.ExamResultsAssembler;
import com.classroom.services.facade.dto.entities.ExamMarksDTO;
import com.classroom.services.facade.dto.entities.ExamResultsDTO;

import com.classroom.services.facade.interfaces.IExamResultsService;
import com.classroom.services.infrastructure.persistence.hibernate.ExamResultsRepository;
import com.classroom.services.domain.model.ExamResults;
import com.classroom.services.domain.model.Exams;



@Service
@Transactional
public class ExamResultsDBService implements IExamResultsService{

	
	 @Autowired
	 private IExamResultsRepository examResultsRepository;
	 private IExamMarksRepository examMarksRepository;
	
	
	public ExamResultsDTO getExamResultDetails(Integer studentId) {
		ExamResultsDTO examResultsDTO = new ExamResultsDTO(); 
		ExamResults examResultsDomain = examResultsRepository.getExamResultDetails(studentId);
		 ExamResultsAssembler.Object2DTO(examResultsDomain, examResultsDTO);
	     return examResultsDTO;
		
	}
	
	public ExamMarksDTO getExamMarks(Integer examId) {
		 ExamMarksDTO examMarksDTO = new ExamMarksDTO();
		 Exams examResultsDomain = examMarksRepository.getExamMarks(examId);
		 ExamResultsAssembler.Object2DTOMarks(examResultsDomain, examMarksDTO);
	     return examMarksDTO;
		
	}
	
}