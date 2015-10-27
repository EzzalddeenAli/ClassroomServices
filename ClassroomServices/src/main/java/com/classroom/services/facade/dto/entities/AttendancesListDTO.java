/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author classroom
 */
package com.classroom.services.facade.dto.entities;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonPropertyOrder;


@XmlRootElement(name = "result")
@JsonPropertyOrder({ "attendances", "count", "pageCount" })
public class AttendancesListDTO extends AbstractListDTO<AttendancesDTO> {
    private Integer pageCount;
    private String errorCode;
    /**
     * Gets the attendances.
     * 
     * @return the attendances
     */
    @XmlElementWrapper(name = "attendances")
    @XmlElement(name = "attendances")
    public List<AttendancesDTO> getAttendances() {
        return getList();
    }

    /**
     * Sets the attendances.
     * 
     * @param attendances
     *            the attendances
     */
    public void setAttendances(List<AttendancesDTO> attendances) {
        setList(attendances);
    }

    /**
     * Gets the page count.
     * 
     * @return the page count
     */
    public Integer getPageCount() {
        return pageCount;
    }

    /**
     * Sets the page count.
     * 
     * @param pageCount
     *            the page count
     */
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}
