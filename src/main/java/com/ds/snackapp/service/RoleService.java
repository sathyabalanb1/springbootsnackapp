package com.ds.snackapp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ds.snackapp.entity.Role;
import com.ds.snackapp.repository.RoleRepository;

public class RoleService {
	@Autowired
	private RoleRepository repository;
	
	public Role createRole(Role role) {
        return repository.save(role);
    }
	public Role getRoleById(int id) {
        return repository.findById(id).orElse(null);
    }

}
