package com.ds.snackapp.securityconfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailService userDetailService;
	/*
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider daoAuth = new DaoAuthenticationProvider();
		UserDetailService uds = userDetailService;
		daoAuth.setUserDetailsService(userDetailService);
		// daoAuth.setPasswordEncoder(bcrypt());
		daoAuth.setPasswordEncoder(getPasswordEncoder());
		return daoAuth;
	}
	*/
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider daoAuth = new DaoAuthenticationProvider();
		//UserDetailService uds = userDetailService;
		daoAuth.setUserDetailsService(userDetailService);
		// daoAuth.setPasswordEncoder(bcrypt());
		daoAuth.setPasswordEncoder(getPasswordEncoder());
		return daoAuth;
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	/*
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests()
				.antMatchers("/", "/registerform", "/addDsuser", "/img/**", "/javascriptfiles/**", "/headerfooter/**",
						"/css/**", "/logoutpage", "/displayforgotpasswordform", "/forgotpassword", "/resetpassword")
				.permitAll()
				.antMatchers("/admin/**", "/name").hasAnyAuthority("SuperAdmin", "Admin")
				.antMatchers("/common/**", "/name").hasAnyAuthority("SuperAdmin", "User", "Admin").anyRequest()
				.authenticated()
				.and()
				.formLogin()
				.loginPage("/signin")
				.usernameParameter("username")
				.loginProcessingUrl("/login")
				.failureHandler(loginFailureHandler)
				.successHandler(loginSuccessHandler).permitAll()
				// .failureUrl("/invalid").permitAll()
				.and().logout().logoutSuccessUrl("/logoutpage").invalidateHttpSession(true).clearAuthentication(true)
				.permitAll();
	}
	*/
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests()
				.antMatchers("/", "/registerform", "/addDsuser", "/img/**", "/javascriptfiles/**", "/headerfooter/**",
						"/css/**", "/logoutpage", "/displayforgotpasswordform", "/forgotpassword", "/resetpassword","/login","/invalid","/signin/*")
				.permitAll()
				.antMatchers("/admin/**", "/name").hasAnyAuthority("SuperAdmin", "Admin")
				.antMatchers("/common/**", "/name").hasAnyAuthority("SuperAdmin", "User", "Admin").anyRequest()
				.authenticated()
				.and()
				.formLogin()
				.loginPage("/signin")
				.loginProcessingUrl("/login")
				.failureHandler(loginFailureHandler).permitAll()
				.successHandler(loginSuccessHandler).permitAll()
				// .failureUrl("/invalid").permitAll()
				.and().logout().logoutSuccessUrl("/signin").invalidateHttpSession(true).clearAuthentication(true)
				.permitAll();
	}
	@Autowired
	private CustomLoginFailureHandler loginFailureHandler;

	@Autowired
	private CustomLoginSuccessHandler loginSuccessHandler;
	
//	.usernameParameter("username") This method is for in memory authentication


	/*
	 * Works fine login and logout
	 * 
	 * @Override public void configure(HttpSecurity http) throws Exception {
	 * http.csrf().disable() .authorizeHttpRequests().antMatchers("/").permitAll()
	 * .anyRequest().authenticated() .and().formLogin().loginPage("/signin")
	 * .loginProcessingUrl("/login")
	 * .defaultSuccessUrl("/snackassignmentform").permitAll()
	 * //.failureUrl("/invalid").permitAll() .and()
	 * .logout().logoutSuccessUrl("/logoutpage") .permitAll(); }
	 */

	/*
	 * Works fine role based authentication
	 * 
	 * @Override public void configure(HttpSecurity http) throws Exception {
	 * http.csrf().disable() .authorizeHttpRequests().antMatchers("/").permitAll()
	 * .antMatchers("/admin/**").hasAuthority("SuperAdmin")
	 * .antMatchers("/common/**").hasAnyAuthority("SuperAdmin", "User")
	 * .anyRequest().authenticated() .and().formLogin().loginPage("/signin")
	 * .loginProcessingUrl("/login")
	 * .defaultSuccessUrl("/snackassignmentform").permitAll()
	 * //.failureUrl("/invalid").permitAll() .and()
	 * .logout().logoutSuccessUrl("/logoutpage") .permitAll(); }
	 */
	/*
	 * Works fine - final configure method
	 * 
	 * @Override public void configure(HttpSecurity http) throws Exception {
	 * http.csrf().disable()
	 * .authorizeHttpRequests().antMatchers("/","/registerform","/addDsuser",
	 * "/img/**","/javascriptfiles/**","/headerfooter/**","/css/**","/logoutpage",
	 * "/displayforgotpasswordform","/forgotpassword","/resetpassword").permitAll()
	 * .antMatchers("/admin/**","/name").hasAnyAuthority("SuperAdmin","Admin")
	 * .antMatchers("/common/**","/name").hasAnyAuthority("SuperAdmin",
	 * "User","Admin") .anyRequest().authenticated()
	 * .and().formLogin().loginPage("/signin")
	 * .loginProcessingUrl("/login").permitAll()
	 * 
	 * .successHandler((request, response, authentication) -> { for
	 * (GrantedAuthority authority : authentication.getAuthorities()) { if
	 * (authority.getAuthority().equals("SuperAdmin")) {
	 * response.sendRedirect("/admin/snackassignmentform"); return; } else if
	 * (authority.getAuthority().equals("Admin")) {
	 * response.sendRedirect("/admin/snackassignmentform"); return; } }
	 * response.sendRedirect("/common/snackselectionform"); })
	 * //.failureUrl("/invalid").permitAll() .and()
	 * .logout().logoutSuccessUrl("/logoutpage") .invalidateHttpSession(true)
	 * .clearAuthentication(true) .permitAll(); }
	 */
	/*
	 * @Bean PasswordEncoder bcrypt() { return new BCryptPasswordEncoder(); }
	 */
}