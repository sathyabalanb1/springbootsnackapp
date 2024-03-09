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
				if (user.getFailedAttempt() > 2) {
					System.out.println("aaaaa"+":"+user.getFailedAttempt());
					dsUserService.lock(user);
					exception = new LockedException("Your account has been locked due to 3 failed attempts."
							+ " It will be unlocked after 24 hours.");
				}

				dsUserService.increaseFailedAttempts(user);
			}

		}
        else
        {
        	System.out.println("Error: User Not Found");
        }
		
		super.setDefaultFailureUrl("/signin");
        super.onAuthenticationFailure(request, response, exception); // in query
    }
 
}