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
@Table(name="students")
public class Students extends AbstractEntity<Integer>{

	@Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
	
	@ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "admission_no")
    private Integer admissionNo;

    @Column(name = "class_roll_no")
    private Integer classRollNo;

    @Column(name = "admission_date")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime admissionDate;

    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "middle_name")
    private String middleName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "batch_id")
    private Integer batchId;

    @Column(name = "date_of_birth")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime dateOfBirth;

    @Column(name = "gender")
    private String gender;

    @Column(name = "blood_group")
    private String bloodGroup;

    @Column(name = "birth_place")
    private String birthPlace;

    @Column(name = "nationality_id")
    private Integer nationalityId;
    
    

    @Column(name = "religion")
    private String religion;

    @Column(name = "student_category_id")
    private Integer studentCategoryId;
    
    @Column(name = "address_line1")
    private String addressLine1;

    @Column(name = "address_line2")
    private String addressLine2;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "state")
    private String state;
    
    @Column(name = "pin_code")
    private Integer pinCode;
    
    @Column(name = "country_id")
    private Integer countryId;
    
    @Column(name = "phone1")
    private Integer phone1;
    
    @Column(name = "phone2")
    private Integer phone2;
    
    @Column(name = "immediate_contact_id")
    private Integer immediateContactId;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "is_sms_enabled")
    private String isSmsEnabled;
    
    @Column(name = "photo_file_name")
    private String photoFileName;
    
    @Column(name = "photo_content_type")
    private String photoContentType;
    
    @Column(name = "photo_data")
    private String photoData;
    
    @Column(name = "status_description")
    private String statusDescription;
    
    @Column(name = "is_active")
    private Integer isActive;
    
    @Column(name = "is_deleted")
    private Integer isDeleted;
    
    @Column(name = "has_paid_fees")
    private Integer hasPaidFees;
    
    @Column(name = "language")
    private String language;

    public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Integer getHasPaidFees() {
		return hasPaidFees;
	}

	public void setHasPaidFees(Integer hasPaidFees) {
		this.hasPaidFees = hasPaidFees;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getAdmissionNo() {
		return admissionNo;
	}

	public void setAdmissionNo(Integer admissionNo) {
		this.admissionNo = admissionNo;
	}

	public Integer getClassRollNo() {
		return classRollNo;
	}

	public void setClassRollNo(Integer classRollNo) {
		this.classRollNo = classRollNo;
	}

	public LocalDateTime getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(LocalDateTime admissionDate) {
		this.admissionDate = admissionDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getBatchId() {
		return batchId;
	}

	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

	public LocalDateTime getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDateTime dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public Integer getNationalityId() {
		return nationalityId;
	}

	public void setNationalityId(Integer nationalityId) {
		this.nationalityId = nationalityId;
	}

	

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public Integer getStudentCategoryId() {
		return studentCategoryId;
	}

	public void setStudentCategoryId(Integer studentCategoryId) {
		this.studentCategoryId = studentCategoryId;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public Integer getPhone1() {
		return phone1;
	}

	public void setPhone1(Integer phone1) {
		this.phone1 = phone1;
	}

	public Integer getPhone2() {
		return phone2;
	}

	public void setPhone2(Integer phone2) {
		this.phone2 = phone2;
	}

	public Integer getImmediateContactId() {
		return immediateContactId;
	}

	public void setImmediateContactId(Integer immediateContactId) {
		this.immediateContactId = immediateContactId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIsSmsEnabled() {
		return isSmsEnabled;
	}

	public void setIsSmsEnabled(String isSmsEnabled) {
		this.isSmsEnabled = isSmsEnabled;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

	public String getPhotoData() {
		return photoData;
	}

	public void setPhotoData(String photoData) {
		this.photoData = photoData;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	

	
	
}
