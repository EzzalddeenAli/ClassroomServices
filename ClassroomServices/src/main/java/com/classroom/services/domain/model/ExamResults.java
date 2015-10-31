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
@Table(name="exam_scores")
public class ExamResults extends AbstractEntity<Integer>{

	@Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
	
    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "exam_id")
    private Integer examId;

    @Column(name = "marks")
    private Float marks;

    @Column(name = "grading_level_id")
    private Integer gradingLevel;
    
    @Column(name = "remarks")
    private String remarks;
    
    @Column(name = "is_failed")
   private Integer isFailed;
    
    @Column(name = "created_at")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime updated_at;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getExamId() {
		return examId;
	}

	public void setExamId(Integer examId) {
		this.examId = examId;
	}

	

	public Float getMarks() {
		return marks;
	}

	public void setMarks(Float marks) {
		this.marks = marks;
	}

	public Integer getGradingLevel() {
		return gradingLevel;
	}

	public void setGradingLevel(Integer gradingLevel) {
		this.gradingLevel = gradingLevel;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	

	public Integer getIsFailed() {
		return isFailed;
	}

	public void setIsFailed(Integer isFailed) {
		this.isFailed = isFailed;
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

	


	
}
