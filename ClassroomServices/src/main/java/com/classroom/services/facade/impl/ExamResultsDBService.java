package com.classroom.services.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.classroom.services.domain.model.repositories.IExamMarksRepository;
import com.classroom.services.domain.model.repositories.IExamResultsRepository;
import com.classroom.services.facade.dto.assembler.ExamResultsAssembler;
import com.classroom.services.facade.dto.assembler.HomeworkAssembler;
import com.classroom.services.facade.dto.entities.ExamMarksDTO;
import com.classroom.services.facade.dto.entities.ExamMarksListDTO;
import com.classroom.services.facade.dto.entities.ExamResultsDTO;
import com.classroom.services.facade.dto.entities.HomeworkDTO;
import com.classroom.services.facade.interfaces.IExamResultsService;
import com.classroom.services.infrastructure.persistence.hibernate.ExamResultsRepository;
import com.classroom.services.domain.model.ExamResults;
import com.classroom.services.domain.model.Exams;
import com.classroom.services.domain.model.Homework;



@Service
@Transactional
public class ExamResultsDBService implements IExamResultsService{

	
	 @Autowired
	 private IExamResultsRepository examResultsRepository;
	 @Autowired
	 private IExamMarksRepository examMarksRepository;
	
	
	public ExamResultsDTO getExamResultDetails(Integer studentId) {
		ExamResultsDTO examResultsDTO = new ExamResultsDTO(); 
		ExamResults examResultsDomain = examResultsRepository.getExamResultDetails(studentId);
		 ExamResultsAssembler.Object2DTO(examResultsDomain, examResultsDTO);
	     return examResultsDTO;
		
	}
	
	public ExamMarksListDTO getExamMarks(Integer examId) {
		ExamMarksListDTO ListDTO = new ExamMarksListDTO();
		 List<Exams> examResultsDomain = examMarksRepository.getExamMarks(examId);
		 List<ExamMarksDTO> examMarksDTOs = new ArrayList<ExamMarksDTO>();
		 for(Exams examResults : examResultsDomain){
			 ExamMarksDTO examMarksDTO = new ExamMarksDTO(); 
			 ExamResultsAssembler.Object2DTOMarks(examResults, examMarksDTO);
			 examMarksDTOs.add(examMarksDTO);
		 }		 
		 ListDTO.setExamMarks(examMarksDTOs);
	     return ListDTO;
		
	}
	
}
