/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.abharana.services.web.dto.response;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;


@XmlRootElement(name = "result")
public class SuccessResponse {
    private String result = "success";

    /**
     * Gets the result.
     * 
     * @return the result
     */
    @XmlValue
    public String getResult() {
        return result;
    }

    /**
     * Sets the result.
     * 
     * @param result
     *            the result
     */
    public void setResult(String result) {
        this.result = result;
    }
}
