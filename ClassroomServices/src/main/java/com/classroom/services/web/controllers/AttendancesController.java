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

import com.classroom.services.facade.dto.entities.AttendancesListDTO;
import com.classroom.services.facade.dto.entities.AttendancesSearchDTO;
import com.classroom.services.facade.interfaces.IAttendancesService;




@RequestMapping("/attendance")
@Controller
public class AttendancesController {
	private static final Logger LOG = LoggerFactory
		    .getLogger(HomeworkController.class);

	@Autowired
	 private IAttendancesService service;
	
	
    /**
     * Add Attendance
     * 
     */
    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    @ResponseBody
    public AttendancesListDTO addAttendance(@RequestBody AttendancesListDTO attendancedto) {
        try {
        	System.out.println("here");
            service.addAttendance(attendancedto);
        } catch (Exception e) {
        	System.out.println(e.getMessage());
            LOG.error("Error");
            attendancedto.setErrorCode(e.getMessage());
        }
        return attendancedto;
    }
    
    /**
     * update Homework
     * 
     *  example : {
				  "attendances": [
				    {
				      "id": 1,
				      "studentId": "1",
				      "batchId": "1",
				      "monthDate": "2015.10.28 00:00",
				      "forenoon": "false",
				      "afternoon": "false",
				      "reason": "absent"
				    },
				    {
				      "id": 2,
				      "studentId": "2",
				      "batchId": "1",
				      "monthDate": "2015.10.28 00:00",
				      "forenoon": "true",
				      "afternoon": "true",
				      "reason": "prese"
				    }
				  ]
				}
     */
    @RequestMapping(value = "/update" ,method = RequestMethod.POST)
    @ResponseBody
    public AttendancesListDTO updateAttendance(@RequestBody AttendancesListDTO attendancedto) {
        try {
            service.updateAttendance(attendancedto);
        } catch (Exception e) {
        	System.out.println(e.getMessage());
            LOG.error("Error");
            attendancedto.setErrorCode(e.getMessage());
        }
        return attendancedto;
    }
    
    /**
     * Gets the Homework based n search.
     * 
     * example :  {
		"studentId" : 1,
		"batchId" : 1,
		"monthDate" : "2015.10.28 00:00"
		}
     *           
     * @return the Homework based n search
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public AttendancesListDTO getAttendance(@RequestBody AttendancesSearchDTO searchDTO) {
    	AttendancesListDTO dto = null;
        try {
            dto = service.getAttendance(searchDTO);
        } catch (Exception e) {
            LOG.error("Error");
            System.out.println(e.getMessage());
        }
        return dto;
    }

    
}
