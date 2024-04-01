package com.ds.snackapp.securityconfig;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.ds.snackapp.entity.Dsusers;
import com.ds.snackapp.service.DsuserService;

@Component
public class CustomLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	@Autowired
	private DsuserService dsUsrService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		HttpSession sess = request.getSession();
	//	HttpSession sess; when i declare like this it shows error "local variable sess not have been initialized"
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		Dsusers user = dsUsrService.fetchUserDetails(email);

		if (user.getFailedAttempt() >= 3) {
			// super.setTargetUrlParameter("/displayforgotpasswordform");
			if(!dsUsrService.isLockTimeExpired(user))
			{
				long minutes = dsUsrService.getRemainingTime(user);
				
				response.sendRedirect("/signin?accountlockerror="+minutes);
				
			}
			else
			{
			response.sendRedirect("/displayforgotpasswordform");
			}
		} else {
			sess.setAttribute("empname", user.getName());
			sess.setAttribute("currentstatus", "alive");

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
			return new ModelAndView("redirect:/displayforgotpasswordform");
		} else {
			return new ModelAndView();
		}
	}

}
