package com.ds.snackapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.ds.snackapp.entity.Assignment;
import com.ds.snackapp.entity.Dsusers;
import com.ds.snackapp.entity.Selection;
import com.ds.snackapp.repository.SelectionRepository;

@Service
public class SelectionService {
	@Autowired
	private SelectionRepository selectionrepository;
		
	
	public Selection addSelection(Selection selectiondetails)
	{
		return selectionrepository.save(selectiondetails);
	}
	
	public Selection fetchSelectionDetails(int assignmentid, int userid)
	{
		Selection sl = selectionrepository.findUserselection(assignmentid,userid);
		//System.err.println(sl);
		
		
		return sl;
	}
	public Selection updateSelection(Selection existingselection,Selection selectiondetails)
	{
		existingselection.setEnabled(selectiondetails.isEnabled());
		
		return selectionrepository.save(existingselection);
		
	}
	
	public ModelAndView redirectToHomepage(int roleid)
	{
		if(roleid == 1 || roleid == 2)
		{
			return new ModelAndView("redirect:/admin/adminhomepage");
		}
		else
		{
			return new ModelAndView("redirect:/userhomepage");
		}
	}

}
