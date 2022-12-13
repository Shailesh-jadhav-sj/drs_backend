package com.example.drs.services;

import java.util.List;
import java.util.Optional;

import com.example.drs.entity.Login;
import com.example.drs.entity.POC;
import com.example.drs.entity.ResourceHub;


public interface POCService {
	public List<POC> getPoc();
	
//	POC getSinglePoc(long pocId);
	
	ResourceHub getSingleResource(long resourceId);
	
	public POC addPoc(POC poc);

	public POC updatePoc(POC poc);
	
	public void deletePoc(long pocId);
	
	POC updatePocById(POC poc,long pocId);

	Optional <POC> getSinglePoc(long pocId);
	
	public List<POC> checkPoc(long pocId,String password);
}
