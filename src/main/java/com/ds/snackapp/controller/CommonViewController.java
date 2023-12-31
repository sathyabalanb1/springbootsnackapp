package com.ds.snackapp.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ds.snackapp.entity.Assignment;
import com.ds.snackapp.service.AssignmentService;

@Controller
public class CommonViewController {
	@Autowired
	private AssignmentService assignmentservice;
	
	@GetMapping("/common/snackselectionform")
	private ModelAndView showSnackSelectionForm(ModelAndView model,Principal principal) {
		System.out.println(principal.getName());
	List<Assignment>ass = assignmentservice.getAssignmentDetails();
	
	String assigneddate = ass.get(0).getAssigneddate();
	
	String snackname = ass.get(0).getSnack().getSnackname();
	
	String vendorname = ass.get(0).getVendor().getVendorname();
	
	model.addObject("assigneddate", assigneddate);
	model.addObject("snackname", snackname);
	model.addObject("vendorname", vendorname);
	model.setViewName("/snackselection/Snackselectionform.jsp");
	
	return model;
				
	}
	
	@GetMapping("/registerform")
	private String showRegisterForm() {
		// TODO Auto-generated method stub
		//return "hi";
	//	return "demo.jsp";
		return "Dsuserregister.jsp";
	}
	
	@GetMapping("/signin")
	private String showLoginForm() {

		return "Loginform.jsp";
	}
	
	@GetMapping("/invalid")
	public String invalid()
	{
		return "Error.jsp";
	}
	
	@GetMapping("/")
	private String showFrontpage()
	{
		return "Appfrontpage.jsp";
	}
	
	@GetMapping("/userhomepage")
	private String showHomePage() {

		return "Userhomepage.jsp";
	}	
	
	@GetMapping("/logoutpage")
	public String logoutPage() {
		return "authentication/logoutpage.jsp";
}
		

}
