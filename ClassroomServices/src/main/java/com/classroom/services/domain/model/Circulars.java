package com.classroom.services.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

@Entity
@Table(name="events")
public class Circulars extends AbstractEntity<Integer>{

	@Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
	
    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "start_date")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime startDate;
    
    @Column(name = "end_date")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime endDate;

    @Column(name = "is_common")
    private boolean isCommon;
    
    @Column(name = "is_holiday")
    private boolean isHoliday;
    
    @Column(name = "is_exam")
    private boolean isExam;
    
    @Column(name = "created_at")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime updatedAt;

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

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

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
