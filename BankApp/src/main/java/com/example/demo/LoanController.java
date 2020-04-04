package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.LoanDto;
import com.example.demo.service.LoginService;

@Controller
public class LoanController {
	
	@Autowired
	private LoginService loginService;
	
	
	@RequestMapping(value="loan",method=RequestMethod.GET)
	public String loan(Model model) {
		
		
		
	/*	
		List<LoanDto> loans = loginService.findAllLoans();
		
		model.addAttribute("loans",loans);
		
		*/
		
		
		return "loan.jsp";
		
		
		
	}

}
