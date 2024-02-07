package com.ds.snackapp.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Assignment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String assigneddate;

	@UpdateTimestamp
	@Column(columnDefinition = "TIMESTAMP", insertable = false)
	private LocalDateTime updatetime;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	private Snack snack;

	@ManyToOne(cascade = CascadeType.DETACH)
	private Vendor vendor;

	@CreationTimestamp
	@Column(columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP ")
	private LocalDateTime creationtime;

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAssigneddate() {
		return assigneddate;
	}

	public void setAssigneddate(String assigneddate) {
		this.assigneddate = assigneddate;
	}

	public Snack getSnack() {
		return snack;
	}

	public void setSnack(Snack snack) {
		this.snack = snack;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
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
	@Override
	public String toString() {
		return "Assignment [id=" + id + ", assigneddate=" + assigneddate + ", snack=" + snack + ", vendor=" + vendor
				+ ", creationtime=" + creationtime + ", updatetime=" + updatetime + "]";
	}
}
