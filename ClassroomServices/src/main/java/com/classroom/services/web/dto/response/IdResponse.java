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
 * Response containing id for created entity JSON example:
 * 
 * <pre>
 * {"id": "id or uuid"}
 * </pre>
 * 
 * XML example:
 * 
 * <pre>
 * {@code
 * <id>
 *      id or uuid
 * </id>
 * }
 * </pre>
 */
@XmlRootElement(name = "id")
public class IdResponse {
    private UUID id;

    /**
     * Gets the id.
     * 
     * @return the id
     */
    @XmlValue
    public UUID getId() {
        return id;
    }

    /**
     * The Constructor.
     */
    public IdResponse() {
        super();
    }

    /**
     * The Constructor.
     * 
     * @param id
     *            the id
     */
    public IdResponse(UUID id) {
        super();
        this.id = id;
    }

}
