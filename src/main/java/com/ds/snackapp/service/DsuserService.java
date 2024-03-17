package com.ds.snackapp.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.ds.snackapp.dto.DsusersDTO;
import com.ds.snackapp.dto.LoginDTO;
import com.ds.snackapp.entity.Dsusers;
import com.ds.snackapp.entity.Role;
import com.ds.snackapp.repository.DsuserRepository;
import com.ds.snackapp.repository.RoleRepository;

@Service
@Transactional
public class DsuserService {
	@Autowired
	private DsuserRepository repository;
	@Autowired
	private RoleRepository rolerepository;



	public static final int MAX_FAILED_ATTEMPTS = 3;

	//	private static final long LOCK_TIME_DURATION = 30 * 60 * 1000;

	private static final long LOCK_TIME_DURATION = 30 * 60 * 1000;


	//@Autowired
	//	private CommonFunctions common;
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

	// public String createDsuser(Dsusers dsuser) { 
	public Dsusers createDsuser(Dsusers dsuser) { 

		Role role = rolerepository.findByRolename("User").get(0); 

		dsuser.setRoleid(role);

		String inputemail = dsuser.getEmail(); 

		Dsusers existinguser = repository.findByEmail(inputemail);


		if (existinguser != null) {
			return null; 
		} else { 																

			Dsusers uss = repository.save(dsuser);

			return uss;

			// return "User Registered Successfully"; 
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
	//	public List<Dsusers> checkUserCredentials(LoginDTO logincredentials) {
	//		// Dsusers dsuser = repository.findByEmail(logincredentials.getEmail()).get(0);
	//		Dsusers dsuser = repository.findByEmail(logincredentials.getEmail());
	//		
	//		return dsuser;


	public boolean isAuthorizedUser(List<Dsusers>dsuser,LoginDTO logincredentials)
	{
		if (dsuser.size() == 0) {
			return false;
		} else if (dsuser.get(0).getEmail().equals(logincredentials.getEmail()) 
				&& dsuser.get(0).getPassword().equals(logincredentials.getPassword())) {

			//	common.createSession(dsuser);


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

	public Dsusers fetchUserDetails(String username)
	{
		Dsusers dsu = repository.findByEmail(username);

		return dsu;

	}

	public List<Dsusers> fetchAllEmployees()
	{
		return repository.findAll();
	}

	public void updatePassword(int empid,String newpassword)
	{
		Dsusers user = repository.findById(empid).orElse(null);

		user.setPassword(newpassword);

		String ps = user.getPassword();

		repository.save(user);

		return;

	}

	public void increaseFailedAttempts(Dsusers user) {
		int newFailAttempts = user.getFailedAttempt() + 1;
		repository.updateFailedAttempts(newFailAttempts, user.getEmail());
	}

	public void resetFailedAttempts(String email) {
		repository.updateFailedAttempts(0, email);
	}

	public void lock(Dsusers user) {
		user.setAccountNonLocked(false);
		user.setLockTime(new Date());         
		repository.save(user);
	}
	public boolean unlockWhenTimeExpired(Dsusers user) {
		long lockTimeInMillis = user.getLockTime().getTime();
		long currentTimeInMillis = System.currentTimeMillis();

		if (lockTimeInMillis + LOCK_TIME_DURATION < currentTimeInMillis) {
			user.setAccountNonLocked(true);
			user.setLockTime(null);
			user.setFailedAttempt(0);

			repository.save(user);

			return true;
		}

		return false;
	}

	public long getRemainingTime(Dsusers user) {
		long lockTimeInMillis = user.getLockTime().getTime();
		long currentTimeInMillis = System.currentTimeMillis();

		long remainingminutes;

		long lockPeriodInMillis = currentTimeInMillis - lockTimeInMillis;

		if(lockPeriodInMillis > LOCK_TIME_DURATION)
		{
			remainingminutes = 0; 
		}
		else
		{
			long remainingTimeInMillis = LOCK_TIME_DURATION - lockPeriodInMillis;
			//	 long remainingTimeInMillis = LOCK_TIME_DURATION - currentLockTimeInMillis;
			remainingminutes = convertMillisToMinutesAndSeconds(remainingTimeInMillis);
		}

		return remainingminutes;

	}
	public long convertMillisToMinutesAndSeconds (long millis)
	{
		long totalSeconds = millis / 1000;
		long minutes = totalSeconds / 60;
		long seconds = totalSeconds % 60;
		/*   
     long arr[]=new long[2];

     arr[0]=minutes;
     arr[1]=seconds;

     return arr;
		 */
		return minutes;
	}

	public ModelAndView redirectToResetPassword(Dsusers user) {
		boolean accountstatus = user.isAccountNonLocked();

		if(accountstatus == false)
		{
			return new ModelAndView("redirect:/displayforgotpasswordform");
		}
		else
		{
			return new ModelAndView("redirect:/signin");
		}
	}

	public boolean isLockTimeExpired(Dsusers user)
	{
		long lockTimeInMillis = user.getLockTime().getTime();
		long currentTimeInMillis = System.currentTimeMillis();

		if (lockTimeInMillis + LOCK_TIME_DURATION < currentTimeInMillis) {
			return true;
		}

		return false;
	}

	/*
 public String allowLogin (Dsusers u,HttpServletRequest request,HttpServletResponse response)
 {
	 try {
			UserDetails userDetails = usrServe.loadUserByUsername(u.getEmail());

			Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails.getUsername(),
					                        userDetails.getPassword(),userDetails.getAuthorities());

			if(authentication.isAuthenticated())
			{		
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        successHandler.onAuthenticationSuccess(request,response,authentication);
	      //  return "Dsuserregister.jsp";
			}	
			}
			catch (Exception e) {
		      //  log.error(e.getMessage(), e);
				return e.getMessage();
		    }
	 return null;
 }
	 */

	public Dsusers editProfile (DsusersDTO dsuser)
	{
		Dsusers existinguser = repository.getById(dsuser.getEmployeeid());
		
		Dsusers usr = repository.findByEmail(dsuser.getEmail());
		
		if(existinguser.getId() == usr.getId())
		{
			existinguser.setName(dsuser.getEmpname());
			existinguser.setEmail(dsuser.getEmail());
			return repository.save(existinguser);
		}
		else
		{
			return null;
		}
				
	}




}
