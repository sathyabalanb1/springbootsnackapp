package com.ds.snackapp.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.ds.snackapp.entity.Assignment;
import com.ds.snackapp.entity.Dsusers;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Selection {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Assignment assignment;
	

	@ManyToOne(cascade = CascadeType.ALL)
	private Dsusers dsuser;
	
	@Column(name = "isselected", nullable = false,columnDefinition = "boolean default true")
	private boolean enabled;
	
	@CreationTimestamp
	@Column(columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP ")
	private LocalDateTime creationtime;
	
	@UpdateTimestamp
	@Column(columnDefinition = "TIMESTAMP", insertable = false)
	private LocalDateTime updatetime;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	public Dsusers getDsuser() {
		return dsuser;
	}

	public void setDsuser(Dsusers dsuser) {
		this.dsuser = dsuser;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public LocalDateTime getCreationtime() {
		return creationtime;
	}

	public void setCreationtime(LocalDateTime creationtime) {
		this.creationtime = creationtime;
	}

	public LocalDateTime getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(LocalDateTime updatetime) {
		this.updatetime = updatetime;
	}


}
