/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.abharana.services.web.dto.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Validation error for specific field.
 * 
 * JSON example:
 * 
 * <pre>
 * {"errors": [{validation error structure}, {validation error structure}]}
 * </pre>
 * 
 * XML example:
 * 
 * <pre>
 * {@code
 * <errors>
 *      <error>
 *          validation error structure
 *      </error>
 *      <error>
 *          validation error structure
 *      </error>
 *      .
 *      .
 *      .
 * </errors>
 * }
 * </pre>
 * 
 * @see ErrorValidationResponse - validation error
 */
@XmlRootElement(name = "errors")
public class ErrorsValidationResponse extends BasicResponse {
    @XmlElement(name = "error")
    private List<ErrorValidationResponse> errors = new ArrayList<ErrorValidationResponse>();

    /**
     * Adds the error.
     * 
     * @param error
     *            the error
     */
    public void addError(ErrorValidationResponse error) {
        this.errors.add(error);
    }

    /**
     * Gets the errors.
     * 
     * @return the errors
     */
    public List<ErrorValidationResponse> getErrors() {
        return errors;
    }

}
