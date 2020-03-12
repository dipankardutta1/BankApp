package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.pojo.Menu;
import com.example.demo.pojo.User;

@Repository
public interface UserDao extends JpaRepository<User,Integer>{
	
	@Query("from User where username=?1 and password=?2")
	User findByUsernameAndPassword(String username,String password);

	@Query("select a from Menu as a inner join a.menuRoleMapList as b inner join b.role as c inner join c.userRoleMapList as d inner join d.user as e where e.id = ?1")
	List<Menu> findMenusById(Integer id);
	

}
