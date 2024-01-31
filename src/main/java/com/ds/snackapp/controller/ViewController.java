package com.ds.snackapp.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

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
import com.ds.snackapp.entity.Role;
import com.ds.snackapp.entity.Snack;
import com.ds.snackapp.entity.Vendor;
import com.ds.snackapp.service.AssignmentService;
import com.ds.snackapp.service.DsuserService;
import com.ds.snackapp.service.RoleService;
import com.ds.snackapp.service.SelectionService;
import com.ds.snackapp.service.SnackService;
import com.ds.snackapp.service.VendorService;


@Controller
public class ViewController {
	@Autowired
	private SnackService snackservice;
	@Autowired
	private VendorService vendorservice;
	@Autowired
	private AssignmentService assignmentservice;	
	@Autowired
	private DsuserService userservice;
	
	@Autowired
	private RoleService roleservice;
	
	@Autowired
	private SelectionService selectionservice;
		

	@GetMapping("/admin/addsnackform")
	private String showSnackInsertForm() {
		return "/snack/Snackinsertform.jsp";
	}

	@GetMapping("/admin/snackupdateform")
	public ModelAndView showUpdateSnackForm(@RequestParam("id") int snackid, ModelAndView model) {

		Snack existingsnack = snackservice.getSnackById(snackid);
		model.addObject("existingsnackid",existingsnack.getId());
		model.addObject("existingsnack",existingsnack.getSnackname());
		model.setViewName("/snack/Updateform.jsp") ;		 

		return model;
	}
	@GetMapping("/admin/vendorinsertform")
	private String showVendorInsertForm() {
		
		return "/vendor/Vendorinsertform.jsp";
	}

	//	@GetMapping("/snackupdateform/{sid}/")
	//	public String showSnackUpdateForm(@PathVariable("sid") int id, ModelAndView model)

	// 		 href="/snackupdateform/${temp.id}"
	
	@GetMapping("/admin/updatevendorform")
//	@GetMapping("/{vid}")
//	public ModelAndView showVendorUpdateForm(@PathVariable("vid") int vid,String number,String name, ModelAndView model)
	public ModelAndView showVendorUpdateForm(@RequestParam("vid") int vendorid,ModelAndView model)
	{
		//System.out.println(number);
		//System.out.println(name);
		Vendor existingvendor = vendorservice.getVendorById(vendorid);
		model.addObject("existingvendorid",existingvendor.getId());
		model.addObject("existingvendorname",existingvendor.getVendorname());
		model.addObject("existingcityname",existingvendor.getCity());
		model.addObject("existingstatename",existingvendor.getState());
		model.addObject("existingcountryname",existingvendor.getCountry());
		model.addObject("existingpincode",existingvendor.getPincode());
		model.addObject("existingmobilenumber",existingvendor.getMobilenumber());
		model.addObject("existinglandlinenumber",existingvendor.getLandlinenumber());
		model.addObject("existingemail",existingvendor.getEmail());


		model.setViewName("/vendor/Vendorupdateform.jsp");
		
		return model;


	}
	/*
	@GetMapping("/{id}")
	public String displayxxForm(@PathVariable("id") String id)
	{
		return "vendor/Vendorupdateform.jsp";
	}
	*/
	@GetMapping("/admin/snackassignmentform")
	private ModelAndView showAssignmentForm(ModelAndView model, Principal principal,HttpSession ss) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String uname = authentication.getName();
		
		Dsusers dsu = userservice.fetchUserDetails(uname);
		
		ss.setAttribute("empname", dsu.getName());
				
		String username = principal.getName();
		
		boolean assignmentTime = assignmentservice.checkAssignmentTime();
		String employeeName = dsu.getName();
		
		if(assignmentTime == false)
		{
			model.addObject("employeename", employeeName);
			model.addObject("assignmenttime", "Time is Over to Make a Snack Assignment");
			model.addObject("assignmenttimeerror", "Please make a Snack Assignment Before 12:30 PM");
			model.setViewName("/snackassignment/Snackassignmentform.jsp");
			return model;
		}
		
		List<Assignment> a = assignmentservice.getAssignmentDetails();
		
		if(a.size()>0)
		{
			Authentication an = SecurityContextHolder.getContext().getAuthentication();
			String un = authentication.getName();
			System.out.println("username is" + un);
			return new ModelAndView("redirect:/admin/adminhomepage");

		}
		else
		{
			model.addObject("noassignment","Today's Snack is not yet Assigned");
		}
		
		List<Snack>sns = snackservice.getSnacks();
		List<Vendor>vns = vendorservice.getVendors();
		model.addObject("snacklist", sns);
		model.addObject("vendorlist", vns);
		model.setViewName("/snackassignment/Snackassignmentform.jsp");

		return model;
	}
	@GetMapping("/assignmentupdateform")
	public String showAssignmentUpdateForm(@RequestParam("aid") int assignmentid, Model model)
	{
		String snackname = assignmentservice.getAssignmentById(assignmentid);
		List<Snack>sns = snackservice.getSnacks();
		List<Vendor>vns = vendorservice.getVendors();
		model.addAttribute("snackname", snackname);
		model.addAttribute("snacklist", sns);
		model.addAttribute("vendorlist",vns);
		model.addAttribute("assignmentid", assignmentid);
		return "snackassignment/Updatesnackassignmentform.jsp";
	}
	
	@GetMapping("/allemployees")
	public String fetchAllEmployees(Model model)
	{
		List<Dsusers>users = userservice.getAllEmployees();
		
		
		model.addAttribute("allemployees",users);
		
		return "employees/Allemployees.jsp";
		
	}
		
	@GetMapping("/admin/adminhomepage")
	public String showAdminHomepage(Principal principal,Model model)
	{
		String username = principal.getName();
		
		Dsusers dsu = userservice.fetchUserDetails(username);
		
		String authenticatedPerson = dsu.getName();
		
		List<Dsusers>allemps = userservice.fetchAllEmployees();
		
		int totalEmployees = allemps.size();
		
		List<Role>rls = roleservice.fetchAllRole();
		
	//	int yesSelectionCount = selectionservice.fetchYesSelectedEmployees();
		
		List<Assignment>as = assignmentservice.getAssignmentDetails();
		
		
		Map<String,Integer> selectionDetails = selectionservice.fetchSelectionCount();
				
		Map<String,Integer> empCategory = roleservice.fetchRoleBasedEmployeeCount(allemps,rls);
		
		if(as.size()>0)
		{
			String snackname = as.get(0).getSnack().getSnackname();
			
			model.addAttribute("assignedsnack", snackname);
		}
		else
		{
			model.addAttribute("assignedsnack", null);
		}
		
		model.addAttribute("authenticatedperson", authenticatedPerson);
		
		model.addAttribute("yesselection", selectionDetails.get("yescount"));
		model.addAttribute("noselection", selectionDetails.get("nocount"));
		model.addAttribute("noresponse", selectionDetails.get("noresponsecount"));
		
		model.addAttribute("superadmincount", empCategory.get("SuperAdmin"));
		model.addAttribute("admincount", empCategory.get("Admin"));
		model.addAttribute("usercount",empCategory.get("User"));
		model.addAttribute("totalemployees", totalEmployees);
		
		
		return "/Adminhomepage.jsp";
	}	
		
	@GetMapping("/admin/reportform")
	public String showSelectionReportform()
	{
		return "/report/Reportform.jsp";
	}
}
