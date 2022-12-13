package com.example.drs.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.drs.dao.BookingDao;
import com.example.drs.dao.Resourcedao;
import com.example.drs.entity.Booking;
import com.example.drs.entity.Resources;

@Service
public class Resourceserviceimpl implements Resourceservice {

	@Autowired
	private Resourcedao resourcedao;
	
	@Autowired
	private BookingDao bookingdao;
	
	@Override
	public List<Resources> getResources(String specification,String value) {
		
		return resourcedao.finda(specification,value);
	}
	@Override
	public Resources addResource(Resources resource) {
		// TODO Auto-generated method stub
		resourcedao.save(resource);
		return resource;
	}
	@Override
	public List<Resources> getAllResources() {
		
		return resourcedao.findAll();
	}
	@Override
	public Resources updateResource(Resources resource) {
		resourcedao.save(resource);
		return resource;
	}
	@Override
	public Resources deleteResources(long resourceId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Resources updateByIdResources(Resources resource, long resourceId) {
		Resources resourcedb = resourcedao.findById(resourceId).get();
		 if (Objects.nonNull(resource.getName()) &&Objects.nonNull(resource.getSpecification())&&Objects.nonNull(resource.getValue())&&Objects.nonNull(resource.getDtime())&&Objects.nonNull(resource.getDid())&& !"".equalsIgnoreCase(resource.getName())&& !"".equalsIgnoreCase(resource.getSpecification())&& !"".equalsIgnoreCase(resource.getValue())) {
	        	resourcedb.setName(resource.getName());
	        	resourcedb.setSpecification(resource.getSpecification());
	        	resourcedb.setValue(resource.getValue());
	        	resourcedb.setDtime(resource.getDtime());
	        	resourcedb.setDid(resource.getDid());
	        }
		return resourcedao.save(resourcedb);
	}
	@Override
	public List<Resources> findPocResources(Integer poc_id) {
		// TODO Auto-generated method stub
		return resourcedao.findPocResources(poc_id);
	}
	@Override
	public List<Booking> findBookingResources(Integer poc_id) {
		return bookingdao.findBookingResources(poc_id);
	}
	

}
