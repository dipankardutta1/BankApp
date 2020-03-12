package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LoanDao;
import com.example.demo.dao.UserDao;
import com.example.demo.dto.LoanDto;
import com.example.demo.dto.MenuDto;
import com.example.demo.dto.UserDto;
import com.example.demo.pojo.Loan;
import com.example.demo.pojo.Menu;
import com.example.demo.pojo.User;

@Service
public class LoginService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private LoanDao loanDao;
	
	public UserDto findUserByUsernameAndPassword(String username,String password) {
		
		
		User user = userDao.findByUsernameAndPassword(username, password);
		
		
		if(user == null) {
			return null;
		}else {
			UserDto userDto = new UserDto();
			
			BeanUtils.copyProperties(user, userDto);
			
			return userDto;
		}
		
		
		
		
	}


	public List<MenuDto> findMenusById(Integer id) {
		List<Menu> menus = userDao.findMenusById(id);
		
		
		List<MenuDto> menuDtos = new ArrayList<MenuDto>();
		
		for(Menu menu : menus) {
			
			MenuDto menuDto = new MenuDto();
			
			BeanUtils.copyProperties(menu, menuDto);
			
			menuDtos.add(menuDto);
			
		}
		
		
		return menuDtos;
		
		
	}


	public List<LoanDto> findAllLoans() {
		List<Loan> loans = loanDao.findAll();
		
		
		List<LoanDto> loanDtos = new ArrayList<LoanDto>();
		
		for(Loan loan : loans) {
			
			LoanDto loanDto = new LoanDto();
			
			BeanUtils.copyProperties(loan, loanDto);
			
			loanDtos.add(loanDto);
			
		}
		
		
		return loanDtos;
	}
	

}
