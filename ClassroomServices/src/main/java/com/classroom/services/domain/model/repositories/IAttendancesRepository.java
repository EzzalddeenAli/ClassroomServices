package com.classroom.services.domain.model.repositories;

import java.util.List;

import org.joda.time.LocalDateTime;

import com.classroom.services.domain.model.Attendances;
import com.classroom.services.facade.dto.entities.AttendancesSearchDTO;



public interface IAttendancesRepository extends IBaseRepository<Attendances>{

	List<Attendances> getAttendance(AttendancesSearchDTO searchDTO);
}
