package com.ds.snackapp.controller;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ds.snackapp.dto.DsusersDTO;
import com.ds.snackapp.entity.Dsusers;
import com.ds.snackapp.securityconfig.CustomLoginSuccessHandler;
import com.ds.snackapp.securityconfig.UserDetailService;
import com.ds.snackapp.service.DsuserService;
@Controller
public class RegisterController {

	@Autowired
	private DsuserService service;
	
	
	@Autowired
	private UserDetailService userDetailService;
	
	@Autowired
	private CustomLoginSuccessHandler successHandler;

	@PostMapping("/addDsuser") 
	public String addDsuser(Dsusers dsuser,Model model,HttpServletRequest request,HttpServletResponse response) {
		
		/*
		String message = service.createDsuser(dsuser);

		if(message == null) {
			model.addAttribute("info",false); 
			return "Dsuserregister.jsp";

		}
		else {
			model.addAttribute("info", true); 
			return "Dsuserregister.jsp"; 
		}
		*/
		
		Dsusers uss = service.createDsuser(dsuser);
		
		
		if(uss != null)
		{
			try {
				UserDetails userDetails = userDetailService.loadUserByUsername(uss.getEmail());
				
				Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails.getUsername(),
						                        userDetails.getPassword(),userDetails.getAuthorities());
				
				if(authentication.isAuthenticated())
				{	
		        SecurityContextHolder.getContext().setAuthentication(authentication);
		        successHandler.onAuthenticationSuccess(request,response,authentication);
				}	
				}
				catch (Exception e) {
			      //  log.error(e.getMessage(), e);
					return e.getMessage();
			    }
		}
	   else if(uss==null)
		{
			model.addAttribute("info",false);
			return "Dsuserregister.jsp";
		}
		return null;
		
	}
	/*
	@PostMapping("/validUser")
	public String isValidUser(LoginDTO logincredentials,Model model)
	{
		boolean user=service.checkUserCredentials(logincredentials);
		if(user == true)
		{
		HttpServletRequest request = null;
		HttpSession session = request.getSession();
		model.addAttribute("validuser", true);
		}
		else
		{
			model.addAttribute("validuser", false);
		}
		return "Loginform.jsp";
	}
	 */
	/*
	 * @PostMapping("/login") public ModelAndView isValidUser(LoginDTO
	 * logincredentials) { ModelAndView model = new ModelAndView();
	 * List<Dsusers>dsuser=service.checkUserCredentials(logincredentials);
	 * 
	 * boolean user = service.isAuthorizedUser(dsuser,logincredentials); if(user ==
	 * true) { return new ModelAndView("redirect:/snackassignmentform"); } else {
	 * model.addObject("info",false); model.setViewName("Loginform.jsp"); return
	 * model; } }
	 */
	@GetMapping("/makeadmin")
	public ModelAndView makeAdmin(@RequestParam("id") int userid)
	{
		String ans = service.promoteAdmin(userid);

		return new ModelAndView("redirect:/allemployees");

	}
	@GetMapping("/removeadmin")
	public ModelAndView removeAdmin(@RequestParam("id") int userid)
	{
		String ans = service.depromoteAdmin(userid);

		return new ModelAndView("redirect:/allemployees");

	}

	@PostMapping("/forgotpassword")
	public String forgotPasswordProcess(@RequestParam("username") String email,Model model)
	{
		Dsusers user = service.fetchUserDetails(email);

		if(user != null)
		{ 
			if(user.getLockTime() != null)
			{
				if(!service.isLockTimeExpired(user))
				{
					long balanceMinutes = service.getRemainingTime(user);

					model.addAttribute("balanceminutes", balanceMinutes);
					System.out.println(balanceMinutes);
					return "Forgotpassword.jsp";
				}
			}
			model.addAttribute("user", user);
			return "Resetpassword.jsp";
		}
		else {
			model.addAttribute("errormessage", "User Doesn't Exist");
			return "Forgotpassword.jsp";
		}

	}

	@PostMapping("/resetpassword")
	public String resetPasswordProcess(@RequestParam("newpassword") String newpassword, @RequestParam("oldpassword") String oldpassword,
			@RequestParam("email") String email,Model model)
	{
		System.out.println("abcdefghijklmnopq");
		boolean validpassword = newpassword.equals(oldpassword);

		if(validpassword == true)
		{
			model.addAttribute("samepassword","New Password should be differ from Old Password");
			return "Resetpassword.jsp";
		}

		//int employeeid = empid;
		System.out.println("zxywvsisis");
		Dsusers user = service.fetchUserDetails(email);
		
		if(user.getLockTime() != null)
		{
		service.unlockWhenTimeExpired(user);
		}
		service.updatePassword(user.getId(),newpassword);

		return "Loginform.jsp";


	}
	/*
	public ModelAndView updateProfile(HttpServletRequest request)
	{
		String inputname = request.getParameter("empname");
		String inputmail = request.getParameter("email");
		String employeeid = request.getParameter("employeeid");
		
		service.editProfile(inputname,inputmail,employeeid);
		
		return new ModelAndView("redirect:/common/profile");
				
	}
	*/
	@PostMapping("/updateprofile")
	public ModelAndView updateProfile(DsusersDTO dsuser)
	{
		Dsusers u = service.editProfile(dsuser);
		
		if(u != null)
		{
			return new ModelAndView("redirect:/common/profile?status=true");
		}
		else
		{
			return new ModelAndView("redirect:/common/profile?status=");
		}
				
	}
	
	



}
