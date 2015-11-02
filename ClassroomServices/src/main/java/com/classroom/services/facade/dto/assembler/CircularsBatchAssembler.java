package com.classroom.services.facade.dto.assembler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.classroom.services.domain.model.Circulars;
import com.classroom.services.domain.model.CircularsBatch;
import com.classroom.services.facade.dto.entities.CircularBatchDTO;
import com.classroom.services.facade.dto.entities.CircularDTO;
import com.classroom.services.web.controllers.CircularsController;

public class CircularsBatchAssembler {
	private static final Logger LOG = LoggerFactory
		    .getLogger(CircularsController.class);

	private CircularsBatchAssembler(){
		
	}

	 public static void DTO2Object(CircularDTO dto,
	            CircularsBatch obj) {
	        obj.setId(dto.getId());
	       
	    }
	
	 public static void Object2DTO(CircularsBatch obj, CircularBatchDTO circularDTO){
		circularDTO.setId(obj.getId());
		
	 }
}