/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.classroom.services.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user")
public class User extends AbstractEntity<Integer> implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "UserID")
    private Integer id;

    @Column(name = "CustomerID")
    private String customerId;

    @Column(name = "UserName")
    private String userName;

    @Column(name = "Password")
    private String password;

    @Column(name = "Status")
    private String status;

    /*
     * (non-Javadoc)
     * 
     * @see com.classroom.services.domain.model.AbstractEntity#getId()
     */
    public Integer getId() {
        return id;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.classroom.services.domain.model.AbstractEntity#setId(java.lang.Object)
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the customer id.
     * 
     * @return the customer id
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Sets the customer id.
     * 
     * @param customerId
     *            the customer id
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets the user name.
     * 
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the user name.
     * 
     * @param userName
     *            the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
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
}
