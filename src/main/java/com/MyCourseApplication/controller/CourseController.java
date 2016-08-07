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
import com.MyCourseApplication.services.CourseService;

/**
 * @author Tejasree
 * 
 */
@RestController
@RequestMapping("course")
public class CourseController {

	@Autowired
	private CourseService courseService;

	/**
	 * Creates a Course
	 * @param course
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Course> createCourse(@RequestBody Course course) throws Exception{
		Course savedCourse = courseService.save(course);
		return new ResponseEntity<Course>(savedCourse, HttpStatus.CREATED);
	}

	
	/**
	 * Prints out the List of all Courses in Database
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<Course> getAll() throws Exception {
		return courseService.findAll();
	}

	
	/**
	 * Prints out the Course details by Course Id
	 * @param cid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "{c_id}", method = RequestMethod.GET)
	public ResponseEntity<Course> getByCourse(@PathVariable("c_id") int cid) throws Exception {
		return new ResponseEntity<Course>(courseService.findOne(cid), HttpStatus.OK);
	}

	/**
	 * Deletes the Course Details by course Id
	 * @param cid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "delete/{c_id}", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> delete(@PathVariable("c_id") int cid) throws Exception {
		courseService.delete(cid);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	
	/**
	 * Updates the Course Details in Database
	 * @param course
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Course> updateCourse(@RequestBody Course course) throws Exception {
		Course updatedCourse = courseService.save(course);
		return new ResponseEntity<Course>(updatedCourse, HttpStatus.OK);
	}

	/**
	 * Adds a User for a Course
	 * @param cid
	 * @param username
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "{c_id}/users/{user_name}", method = RequestMethod.PUT)
	public ResponseEntity<HttpStatus> addUsertoCourse(@PathVariable("c_id") int cid, @PathVariable("user_name") String username) throws Exception {
		courseService.addUser(cid, username);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	/**
	 *  Removes a User from a Course
	 * @param cid
	 * @param username
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "{c_id}/users/{user_name}", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> deleteUserFromCourse(@PathVariable("c_id") int cid, @PathVariable("user_name") String username) throws Exception {
		courseService.deleteUser(cid, username);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	/**
	 * Add Topics for a Course
	 * @param cid
	 * @param topic
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "{c_id}/topic", method = RequestMethod.PUT)
	public ResponseEntity<Course>addTopicsForCourse(@PathVariable("c_id") int cid, @RequestBody Topic topic)throws Exception{
		return new ResponseEntity<Course>(courseService.addTopic(cid,topic), HttpStatus.OK);
	}
	
	/**
	 * Removes Topics From a Course
	 * @param cid
	 * @param topic
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "{c_id}/topic", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus>removeTopicsFromCourse(@PathVariable("c_id") int cid, @RequestBody Topic topic)throws Exception{
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	/**
	 *  Prints out the List of Users Enrolled for a Course
	 * @param cid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "{c_id}/usersList", method = RequestMethod.GET)
	public ResponseEntity<Set<User>> getUsersForCourse(@PathVariable("c_id") int cid) throws Exception {
		return new ResponseEntity<Set<User>>(courseService.findOne(cid).getUsers(), HttpStatus.OK);
	}
	
	/**
	 * Prints out the list of Topics for a Course
	 * @param cid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "{c_id}/topics", method = RequestMethod.PUT)
	public ResponseEntity<Set<Topic>> getTopicsForCourse(@PathVariable("c_id") int cid) throws Exception {
		return new ResponseEntity<Set<Topic>>(courseService.findOne(cid).getTopic(), HttpStatus.OK);
	}

}
