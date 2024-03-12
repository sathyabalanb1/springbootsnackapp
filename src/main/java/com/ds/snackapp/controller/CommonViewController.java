package com.ds.snackapp.controller;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ds.snackapp.entity.Assignment;
import com.ds.snackapp.entity.Dsusers;
import com.ds.snackapp.entity.Selection;
import com.ds.snackapp.service.AssignmentService;
import com.ds.snackapp.service.DsuserService;
import com.ds.snackapp.service.SelectionService;


@Controller
public class CommonViewController {
	@Autowired
	private AssignmentService assignmentservice;
	
	@Autowired
	private DsuserService dsuserservice;
	
	@Autowired
	private SelectionService selectionservice;
	
	@GetMapping("/common/snackselectionform")
	private ModelAndView showSnackSelectionForm(@RequestParam(required=false) String edit,ModelAndView model,Principal principal,HttpSession ss) {
	
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String uname = authentication.getName();
		String username = principal.getName();

		Dsusers dsu = dsuserservice.fetchUserDetails(username);

		
		//Dsusers dsu = dsuserservice.fetchUserDetails(uname);
		
		ss.setAttribute("empname", dsu.getName());
	
	
	int userid = dsu.getId();
	
	
	List<Assignment>ass = assignmentservice.getAssignmentDetails();
	
	if(ass.size() == 0)
	{
	 return assignmentservice.displayNoAssignmentInfo(ass,dsu.getName());
	}
	
	boolean ans = selectionservice.checkSelectionTime();
		
	if(ans == false)
	{
		return selectionservice.displayChooseSnackTimeInfo(ans,dsu.getName()); 
	}
	
	int assignmentid = ass.get(0).getId();

	
	Selection sl = selectionservice.fetchSelectionDetails(assignmentid,userid);
	
	if(sl != null)
	{
		return selectionservice.displaySnackSelectionInfo(sl);		
		
	}
	
	
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
	
	/*
	@GetMapping("/signin")
	//@GetMapping("/login")
	private String showLoginForm() {

		return "Loginform.jsp";
	}
	*/
	
	@GetMapping("/signin")
	private String showLoginForm(@RequestParam(required=false) String accountlockerror,Model model) {
		//@RequestParam(required=false) String error, Model model
		
		if(accountlockerror != null)
		{
		model.addAttribute("lockminutes", accountlockerror);
		}
		
		System.out.println("Now we are displaying signin form");
		return "Loginform.jsp";
	}
	
	@GetMapping("/invalid")
	public String invalid()
	{
		return "Error.jsp";
	}
	
	@GetMapping("/")
	private String showFrontpage(Model model)
	{
		model.addAttribute("welcomeinfo", "Welcome to DiligentSquad Snack Site");
		return "Appfrontpage.jsp";
	}
	/*
	@GetMapping("/userhomepage")
	private ModelAndView showHomePage(Principal principal) {
		
		List<Assignment> a = assignmentservice.getAssignmentDetails();
		
		String username = principal.getName();
		
		Dsusers dsu = dsuserservice.fetchUserDetails(username);
		
		String employeename = dsu.getName();
		
		int userid = dsu.getId();
		
		ModelAndView model = new ModelAndView();		

		
		if(a.size()>0)
		{
			int assignmentid = a.get(0).getId();
			
			Selection sl = selectionservice.fetchSelectionDetails(assignmentid,userid); // return type doubt
			
			if(sl != null)
			{
				boolean val = sl.isEnabled();
				
				String temp;
				
				if(val == true)
				{
					temp="Yes";
				}
				else
				{
					temp="False";
				}
				
				String empname = sl.getDsuser().getName();
				
				model.addObject("empname", empname);
				model.addObject("selectionvalue", temp);
				model.setViewName("Userhomepage.jsp");
				return model;				
				
			}
			else
			{
				return new ModelAndView("redirect:/common/snackselectionform");

			}

		}
		else
		{
			model.addObject("employeename", employeename);
			model.addObject("noassignment","Today's Snack is not yet Assigned");
			model.setViewName("Userhomepage.jsp");
			return model;
		}
						
	}	
	*/
	@GetMapping("/logoutpage")
	public String logoutPage() {
		return "authentication/logoutpage.jsp";
}
	
	@GetMapping("/common/snackselectionupdate")
	public ModelAndView showSnackSelectionUpdateForm(ModelAndView model,Principal principal) {

		String username = principal.getName();
		
		Dsusers dsu = dsuserservice.fetchUserDetails(username);
		
		int userid = dsu.getId();
		
		List<Assignment>ass = assignmentservice.getAssignmentDetails();
		
		boolean ans = selectionservice.checkSelectionTime();
		
		if(ans == false)
		{
			return selectionservice.displayChooseSnackTimeInfo(ans,dsu.getName()); 
		}
		
		int assignmentid = ass.get(0).getId();
		
		String assigneddate = ass.get(0).getAssigneddate();
		
		String snackname = ass.get(0).getSnack().getSnackname();
		
		String vendorname = ass.get(0).getVendor().getVendorname();
		
		model.addObject("assigneddate", assigneddate);
		model.addObject("snackname", snackname);
		model.addObject("vendorname", vendorname);
		model.addObject("userid", userid);
		model.addObject("assignmentid", assignmentid);
		model.setViewName("/snackselection/Editsnackselectionform.jsp");
		
		return model;

	}
	
	@GetMapping("/displayforgotpasswordform")
	public String showForgotPasswordForm(@RequestParam(required=false) boolean forgot)
	{
		System.out.println("Now we are ready to update password");
		return "Forgotpassword.jsp";
	}
	

}
