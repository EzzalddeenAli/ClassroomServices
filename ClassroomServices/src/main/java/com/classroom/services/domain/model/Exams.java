package com.classroom.services.domain.model;

import java.text.DecimalFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;


@Entity
@Table(name="exams")
public class Exams extends AbstractEntity<Integer>{

	@Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
	
    @Column(name = "exam_group_id")
    private Integer examGroupId;

    @Column(name = "subject_id")
    private Integer subjectId;

    @Column(name = "maximum_marks")
    private Integer maximumMarks;
    
    @Column(name = "minimum_marks")
    private Integer minimumMarks;

    @Column(name = "grading_level_id")
    private Integer gradingLevel;
    
    @Column(name = "weightage")
    private Integer Weightage;
    
    @Column(name = "event_id")
    private Integer eventId;
    
    @Column(name = "created_at")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime updated_at;
    
    @Column(name = "start_time")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime startTime;
    
    @Column(name = "end_time")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime endTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getExamGroupId() {
		return examGroupId;
	}

	public void setExamGroupId(Integer examGroupId) {
		this.examGroupId = examGroupId;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	

	public Integer getMaximumMarks() {
		return maximumMarks;
	}

	public void setMaximumMarks(Integer maximumMarks) {
		this.maximumMarks = maximumMarks;
	}

	public Integer getMinimumMarks() {
		return minimumMarks;
	}

	public void setMinimumMarks(Integer minimumMarks) {
		this.minimumMarks = minimumMarks;
	}

	public Integer getGradingLevel() {
		return gradingLevel;
	}

	public void setGradingLevel(Integer gradingLevel) {
		this.gradingLevel = gradingLevel;
	}

	public Integer getWeightage() {
		return Weightage;
	}

	public void setWeightage(Integer weightage) {
		Weightage = weightage;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

    
	
}
