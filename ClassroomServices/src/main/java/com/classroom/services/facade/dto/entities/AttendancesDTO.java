package com.classroom.services.facade.dto.entities;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.joda.time.LocalDateTime;

import com.classroom.services.web.dto.mappers.LocalDateTimeAdapter;




@XmlRootElement(name="homework")
public class AttendancesDTO extends AbstractDTO<Integer>{

	 	private Integer id;
	    private Integer studentId;
	    private Integer batchId;
	    private LocalDateTime monthDate;
	    private Boolean forenoon;
	    private Boolean afternoon;
	    private String reason;
	    private String errorCode;
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
		
		@XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
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
		public String getErrorCode() {
			return errorCode;
		}
		public void setErrorCode(String errorCode) {
			this.errorCode = errorCode;
		}

    
}
