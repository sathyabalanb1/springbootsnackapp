package com.ds.snackapp.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ds.snackapp.dto.AssignmentDTO;
import com.ds.snackapp.entity.Assignment;
import com.ds.snackapp.entity.Snack;
import com.ds.snackapp.entity.Vendor;
import com.ds.snackapp.service.AssignmentService;
import com.ds.snackapp.service.SnackService;
import com.ds.snackapp.service.VendorService;

@Controller
public class AssignmentController {
	@Autowired
	private AssignmentService assignmentservice;
	
	@Autowired
	private VendorService vendorservice;
	
	@Autowired
	private SnackService snackservice;
/*
	@PostMapping("/addassignment")
	public String addAssignment(@RequestParam("dates") String date,AssignmentDTO assignment, Model model)
	{
		String message = assignmentservice.createAssignment(assignment,date);
				
		if(message == null)
		{
			model.addAttribute("assignmentinfo", false);
			
			return "snackassignment/Snackassignmentform.jsp";
		}
		else
		{
			model.addAttribute("assignmentinfo",true);
			return "snackassignment/Snackassignmentform.jsp";
		}
		
	//	return new ModelAndView("redirect:/assignments");
	}
*/
	@PostMapping("/addassignment")
	public ModelAndView addAssignment(@RequestParam("dates") String date,AssignmentDTO assignment)
	{
		String message = assignmentservice.createAssignment(assignment,date);
		
		List<Snack>sns = snackservice.getSnacks();
		List<Vendor>vns = vendorservice.getVendors();
		
		ModelAndView model = new ModelAndView();		
				
		if(message == null)
		{
			model.addObject("assignmentinfo", false);
			model.addObject("snacklist", sns);
			model.addObject("vendorlist", vns);
			model.setViewName("snackassignment/Snackassignmentform.jsp");
			return model;
		}
		else
		{
			model.addObject("assignmentinfo",true);
			model.addObject("snacklist", sns);
			model.addObject("vendorlist", vns);
			model.setViewName("snackassignment/Snackassignmentform.jsp");
			return model;
		}
		
	//	return new ModelAndView("redirect:/assignments");
	}
	@GetMapping("/assignments")
	public String fetchAllAssignments(Model model)
	{
		List<Assignment>assignments = assignmentservice.getAssignments();

		model.addAttribute("assignments", assignments);

		return "snackassignment/Assignmentlist.jsp";

	}
	@GetMapping("/updateassignment")
	public ModelAndView updateAssignment(@RequestParam("snacksId") int snackid,@RequestParam("vendorId") int vendorid,@RequestParam("assignmentid") int assignmentid)
	{
		//ModelAndView model = new ModelAndView();
		assignmentservice.editAssignment(snackid,vendorid,assignmentid);
		
	//	model.addObject("editassignmentinfo", "Assignment id Edited Successfully");
		
	//	model.setViewName("snackassignment/Assignmentlist.jsp");
		
		return new ModelAndView("redirect:/assignments");

	}
	@GetMapping("/deleteassignment")
	public ModelAndView deleteAssignment(@RequestParam("aid") int assignmentid) {
		 
			assignmentservice.removeAssignment(assignmentid);
		 
			return new ModelAndView("redirect:/assignments");
		
	}
	@GetMapping("/name")
	public String userName(Principal principal) {
		 
		System.out.println(principal.getName());
		
		
			return "done";
		
	}
	
	
}
