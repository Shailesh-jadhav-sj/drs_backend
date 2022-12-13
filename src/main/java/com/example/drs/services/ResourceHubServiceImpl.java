package com.example.drs.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.drs.dao.ResourceHubDao;
import com.example.drs.entity.ResourceHub;
@Service
public class ResourceHubServiceImpl implements ResourceHubservice{

	@Autowired
	private ResourceHubDao resourceHubDao;
	@Override
	public List<ResourceHub> getResource() {
		return resourceHubDao.findAll();
		
	}

	@Override
	public ResourceHub getSingleResource(long resourceId) {
		Optional<ResourceHub> resourceHub = resourceHubDao.findById(resourceId);
		if(resourceHub.isPresent()) {
			return resourceHub.get();
		}
		throw new RuntimeException("Resource not found with id : "+ resourceId);
		
	}

	@Override
	public ResourceHub addResource(ResourceHub resourceHub) {
		resourceHubDao.save(resourceHub);
		return resourceHub;
	}

	@Override
	public ResourceHub updateResource(ResourceHub resourceHub) {
		resourceHubDao.save(resourceHub);
		return resourceHub;
	}

	@Override
	public void deleteResource(long resourceId) {
		ResourceHub entity=resourceHubDao.getOne(resourceId);
		resourceHubDao.delete(entity);
		
	}

	@Override
	public ResourceHub updateResourseById(ResourceHub resourceHub, long resourceId) {
		ResourceHub resourceDB = resourceHubDao.findById(resourceId).get();
		 
        if (Objects.nonNull(resourceHub.getDname()) && !"".equalsIgnoreCase(resourceHub.getDname())) {
        	resourceDB.setDname(resourceHub.getDname());
        }
 
        return resourceHubDao.save(resourceDB);
	}
	
}
