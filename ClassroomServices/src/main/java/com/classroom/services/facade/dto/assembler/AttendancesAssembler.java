package com.classroom.services.facade.dto.assembler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.classroom.services.domain.model.Attendances;
import com.classroom.services.facade.dto.entities.AttendancesDTO;
import com.classroom.services.facade.dto.entities.AttendancesListDTO;
import com.classroom.services.web.controllers.HomeworkController;

public class AttendancesAssembler {
	private static final Logger LOG = LoggerFactory
		    .getLogger(HomeworkController.class);

	private AttendancesAssembler(){
		
	}

	 public static void DTO2Object(AttendancesDTO dto,
			 Attendances obj) {
	        obj.setId(dto.getId());
	        obj.setBatchId(dto.getBatchId());
	        obj.setAfternoon(dto.getAfternoon());
	        obj.setForenoon(dto.getForenoon());
	        obj.setMonthDate(dto.getMonthDate());
	        obj.setReason(dto.getReason());
	        obj.setStudentId(dto.getStudentId());
	    }
	
	 public static void Object2DTO(Attendances obj, AttendancesDTO dto){
			 dto.setId(obj.getId());
			 dto.setBatchId(obj.getBatchId());
			 dto.setAfternoon(obj.getAfternoon());
			 dto.setForenoon(obj.getForenoon());
			 dto.setMonthDate(obj.getMonthDate());
			 dto.setReason(obj.getReason());
			 dto.setStudentId(obj.getStudentId());
	 }
	 
	 public static void objectSeriesDTO2SeriesDomain(AttendancesListDTO dto, Attendances obj){
	        
	 }
	 
	 public static void objectSeriesDomain2SeriesDTO(Attendances obj,
			 AttendancesListDTO dto) {
	    }
}