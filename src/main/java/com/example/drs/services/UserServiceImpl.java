package com.example.drs.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.drs.dao.BookingDao;
import com.example.drs.dao.UserDao;
import com.example.drs.entity.Booking;
import com.example.drs.entity.POC;
import com.example.drs.entity.User;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BookingDao bookDao;
	
	@Override
	public List<User> getUser() {
		return userDao.findAll();
	}

	@Override
	public User getSingleUser(long userId) {
		Optional<User> user = userDao.findById(userId);
		if(user.isPresent()) {
			return user.get();
		}
		throw new RuntimeException("Resource not found with id : "+ userId);
	}

	@Override
	public User addUser(User user) {
		userDao.save(user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		userDao.save(user);
		return user;
	}

	@Override
	public void deleteUser(long userId) {
		User entity=userDao.getOne(userId);
		userDao.delete(entity);

	}

	@Override
	public User updateUserById(User user, long userId) {
		User userDB = userDao.findById(userId).get();
		 
        if (Objects.nonNull(user.getName()) && !"".equalsIgnoreCase(user.getName())) {
        	userDB.setName(user.getName());
        }
 
        return userDao.save(userDB);
	}

	@Override
	public List<User> checkUser(String email, String password) {
		return userDao.checkUser(email, password);
	}

	@Override
	public Booking bookResource(Booking booking) {
		bookDao.save(booking);
		return booking;
	}

}
