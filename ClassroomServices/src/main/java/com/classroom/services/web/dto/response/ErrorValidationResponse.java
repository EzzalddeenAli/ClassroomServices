/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.classroom.services.web.dto.response;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * Validation error for specific field.
 * 
 * JSON example:
 * 
 * <pre>
 * {"error": ["path":"field name","error":"some error message"]}
 * </pre>
 * 
 * XML example:
 * 
 * <pre>
 * {@code
 * <error>
 *      <path>
 *          field name
 *      </path>
 *      <message>
 *          some error message
 *      </message>
 * </error>
 * }
 * </pre>
 */
@XmlRootElement(name = "error")
public class ErrorValidationResponse {
    private String path;
    private String message;

    /**
     * The Constructor.
     */
    public ErrorValidationResponse() {
        super();
    }

    /**
     * Gets the path.
     * 
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets the path.
     * 
     * @param path
     *            the path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Gets the message.
     * 
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message.
     * 
     * @param message
     *            the message
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
