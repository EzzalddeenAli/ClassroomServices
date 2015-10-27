package com.classroom.services.facade.dto.entities;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.classroom.services.web.dto.mappers.LocalDateTimeAdapter;
import org.joda.time.LocalDateTime;




@XmlRootElement(name="searchHomework")
public class HomeworkSearchDTO{

	
    private LocalDateTime startTime;
    
	/**
     * Gets the startDate.
     * 
     * @return the startDate.
     */
	@XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
	public LocalDateTime getStartDate() {
		System.out.println("he " + startTime);
		return startTime;
	}

	public void setStartDate(LocalDateTime startTime) {
		this.startTime = startTime;
	}
}
