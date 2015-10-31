package com.classroom.services.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.classroom.services.facade.dto.entities.ExamMarksDTO;
import com.classroom.services.facade.dto.entities.ExamResultsDTO;

import com.classroom.services.facade.interfaces.IExamResultsService;


@RequestMapping("/examresults")
@Controller
public class ExamResultsController {
	private static final Logger LOG = LoggerFactory
		    .getLogger(ExamResultsController.class);

	@Autowired
	 private IExamResultsService service;
	

    /**
     * Gets the Student details.
     * 
     * @param id
     *           
     * @return the student details
     */
    @RequestMapping(value = "/results/{studentId}", method = RequestMethod.GET)
    @ResponseBody
    public ExamResultsDTO getExamResultDetails(@PathVariable Integer studentId) {
    	ExamResultsDTO dto = null;
        try {
            dto = service.getExamResultDetails(studentId);
        } catch (Exception e) {
            LOG.error("Error");
            System.out.println(e.getMessage());
        }
        return dto;
    }
    
    @RequestMapping(value = "/marks/{examId}", method = RequestMethod.GET)
    @ResponseBody
    public ExamMarksDTO getExamMarks(@PathVariable Integer examId) {
    	ExamMarksDTO dto = null;
        try {
        	 System.out.println("examId !! "+examId);
            dto = service.getExamMarks(examId);
            System.out.println("after examId !! "+examId);
        } catch (Exception e) {
            LOG.error("Error");
            System.out.println(e.getMessage());
        }
        return dto;
    }
	
}
