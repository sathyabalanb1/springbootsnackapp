package com.ds.snackapp.controller;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
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
		/*
		ss.setAttribute("empname", dsu.getName());
		ss.setAttribute("roleid", dsu.getRoleid().getId());
		ss.setAttribute("currentstatus", "alive");
		*/
	
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
	private ModelAndView showRegisterForm() {
		// TODO Auto-generated method stub
		
		ModelAndView model = new ModelAndView();
		
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			model.setViewName("Dsuserregister.jsp");
			return model;
		}else {
			if(authentication.getAuthorities().stream().anyMatch(auth ->auth.getAuthority().equals("SuperAdmin")))
			{
				return new ModelAndView("redirect:/admin/snackassignmentform");
			}
			else if(authentication.getAuthorities().stream().anyMatch(auth ->auth.getAuthority().equals("Admin"))) {
				return new ModelAndView("redirect:/admin/snackassignmentform");
			}
			else if(authentication.getAuthorities().stream().anyMatch(auth ->auth.getAuthority().equals("User"))) {
				return new ModelAndView("redirect:/common/snackselectionform");
			}
				
		}
		model.setViewName("Dsuserregister.jsp");
		return model;
	}
	
	
	/* works fine dated at 21.03.2024
	@GetMapping("/signin")
	private ModelAndView showLoginForm(@RequestParam(required=false) String accountlockerror,HttpSession sess) {
		
		ModelAndView model = new ModelAndView();
		
		
				
		if(sess.getAttribute("roleid") != null && accountlockerror == null)
		{
		int roleid = (int) sess.getAttribute("roleid");
		
		if(roleid == 1 || roleid == 2)
		{
			return new ModelAndView("redirect:/admin/snackassignmentform");
		}
		else {
			return new ModelAndView("redirect:/common/snackselectionform");
		}
		}				
		
		if(accountlockerror != null)
		{
		model.addObject("lockminutes", accountlockerror);
		model.setViewName("Loginform.jsp");
		return model;
		//model.addAttribute("lockminutes", accountlockerror);
		}
		
		model.setViewName("Loginform.jsp");
		return model;
	}
	*/
	/* Works fine 22.03.2024 display bad credentials InProgress
	@GetMapping("/signin")
	private ModelAndView showLoginForm(@RequestParam(required=false) String accountlockerror,@RequestParam(name="badcredential", required=false) String badcredential,HttpSession sess) {
		
		ModelAndView model = new ModelAndView();
		
		String bc = badcredential;
		
		if(badcredential != null)
		{
			System.out.println("Bad Credential received");
			model.addObject("badcredential", "Username or Password Seems to be Incorrect");
			model.setViewName("Loginform.jsp");
			return model;
		}
		
				
		if(sess.getAttribute("roleid") != null && accountlockerror == null)
		{
		int roleid = (int) sess.getAttribute("roleid");
		
		if(roleid == 1 || roleid == 2)
		{
			return new ModelAndView("redirect:/admin/snackassignmentform");
		}
		else {
			return new ModelAndView("redirect:/common/snackselectionform");
		}
		}				
		
		if(accountlockerror != null)
		{
		model.addObject("lockminutes", accountlockerror);
		model.setViewName("Loginform.jsp");
		return model;
		//model.addAttribute("lockminutes", accountlockerror);
		}
		
		model.setViewName("Loginform.jsp");
		return model;
	}
	*/
	@GetMapping("/signin")
	@Validated
	private ModelAndView showLoginForm(@RequestParam(required=false) String accountlockerror,HttpSession sess) {
		
		ModelAndView model = new ModelAndView();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			model.setViewName("Loginform.jsp");
			return model;
		}else {
			if(authentication.getAuthorities().stream().anyMatch(auth ->auth.getAuthority().equals("SuperAdmin")))
			{
				return new ModelAndView("redirect:/admin/snackassignmentform");
			}
			else if(authentication.getAuthorities().stream().anyMatch(auth ->auth.getAuthority().equals("Admin"))) {
				return new ModelAndView("redirect:/admin/snackassignmentform");
			}
			else if(authentication.getAuthorities().stream().anyMatch(auth ->auth.getAuthority().equals("User"))) {
				return new ModelAndView("redirect:/common/snackselectionform");
			}
				
		}
		
		
		/*		
		if(sess.getAttribute("roleid") != null && accountlockerror == null)
		{
		int roleid = (int) sess.getAttribute("roleid");
		
		if(roleid == 1 || roleid == 2)
		{
			return new ModelAndView("redirect:/admin/snackassignmentform");
		}
		else {
			return new ModelAndView("redirect:/common/snackselectionform");
		}
		}				
		*/
		if(accountlockerror != null)
		{
		model.addObject("lockminutes", accountlockerror);
		model.setViewName("Loginform.jsp");
		return model;
		//model.addAttribute("lockminutes", accountlockerror);
		}
		
		model.setViewName("Loginform.jsp");
		return model;
	}
	
	@GetMapping("/invalid")
	public String invalid(@RequestParam(name="badcredential", required=false) String badcredential,@RequestParam(name="loginerror", required=false) String loginerror,Model model)
	{
		if(loginerror != null)
		{
			model.addAttribute("loginerror", loginerror);
			return "Loginform.jsp";
		}
		else
		{
		model.addAttribute("badcredential", badcredential);
		return "Loginform.jsp";
		}
		//return "Error.jsp";
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
		return "Forgotpassword.jsp";
	}
	
	@GetMapping("/common/editprofile")
	public ModelAndView displayProfile(@RequestParam(required=false) String status)
	{
		
		ModelAndView model = new ModelAndView();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String uname = authentication.getName();
		
		Dsusers dsu = dsuserservice.fetchUserDetails(uname);
		
		String empname = dsu.getName();
		String email = dsu.getEmail();
		String rolename = dsu.getRoleid().getRolename();
		int employeeid = dsu.getId();
		if(status != null)
		{
			model.addObject("info", false);
		}
		model.addObject("empname", empname);
		model.addObject("email", email);
		model.addObject("rolename", rolename);
		model.addObject("employeeid", employeeid);
		model.setViewName("/profile/ProfileInfo.jsp");
		
		return model;		
	}
	
	@GetMapping("/common/profile")
	public ModelAndView viewProfile()
	{
		ModelAndView model = new ModelAndView();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String uname = authentication.getName();
		
		Dsusers dsu = dsuserservice.fetchUserDetails(uname);
		
		String empname = dsu.getName();
		String email = dsu.getEmail();
		String rolename = dsu.getRoleid().getRolename();
		int employeeid = dsu.getId();
		
		model.addObject("empname", empname);
		model.addObject("email", email);
		model.addObject("rolename", rolename);
		model.addObject("employeeid", employeeid);
		model.setViewName("/profile/DisplayProfile.jsp");
		
		return model;
	}
	
	

}
