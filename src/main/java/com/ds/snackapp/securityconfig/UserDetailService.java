package com.ds.snackapp.securityconfig;


import javax.servlet.http.HttpSession;

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
		
		//HttpSession session;
		
		//System.out.println(user.getName());
		if (user == null) {
			throw new UsernameNotFoundException("user not found");
		} else {
		//	session.setAttribute("AuthenticatedEmployee", user.getName());

			return new UserPrinciple(user);
		}

	}

}