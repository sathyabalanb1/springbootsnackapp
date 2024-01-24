package com.ds.snackapp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ds.snackapp.entity.Dsusers;
import com.ds.snackapp.entity.Role;
import com.ds.snackapp.repository.RoleRepository;
@Service
public class RoleService {
	@Autowired
	private RoleRepository repository;
	
	public Role createRole(Role role) {
        return repository.save(role);
    }
	public Role getRoleById(int id) {
        return repository.findById(id).orElse(null);
    }
	public List<Role> fetchAllRole(){
		return repository.findAll();
	}
	
	
	
	public Map fetchRoleBasedEmployeeCount(List<Dsusers>allemps,List<Role>rls)
	{
		int i =0, superadmincount=0, admincount=0,usercount=0;
		
		while(i<allemps.size())
		{
			Dsusers u = allemps.get(i);
			
			if(u.getRoleid().getId() == 1)
			{
				superadmincount++;
			}
			else if(u.getRoleid().getId() == 2)
			{
				admincount++;
			}
			else
			{
				usercount++;
			}
			i++;
		}
		
		Map<String, Integer> myMap = new HashMap<String, Integer>();
		
		myMap.put("SuperAdmin", superadmincount );
		myMap.put("Admin", admincount);
		myMap.put("User", usercount);
		
		return myMap;
		
	}

}
