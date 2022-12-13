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
import org.springframework.web.bind.annotation.RestController;

import com.example.drs.entity.Booking;
import com.example.drs.entity.Login;
import com.example.drs.entity.POC;
import com.example.drs.entity.User;
import com.example.drs.entity.userLogin;
import com.example.drs.services.UserService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/users")
	public List<User> getUser(){
		return this.userService.getUser();
	}
	
	
	
	@PostMapping(path="/userCheck",consumes="application/json")
	 public List<User> checkUser(@RequestBody userLogin login)
	 {
		 return this.userService.checkUser(login.getEmail(),login.getPassword());
	 }
	
	@GetMapping("/users/{userId}")
	public User getSingleUser(@PathVariable Long userId) {
		return this.userService.getSingleUser(userId);
	}
	
	@PostMapping(path="/users",consumes="application/json")
	public User addUser(@RequestBody User user) {
		return this.userService.addUser(user);
	}
	
	@PostMapping(path="/bookResource")
	public Booking bookResource(@RequestBody Booking booking) {
		
		return this.userService.bookResource(booking);
	}
	@PutMapping("/users")
	public User updateResource(@RequestBody User user) {
		return this.userService.updateUser(user);
	}
	
	@PutMapping("/users/{userId}")
    public User updateUserById(@RequestBody User user,@PathVariable Long userId)
    {
        return userService.updateUserById(user, userId);
    }
	
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable String userId){
		try {
			this.userService.deleteUser(Long.parseLong(userId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
