/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.abharana.services.domain.model;

import static javax.persistence.FetchType.LAZY;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.abharana.services.domain.exceptions.DomainIllegalArgumentException;


@Entity
@Table(name = "User_Detail")
public class UserDetail extends AbstractEntity<UUID> {
    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private UUID id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "primary_phone")
    private String primaryPhone;
    @Column(name = "mobile_phone_number")
    private String mobilePhone;
    @Column(name = "home_phone_number")
    private String homePhone;
    @Column(name = "work_phone_number")
    private String workPhone;
    private String fax;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "uniquie_id")
    private String uniqueIdentifier;

    /**
     * The Constructor.
     */
    public UserDetail() {

    }

    /**
     * Gets the unique identifier.
     * 
     * @return the unique identifier
     */
    public String getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    /**
     * Sets the unique identifier.
     * 
     * @param uniqueIdentifier
     *            the unique identifier
     */
    public void setUniqueIdentifier(String uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
    }

    /**
     * Gets the first name.
     * 
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     * 
     * @param firstName
     *            the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the middle name.
     * 
     * @return the middle name
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Sets the middle name.
     * 
     * @param middleName
     *            the middle name
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Gets the last name.
     * 
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     * 
     * @param lastName
     *            the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the primary phone.
     * 
     * @return the primary phone
     */
    public String getPrimaryPhone() {
        return primaryPhone;
    }

    /**
     * Sets the primary phone.
     * 
     * @param primaryPhone
     *            the primary phone
     */
    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    /**
     * Gets the mobile phone.
     * 
     * @return the mobile phone
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * Sets the mobile phone.
     * 
     * @param mobilePhone
     *            the mobile phone
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /**
     * Gets the home phone.
     * 
     * @return the home phone
     */
    public String getHomePhone() {
        return homePhone;
    }

    /**
     * Sets the home phone.
     * 
     * @param homePhone
     *            the home phone
     */
    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    /**
     * Gets the work phone.
     * 
     * @return the work phone
     */
    public String getWorkPhone() {
        return workPhone;
    }

    /**
     * Sets the work phone.
     * 
     * @param workPhone
     *            the work phone
     */
    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    /**
     * Gets the fax.
     * 
     * @return the fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * Sets the fax.
     * 
     * @param fax
     *            the fax
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * Gets the gender.
     * 
     * @return the gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Sets the gender.
     * 
     * @param gender
     *            the gender
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public enum Gender {
        MALE, FEMALE;

        /**
         * From string.
         * 
         * @param s
         *            the s
         * @return the gender
         * @throws DomainIllegalArgumentException
         *             the domain illegal argument exception
         */
        public static Gender fromString(String s)
                throws DomainIllegalArgumentException {
            if (s == null || (s.length() == 0)) {
                throw new DomainIllegalArgumentException(
                        "Gender can not be empty");
            }
            for (Gender v : values()) {
                if (v.toString().equals(s)) {
                    return v;
                }
            }
            throw new DomainIllegalArgumentException(String.format(
                    "No such gender as %s", s));
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.abharana.services.domain.model.AbstractEntity#getId()
     */
    public UUID getId() {
        return id;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.abharana.services.domain.model.AbstractEntity#setId(java.lang.Object)
     */
    public void setId(UUID id) {
        this.id = id;
    }

}
