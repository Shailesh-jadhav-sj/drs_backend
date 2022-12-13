package com.example.drs.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.drs.dao.POCDao;
import com.example.drs.dao.ResourceHubDao;
import com.example.drs.entity.Login;
import com.example.drs.entity.POC;
import com.example.drs.entity.ResourceHub;


@Service
public class POCServiceImpl implements POCService {
	@Autowired
	private POCDao pocDao;
	
	@Autowired
	private ResourceHubDao resourceHubDao;
	
	@Override
	public List<POC> getPoc() {
		return pocDao.findAll();
	}
	
	@Override
	public Optional<POC> getSinglePoc(long pocId) {
		return pocDao.findById(pocId);
		//return pocDao.findById(pocId).get();
//		Optional<POC> poc = pocDao.findById(pocId);
//		if(poc.isPresent()) {
//			return poc.get();
//		}
//		throw new RuntimeException("POC not found with id : "+ pocId);
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
	public POC addPoc(POC poc) {
		pocDao.save(poc);
		return poc;
	}

	@Override
	public POC updatePoc(POC poc) {
		pocDao.save(poc);
		return poc;
	}

	@Override
    public POC updatePocById(POC poc,long pocId)
    {
		POC pocDB = pocDao.findById(pocId).get();
 
        if (Objects.nonNull(poc.getPocName()) && !"".equalsIgnoreCase(poc.getPocName())) {
        	pocDB.setPocName(poc.getPocName());
        }
 
        return pocDao.save(pocDB);
    }
	
	@Override
	public void deletePoc(long pocId) {
		POC entity=pocDao.getOne(pocId);
		pocDao.delete(entity);
	}

	@Override
	public List<POC> checkPoc(long pocId, String password) {
		
		return pocDao.checkPoc(pocId, password);
	}
}
