package com.classroom.services.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;


@Entity
@Table(name="attendances")
public class Attendances extends AbstractEntity<Integer>{

	@Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
	
	@Column(name = "student_id", nullable = false)
    private Integer studentId;
	
	@Column(name = "batch_id", nullable = false)
    private Integer batchId;

    @Column(name = "month_date")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime monthDate;
    
    @Column(name = "forenoon")
    private Boolean forenoon;
    
    @Column(name = "afternoon")
    private Boolean afternoon;

    @Column(name = "reason")
    private String reason;

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

	public Integer getBatchId() {
		return batchId;
	}

	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

	public LocalDateTime getMonthDate() {
		return monthDate;
	}

	public void setMonthDate(LocalDateTime monthDate) {
		this.monthDate = monthDate;
	}

	public Boolean getForenoon() {
		return forenoon;
	}

	public void setForenoon(Boolean forenoon) {
		this.forenoon = forenoon;
	}

	public Boolean getAfternoon() {
		return afternoon;
	}

	public void setAfternoon(Boolean afternoon) {
		this.afternoon = afternoon;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
    
    
	
}
