/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.classroom.services.web.dto.request;

import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * Request for role creation
 * 
 * JSON example:
 * 
 * <pre>
 * {"name":"rolename", 
 *  "description":"some description"}
 * </pre>
 * 
 * XML example:
 * 
 * <pre>
 * {@code
 * <role>
 *      <name>
 *          rolename
 *      </name>
 *      <description>
 *          some description
 *      </description>
 * </role>
 * }
 * </pre>
 * 
 * Name should not be empty
 */
@XmlRootElement(name = "role")
public class RoleRequest extends BasicRequest {
    @NotEmpty
    private String name;
    private String description;

    /**
     * The Constructor.
     */
    public RoleRequest() {
        super();
    }

    /**
     * The Constructor.
     * 
     * @param name
     *            the name
     * @param description
     *            the description
     */
    public RoleRequest(String name, String description) {
        super();
        this.name = name;
        this.description = description;
    }

    /**
     * Gets the name.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     * 
     * @param name
     *            the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description.
     * 
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     * 
     * @param description
     *            the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
