package com.ds.snackapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.snackapp.dto.LoginDTO;
import com.ds.snackapp.entity.Dsusers;
import com.ds.snackapp.entity.Role;
import com.ds.snackapp.generic.CommonFunctions;
import com.ds.snackapp.repository.DsuserRepository;
import com.ds.snackapp.repository.RoleRepository;

@Service
public class DsuserService {
	@Autowired
	private DsuserRepository repository;
	@Autowired
	private RoleRepository rolerepository;
	@Autowired
	private CommonFunctions common;
/*	
	public Dsusers createDsuser(Dsusers dsuser) {
		Role role = rolerepository.findByRolename("User").get(0);
		dsuser.setRoleid(role);
		
		String inputemail = dsuser.getEmail();
		List<Dsusers> existinguser = repository.findByEmail(inputemail);
		
		
		if (existinguser.size() > 0) {
			return existinguser.get(0);
		}

		// return repository.save(dsuser.setRoleid(rolerepository.findById(3)));
		return repository.save(dsuser);
	}
*/	
	public String createDsuser(Dsusers dsuser) {
		Role role = rolerepository.findByRolename("User").get(0);
		dsuser.setRoleid(role);
		
		String inputemail = dsuser.getEmail();
		List<Dsusers> existinguser = repository.findByEmail(inputemail);
		
		
		if (existinguser.size() > 0) {
			return null;
		}
		else
		{
			repository.save(dsuser);
			return "User Registered Successfully";
		}

	}

	public Dsusers getDsuserById(int id) {
		return repository.findById(id).orElse(null);
	}
	/*
	public boolean checkUserCredentials(LoginDTO logincredentials) {
		// Dsusers dsuser = repository.findByEmail(logincredentials.getEmail()).get(0);
		List<Dsusers> dsuser = repository.findByEmail(logincredentials.getEmail());
		if (dsuser.size() == 0) {
			return false;
		} else if (dsuser.get(0).getEmail().equals(logincredentials.getEmail()) 
				&& dsuser.get(0).getPassword().equals(logincredentials.getPassword())) {

			return true;

		}
		return false;

	}
	*/
	public List<Dsusers> checkUserCredentials(LoginDTO logincredentials) {
		// Dsusers dsuser = repository.findByEmail(logincredentials.getEmail()).get(0);
		List<Dsusers> dsuser = repository.findByEmail(logincredentials.getEmail());
		
		return dsuser;

	}
	public boolean isAuthorizedUser(List<Dsusers>dsuser,LoginDTO logincredentials)
	{
		if (dsuser.size() == 0) {
			return false;
		} else if (dsuser.get(0).getEmail().equals(logincredentials.getEmail()) 
				&& dsuser.get(0).getPassword().equals(logincredentials.getPassword())) {
			
			common.createSession(dsuser);
			

			return true;

		}
		return false;
	}
	
	public List<Dsusers> getAllEmployees()
	{
		List<Dsusers>users = repository.findAll();
		
		return users;
	}
	
	public String promoteAdmin(int userid)
	{
		Dsusers user = repository.findById(userid).orElse(null);
		
		Role role = rolerepository.findByRolename("Admin").get(0);
		
		user.setRoleid(role);
		
		repository.save(user);

		return "Role is Updated Successfully";
	}
	
	public String depromoteAdmin(int userid)
	{
		Dsusers user = repository.findById(userid).orElse(null);
		
		Role role = rolerepository.findByRolename("User").get(0);
		
		user.setRoleid(role);
		
		repository.save(user);

		return "Role is Updated Successfully";
	}
	

}
