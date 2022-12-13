package com.example.drs.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.drs.entity.Login;
import com.example.drs.entity.POC;
import com.example.drs.entity.ResourceHub;
import com.example.drs.services.POCService;
import com.example.drs.services.ResourceHubservice;

@RestController
@CrossOrigin
public class POCController {
	@Autowired
	private POCService pocService;
	
	@Autowired
	private ResourceHubservice resourceHubService;
	
	
	
	@CrossOrigin(origins="http://localhost:3000")
	
	//getting all data
	@GetMapping("/poc")
	public List<POC> getPoc(){
		return this.pocService.getPoc();
	}
	
	//getting single ID data
//	@GetMapping("/poc/{pocId}")
//	public POC getSinglePoc(@PathVariable Long pocId) {
//		return this.pocService.getSinglePoc(pocId);
//	}
	
	 @GetMapping("/poc/{pocId}")
	    public ResponseEntity<?> getSinglePoc(@PathVariable("pocId") Long pocId) {
	        Optional<POC> poc = pocService.getSinglePoc(pocId);
	        return ResponseEntity.status(HttpStatus.OK).body(poc);
	    }
	
	 @PostMapping(path="/pocCheck",consumes="application/json")
	 public List<POC> checkPoc(@RequestBody Login login)
	 {
		 return this.pocService.checkPoc(login.getId(), login.getPassword());
	 }
	//inserting resources
	@PostMapping(path="/poc",consumes="application/json")
	public POC addPoc(@RequestBody POC poc) {
		
		//System.out.println("@@@@ 11");
		//Resource res = resourceService.getSingleResource(resId);
		//System.out.println("@@@@ 22  = "+ res.getDname());
		//System.out.println("@@### res :"+res);
		return this.pocService.addPoc(poc);
		
		
	}
	
	//update resources 
	@PutMapping("/poc")
	public POC updatePoc(@RequestBody POC poc) {
		return this.pocService.updatePoc(poc);
	}
	

	//update resources by ID
	@PutMapping("/poc/{pocId}")
    public POC updatePocById(@RequestBody POC poc,@PathVariable Long pocId)
    {
        return pocService.updatePocById(poc, pocId);
    }
	
	
	//delete resources
	@DeleteMapping("/poc/{pocId}")
	public ResponseEntity<HttpStatus> deletePoc(@PathVariable String pocId){
		try {
			this.pocService.deletePoc(Long.parseLong(pocId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
