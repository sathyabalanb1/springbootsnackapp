package com.ds.snackapp.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "dsusers", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Dsusers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@Column(unique=true)
	private String email;
	private String password;
//	private boolean status;
	
	@Column(name = "status", nullable = false, columnDefinition = "boolean default true")
	private boolean enabled = true;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
	private Role roleid ;	
	
	@CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP ")
    private LocalDateTime creationtime;
    
    @UpdateTimestamp
    @Column(columnDefinition = "TIMESTAMP",insertable = false)
    private LocalDateTime updatetime ;
    
    // below three are new columns
    
    @Column(name = "account_non_locked", nullable = false, columnDefinition = "boolean default true")
    private boolean accountNonLocked = true;
         
    @Column(name = "failed_attempt")
    private int failedAttempt;
         
    @Column(name = "lock_time")
    private Date lockTime;
    
    

    
    public boolean isAccountNonLocked() {
		return accountNonLocked;
	}
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	public int getFailedAttempt() {
		return failedAttempt;
	}
	public void setFailedAttempt(int failedAttempt) {
		this.failedAttempt = failedAttempt;
	}
	public Date getLockTime() {
		return lockTime;
	}
	public void setLockTime(Date lockTime) {
		this.lockTime = lockTime;
	}
	
	
	public Role getRoleid() {
		return roleid;
	}
	public void setRoleid(Role roleid) {
		this.roleid = roleid;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}		
	
}


