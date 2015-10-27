package com.classroom.services.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.classroom.services.facade.dto.assembler.AttendancesAssembler;
import com.classroom.services.facade.dto.entities.AttendancesDTO;
import com.classroom.services.facade.dto.entities.AttendancesListDTO;
import com.classroom.services.facade.dto.entities.AttendancesSearchDTO;
import com.classroom.services.facade.dto.entities.HomeworkListDTO;
import com.classroom.services.facade.interfaces.IAttendancesService;
import com.classroom.services.domain.model.Attendances;
import com.classroom.services.domain.model.repositories.IAttendancesRepository;



@Service
@Transactional
public class AttendancesDBService implements IAttendancesService{

	
	 @Autowired
	 private IAttendancesRepository attendanceRepository;
	
	
    public void addAttendance(AttendancesListDTO attendancesdto){
    	 System.out.println("111111111");
    	  List<AttendancesDTO> attendanceDTOs = attendancesdto.getAttendances(); 
    	  Attendances attendance = new Attendances();
    	for(AttendancesDTO attendanceDTO : attendanceDTOs){
	    	AttendancesAssembler.DTO2Object(attendanceDTO, attendance);
	    	attendanceRepository.save(attendance);
	        AttendancesAssembler.Object2DTO(attendance, attendanceDTO);
        
    	}
    }
    
    public void updateAttendance(AttendancesListDTO attendancesdto){
    	
    	 Attendances attendance = new Attendances();
	   	 List<AttendancesDTO> attendanceDTOs = attendancesdto.getAttendances(); 
	   	
	   	for(AttendancesDTO attendanceDTO : attendanceDTOs){
	   		attendance = attendanceRepository.get(attendanceDTO.getId());
		    AttendancesAssembler.DTO2Object(attendanceDTO, attendance);
		    attendanceRepository.save(attendance);
		    AttendancesAssembler.Object2DTO(attendance, attendanceDTO);
	       
	   	}
    }
    
	
	public AttendancesListDTO getAttendance(AttendancesSearchDTO searchDTO) {    
		 AttendancesListDTO listDTO = new AttendancesListDTO(); 
		 List<Attendances> attendances = (List<Attendances>) attendanceRepository.getAttendance(searchDTO);
		 List<AttendancesDTO> attendanceDTOs = new ArrayList<AttendancesDTO>(); 
		 for(Attendances attendance : attendances){
			 AttendancesDTO attendancesDTO = new AttendancesDTO(); 
			 AttendancesAssembler.Object2DTO(attendance, attendancesDTO);
			 attendanceDTOs.add(attendancesDTO);
		 }		 
		 listDTO.setAttendances(attendanceDTOs);
	     return listDTO;
		  
		 }
}