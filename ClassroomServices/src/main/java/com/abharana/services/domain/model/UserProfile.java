/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.abharana.services.domain.model;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import com.abharana.services.domain.exceptions.DomainIllegalArgumentException;


@Entity
@Table(name = "User_Profile")
public class UserProfile extends AbstractEntity<UUID> {
    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private UUID id;

    private String username;
    private String email;
    private String password;
    @Column(name = "last_login")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime lastLogin;
    @Column(name = "creation_date")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime creationDate;
    @Column(name = "update_date")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime updateDate;

    @Enumerated(EnumType.ORDINAL)
    private UserStatus status = UserStatus.NEW;

    @Type(type = "uuid-char")
    @Column(name = "login_token")
    private UUID loginToken;
    @Column(name = "failed_login_attempts")
    private int failedLoginAttempts;
    @Type(type = "uuid-char")
    @Column(name = "recover_token")
    private UUID recoverToken;
    @Column(name = "recover_date")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime recoverDate;

    @ManyToOne(fetch = EAGER, cascade = ALL)
    @JoinColumn(name="user_detail_id", nullable = true)
    private UserDetail detail;

    /**
     * The Constructor.
     */
    public UserProfile() {

    }

    /**
     * Gets the password.
     * 
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     * 
     * @param password
     *            the password
     */
    public void setPassword(String password) {
        this.password = password;
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
     * Gets the last login.
     * 
     * @return the last login
     */
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

    /**
     * Gets the status.
     * 
     * @return the status
     */
    public UserStatus getStatus() {
        return status;
    }

    /**
     * Sets the status.
     * 
     * @param status
     *            the status
     */
    public void setStatus(UserStatus status) {
        this.status = status;
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
     * Gets the detail.
     * 
     * @return the detail
     */
    public UserDetail getDetail() {
        return detail;
    }

    /**
     * Sets the detail.
     * 
     * @param detail
     *            the detail
     */
    public void setDetail(UserDetail detail) {
        this.detail = detail;
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
     * Adds the failed login attempt.
     */
    public void addFailedLoginAttempt() {
        this.failedLoginAttempts += 1;
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

    public enum UserStatus {

        // ATTENTION! Do not change the order of these values without changing
        // the DDL where indexes of these enum values are used!
        NEW, ACTIVE, EXPIRED, LOCKED, DELETED;

        /**
         * From string.
         * 
         * @param s
         *            the s
         * @return the user status
         * @throws DomainIllegalArgumentException
         *             the domain illegal argument exception
         */
        public static UserStatus fromString(String s)
                throws DomainIllegalArgumentException {
            if (s == null || (s.length() == 0)) {
                throw new DomainIllegalArgumentException(
                        "UserProfile status can not be empty");
            }
            for (UserStatus v : values()) {
                if (v.toString().equals(s)) {
                    return v;
                }
            }
            throw new DomainIllegalArgumentException(String.format(
                    "No such user status as %s", s));
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
