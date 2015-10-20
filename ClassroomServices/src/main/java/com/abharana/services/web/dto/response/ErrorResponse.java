/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.abharana.services.web.dto.response;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;


/**
 * Response for representing single error.
 * 
 * JSON example:
 * 
 * <pre>
 * {"error": "some error message"}
 * </pre>
 * 
 * XML example:
 * 
 * <pre>
 * {@code
 * <error>
 *      some error message
 * </error>
 * }
 * </pre>
 */
@XmlRootElement(name = "error")
public class ErrorResponse {
    private String error;

    /**
     * The Constructor.
     */
    public ErrorResponse() {
    }

    /**
     * The Constructor.
     * 
     * @param error
     *            the error
     */
    public ErrorResponse(String error) {
        super();
        this.error = error;
    }

    /**
     * Gets the error.
     * 
     * @return the error
     */
    @XmlValue
    public String getError() {
        return error;
    }

}
