package com.classroom.services.facade.impl;

import java.util.ArrayList;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.classroom.services.domain.model.Circulars;
import com.classroom.services.domain.model.repositories.ICircularsRepository;
import com.classroom.services.facade.dto.assembler.CircularsAssembler;
import com.classroom.services.facade.dto.entities.CircularDTO;
import com.classroom.services.facade.dto.entities.CircularsDTO;
import com.classroom.services.facade.interfaces.ICircularsService;

import antlr.collections.List;



@Service
@Transactional
public class CircularsDBService implements ICircularsService{
	
	 @Autowired
	 private ICircularsRepository circularsRepository;
	
	public CircularsDTO getCircularDetails(LocalDateTime startDate) {    
	     
	       CircularsDTO listDTO = new CircularsDTO(); 
	       System.out.println("startDate " + startDate);
		   java.util.List<Circulars> circulars = circularsRepository.getCircular(startDate);
		   ArrayList<CircularDTO> circularsDTO = new ArrayList<CircularDTO>(); 
		   for(Circulars circular : circulars){
			CircularDTO circularDTO = new CircularDTO(); 
			CircularsAssembler.Object2DTO(circular, circularDTO);
			circularsDTO.add(circularDTO);
		   }   
		   listDTO.setCirculars(circularsDTO);
		      return listDTO;
		  
		 }
	}