package com.classroom.services.web.controllers;


import org.hibernate.validator.constraints.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.classroom.services.facade.dto.entities.StudentsDTO;

import com.classroom.services.facade.interfaces.IStudentsService;


@RequestMapping("/students")
@Controller
public class StudentsController {
	private static final Logger LOG = LoggerFactory
		    .getLogger(StudentsController.class);

	@Autowired
	 private IStudentsService service;
	

    /**
     * Gets the Student details.
     * 
     * @param id
     *           
     * @return the student details
     */
    @RequestMapping(value = "/{StudentId}", method = RequestMethod.GET)
    @ResponseBody
    public StudentsDTO getStudentDetails(@PathVariable Integer StudentId) {
        StudentsDTO dto = null;
        try {
            dto = service.getStudentDetails(StudentId);
        } catch (Exception e) {
            LOG.error("Error");
        }
        return dto;
    }
	
}
