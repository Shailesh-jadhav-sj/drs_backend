package com.example.drs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.drs.entity.Booking;
import com.example.drs.entity.Resources;

public interface Resourcedao extends JpaRepository<Resources, Long> {

	@Query(value = "select * from resources where specification= ?1 and value = ?2",nativeQuery=true)
	public List<Resources> finda(String specification,String value);
	
	@Query(value="select * from resources where did_did = (select did from poc where poc_id= ?1)",nativeQuery = true)
	public List<Resources> findPocResources(Integer poc_id);
	
	@Query(value="SELECT * FROM resources where id not in (select rid_id from booking where endtime  > ?1 ) and specification= ?2 and value = ?3 and did_did = ?4",nativeQuery = true)
	public List<Resources> findAvbResources(Integer stime,String spec,String value,Integer did);
	
}
