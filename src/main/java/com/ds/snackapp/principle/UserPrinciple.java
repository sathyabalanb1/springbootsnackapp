package com.ds.snackapp.principle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ds.snackapp.entity.Dsusers;
import com.ds.snackapp.entity.Role;

public class UserPrinciple implements UserDetails {
	
	private static final long serialVersionUID = 3136550751607020144L;
	private String username;
	private String password;
	private transient Role authorities;

	public UserPrinciple(Dsusers dsuser) {
		this.username = dsuser.getEmail();
		this.password = dsuser.getPassword();
		this.authorities = dsuser.getRoleid();
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
		return true;
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

}
