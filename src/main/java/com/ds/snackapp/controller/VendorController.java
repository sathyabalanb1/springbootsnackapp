package com.ds.snackapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ds.snackapp.entity.Assignment;
import com.ds.snackapp.entity.Vendor;
import com.ds.snackapp.service.AssignmentService;
import com.ds.snackapp.service.VendorService;

@Controller
public class VendorController {
	@Autowired
	private VendorService vendorservice;
	
	@Autowired
	private AssignmentService assignservice;
	
	@PostMapping("/addvendor")
	public ModelAndView addVendor (Vendor vendor)
	{
		
		vendorservice.createVendor(vendor);
		
		return new ModelAndView("redirect:/admin/vendors");
	}
	@GetMapping("/admin/vendors")
	public String fetchAllVendors(@RequestParam(required=false) String vendordelete, Model model)
	{
		List<Vendor>vns = vendorservice.getVendors();
		model.addAttribute("vendors",vns);
		
		model.addAttribute("deleteinfo",vendordelete);

		
		return "/vendor/Vendorlist.jsp";
		
	}
	@PostMapping("/updatevendor")
	public ModelAndView editVendor(Vendor vendor)
	{
		ModelAndView model = new ModelAndView();
		
		Vendor resultvendor=vendorservice.updateVendor(vendor);
		
		return new ModelAndView("redirect:/admin/vendors");
				
	}
	@GetMapping("/admin/deletevendor")
	public ModelAndView removeVendor(@RequestParam("vid") int vendorid) {
		
		    Assignment ass = assignservice.getAssignedVendor(vendorid);
		    
		    if(ass != null)
			{
			   return new ModelAndView("redirect:/admin/vendors?vendordelete="+ass.getVendor().getVendorname());
			}
			else
			{
				vendorservice.deleteVendor(vendorid);
				 
				return new ModelAndView("redirect:/admin/vendors");
	        }
		
	}
}
