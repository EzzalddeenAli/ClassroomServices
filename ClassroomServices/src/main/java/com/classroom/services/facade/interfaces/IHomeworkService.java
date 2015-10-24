package com.classroom.services.facade.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.classroom.services.facade.dto.entities.HomeworkDTO;
import com.classroom.services.facade.dto.entities.HomeworkListDTO;


public interface IHomeworkService {

	HomeworkListDTO getHomework(Integer batchId,Integer courseId);
	void addHomework(HomeworkDTO homeworkDTO);
	void updateHomework(HomeworkDTO homeworkDTO);
}
