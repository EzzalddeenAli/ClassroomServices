package com.classroom.services.facade.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.classroom.services.facade.dto.entities.StudentsDTO;


public interface IStudentsService {

	StudentsDTO getStudentDetails(Integer id);

}
