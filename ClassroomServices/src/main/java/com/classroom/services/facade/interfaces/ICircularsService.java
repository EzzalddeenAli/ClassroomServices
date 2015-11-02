package com.classroom.services.facade.interfaces;

import com.classroom.services.facade.dto.entities.CircularBatchSearchDTO;
import com.classroom.services.facade.dto.entities.CircularDTO;
import com.classroom.services.facade.dto.entities.CircularSearchDTO;
import com.classroom.services.facade.dto.entities.CircularsBatchDTO;
import com.classroom.services.facade.dto.entities.CircularsDTO;


public interface ICircularsService {

	void updateCircular(CircularDTO circularDTO);
	CircularsDTO getCircularDetails(CircularSearchDTO searchDTO);
	CircularsBatchDTO getCircularBatchDetails(CircularBatchSearchDTO searchDTO);
}
