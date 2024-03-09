package com.ds.snackapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ds.snackapp.entity.Dsusers;
import com.ds.snackapp.securityconfig.UserDetailService;
import com.ds.snackapp.service.DsuserService;
@Controller
public class RegisterController {

	@Autowired
	private DsuserService service;
	
	private UserDetailService userDetailService;
	
	  @PostMapping("/addDsuser") 
	  public String addDsuser(Dsusers dsuser,Model model) {
	  
	 // System.out.println("we going to add a product");
	  
	  // Dsusers createDsuser = service.createDsuser(dsuser);
	  
	  String message = service.createDsuser(dsuser);
	  
	  if(message == null) {
		  model.addAttribute("info",false); 
		  return "Dsuserregister.jsp";
		//  return "/authentication/Dsuserregister.jsp";

	  }
	   else {
	   model.addAttribute("info", true); 
	   return "Dsuserregister.jsp"; 
	 //  return "/authentication/Dsuserregister.jsp";
	   }
	 

		//	ModelAndView modelAndView = new ModelAndView();
		//	modelAndView.addObject( "status",createDsuser);
		//	modelAndView.setViewName("Dsuserregister.jsp");
		// return modelAndView;
		//	model.addAttribute("status", createDsuser);

		//	return "Dsuserregister.jsp";
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
			model.addAttribute("user", user);
			return "Resetpassword.jsp";
		}
		
		model.addAttribute("errormessage", "User Doesn't Exist");
		return "Forgotpassword.jsp";
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
		
		service.unlockWhenTimeExpired(user);
		
		service.updatePassword(user.getId(),newpassword);
		
		return "Loginform.jsp";
		
		
	}
	
	
	

}
