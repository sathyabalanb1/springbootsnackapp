package com.ds.snackapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ds.snackapp.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Integer> {

	
	public List<Role> findByRolename(String rolename);
	
}
