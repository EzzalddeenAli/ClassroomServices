/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.classroom.services.web.dto.response;

import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;


/**
 * Response containing recover token for password recovery JSON example:
 * 
 * <pre>
 * {"recoverToken": "uuid"}
 * </pre>
 * 
 * XML example:
 * 
 * <pre>
 * {@code
 * <recoverToken>
 *      uuid
 * </recoverToken>
 * }
 * </pre>
 */
@XmlRootElement(name = "recoverToken")
public class RecoverTokenResponse {
    private UUID recoverToken;

    /**
     * Gets the recover token.
     * 
     * @return the recover token
     */
    @XmlValue
    public UUID getRecoverToken() {
        return recoverToken;
    }

    /**
     * The Constructor.
     */
    public RecoverTokenResponse() {
        super();
    }

    /**
     * The Constructor.
     * 
     * @param recoverToken
     *            the recover token
     */
    public RecoverTokenResponse(UUID recoverToken) {
        super();
        this.recoverToken = recoverToken;
    }

}
