package com.classroom.services.facade.dto.assembler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.classroom.services.domain.model.Homework;
import com.classroom.services.facade.dto.entities.HomeworkDTO;
import com.classroom.services.web.controllers.HomeworkController;

public class HomeworkAssembler {
	private static final Logger LOG = LoggerFactory
		    .getLogger(HomeworkController.class);

	private HomeworkAssembler(){
		
	}

	 public static void DTO2Object(HomeworkDTO dto,
			 Homework obj) {
	        obj.setId(dto.getId());
	        obj.setBatchId(dto.getBatchId());
	        obj.setCourseId(dto.getCourseId());
	        obj.setDesc(dto.getDesc());
	        obj.setSubjectId(dto.getSubjectId());
	        obj.setCreatedAt(dto.getCreatedAt());
	        obj.setUpdatedAt(dto.getUpdatedAt());
	        obj.setStartTime(dto.getStartTime());
	        obj.setEndTime(dto.getEndTime());
	    }
	
	 public static void Object2DTO(Homework obj, HomeworkDTO dto){
			 dto.setId(obj.getId());
			 dto.setBatchId(obj.getBatchId());
			 dto.setCourseId(obj.getCourseId());
			 dto.setDesc(obj.getDesc());
			 dto.setSubjectId(obj.getSubjectId());
			 dto.setCreatedAt(obj.getCreatedAt());
			 dto.setUpdatedAt(obj.getUpdatedAt());
			 dto.setStartTime(obj.getStartTime());
			 dto.setEndTime(obj.getEndTime());
	 }
}