package com.abharana.services.facade.dto.entities;

import javax.xml.bind.annotation.XmlRootElement;


import org.joda.time.LocalDateTime;



@XmlRootElement(name="studentdetails")
public class StudentsDTO extends AbstractDTO<Integer>{

	private Integer id;
    private String userId;
    private Integer AdmissionNo;
    private Integer ClassRollNo;
    private String firstName;
    private String MiddleName;
    private String lastName;
    private String gender;
    private LocalDateTime dateOfBirth;
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
	public Integer getAdmissionNo() {
		return AdmissionNo;
	}
	public void setAdmissionNo(Integer admissionNo) {
		AdmissionNo = admissionNo;
	}
	public Integer getClassRollNo() {
		return ClassRollNo;
	}
	public void setClassRollNo(Integer classRollNo) {
		ClassRollNo = classRollNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return MiddleName;
	}
	public void setMiddleName(String middleName) {
		MiddleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDateTime getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDateTime dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
    
}
