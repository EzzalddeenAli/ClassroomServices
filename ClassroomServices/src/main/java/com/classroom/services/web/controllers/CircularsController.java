package com.classroom.services.web.controllers;


import org.joda.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.classroom.services.facade.dto.entities.CircularDTO;
import com.classroom.services.facade.dto.entities.CircularSearchDTO;
import com.classroom.services.facade.dto.entities.CircularsDTO;
import com.classroom.services.facade.interfaces.ICircularsService;


@RequestMapping("/circulars")
@Controller
public class CircularsController {
	private static final Logger LOG = LoggerFactory
		    .getLogger(CircularsController.class);

	@Autowired
	 private ICircularsService service;
	

    /**
     * Gets the Circular details.
     * 
     * @param id
     *           
     * @return the Circular details
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public CircularsDTO getCircularDetails(@RequestBody CircularSearchDTO searchDTO) {
    	CircularsDTO dto = null;
        try {
        	System.out.println("here .. ");
        	System.out.println(searchDTO.getStartDate());
            dto = service.getCircularDetails(searchDTO.getStartDate());
        } catch (Exception e) {
            LOG.error("Error");
            System.out.println(e.getMessage());
        }
        return dto;
    }
	
}
