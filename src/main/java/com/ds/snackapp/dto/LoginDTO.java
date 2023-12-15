package com.ds.snackapp.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import com.ds.snackapp.service.DsuserService;

public class LoginDTO {
	
	private String email;
	
    private String password;
    
    @Autowired
	private DsuserService  service;
	
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
	
}
