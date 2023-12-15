package com.ds.snackapp.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Id;


//import org.springframework.data.annotation.Id;
//import org.springframework.stereotype.Component;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String rolename;
//	private boolean status;

//	@Column(name = "`status`", nullable = false, columnDefinition = "default bit 1")
//    private boolean active = true;

//	@Column(name = "status", nullable = false)
//	private boolean enabled = true;

	@Column(name = "status", nullable = false, columnDefinition = "boolean default true")
	private boolean enabled = true;

	@Basic(optional = false)
	@Column(name = "created_at", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdat;

	@Basic(optional = false)
	@Column(name = "modified_at", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedat;
//	@OneToMany(cascade = CascadeType.ALL,mappedBy = "roleid")
//	private List<Dsusers>dsusers = new ArrayList();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

//	public boolean isStatus() {
//		return status;
//	}
//
//	public void setStatus(boolean status) {
//		this.status = status;
//	}

	public Date getCreatedat() {
		return createdat;
	}

	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}

	public Date getUpdatedat() {
		return updatedat;
	}

	public void setUpdatedat(Date updatedat) {
		this.updatedat = updatedat;
	}

}
