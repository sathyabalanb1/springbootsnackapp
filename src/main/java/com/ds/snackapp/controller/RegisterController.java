package com.ds.snackapp.controller;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ds.snackapp.dto.LoginDTO;
import com.ds.snackapp.entity.Dsusers;
import com.ds.snackapp.service.DsuserService;
@Controller
public class RegisterController {

	@Autowired
	private DsuserService service;

	@PostMapping("/addDsuser")
	public String addDsuser(Dsusers dsuser,Model model) {

		//	 System.out.println("we going to add a product");

		//	Dsusers createDsuser = service.createDsuser(dsuser);

		String message = service.createDsuser(dsuser);

		if(message == null)
		{
			model.addAttribute("info",false);
			return "Dsuserregister.jsp";
		}
		else
		{
			model.addAttribute("info", true);
			return "Dsuserregister.jsp";
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
	@PostMapping("/validUser")
	public ModelAndView isValidUser(LoginDTO logincredentials)
	{
		ModelAndView model = new ModelAndView();
		List<Dsusers>dsuser=service.checkUserCredentials(logincredentials);

		boolean user = service.isAuthorizedUser(dsuser,logincredentials);	
		if(user == true)
		{
			return new ModelAndView("redirect:/snackassignmentform");
		}
		else
		{
			model.addObject("info",false);
			model.setViewName("Loginform.jsp");
			return model;
		}
	}

}
