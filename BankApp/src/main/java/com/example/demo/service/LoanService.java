package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LoanDao;
import com.example.demo.dto.LoanDto;
import com.example.demo.pojo.Loan;

@Service
public class LoanService {
	
	@Autowired
	private LoanDao loanDao;

	public List<LoanDto> findAllLoans() {
		
		
		List<Loan> loans = loanDao.findAll();
		
		List<LoanDto> loanDtos = new ArrayList<LoanDto>();
		
		for(Loan loan :loans) {
			LoanDto loanDto = new LoanDto();
			
			BeanUtils.copyProperties(loan, loanDto);
			
			
			loanDtos.add(loanDto);
			
		}
		
		
		return loanDtos;
		
	}

	public void processLoanDetail(LoanDto loanDto) {
		
		
		

			Loan loan = new Loan();
			
			BeanUtils.copyProperties(loanDto, loan);
			
			
			
			loanDao.save(loan);

			
			
		
		
		
		
		
	}

	public void deleteLoanById(Integer id) {
	
		loanDao.deleteById(id);
		
	}

	public LoanDto findLoanById(Integer id) {
		Loan loan = loanDao.getOne(id);
		
		LoanDto loanDto = new LoanDto();
		
		BeanUtils.copyProperties(loan, loanDto);
		
		return loanDto;
		
	}

	
}
