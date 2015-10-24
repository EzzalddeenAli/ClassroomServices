package com.classroom.services.facade.dto.assembler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.classroom.services.domain.model.Circulars;
import com.classroom.services.facade.dto.entities.CircularDTO;
import com.classroom.services.web.controllers.CircularsController;

public class CircularsAssembler {
	private static final Logger LOG = LoggerFactory
		    .getLogger(CircularsController.class);

	private CircularsAssembler(){
		
	}

	 public static void DTO2Object(CircularDTO dto,
	            Circulars obj) {
	        obj.setId(dto.getId());
	        obj.setTile(dto.getTitle());
	        obj.setDescription(dto.getDescription());
	        obj.setStartDate(dto.getStartDate());
	        obj.setEndDate(dto.getEndDate());
	        obj.setIsCommon(dto.getIsCommon());
	        obj.setIsHoliday(dto.getIsHoliday());
	        obj.setIsExam(dto.getIsExam());
	    }
	
	 public static void Object2DTO(Circulars obj, CircularDTO circularDTO){
		circularDTO.setId(obj.getId());
		circularDTO.setTile(obj.getTitle());
		circularDTO.setDescription(obj.getDescription());
		circularDTO.setStartDate(obj.getStartDate());
		circularDTO.setEndDate(obj.getEndDate());
		circularDTO.setIsCommon(obj.getIsCommon());
		circularDTO.setIsHoliday(obj.getIsHoliday());
        circularDTO.setIsExam(obj.getIsExam());
	 }
}