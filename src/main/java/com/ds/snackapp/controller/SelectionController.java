package com.ds.snackapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ds.snackapp.entity.Role;
import com.ds.snackapp.entity.Selection;
import com.ds.snackapp.service.SelectionService;

@Controller
public class SelectionController {
	
	@Autowired
	SelectionService selectionservice;
	
	@PostMapping("/insertselection")
	public ModelAndView insertSelection(Selection selectiondetails)
	{				
		int userid = selectiondetails.getDsuser().getId();
		Role role = selectiondetails.getDsuser().getRoleid();
		int roleid = role.getId();
		int assignmentid = selectiondetails.getAssignment().getId();
		
		boolean selectionvalue = selectiondetails.isEnabled();
	/*	
		Selection existingselection = selectionservice.fetchSelectionDetails(assignmentid,userid);	
		
		
		if(existingselection != null)
		{
			selectionservice.updateSelection(existingselection,selectiondetails);
			
		    return	selectionservice.redirectToHomepage(roleid);
			
		}
	*/
		
		selectionservice.addSelection(selectiondetails);
		
		return new ModelAndView("redirect:/common/snackselectionform");
		
	}
	
	@PostMapping("/updateselection")
	public ModelAndView updateSelection(Selection selectiondetails)
	{
		int userid = selectiondetails.getDsuser().getId();
		Role role = selectiondetails.getDsuser().getRoleid();
		int roleid = role.getId();
		int assignmentid = selectiondetails.getAssignment().getId();
		
		boolean selectionvalue = selectiondetails.isEnabled();
		
		Selection existingselection = selectionservice.fetchSelectionDetails(assignmentid,userid);
		
		selectionservice.updateSelection(existingselection,selectiondetails);
		
		return new ModelAndView("redirect:/common/snackselectionform"); 
		
	}


}
