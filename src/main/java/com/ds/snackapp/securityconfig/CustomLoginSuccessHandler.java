package com.ds.snackapp.securityconfig;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.ds.snackapp.entity.Dsusers;
import com.ds.snackapp.principle.UserPrinciple;
import com.ds.snackapp.service.DsuserService;

@Component
public class CustomLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	@Autowired
	private DsuserService dsUserService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		System.out.println("1111111");

		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		Dsusers user = dsUserService.fetchUserDetails(email);

		if (user.getFailedAttempt() >= 3) {
			// super.setTargetUrlParameter("/displayforgotpasswordform");
			System.out.println("22222");
			if(!user.isAccountNonLocked())
			{
				response.sendRedirect("/signin?accountlockerror=true");
			}
			else
			{
			response.sendRedirect("/displayforgotpasswordform");
			}
		} else {
			System.out.println("33333");
			for (GrantedAuthority authority : authentication.getAuthorities()) {
				if (authority.getAuthority().equals("SuperAdmin")) {
					response.sendRedirect("/admin/snackassignmentform");
					return;
				} else if (authority.getAuthority().equals("Admin")) {
					response.sendRedirect("/admin/snackassignmentform");
					return;
				}
			}
			response.sendRedirect("/common/snackselectionform");
		}
		// super.onAuthenticationSuccess(request, response, authentication);
	}

	public ModelAndView redirectToResetPassword(Dsusers user) {
		// boolean accountstatus = user.isAccountNonLocked();

		int count = user.getFailedAttempt();

		if (count > 0) {
			String temp = "abcdefghijklmno";
			return new ModelAndView("redirect:/displayforgotpasswordform");
		} else {
			return new ModelAndView();
		}
	}

}
