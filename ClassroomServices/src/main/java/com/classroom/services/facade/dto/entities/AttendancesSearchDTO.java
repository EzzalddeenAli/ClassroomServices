package com.classroom.services.facade.dto.entities;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.classroom.services.web.dto.mappers.LocalDateTimeAdapter;
import org.joda.time.LocalDateTime;




@XmlRootElement(name="searchHomework")
public class AttendancesSearchDTO{

	
    private LocalDateTime monthDate;
    private Integer studentId;
    private Integer batchId;
    private Integer count;
    
    public Integer getCount() {
		return count;
	}


	public void setCount(Integer count) {
		this.count = count;
	}


	@XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
	public LocalDateTime getMonthDate() {
    	System.out.println("he " + monthDate);
		return monthDate;
	}
    
    
	public void setMonthDate(LocalDateTime monthDate) {
		this.monthDate = monthDate;
	}
	
	
	public Integer getStudentId() {
		return studentId;
	}
	
	
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}


	public Integer getBatchId() {
		return batchId;
	}


	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}
    
}
