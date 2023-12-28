package com.ds.snackapp.securityconfig;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ds.snackapp.entity.Dsusers;
import com.ds.snackapp.principle.UserPrinciple;
import com.ds.snackapp.repository.DsuserRepository;

//@Component
@Service
public class UserDetailService implements UserDetailsService {

	@Autowired
	private  DsuserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Dsusers user = userRepo.findByEmail(username);
		//System.out.println(user.getName());
		if (user == null) {
			throw new UsernameNotFoundException("user not found");
		} else {
			return new UserPrinciple(user);
		}

	}

}