package com.classroom.services.facade.dto.entities;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.classroom.services.web.dto.mappers.LocalDateTimeAdapter;
import org.joda.time.LocalDateTime;




@XmlRootElement(name="searchCirculars")
public class CircularSearchDTO{

	
    private LocalDateTime startDate;
    private boolean isExam;
    private Integer id;
    
	/**
     * Gets the startDate.
     * 
     * @return the startDate.
     */
	@XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
	public LocalDateTime getStartDate() {
		System.out.println("he " + startDate);
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public boolean getIsExam() {
		return isExam;
	}

	public void setIsExam(boolean isExam) {
		this.isExam = isExam;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
