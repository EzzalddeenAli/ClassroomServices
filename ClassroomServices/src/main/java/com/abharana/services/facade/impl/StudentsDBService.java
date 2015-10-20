package com.abharana.services.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import com.abharana.services.domain.model.repositories.IStudentsRepository;
import com.abharana.services.facade.dto.assembler.StudentsAssembler;
import com.abharana.services.facade.dto.entities.StudentsDTO;

import com.abharana.services.facade.interfaces.IStudentsService;
import com.abharana.services.infrastructure.persistence.hibernate.StudentsRepository;
import com.abharana.services.domain.model.Students;



@Service
@Transactional
public class StudentsDBService implements IStudentsService{

	
	 @Autowired
	 private IStudentsRepository studentsRepository;
	
	
	
	public StudentsDTO getStudentDetails(Integer studentId) {
		 Students studentDomain = studentsRepository.get(studentId);
	     StudentsDTO studentDTO = new StudentsDTO ();
		 StudentsAssembler.Object2DTO(studentDomain, studentDTO);
	     return studentDTO;
		
	}
}