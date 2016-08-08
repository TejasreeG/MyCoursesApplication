package com.MyCourseApplication.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.MyCourseApplication.domain.User;
import com.MyCourseApplication.services.UserService;

/**
 * @author Tejasree
 *
 */
@RestController
@RequestMapping("authenticateUSer")
public class LoginController {
	@Autowired
	private UserService userService;

	/**
	 * Authenticates a User
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> check(@RequestBody User user) throws Exception {
		User userObj = userService.findOne(user.getUser_name());
		if(userObj != null){
			if(userObj.getPwd().equals(user.getPwd())){
				return new ResponseEntity<User>(userObj, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<User>(user, HttpStatus.FORBIDDEN);
			}
		}
		return new ResponseEntity<User>(user, HttpStatus.FORBIDDEN);
	}
 
}
