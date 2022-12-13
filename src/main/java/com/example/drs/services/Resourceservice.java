package com.example.drs.services;

import java.util.List;

import com.example.drs.entity.Booking;
import com.example.drs.entity.Resources;

public interface Resourceservice {
	
	public List<Resources> getResources(String specification,String value);
	public Resources addResource(Resources resource);
	public List<Resources> getAllResources();
	public Resources updateResource(Resources resource);
	public Resources deleteResources(long resourceId);
	public Resources updateByIdResources(Resources resource,long resourceId);
	public List<Resources> findPocResources(Integer poc_id);
	public List<Booking> findBookingResources(Integer poc_id);
	

}
