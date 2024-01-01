package com.ds.snackapp.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ds.snackapp.entity.Assignment;
import com.ds.snackapp.entity.Dsusers;
import com.ds.snackapp.service.AssignmentService;
import com.ds.snackapp.service.DsuserService;


@Controller
public class CommonViewController {
	@Autowired
	private AssignmentService assignmentservice;
	
	@Autowired
	private DsuserService dsuserservice;
	
	@GetMapping("/common/snackselectionform")
	private ModelAndView showSnackSelectionForm(ModelAndView model,Principal principal) {
	
	String username = principal.getName();
	
	Dsusers dsu = dsuserservice.fetchUserDetails(username);
	
	int userid = dsu.getId();
	
	List<Assignment>ass = assignmentservice.getAssignmentDetails();
	
	int assignmentid = ass.get(0).getId();
	
	String assigneddate = ass.get(0).getAssigneddate();
	
	String snackname = ass.get(0).getSnack().getSnackname();
	
	String vendorname = ass.get(0).getVendor().getVendorname();
	
	model.addObject("assigneddate", assigneddate);
	model.addObject("snackname", snackname);
	model.addObject("vendorname", vendorname);
	model.addObject("userid", userid);
	model.addObject("assignmentid", assignmentid);
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
	private ModelAndView showHomePage() {
		List<Assignment> a = assignmentservice.getAssignmentDetails();
		
		ModelAndView model = new ModelAndView();		
		
		if(a.size()>0)
		{
			return new ModelAndView("redirect:/common/snackselectionform");

		}
		else
		{
			model.addObject("noassignment","Today's Snack is not yet Assigned");
			model.setViewName("Userhomepage.jsp");
			return model;
		}
		
	}	
	
	@GetMapping("/logoutpage")
	public String logoutPage() {
		return "authentication/logoutpage.jsp";
}
		

}
