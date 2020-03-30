package com.example.demo;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;



public class CustomFilter implements Filter {
 
    @Override
    public void doFilter(ServletRequest req,  ServletResponse res, FilterChain chain) throws IOException, ServletException {
       
        
    	
    	
    	HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        String loginURI = request.getContextPath() + "/page";
        String loginPostURI = request.getContextPath() + "/dologin";

        boolean loggedIn = session != null && session.getAttribute("isLoggedIn") != null;
        boolean loginRequest = request.getRequestURI().equals(loginURI);
        boolean loginPost = request.getRequestURI().equals(loginPostURI);

        if (loggedIn || loginRequest || loginPost) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect(loginURI);
        }

    	
    	
    	
       
    }

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
 
    // other methods 
}