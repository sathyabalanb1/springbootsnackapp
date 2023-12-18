package com.ds.snackapp.generic;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ds.snackapp.entity.Dsusers;

@Component
public class CommonFunctions {
	
	public void createSession(List<Dsusers>dsuser)
	{
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 
		 String username = authentication.getName();
		 HttpServletRequest request = null;
		 HttpSession session = request.getSession(); 
		 
		 return;
	}
	 @RequestMapping("/formLoginSuccess")
	 @ResponseBody
	 public String formLoginSuccess(Principal principal,HttpSession session) {
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String username = authentication.getName();
			System.out.println("username is" + username);
			session.setAttribute("username", username);
			return "ok";
	 }

}
