package com.MyCourseApplication.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyCourseApplication.domain.Course;
import com.MyCourseApplication.domain.Topic;
import com.MyCourseApplication.domain.User;
import com.MyCourseApplication.exceptions.ResourceNotFoundException;
import com.MyCourseApplication.repositories.CourseRepository;
import com.MyCourseApplication.repositories.UserRepository;

/**
 * @author Tejasree
 *
 */

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private UserRepository userRepository;

	public Course save(Course course) throws Exception {
		User user = userRepository.findOne(course.getUser_name());
		/*if(course.getC_id()== null){
			course.setCreated_at(LocalDateTime.now());
		}*/
		course.setChanged_at(LocalDateTime.now());
		course.getUsers().add(user);
		
		return courseRepository.save(course);
	}

	public List<Course> findAll() throws Exception {
		return courseRepository.findAll();
	}

	public Course findOne(int cid) throws Exception {
		Course course = courseRepository.findOne(cid);
		if (course == null) {
			throw new ResourceNotFoundException("course " + cid + " not found");
		}
		return course;
	}

	public void delete(int cid) throws Exception {
		if (courseRepository.findOne(cid) == null) {
			throw new ResourceNotFoundException("Course " + cid + " not found");
		}
		courseRepository.delete(cid);
	}

	public void addUser(int cid, String username) throws Exception {
		Course course = courseRepository.findOne(cid);
		if (course == null) {
			throw new ResourceNotFoundException("Course:  " + cid + " doesn't exist");
		}
		User user = userRepository.findOne(username);
		if (user == null) {
			throw new ResourceNotFoundException("User: " + username + " is not enrolled in course: " + cid);
		}
		course.getUsers().add(user);
		courseRepository.save(course);
	}

	public void deleteUser(int cid, String username) throws Exception {
		Course course = courseRepository.findOne(cid);
		if (course == null) {
			throw new ResourceNotFoundException("Course: " + cid + " doesn't exist");
		}
		User user = userRepository.findOne(username);
		if (user == null) {
			throw new ResourceNotFoundException("User: " + username + " is not enrolled in course: " + cid);
		}

		course.getUsers().remove(user);
		courseRepository.save(course);
	}
	
	public Course addTopic(int cid, Topic topic)throws Exception{
		Course course = courseRepository.findOne(cid);
		if (course == null) {
			throw new ResourceNotFoundException("Course:  " + cid + " doesn't exist");
		}
		course.getTopic().add(topic);
		return courseRepository.save(course);
	}
	
	public void removeTopic(int cid, Topic topic)throws Exception{
		Course course = courseRepository.findOne(cid);
		if (course == null) {
			throw new ResourceNotFoundException("Course:  " + cid + " doesn't exist");
		}
		course.getTopic().remove(topic);
		courseRepository.save(course);
	}

}
