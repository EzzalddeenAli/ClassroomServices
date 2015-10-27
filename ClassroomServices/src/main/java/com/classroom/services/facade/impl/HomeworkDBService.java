package com.classroom.services.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.classroom.services.domain.model.repositories.IHomeworkRepository;
import com.classroom.services.domain.model.repositories.IStudentsRepository;
import com.classroom.services.facade.dto.assembler.CircularsAssembler;
import com.classroom.services.facade.dto.assembler.HomeworkAssembler;
import com.classroom.services.facade.dto.assembler.StudentsAssembler;
import com.classroom.services.facade.dto.entities.CircularDTO;
import com.classroom.services.facade.dto.entities.CircularsDTO;
import com.classroom.services.facade.dto.entities.HomeworkDTO;
import com.classroom.services.facade.dto.entities.HomeworkListDTO;
import com.classroom.services.facade.dto.entities.StudentsDTO;

import com.classroom.services.facade.interfaces.IHomeworkService;
import com.classroom.services.infrastructure.persistence.hibernate.StudentsRepository;
import com.classroom.services.domain.model.Circulars;
import com.classroom.services.domain.model.Homework;



@Service
@Transactional
public class HomeworkDBService implements IHomeworkService{

	
	 @Autowired
	 private IHomeworkRepository homeworkRepository;
	
	
	
	public HomeworkListDTO getHomework(Integer batchId,Integer courseId) {
		 HomeworkListDTO listDTO = new HomeworkListDTO(); 
		 List<Homework> homeworks = homeworkRepository.getHomework(batchId,courseId);
		 List<HomeworkDTO> homeworkDTOs = new ArrayList<HomeworkDTO>(); 
		 for(Homework homework : homeworks){
			 HomeworkDTO homeworkDTO = new HomeworkDTO(); 
			 HomeworkAssembler.Object2DTO(homework, homeworkDTO);
			 homeworkDTOs.add(homeworkDTO);
		 }		 
		 listDTO.setHomeworks(homeworkDTOs);
	     return listDTO;
		
	}
	
    public void addHomework(HomeworkDTO homeworkDTO){
    	Homework homework = new Homework();
    	HomeworkAssembler.DTO2Object(homeworkDTO, homework);
    	homeworkRepository.save(homework);
        HomeworkAssembler.Object2DTO(homework, homeworkDTO);
    }
    
    public void updateHomework(HomeworkDTO homeworkDTO){
    	Homework homework = homeworkRepository.get(homeworkDTO.getId());
    	HomeworkAssembler.DTO2Object(homeworkDTO, homework);
    	homeworkRepository.save(homework);
        HomeworkAssembler.Object2DTO(homework, homeworkDTO);
    }
    
	
	public HomeworkListDTO getHomeworkSearch(LocalDateTime startTime) {    
		 HomeworkListDTO listDTO = new HomeworkListDTO(); 
		 List<Homework> homeworks = homeworkRepository.getHomeworkSearch(startTime);
		 List<HomeworkDTO> homeworkDTOs = new ArrayList<HomeworkDTO>(); 
		 for(Homework homework : homeworks){
			 HomeworkDTO homeworkDTO = new HomeworkDTO(); 
			 HomeworkAssembler.Object2DTO(homework, homeworkDTO);
			 homeworkDTOs.add(homeworkDTO);
		 }		 
		 listDTO.setHomeworks(homeworkDTOs);
	     return listDTO;
		  
		 }
}