package com.classroom.services.facade.dto.assembler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.classroom.services.domain.model.ExamResults;
import com.classroom.services.domain.model.Exams;
import com.classroom.services.facade.dto.entities.ExamMarksDTO;
import com.classroom.services.facade.dto.entities.ExamResultsDTO;
import com.classroom.services.web.controllers.ExamResultsController;


public class ExamResultsAssembler {
	private static final Logger LOG = LoggerFactory
		    .getLogger(ExamResultsController.class);

	private ExamResultsAssembler(){
		
	}

	 public static void DTO2Object(ExamResultsDTO dto,
	            ExamResults obj) {
	        obj.setId(dto.getId());
	        //obj.setUser(dto.getUserId());
	        obj.setExamId(dto.getExamId());
	        obj.setMarks(dto.getMarks());
	        obj.setStudentId(dto.getStudentId());
	        obj.setGradingLevel(dto.getGradingLevelId());
	        obj.setRemarks(dto.getRemarks());
	    }
	
	 public static void Object2DTO(ExamResults obj, ExamResultsDTO dto){
		dto.setId(obj.getId());
		dto.setExamId(obj.getExamId());
		dto.setMarks(obj.getMarks());
		dto.setStudentId(obj.getStudentId());
		dto.setGradingLevelId(obj.getGradingLevel());
		dto.setRemarks(obj.getRemarks());
	 }
	 
	 
	 public static void DTO2ObjectMarks(ExamMarksDTO dto,
	            Exams obj) {
	        obj.setId(dto.getId());
	        //obj.setUser(dto.getUserId());
	        obj.setExamGroupId(dto.getExamGroupId());
	        obj.setMaximumMarks(dto.getMaximumMarks());
	        obj.setGradingLevel(dto.getGradingLevelId());
	    }
	
	 public static void Object2DTOMarks(Exams obj, ExamMarksDTO dto){
		dto.setId(obj.getId());
		dto.setExamGroupId(obj.getExamGroupId());
		dto.setMaximumMarks(obj.getMaximumMarks());
		dto.setGradingLevelId(obj.getGradingLevel());

	 }
}