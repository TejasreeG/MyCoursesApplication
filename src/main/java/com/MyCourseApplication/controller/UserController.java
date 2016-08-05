package com.MyCourseApplication.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.MyCourseApplication.domain.Course;
import com.MyCourseApplication.domain.User;
import com.MyCourseApplication.services.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	/*@Autowired
	private UserRepository userRepository;
	*/
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> CreateUser(@RequestBody User user)throws Exception{
		User savedUser = userService.save(user) ;
		return new ResponseEntity<User>(savedUser,HttpStatus.CREATED);
	}
		
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAll()throws Exception{
		List<User>listOfUsers = userService.findAll();
		return new ResponseEntity<List<User>>(listOfUsers,HttpStatus.OK);
	}
	
	@RequestMapping(value = "{user_name}", method = RequestMethod.GET)
	public ResponseEntity<User> get(@PathVariable("user_name") String username) throws Exception {
		return new ResponseEntity<User>(userService.findOne(username), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete/{user_name}", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> delete(@PathVariable("user_name") String username)throws Exception{
		userService.delete(username);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<User> UpdateUser(@RequestBody User user)throws Exception{
		User updatedUser = userService.save(user);
		return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
		}
	
	@RequestMapping(value = "{user_name}/courses", method = RequestMethod.GET)
	public ResponseEntity<Set<Course>> getCourses(@PathVariable("user_name") String username) throws Exception {
		Set<Course>coursesList = userService.findOne(username).getCourses();
		return new ResponseEntity<Set<Course>>(coursesList, HttpStatus.OK);
	}
	
	/*@RequestMapping(value = "/get/{last_name}", method = RequestMethod.GET)
	public ResponseEntity<List<User>> get(@PathVariable("last_name") String lastname)throws Exception{
		List<User>listOfUsers = userService.findone(); ---> find list??
		return new ResponseEntity<List<User>>(listOfUsers,HttpStatus.OK);
	}
	*/
	
	
	
}
