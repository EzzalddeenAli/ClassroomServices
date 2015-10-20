/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.classroom.services.web.dto.response;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;


/**
 * Response containing generated password JSON example:
 * 
 * <pre>
 * {"password": "password"}
 * </pre>
 * 
 * XML example:
 * 
 * <pre>
 * {@code
 * <password>
 *      password
 * </password>
 * }
 * </pre>
 */
@XmlRootElement(name = "password")
public class PasswordResponse {
    private String password;

    /**
     * The Constructor.
     */
    public PasswordResponse() {

    }

    /**
     * The Constructor.
     * 
     * @param password
     *            the password
     */
    public PasswordResponse(String password) {
        this.password = password;
    }

    /**
     * Gets the password.
     * 
     * @return the password
     */
    @XmlValue
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

}
