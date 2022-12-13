package com.example.drs.services;

import java.util.List;

import com.example.drs.entity.Booking;
import com.example.drs.entity.POC;
import com.example.drs.entity.User;

public interface UserService {

public List<User> getUser();
	
	User getSingleUser(long userId);
	
	public User addUser(User user);

	public User updateUser(User user);
	
	public void deleteUser(long userId);
	
	User updateUserById(User user,long userId);
	
	public List<User> checkUser(String email,String password);
	
	public Booking bookResource(Booking booking);
}
