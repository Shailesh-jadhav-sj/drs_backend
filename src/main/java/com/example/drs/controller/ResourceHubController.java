package com.example.drs.controller;

import java.util.List;

import com.example.drs.entity.ResourceHub;
import com.example.drs.services.ResourceHubservice;
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



@RestController
@CrossOrigin
public class ResourceHubController {

	@Autowired
	private ResourceHubservice resourceHubService;
	
	@GetMapping("/resourcehub")
	public List<ResourceHub> getResource(){
		return this.resourceHubService.getResource();
	}
	
	//getting single ID data
		@GetMapping("/resourcehub/{resourcehubId}")
		public ResourceHub getSingleResource(@PathVariable Long resourcehubId) {
			return this.resourceHubService.getSingleResource(resourcehubId);
		}
		
		//inserting resources
		@PostMapping(path="/resourcehub",consumes="application/json")
		public ResourceHub addResource(@RequestBody ResourceHub resourceHub) {
			return this.resourceHubService.addResource(resourceHub);
		}
		
		//update resources 
		@PutMapping("/resourcehub")
		public ResourceHub updateResource(@RequestBody ResourceHub resourceHub) {
			return this.resourceHubService.updateResource(resourceHub);
		}
		
		@PutMapping("/resourcehub/{resourcehubId}")
	    public ResourceHub updateCourseById(@RequestBody ResourceHub resourceHub,@PathVariable Long resourcehubId)
	    {
	        return resourceHubService.updateResourseById(resourceHub, resourcehubId);
	    }
		
		@DeleteMapping("/resourcehub/{resourcehubId}")
		public ResponseEntity<HttpStatus> deleteResourse(@PathVariable String resourcehubId){
			try {
				this.resourceHubService.deleteResource(Long.parseLong(resourcehubId));
				return new ResponseEntity<>(HttpStatus.OK);
			}catch(Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
}
