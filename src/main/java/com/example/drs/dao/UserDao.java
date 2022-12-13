package com.example.drs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.drs.entity.POC;
import com.example.drs.entity.User;

public interface UserDao extends JpaRepository<User, Long>{

	@Query(value="select *  from user where email =  ?1 and password = ?2",nativeQuery = true)
	public List<User> checkUser(String email,String password);
}
