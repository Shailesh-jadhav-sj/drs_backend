package com.example.drs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.drs.entity.Login;
import com.example.drs.entity.POC;
import com.example.drs.entity.Resources;

public interface POCDao extends JpaRepository<POC,Long>{
	
	@Query(value="select *  from poc where poc_id =  ?1 and password = ?2",nativeQuery = true)
	public List<POC> checkPoc(long poc_id,String password);
	
}
