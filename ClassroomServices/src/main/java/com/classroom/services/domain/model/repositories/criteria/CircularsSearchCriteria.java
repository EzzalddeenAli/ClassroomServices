/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.classroom.services.domain.model.repositories.criteria;


public class CircularsSearchCriteria extends BaseSearchCriteria {
 
    private String status;
    private String filter;

    /**
     * Gets the status.
     * 
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     * 
     * @param status
     *            the status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the filter.
     * 
     * @return the filter
     */
    public String getFilter() {
        return filter;
    }

    /**
     * Sets the filter.
     * 
     * @param filter
     *            the filter
     */
    public void setFilter(String filter) {
        this.filter = filter;
    }

}
