package com.ds.snackapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ds.snackapp.entity.Selection;
import com.ds.snackapp.service.SelectionService;

@Controller
public class SelectionController {
	
	@Autowired
	SelectionService selectionservice;
	
	@PostMapping("/insertselection")
	public ModelAndView insertSelection(Selection selectiondetails)
	{
		
		selectionservice.addSelection(selectiondetails);
		
		return new ModelAndView("redirect:/admin/snacks");	
				
	}

}
