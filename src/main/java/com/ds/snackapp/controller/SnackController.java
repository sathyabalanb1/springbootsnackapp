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

import com.ds.snackapp.entity.Snack;
import com.ds.snackapp.service.SnackService;

@Controller
public class SnackController {
	@Autowired
	private SnackService snackservice;
	
	@PostMapping("/addsnack")
	public ModelAndView addSnack(Snack snack )
	{
				
		snackservice.createSnack(snack);
		
		return new ModelAndView("redirect:/snacks");
	}
	@GetMapping("/admin/snacks")
	public String fetchAllSnacks(Model model,Principal principal)	
	{
		//System.out.println(principal.get);
		List<Snack>snacks = snackservice.getSnacks();
		model.addAttribute("availablesnacks",snacks);
	//	model.put("snacklist",snacklist);
	//	return "Snacklist.jsp";
		
		return "/snack/Availablesnacks.jsp";
	}
/*	
	@GetMapping("/editsnack/{id}")
	public String editSnack(int id, Model model)
	{		
		Snack existingsnack = snackservice.getSnackById(id);
		Snack updatedsnack = snackservice.updateSnack(existingsnack);
		model.addAttribute("snacks",updatedsnack);
	//	model.put("snacklist",snacklist);
		return "Snacklist.jsp";
	}
*/	
	@PostMapping("/updatesnack")
	public ModelAndView editSnack(Snack snack)
	{
	//	int snackid = snack.getId();
		
	//	Snack existingsnack = snackservice.getSnackById(snackid);
		
	//	snackservice.updateSnack(snackid);
		
		ModelAndView model = new ModelAndView();
		
		Snack resultsnack=snackservice.updateSnack(snack);
		
	//	model.setViewName("Snacklist.jsp");
	//	return "Snacklist.jsp";
		
		return new ModelAndView("redirect:/snacks");
				
	}
	
	@GetMapping("/admin/deletesnack")
	public ModelAndView deleteProduct(@RequestParam("id") int snackid) {
		 
			snackservice.deleteSnack(snackid);
		 
			return new ModelAndView("redirect:/snacks");		
	}

}
