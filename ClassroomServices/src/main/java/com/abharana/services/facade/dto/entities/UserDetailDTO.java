/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.abharana.services.facade.dto.entities;

import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;

import com.abharana.services.facade.dto.IUserDependent;


/**
 * Transfer object for user detail information
 * 
 * JSON example:
 * 
 * <pre>
 * { "firstName":"first name", 
 *  "middleName":"middle name",
 *  "lastName":"last name",
 *  "primaryPhone":"phone number",
 *  "mobilePhone":"phone number",
 *  "homePhone":"phone number",
 *  "workPhone":"phone number",
 *  "fax":"phone number",
 *  "gender":"male",
 *  "uniqueId":"unique identifier",
 *  "userId":"user id"}
 * </pre>
 * 
 * XML example:
 * 
 * <pre>
 * {@code
 * <detail>
 *      <firstName>
 *          first name
 *      </firstName>
 *      <middleName>
 *          middle name
 *      </middleName>
 *      <lastName>
 *          last name
 *      </lastName>
 *      <primaryPhone>
 *          phone number
 *      </primaryPhone>
 *      <mobilePhone>
 *          phone number
 *      </mobilePhone>
 *      <homePhone>
 *          phone number
 *      </homePhone>
 *      <workPhone>
 *          phone number
 *      </workPhone>
 *      <fax>
 *          phone number
 *      </fax>
 *      <gender>
 *          male
 *      </gender>
 *      <uniqueId>
 *          unique identifier
 *      </uniqueId>
 *      <userId>
 *          user id
 *      </userId>
 * </detail>
 * }
 * </pre>
 */
@XmlRootElement(name = "detail")
public class UserDetailDTO implements IUserDependent {
    private String firstName;
    private String middleName;
    private String lastName;

    private String primaryPhone;
    private String mobilePhone;
    private String homePhone;

    private String workPhone;
    private String fax;

    private String gender;

    private String uniqueId;
    private UUID userId;

    /**
     * The Constructor.
     */
    public UserDetailDTO() {
    }

    /**
     * The Constructor.
     * 
     * @param firstName
     *            the first name
     * @param middleName
     *            the middle name
     * @param lastName
     *            the last name
     * @param primaryPhone
     *            the primary phone
     * @param mobilePhone
     *            the mobile phone
     * @param homePhone
     *            the home phone
     * @param workPhone
     *            the work phone
     * @param fax
     *            the fax
     * @param gender
     *            the gender
     * @param uniqueId
     *            the unique id
     * @param userId
     *            the user id
     */
    public UserDetailDTO(String firstName, String middleName, String lastName,
            String primaryPhone, String mobilePhone, String homePhone,
            String workPhone, String fax, String gender, String uniqueId,
            UUID userId) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.primaryPhone = primaryPhone;
        this.mobilePhone = mobilePhone;
        this.homePhone = homePhone;
        this.workPhone = workPhone;
        this.fax = fax;
        this.gender = gender;
        this.uniqueId = uniqueId;
        this.userId = userId;
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

    /*
     * (non-Javadoc)
     * 
     * @see com.abharana.services.facade.dto.IUserDependent#getUserId()
     */
    public UUID getUserId() {
        return userId;
    }

    /**
     * Sets the user id.
     * 
     * @param userId
     *            the user id
     */
    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    /**
     * Gets the gender.
     * 
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the gender.
     * 
     * @param gender
     *            the gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets the unique id.
     * 
     * @return the unique id
     */
    public String getUniqueId() {
        return uniqueId;
    }

    /**
     * Sets the unique id.
     * 
     * @param uniqueId
     *            the unique id
     */
    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }
}
