package com.ds.snackapp.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SpringConfig extends WebSecurityConfigurerAdapter{

	/*
	  
	@Bean
	public DaoAuthenticationProvider getAuthenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(getDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(getPasswordEncoder());
		return daoAuthenticationProvider;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		  http.csrf().disable()
	        .authorizeRequests()
	           .antMatchers("/signin","/logout").permitAll()	           
	            .antMatchers("/user/**").hasAuthority("User")
	            .antMatchers("/admin/**").hasAnyAuthority("SuperAdmin")
	            .anyRequest().authenticated()
	        .and()
	        .formLogin()
	            .loginPage("/signin")
	            .loginProcessingUrl("/login")
	            .successHandler((request, response, authentication) -> {
	                for (GrantedAuthority authority : authentication.getAuthorities()) {
	                    if (authority.getAuthority().equals("SuperAdmin")) {
	                        response.sendRedirect("/admin/adminhomepage");
	                        return;
	                    }
	                }
	                response.sendRedirect("/user/homepage");
	            })
	            .permitAll()
	        .and()
	        .logout()
	            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	            .logoutSuccessUrl("/logout-page")
	            .invalidateHttpSession(true)
	            .clearAuthentication(true)
	            .permitAll();
	}
*/
	@Autowired
	UserDetailService userDetailService;
	
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider daoAuth = new DaoAuthenticationProvider();
		daoAuth.setUserDetailsService(userDetailService);
	 //   daoAuth.setPasswordEncoder(bcrypt());
		daoAuth.setPasswordEncoder(getPasswordEncoder());
		return daoAuth;
	}
	
	/*
	@Bean
	PasswordEncoder bcrypt() {
		return new BCryptPasswordEncoder();
	}
	*/
	
	@Bean
	public PasswordEncoder getPasswordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
	
	/*  Works fine
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeHttpRequests().antMatchers("/").permitAll()
		.anyRequest().authenticated()
				.and().formLogin().loginPage("/signin")
				.loginProcessingUrl("/login")
				.defaultSuccessUrl("/snackassignmentform").permitAll()
				//.failureUrl("/invalid").permitAll()
				.and()
				.logout().logoutSuccessUrl("/logoutpage")				
				.permitAll();
	}
	*/
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeHttpRequests().antMatchers("/").permitAll()
		.antMatchers("/addsnackform").hasAuthority("SuperAdmin")
		.antMatchers("/user/**").hasAnyAuthority("SuperAdmin","User")
		.anyRequest().authenticated()
				.and().formLogin().loginPage("/signin")
				.loginProcessingUrl("/login")
				.defaultSuccessUrl("/snackassignmentform").permitAll()
				//.failureUrl("/invalid").permitAll()
				.and()
				.logout().logoutSuccessUrl("/logoutpage")				
				.permitAll();
	}
	

}