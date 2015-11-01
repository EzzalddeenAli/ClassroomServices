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
public class ExamMarksListDTO extends AbstractListDTO<ExamMarksDTO> {
    private Integer pageCount;

    
    @XmlElementWrapper(name = "examresults")
    @XmlElement(name = "examresults")
    public List<ExamMarksDTO> getExamMarks() {
        return getList();
    }
    
    public void setExamMarks(List<ExamMarksDTO> exammarks) {
        setList(exammarks);
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
