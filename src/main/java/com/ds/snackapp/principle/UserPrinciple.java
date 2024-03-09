package com.ds.snackapp.principle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.servlet.ModelAndView;

import com.ds.snackapp.entity.Dsusers;
import com.ds.snackapp.entity.Role;

public class UserPrinciple implements UserDetails {
	
	private Dsusers us; // new field
	private static final long serialVersionUID = 3136550751607020144L;
	private String username;
	private String password;
	private transient Role authorities;

	
	
	public UserPrinciple(Dsusers dsuser) {
		/*
		boolean accountstatus = dsuser.isAccountNonLocked();
		
		if(accountstatus == false)
		{
			return new ModelAndView("redirect:/displayforgotpasswordform");
		}
		*/
		
		this.username = dsuser.getEmail();
		this.password = dsuser.getPassword();
		this.authorities = dsuser.getRoleid();
		this.us = dsuser;  // new change
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities(){
		List<GrantedAuthority>auth = new ArrayList<>();
		auth.add(new SimpleGrantedAuthority(authorities.getRolename()));
		return auth;
	}
	@Override
	public String getPassword()
	{
		return password;
	}
	
	@Override
	public String getUsername()
	{
		return username;
	}
	
	@Override
	public boolean isAccountNonExpired()
	{
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked()
	{
		//return true;
		
		boolean ans = us.isAccountNonLocked();
		
		return us.isAccountNonLocked();
	}
	
	@Override
	public boolean isCredentialsNonExpired()
	{
		return true;
	}
	
	@Override
	public boolean isEnabled()
	{
		return true;
	}
	public Dsusers getUs() {
		return us;
	}
	public void setUs(Dsusers us) {
		this.us = us;
	}

}
