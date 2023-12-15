package com.ds.snackapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ds.snackapp.entity.Snack;
import com.ds.snackapp.entity.Vendor;
import com.ds.snackapp.service.SnackService;
import com.ds.snackapp.service.VendorService;
import com.ds.snackapp.service.AssignmentService;


@Controller
public class ViewController {
	@Autowired
	private SnackService snackservice;
	@Autowired
	private VendorService vendorservice;
	@Autowired
	private AssignmentService assignmentservice;

	@GetMapping("/registerform")
	private String showRegisterForm() {
		// TODO Auto-generated method stub
		//return "hi";
	//	return "demo.jsp";
		return "Dsuserregister.jsp";
	}

	@GetMapping("/loginform")
	private String showLoginForm() {

		return "Loginform.jsp";
	}

	@GetMapping("/homepage")
	private String showHomePage() {

		return "index.html";
	}

	@GetMapping("/addsnackform")
	private String showSnackInsertForm() {
		return "snack/Snackinsertform.jsp";
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


}
