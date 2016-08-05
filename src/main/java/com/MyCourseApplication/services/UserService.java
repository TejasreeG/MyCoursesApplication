package com.MyCourseApplication.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.MyCourseApplication.domain.User;
import com.MyCourseApplication.exceptions.ResourceNotFoundException;
import com.MyCourseApplication.repositories.UserRepository;

public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User save(User user) throws Exception{
		return userRepository.save(user);
	}
	
	public List<User>findAll() throws Exception{
		return userRepository.findAll();
	}
	
	public User findOne(String username) throws Exception{
		User user = userRepository.findOne(username);
		if(user == null){
			throw new ResourceNotFoundException("User: "+username+" not found");
		}
		return user;
	}
	
	public void delete(String username) throws Exception{
		if(userRepository.findOne(username) == null){
			throw new ResourceNotFoundException("User: "+username+" not found ");
		}
		userRepository.delete(username);
	}
	
	
}
