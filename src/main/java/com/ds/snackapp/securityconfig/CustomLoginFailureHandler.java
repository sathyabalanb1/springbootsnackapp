package com.ds.snackapp.securityconfig;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ds.snackapp.entity.Dsusers;
import com.ds.snackapp.service.DsuserService;

@Component
public class CustomLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {
     
   
    @Autowired
    private DsuserService dsUserService;
    
    
     
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {
        String email = request.getParameter("username");
        Dsusers user = dsUserService.fetchUserDetails(email);
        
		if (user != null) {
			if (user.isAccountNonLocked()) {
				if (user.getFailedAttempt() > 1) {
					dsUserService.lock(user);
					exception = new LockedException("Your account has been locked due to 3 failed attempts."
							+ " It will be unlocked af ter 24 hours.");
				}

				dsUserService.increaseFailedAttempts(user);
			}
		// 	response.sendRedirect("/signin?badcredential=invalid");
		//	response.sendRedirect("/signin?badcredential="+"invalid");
			response.sendRedirect("/invalid?loginerror=invalid");
		//	super.setDefaultFailureUrl("/signin?badcredential=invalid");
		//	super.setDefaultFailureUrl("/signin?error");
		//	super.setDefaultFailureUrl("/login?error");

		}
        else
        {
        //	System.out.println("Error: User Not Found");
		//	System.out.println("testing "+request.getContextPath());
      //  response.encodeRedirectURL("/signin?badcredential=invalid");
        //response.encodeRedirectURL(email)
        	//response.sendRedirect("/signin?badcredential=invalid");
        //	response.sendRedirect("/signin?badcredential="+"invalid");
        	response.sendRedirect("/invalid?badcredential=invalid");
        //	super.setDefaultFailureUrl("/signin?badcredential=invalid");
        //	super.setDefaultFailureUrl("/signin?error");
        //	super.setDefaultFailureUrl("/login?error");
        }
		//response.sendRedirect("/common/snackselectionform");
		
//        super.onAuthenticationFailure(request, response, exception); // in query
    }
 
}