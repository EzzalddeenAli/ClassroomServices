package com.classroom.services.facade.dto.entities;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.classroom.services.web.dto.mappers.LocalDateTimeAdapter;
import org.joda.time.LocalDateTime;




@XmlRootElement(name="circulardetails")
public class CircularDTO extends AbstractDTO<Integer>{

	private Integer id;
    private String title;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean isCommon;
    private boolean isHoliday;
    private boolean isExam;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    private String errorCode;

    public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTile(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
     * Gets the startDate.
     * 
     * @return the startDate.
     */
	@XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	
	/**
     * Gets the endDate.
     * 
     * @return the endDate.
     */
	@XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
	public LocalDateTime getEndDate() {
		return endDate;
	}
	
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	
	public boolean getIsCommon() {
		return isCommon;
	}

	public void setIsCommon(boolean isCommon) {
		this.isCommon = isCommon;
	}
	
	public boolean getIsHoliday() {
		return isHoliday;
	}

	public void setIsHoliday(boolean isHoliday) {
		this.isHoliday = isHoliday;
	}

	public boolean getIsExam() {
		return isExam;
	}

	public void setIsExam(boolean isExam) {
		this.isExam = isExam;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}    
}
