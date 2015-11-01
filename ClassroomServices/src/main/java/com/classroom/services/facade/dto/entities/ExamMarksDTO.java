package com.classroom.services.facade.dto.entities;

import java.text.DecimalFormat;

import javax.xml.bind.annotation.XmlRootElement;


import org.joda.time.LocalDateTime;



@XmlRootElement(name="exams")
public class ExamMarksDTO extends AbstractDTO<Integer>{

	private Integer id;
    private Integer subjectId;
    private Integer examGroupId;
    private Integer maximumMarks;
    private Integer minimumMarks;
    private Integer gradingLevelId;
    private Integer weightage;
    private Integer eventId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
	
	public Integer getExamGroupId() {
		return examGroupId;
	}
	public void setExamGroupId(Integer examGroupId) {
		this.examGroupId = examGroupId;
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
	public Integer getGradingLevelId() {
		return gradingLevelId;
	}
	public void setGradingLevelId(Integer gradingLevelId) {
		this.gradingLevelId = gradingLevelId;
	}
	public Integer getWeightage() {
		return weightage;
	}
	public void setWeightage(Integer weightage) {
		this.weightage = weightage;
	}
	public Integer getEventId() {
		return eventId;
	}
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}
}
