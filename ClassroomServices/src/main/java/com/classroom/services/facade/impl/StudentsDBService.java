package com.classroom.services.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import com.classroom.services.domain.model.repositories.IStudentsRepository;
import com.classroom.services.facade.dto.assembler.StudentsAssembler;
import com.classroom.services.facade.dto.entities.StudentsDTO;

import com.classroom.services.facade.interfaces.IStudentsService;
import com.classroom.services.infrastructure.persistence.hibernate.StudentsRepository;
import com.classroom.services.domain.model.Students;



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