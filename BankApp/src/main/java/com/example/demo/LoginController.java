package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.MenuDto;
import com.example.demo.dto.UserDto;
import com.example.demo.service.AdminService;
import com.example.demo.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="login")
	public String goToLoginPage() {
		
		
		return "login.jsp";
	}
	
	
	@RequestMapping(value="dologin",method=RequestMethod.POST)
	public String dologin(Model model,HttpSession session, @RequestParam("username") String username,@RequestParam("password") String password) {
		
		
		
		
		UserDto userDto =  adminService.findUserByUsernameAndPassword(username, password);
		
		if(userDto == null) {
			return "login.jsp";
		}else {
			
			session.setAttribute("isLoggedIn", true);
			
			List<MenuDto> menus = adminService.findMenusById(userDto.getId());
			
			session.setAttribute("menus", menus);
			
			return "dashboard.jsp";
		}
		
		
		
	}
	
	
	@RequestMapping(value="logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:page";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
