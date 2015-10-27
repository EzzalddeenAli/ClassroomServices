package com.classroom.services.facade.interfaces;

import java.util.List;

import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.classroom.services.facade.dto.entities.AttendancesListDTO;
import com.classroom.services.facade.dto.entities.AttendancesSearchDTO;
import com.classroom.services.facade.dto.entities.CircularsDTO;
import com.classroom.services.facade.dto.entities.HomeworkDTO;
import com.classroom.services.facade.dto.entities.HomeworkListDTO;


public interface IAttendancesService {
	
	void addAttendance(AttendancesListDTO attendancedto);
	void updateAttendance(AttendancesListDTO attendancedto);
	AttendancesListDTO getAttendance(AttendancesSearchDTO searchDTO);
}
