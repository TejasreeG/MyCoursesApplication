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

/**
 * @author Tejasree
 *
 */
@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * Creates a user
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> CreateUser(@RequestBody User user) throws Exception {
		User savedUser = userService.save(user);
		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
	}
	
	/**
	 * Prints out the list of users in database
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAll() throws Exception {
		List<User> listOfUsers = userService.findAll();
		return new ResponseEntity<List<User>>(listOfUsers, HttpStatus.OK);
	}

	
	/**
	 * Prints out the user details by User name
	 * @param username
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "{user_name}", method = RequestMethod.GET)
	public ResponseEntity<User> findByUserName(@PathVariable("user_name") String username) throws Exception {
		if(!username.contains(".com")){
			username = username + ".com";
		}
		return new ResponseEntity<User>(userService.findOne(username), HttpStatus.OK);
	}

	
	/**
	 * Deletes a user from Database by user name
	 * @param username
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "delete/{user_name}", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> delete(@PathVariable("user_name") String username) throws Exception {
		if(!username.contains(".com")){
			username = username + ".com";
		}
		userService.delete(username);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	
	/**
	 * Updates the user details
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<User> UpdateUser(@RequestBody User user) throws Exception {
		User updatedUser = userService.save(user);
		return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
	}

	
	/**
	 * Prints the List of Courses that a user is enrolled in
	 * @param username
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "{user_name}/courses", method = RequestMethod.GET)
	public ResponseEntity<Set<Course>> getCoursesOfAUser(@PathVariable("user_name") String username) throws Exception {
		if(!username.contains(".com")){
			username = username + ".com";
		}
		Set<Course> coursesList = userService.findOne(username).getCourses();
		return new ResponseEntity<Set<Course>>(coursesList, HttpStatus.OK);
	}

}
