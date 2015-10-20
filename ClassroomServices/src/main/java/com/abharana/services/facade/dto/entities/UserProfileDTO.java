/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.abharana.services.facade.dto.entities;

import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDateTime;

import com.abharana.services.facade.dto.IUserDependent;
import com.abharana.services.util.BankingConstants;
import com.abharana.services.web.dto.mappers.LocalDateTimeAdapter;


/**
 * Transfer object for user common information
 * 
 * JSON example:
 * 
 * <pre>
 * {"id":"id",
 *  "username":"username",
 *  "email":"some@email.com",
 *  "lastLogin":"date in format",
 *  "creationDate":"date in format",
 *  "updateDate":"date in format",
 *  "status":"ACTIVE"}
 * </pre>
 * 
 * XML example:
 * 
 * <pre>
 * {@code
 * <user>
 *      <id>
 *          id
 *      </id>
 *      <username>
 *          username
 *      </username>
 *      <email>
 *          some@email.com
 *      </email>
 *      <lastLogin>
 *          date in format
 *      </lastLogin>
 *      <creationDate>
 *          date in format
 *      </creationDate>
 *      <updateDate>
 *          date in format
 *      </updateDate>
 *      <status>
 *          ACTIVE
 *      </status>
 * </user>
 * }
 * </pre>
 */
@XmlRootElement(name = "user")
public class UserProfileDTO extends AbstractDTO<UUID> implements IUserDependent {
    @NotEmpty
    @Length(max = BankingConstants.NUMBER_HUNDRED)
    private String username;
    private String email;

    private LocalDateTime lastLogin;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;

    private String status;

    /**
     * The Constructor.
     */
    public UserProfileDTO() {
        super();
    }

    /**
     * The Constructor.
     * 
     * @param id
     *            the id
     * @param username
     *            the username
     * @param email
     *            the email
     * @param status
     *            the status
     * @param lastLogin
     *            the last login
     * @param creationDate
     *            the creation date
     * @param updateDate
     *            the update date
     */
    public UserProfileDTO(UUID id, String username, String email,
            String status, LocalDateTime lastLogin, LocalDateTime creationDate,
            LocalDateTime updateDate) {
        super(id);
        this.username = username;
        this.email = email;
        this.status = status;
        this.lastLogin = lastLogin;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    /**
     * Gets the username.
     * 
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username.
     * 
     * @param username
     *            the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the email.
     * 
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     * 
     * @param email
     *            the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the status.
     * 
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     * 
     * @param status
     *            the status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the last login.
     * 
     * @return the last login
     */
    @XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    /**
     * Sets the last login.
     * 
     * @param lastLogin
     *            the last login
     */
    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    /**
     * Gets the creation date.
     * 
     * @return the creation date
     */
    @XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the creation date.
     * 
     * @param creationDate
     *            the creation date
     */
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets the update date.
     * 
     * @return the update date
     */
    @XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    /**
     * Sets the update date.
     * 
     * @param updateDate
     *            the update date
     */
    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.abharana.services.facade.dto.IUserDependent#getUserId()
     */
    @JsonIgnore
    @XmlTransient
    public UUID getUserId() {
        return id;
    }

	public UUID getId() {
		return super.getId();
	}

	public void setId(UUID id) {
		super.setId(id);
	}

}
