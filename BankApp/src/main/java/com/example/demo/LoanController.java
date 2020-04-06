package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.LoanDto;
import com.example.demo.service.LoanService;

@Controller
public class LoanController {
	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	
	
	
	@Autowired
	private LoanService loanService;
	
	
	@RequestMapping(value="loan",method=RequestMethod.GET)
	public String loan(Model model) {
		
		
		
	
		List<LoanDto> loans = loanService.findAllLoans();
		
		model.addAttribute("loans",loans);
		
		
		
		LoanDto loanDto = new LoanDto();
		
		model.addAttribute("loanDto",loanDto);
		
		
		
		return "loan.jsp";
		
		
		
	}
	
	
	@RequestMapping(value="processLoan",method=RequestMethod.POST)
	public String processLoan(Model model,@ModelAttribute("loanDto") LoanDto loanDto) {
		
		
		
		loanService.processLoanDetail(loanDto);
		
		List<LoanDto> loans = loanService.findAllLoans();
		
		model.addAttribute("loans",loans);
		
		
		loanDto = new LoanDto();
		
		model.addAttribute("loanDto",loanDto);
		
		
		return "loan.jsp";
	}
	
	
	@RequestMapping(value="deleteLoan",method=RequestMethod.GET)
	public String deleteLoan(Model model,@RequestParam("id") Integer id) {
		
		
		
		loanService.deleteLoanById(id);
		
		List<LoanDto> loans = loanService.findAllLoans();
		
		model.addAttribute("loans",loans);
		
		
		LoanDto loanDto = new LoanDto();
		
		model.addAttribute("loanDto",loanDto);
		
		
		return "loan.jsp";
	}
	
	
	
	@RequestMapping(value="editLoan",method=RequestMethod.GET)
	public String editLoan(Model model,@RequestParam("id") Integer id) {
		
		
		LoanDto loanDto = loanService.findLoanById(id);
		
		
		List<LoanDto> loans = loanService.findAllLoans();
		
		model.addAttribute("loans",loans);
		
		
	
		
		model.addAttribute("loanDto",loanDto);
		
		
		return "loan.jsp";
	}
	
	

}
