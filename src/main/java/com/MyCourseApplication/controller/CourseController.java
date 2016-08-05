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
import com.MyCourseApplication.domain.Topic;
import com.MyCourseApplication.domain.User;
import com.MyCourseApplication.repositories.CourseRepository;
import com.MyCourseApplication.repositories.UserRepository;
import com.MyCourseApplication.services.CourseService;

@RestController
@RequestMapping("course")
public class CourseController {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CourseService courseService;
	

	/*@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Course> CreateCourse(@RequestBody Course course)throws Exception{
		User user = userRepository.findone(course.getUser_name());
		course.getUsers().add(user);
		Course savedCourse = courseRepository.save(course) ;
		return new ResponseEntity<Course>(savedCourse,HttpStatus.CREATED);
	}*/
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Course> getAll() throws Exception {
		return courseService.findAll();
	}
	
	@RequestMapping(value = "{c_id}", method = RequestMethod.GET)
	public ResponseEntity<Course> get(@PathVariable("c_id") int cid) throws Exception {
		return new ResponseEntity<Course>(courseService.findOne(cid), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete/{c_id}", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> delete(@PathVariable("c_id") int cid)throws Exception{
		courseService.delete(cid);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(value = "{c_id}/topics", method = RequestMethod.GET)
	public ResponseEntity<Set<Topic>> getTopicsForCourse(@PathVariable("c_id") int cid) throws Exception {
		return new ResponseEntity<Set<Topic>>(courseService.findOne(cid).getTopic(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "{c_id}/users", method = RequestMethod.GET)
	public ResponseEntity<Set<User>> getUsersForCourse(@PathVariable("c_id") int cid) throws Exception {
		return new ResponseEntity<Set<User>>(courseService.findOne(cid).getUsers(), HttpStatus.OK);
	}

}
