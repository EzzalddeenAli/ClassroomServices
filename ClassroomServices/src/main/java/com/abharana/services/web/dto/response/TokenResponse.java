/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.abharana.services.web.dto.response;

import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;


/**
 * Response containing login token for accessing secure urls JSON example:
 * 
 * <pre>
 * {"token": "uuid"}
 * </pre>
 * 
 * XML example:
 * 
 * <pre>
 * {@code
 * <token>
 *      uuid
 * </token>
 * }
 * </pre>
 */
@XmlRootElement(name = "token")
public class TokenResponse {
    private UUID token;

    /**
     * Gets the token.
     * 
     * @return the token
     */
    @XmlValue
    public UUID getToken() {
        return token;
    }

    /**
     * Sets the token.
     * 
     * @param token
     *            the token
     */
    public void setToken(UUID token) {
        this.token = token;
    }
}
