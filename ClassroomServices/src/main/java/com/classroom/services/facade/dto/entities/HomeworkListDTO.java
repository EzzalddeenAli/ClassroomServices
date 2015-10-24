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
@JsonPropertyOrder({ "transfers", "count", "pageCount" })
public class HomeworkListDTO extends AbstractListDTO<HomeworkDTO> {
    private Integer pageCount;

    /**
     * Gets the homeworks.
     * 
     * @return the homeworks
     */
    @XmlElementWrapper(name = "homework")
    @XmlElement(name = "homework")
    public List<HomeworkDTO> getHomeworks() {
        return getList();
    }

    /**
     * Sets the homeworks.
     * 
     * @param Homeworks
     *            the homeworks
     */
    public void setHomeworks(List<HomeworkDTO> homeworks) {
        setList(homeworks);
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

}
