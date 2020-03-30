package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.dto.MenuDto;
import com.example.demo.dto.UserDto;
import com.example.demo.pojo.Menu;
import com.example.demo.pojo.User;


@Service
public class AdminService {
	
	@Autowired
	private UserDao userDao;
	
	
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
}
