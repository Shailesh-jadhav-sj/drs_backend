package com.example.drs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.drs.entity.Booking;
import com.example.drs.entity.Resources;

public interface BookingDao extends JpaRepository<Booking, Long>{


	@Query(value="select * from booking where rid_id in (select id from resources where did_did in (select did from poc where poc_id= ?1))",nativeQuery = true)
	public List<Booking> findBookingResources(Integer poc_id);
	
	
}
