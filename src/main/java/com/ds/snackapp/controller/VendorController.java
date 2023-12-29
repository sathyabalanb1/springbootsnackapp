package com.ds.snackapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ds.snackapp.entity.Vendor;
import com.ds.snackapp.service.VendorService;

@Controller
public class VendorController {
	@Autowired
	private VendorService vendorservice;
	
	@PostMapping("/addvendor")
	public String addVendor (Vendor vendor)
	{
		
		vendorservice.createVendor(vendor);
		
		return "vendor/Vendorinsertform.jsp";
	}
	@GetMapping("/admin/vendors")
	public String fetchAllVendors(Model model)
	{
		List<Vendor>vns = vendorservice.getVendors();
		model.addAttribute("vendors",vns);
		
		return "/vendor/Vendorlist.jsp";
		
	}
	@PostMapping("/updatevendor")
	public ModelAndView editVendor(Vendor vendor)
	{
		ModelAndView model = new ModelAndView();
		
		Vendor resultvendor=vendorservice.updateVendor(vendor);
		
		return new ModelAndView("redirect:/vendors");
				
	}
	@GetMapping("/admin/deletevendor")
	public ModelAndView removeVendor(@RequestParam("vid") int vendorid) {
		 
			vendorservice.deleteVendor(vendorid);
		 
			return new ModelAndView("redirect:/vendors");
		
	}
}
