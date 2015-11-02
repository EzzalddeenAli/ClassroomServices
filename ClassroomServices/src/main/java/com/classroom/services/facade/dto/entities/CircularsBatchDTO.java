package com.classroom.services.facade.dto.entities;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;




@XmlRootElement(name="circularBatchDetails")
public class CircularsBatchDTO extends AbstractListDTO<CircularBatchDTO> {
    /**
     * Gets the Circulars.
     * 
     * @return the Circulars
     */
    @XmlElementWrapper(name = "CircularsBatch")
    @XmlElement(name = "CircularBatch")
    public List<CircularBatchDTO> getCircularBatchDetails() {
        return getList();
    }

    /**
     * Sets the Circulars.
     * 
     * @param Circulars
     */
    public void setCircularsBatch(List<CircularBatchDTO> circularsBatch) {
        setList(circularsBatch);
    }

}
