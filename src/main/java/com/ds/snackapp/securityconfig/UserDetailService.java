package com.ds.snackapp.securityconfig;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ds.snackapp.controller.CommonViewController;
import com.ds.snackapp.controller.RegisterController;
import com.ds.snackapp.entity.Dsusers;
import com.ds.snackapp.repository.DsuserRepository;

//@Component
@Service
public class UserDetailService implements UserDetailsService {

	@Autowired
	private  DsuserRepository userRepo;
	
	
	
	
	
	//@Autowired
	//Model model;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Dsusers user = userRepo.findByEmail(username);
		//HttpSession session;
		
		//System.out.println(user.getName());
	//	regCnt.forgotPasswordProcess(user.getEmail());
		if (user == null) {
			throw new UsernameNotFoundException("user not found");
		} else {
		//	session.setAttribute("AuthenticatedEmployee", user.getName());
			/*
			if(!user.isAccountNonLocked())
			{
				//Model model;
				//regcont.forgotPasswordProcess(user.getEmail(), null);
				//return comControl.showForgotPasswordForm();
				return null;
			}
			*/
			UserDetails usd= User.withUsername(user.getEmail())
                    .password(user.getPassword())
                    .authorities(user.getRoleid().getRolename()).build();
			return usd;
		}

	}
	
	 	 
	 
	 
			
}