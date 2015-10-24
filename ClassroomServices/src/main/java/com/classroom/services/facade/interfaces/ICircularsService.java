package com.classroom.services.facade.interfaces;

import org.joda.time.LocalDateTime;

import com.classroom.services.facade.dto.entities.CircularsDTO;


public interface ICircularsService {

	CircularsDTO getCircularDetails(LocalDateTime startDate);

}
