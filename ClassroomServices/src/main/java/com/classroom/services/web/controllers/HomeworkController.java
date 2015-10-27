package com.classroom.services.web.controllers;

import java.io.Console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.classroom.services.facade.dto.entities.CircularSearchDTO;
import com.classroom.services.facade.dto.entities.CircularsDTO;
import com.classroom.services.facade.dto.entities.HomeworkDTO;
import com.classroom.services.facade.dto.entities.HomeworkListDTO;
import com.classroom.services.facade.dto.entities.HomeworkSearchDTO;
import com.classroom.services.facade.interfaces.IHomeworkService;



@RequestMapping("/homework")
@Controller
public class HomeworkController {
	private static final Logger LOG = LoggerFactory
		    .getLogger(HomeworkController.class);

	@Autowired
	 private IHomeworkService service;
	

    /**
     * Gets the Homework.
     * 
     * @param id
     *           
     * @return the Homework
     */
    @RequestMapping(value = "/{batchId}/{courseId}", method = RequestMethod.GET)
    @ResponseBody
    public HomeworkListDTO getHomework(@PathVariable Integer batchId,@PathVariable Integer courseId) {
    	HomeworkListDTO dto = null;
        try {
            dto = service.getHomework(batchId,courseId);
        } catch (Exception e) {
        	System.out.println(e.getMessage());
            LOG.error("Error");
        }
        return dto;
    }
	
    /**
     * Add Homework
     * 
     */
    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    @ResponseBody
    public HomeworkDTO addHomework(@RequestBody HomeworkDTO homeworkdto) {
        try {
            service.addHomework(homeworkdto);
        } catch (Exception e) {
        	System.out.println(e.getMessage());
            LOG.error("Error");
            homeworkdto.setErrorCode(e.getMessage());
        }
        return homeworkdto;
    }
    
    /**
     * Add Homework
     * 
     */
    @RequestMapping(value = "/update" ,method = RequestMethod.POST)
    @ResponseBody
    public HomeworkDTO updateHomework(@RequestBody HomeworkDTO homeworkdto) {
        try {
            service.updateHomework(homeworkdto);
        } catch (Exception e) {
        	System.out.println(e.getMessage());
            LOG.error("Error");
            homeworkdto.setErrorCode(e.getMessage());
        }
        return homeworkdto;
    }
    
    /**
     * Gets the Homework based n search.
     * 
     * @param id
     *           
     * @return the Homework based n search
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public HomeworkListDTO getHomeworkSearch(@RequestBody HomeworkSearchDTO searchDTO) {
    	HomeworkListDTO dto = null;
        try {
        	System.out.println("here .. ");
        	System.out.println(searchDTO.getStartDate());
            dto = service.getHomeworkSearch(searchDTO.getStartDate());
        } catch (Exception e) {
            LOG.error("Error");
            System.out.println(e.getMessage());
        }
        return dto;
    }

    
}
