package com.classroom.services.facade.dto.entities;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;




@XmlRootElement(name="circulardetails")
public class CircularsDTO extends AbstractListDTO<CircularDTO> {
    /**
     * Gets the Circulars.
     * 
     * @return the Circulars
     */
    @XmlElementWrapper(name = "Circulars")
    @XmlElement(name = "Circular")
    public List<CircularDTO> getCircularDetails() {
        return getList();
    }

    /**
     * Sets the Circulars.
     * 
     * @param Circulars
     */
    public void setCirculars(List<CircularDTO> circulars) {
        setList(circulars);
    }
}
