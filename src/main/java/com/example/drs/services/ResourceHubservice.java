package com.example.drs.services;

import java.util.List;

import com.example.drs.entity.ResourceHub;

public interface ResourceHubservice {

public List<ResourceHub> getResource();
	
	ResourceHub getSingleResource(long resourceId);
	
	public ResourceHub addResource(ResourceHub resourceHub);

	public ResourceHub updateResource(ResourceHub resourceHub);
	
	public void deleteResource(long resourceId);
	
	ResourceHub updateResourseById(ResourceHub resourceHub,long resourceId);
}
