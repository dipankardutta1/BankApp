package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.LoanDto;
import com.example.demo.dto.MenuDto;
import com.example.demo.dto.UserDto;
import com.example.demo.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="page")
	public String goToLoginPage() {
		
		
		return "login";
	}
	
	
	@RequestMapping(value="dologin",method=RequestMethod.POST)
	public String dologin(Model model,@RequestParam("username") String username,@RequestParam("password") String password) {
		
		UserDto userDto =  loginService.findUserByUsernameAndPassword(username, password);
		
		if(userDto == null) {
			return "login";
		}else {
			
			
			List<MenuDto> menus = loginService.findMenusById(userDto.getId());
			
			model.addAttribute("menus", menus);
			
			return "dashboard";
		}
		
		
		
	}
	
	
	
	@RequestMapping(value="loan",method=RequestMethod.GET)
	public String loan(Model model) {
		
		
		
		
		List<LoanDto> loans = loginService.findAllLoans();
		
		model.addAttribute("loans",loans);
		
		return "loan";
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
