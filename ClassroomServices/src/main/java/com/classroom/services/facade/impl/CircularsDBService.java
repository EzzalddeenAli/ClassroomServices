package com.classroom.services.facade.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.classroom.services.domain.model.Circulars;
import com.classroom.services.domain.model.CircularsBatch;
import com.classroom.services.domain.model.Homework;
import com.classroom.services.domain.model.repositories.ICircularsBatchRepository;
import com.classroom.services.domain.model.repositories.ICircularsRepository;
import com.classroom.services.facade.dto.assembler.CircularsAssembler;
import com.classroom.services.facade.dto.assembler.CircularsBatchAssembler;
import com.classroom.services.facade.dto.assembler.HomeworkAssembler;
import com.classroom.services.facade.dto.entities.CircularBatchDTO;
import com.classroom.services.facade.dto.entities.CircularBatchSearchDTO;
import com.classroom.services.facade.dto.entities.CircularDTO;
import com.classroom.services.facade.dto.entities.CircularSearchDTO;
import com.classroom.services.facade.dto.entities.CircularsBatchDTO;
import com.classroom.services.facade.dto.entities.CircularsDTO;
import com.classroom.services.facade.dto.entities.HomeworkDTO;
import com.classroom.services.facade.interfaces.ICircularsService;
import com.classroom.services.infrastructure.persistence.hibernate.CircularsRepository;



@Service
@Transactional
public class CircularsDBService implements ICircularsService{
	
	 @Autowired
	 private ICircularsRepository circularsRepository;
	 @Autowired
	 private ICircularsBatchRepository circularsBatchRepository;
	 
	
	public CircularsDTO getCircularDetails(CircularSearchDTO searchDTO) {    
	     
	       CircularsDTO listDTO = new CircularsDTO(); 
		   java.util.List<Circulars> circulars = circularsRepository.getCircular(searchDTO);
		   ArrayList<CircularDTO> circularsDTO = new ArrayList<CircularDTO>(); 
		   for(Circulars circular : circulars){
			CircularDTO circularDTO = new CircularDTO(); 
			CircularsAssembler.Object2DTO(circular, circularDTO);
			circularsDTO.add(circularDTO);
		   }   
		   listDTO.setCirculars(circularsDTO);
		      return listDTO;
		  
		 }
	
	  public void updateCircular(CircularDTO circularDTO){
		  Circulars circular = circularsRepository.get(circularDTO.getId());
		  CircularsAssembler.DTO2Object(circularDTO, circular);
		  circularsRepository.save(circular);
		  CircularsAssembler.Object2DTO(circular, circularDTO);
	    }

	public CircularsBatchDTO getCircularBatchDetails(CircularBatchSearchDTO searchDTO) {

	       CircularsBatchDTO listDTO = new CircularsBatchDTO(); 
		   java.util.List<CircularsBatch> circulars = circularsBatchRepository.getCircularBatch(searchDTO);
		   ArrayList<CircularBatchDTO> circularsDTO = new ArrayList<CircularBatchDTO>(); 
		   for(CircularsBatch circularBatch : circulars){
			CircularBatchDTO circularDTO = new CircularBatchDTO(); 
			CircularsBatchAssembler.Object2DTO(circularBatch, circularDTO);
			circularsDTO.add(circularDTO);
		   }   
		   listDTO.setCircularsBatch(circularsDTO);
		      return listDTO;
	}
}