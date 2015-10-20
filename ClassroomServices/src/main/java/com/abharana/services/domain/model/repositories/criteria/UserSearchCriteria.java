/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.abharana.services.domain.model.repositories.criteria;

import java.util.UUID;

import org.joda.time.LocalDateTime;


/**
 * Search filter for UserProfile
 * 
 * @author mkol
 * 
 */
public class UserSearchCriteria extends BaseSearchCriteria {
    private String username;
    private String email;

    private LocalDateTime lastLogin;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;

    private String status;
    private UUID loginToken;
    private int failedLoginAttempts;
    private UUID recoverToken;
    private LocalDateTime recoverDate;

    private String firstName;
    private String middleName;
    private String lastName;

    /**
     * The Constructor.
     */
    public UserSearchCriteria() {

    }

    /**
     * The Constructor.
     * 
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
     * @param orderField
     *            the order field
     * @param startIndex
     *            the start index
     * @param pageSize
     *            the page size
     */
    public UserSearchCriteria(String username, String email, String status,
            LocalDateTime lastLogin, LocalDateTime creationDate,
            LocalDateTime updateDate, String orderField, int startIndex,
            int pageSize) {
        this.username = username;
        this.email = email;
        this.status = status;
        this.lastLogin = lastLogin;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.setOrderField(orderField);
        this.setStartIndex(startIndex);
        this.setPageSize(pageSize);
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
     * Gets the email.
     * 
     * @return the email
     */
    public String getEmail() {
        return email;
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
     * Gets the last login.
     * 
     * @return the last login
     */
    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    /**
     * Gets the creation date.
     * 
     * @return the creation date
     */
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * Gets the update date.
     * 
     * @return the update date
     */
    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    /**
     * Gets the login token.
     * 
     * @return the login token
     */
    public UUID getLoginToken() {
        return loginToken;
    }

    /**
     * Sets the login token.
     * 
     * @param loginToken
     *            the login token
     */
    public void setLoginToken(UUID loginToken) {
        this.loginToken = loginToken;
    }

    /**
     * Gets the failed login attempts.
     * 
     * @return the failed login attempts
     */
    public int getFailedLoginAttempts() {
        return failedLoginAttempts;
    }

    /**
     * Sets the failed login attempts.
     * 
     * @param failedLoginAttempts
     *            the failed login attempts
     */
    public void setFailedLoginAttempts(int failedLoginAttempts) {
        this.failedLoginAttempts = failedLoginAttempts;
    }

    /**
     * Gets the recover token.
     * 
     * @return the recover token
     */
    public UUID getRecoverToken() {
        return recoverToken;
    }

    /**
     * Sets the recover token.
     * 
     * @param recoverToken
     *            the recover token
     */
    public void setRecoverToken(UUID recoverToken) {
        this.recoverToken = recoverToken;
    }

    /**
     * Gets the recover date.
     * 
     * @return the recover date
     */
    public LocalDateTime getRecoverDate() {
        return recoverDate;
    }

    /**
     * Sets the recover date.
     * 
     * @param recoverDate
     *            the recover date
     */
    public void setRecoverDate(LocalDateTime recoverDate) {
        this.recoverDate = recoverDate;
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
     * Sets the email.
     * 
     * @param email
     *            the email
     */
    public void setEmail(String email) {
        this.email = email;
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
     * Sets the creation date.
     * 
     * @param creationDate
     *            the creation date
     */
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
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

}
