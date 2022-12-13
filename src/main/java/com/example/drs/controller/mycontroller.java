package com.example.drs.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.drs.entity.Booking;
import com.example.drs.entity.ResourceHub;
import com.example.drs.entity.Resources;
import com.example.drs.services.Resourceservice;

@RestController
@CrossOrigin
public class mycontroller {

	@Autowired
	private Resourceservice resourceservice;
	
	@GetMapping("/home")
	public String home() {
		return "this";
	}	
	
	@GetMapping("/Resources/")
	public List<Resources> getResources(@RequestParam("specification") String specification,@RequestParam("value") String value) {
		
		return this.resourceservice.getResources(specification,value);
		
	}
	
	@GetMapping("/Resources_poc")
	public List<Resources> findPocResources(@RequestParam("poc_id")Integer poc_id){
		return this.resourceservice.findPocResources(poc_id);
	}
	
	@GetMapping("/get_avb_resource")
	public List<Resources> findAvbResources(@RequestParam ("stime")Integer stime , @RequestParam ("spec") String spec,@RequestParam ("value") String value, @RequestParam ("did") Integer did)
	{
		return this.resourceservice.findAvbResources(stime, spec, value, did);
	}
	
	@GetMapping("/Booking_Resources_poc")
	public List<Booking> findBookingResources(@RequestParam("poc_id")Integer poc_id){
		return this.resourceservice.findBookingResources(poc_id);
	}
	@GetMapping("/Resources")
	public List<Resources> getAllResources(){
		return this.resourceservice.getAllResources();
	}
	
	@PostMapping("/Resources")
	public Resources addResources(@RequestBody Resources resources)
	{
		return 	this.resourceservice.addResource(resources);
		
	}
	
	@PutMapping("/Resources/{resourceid}")
	public Resources updateResources(@RequestBody Resources resource,@PathVariable Long resourceid)
    {
        return resourceservice.updateByIdResources(resource, resourceid);
    }
	
	@DeleteMapping("/Resources/{resourceid}")
	public ResponseEntity<HttpStatus> deleteResourse(@PathVariable long resourceid){
		try {
			this.resourceservice.deleteResources(resourceid);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
