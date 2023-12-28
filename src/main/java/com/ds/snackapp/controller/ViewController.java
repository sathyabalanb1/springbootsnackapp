package com.ds.snackapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ds.snackapp.entity.Assignment;
import com.ds.snackapp.entity.Dsusers;
import com.ds.snackapp.entity.Snack;
import com.ds.snackapp.entity.Vendor;
import com.ds.snackapp.service.AssignmentService;
import com.ds.snackapp.service.DsuserService;
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
	
	@GetMapping("/appfront")
	private String showFrontpage()
	{
		return "Appfrontpage.jsp";
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

	@GetMapping("/user/homepage")
	private String showHomePage() {

		return "Userhomepage.jsp";
	}

	@GetMapping("/addsnackform")
	private String showSnackInsertForm() {
		return "/snack/Snackinsertform.jsp";
	}

	@GetMapping("/snackupdateform")
	public ModelAndView showUpdateSnackForm(@RequestParam("id") int snackid, ModelAndView model) {

		Snack existingsnack = snackservice.getSnackById(snackid);
		model.addObject("existingsnackid",existingsnack.getId());
		model.addObject("existingsnack",existingsnack.getSnackname());
		model.setViewName("snack/Updateform.jsp") ;		 

		return model;
	}
	@GetMapping("/vendorinsertform")
	private String showVendorInsertForm() {
		
		return "vendor/Vendorinsertform.jsp";
	}

	//	@GetMapping("/snackupdateform/{sid}/")
	//	public String showSnackUpdateForm(@PathVariable("sid") int id, ModelAndView model)

	// 		 href="/snackupdateform/${temp.id}"
	
	@GetMapping("/updatevendorform")
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


		model.setViewName("vendor/Vendorupdateform.jsp");
		
		return model;


	}
	/*
	@GetMapping("/{id}")
	public String displayxxForm(@PathVariable("id") String id)
	{
		return "vendor/Vendorupdateform.jsp";
	}
	*/
	@GetMapping("/snackassignmentform")
	private ModelAndView showAssignmentForm(ModelAndView model) {
		List<Snack>sns = snackservice.getSnacks();
		List<Vendor>vns = vendorservice.getVendors();
		model.addObject("snacklist", sns);
		model.addObject("vendorlist", vns);
		model.setViewName("snackassignment/Snackassignmentform.jsp");

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
	@GetMapping("/all")
	@ResponseBody
	public String home()
	{
		return ("<h1>Welcome Home</h1>");
	}
	@GetMapping("/user")
	@ResponseBody
	public String user()
	{
		return ("<h1>Welcome User</h1>");
	}
	@GetMapping("/admin")
	@ResponseBody
	public String admin()
	{
		return ("<h1>Welcome Admin</h1>");
	}
	@GetMapping("/allemployees")
	public String fetchAllEmployees(Model model)
	{
		List<Dsusers>users = userservice.getAllEmployees();
		
		
		model.addAttribute("allemployees",users);
		
		return "employees/Allemployees.jsp";
		
	}
	
	@GetMapping("/snackselectionform")
	private ModelAndView showSnackSelectionForm(ModelAndView model) {
		
	List<Assignment>ass=assignmentservice.getAssignmentDetails();
	
	String assigneddate = ass.get(0).getAssigneddate();
	
	String snackname = ass.get(0).getSnack().getSnackname();
	
	String vendorname = ass.get(0).getVendor().getVendorname();
	
	model.addObject("assigneddate", assigneddate);
	model.addObject("snackname", snackname);
	model.addObject("vendorname", vendorname);
	model.setViewName("snackselection/Snackselectionform.jsp");
	
	return model;
				
	}
	
	@GetMapping("/adminhomepage")
	public String showAdminHomepage()
	{
		return "Adminhomepage.jsp";
	}
	
	@GetMapping("/invalid")
	public String invalid()
	{
		return "Error.jsp";
	}
	
	@GetMapping("/logoutpage")
	public String logoutPage() {
		return "authentication/logoutpage.jsp";
}
	

}
