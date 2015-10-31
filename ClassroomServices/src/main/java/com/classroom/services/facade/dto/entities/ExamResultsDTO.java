package com.classroom.services.facade.dto.entities;

import java.text.DecimalFormat;

import javax.xml.bind.annotation.XmlRootElement;


import org.joda.time.LocalDateTime;



@XmlRootElement(name="examresults")
public class ExamResultsDTO extends AbstractDTO<Integer>{

	private Integer id;
    private String userId;
    private Integer studentId;
    private Integer examId;
    private Float Marks;
    private Integer GradingLevelId;
    private String Remarks;

	
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
		return Marks;
	}
	public void setMarks(Float marks) {
		Marks = marks;
	}
	public Integer getGradingLevelId() {
		return GradingLevelId;
	}
	public void setGradingLevelId(Integer gradingLevelId) {
		GradingLevelId = gradingLevelId;
	}
	public String getRemarks() {
		return Remarks;
	}
	public void setRemarks(String remarks) {
		Remarks = remarks;
	}
	
	
	
    
}
