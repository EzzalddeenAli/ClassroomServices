package com.classroom.services.domain.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

@Entity
@Table(name="batches")
public class Batches extends AbstractEntity<Integer>{
	
	@Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
	
    @Column(name = "name")
    private String name;
    
    
	@Column(name = "start_date")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime startDate;
    
    @Column(name = "end_date")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime endDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getCreatedAt() {
		return startDate;
	}

	public void setCreatedAt(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getUpdatedAt() {
		return endDate;
	}

	public void setUpdatedAt(LocalDateTime endDate) {
		this.endDate = endDate;
	}


}
