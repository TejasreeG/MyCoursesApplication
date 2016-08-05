package com.MyCourseApplication.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.MyCourseApplication.domain.Course;
import com.MyCourseApplication.domain.User;
import com.MyCourseApplication.exceptions.ResourceNotFoundException;
import com.MyCourseApplication.repositories.CourseRepository;
import com.MyCourseApplication.repositories.UserRepository;

public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private UserRepository userRepository;

	public void createUser(int cid, String username) throws Exception {
		Course course = courseRepository.findOne(cid);
		if (course == null) {
			throw new ResourceNotFoundException("Course " + cid + " not found");
		}
		User user = userRepository.findOne(username);
		if (user == null) {
			throw new ResourceNotFoundException("User: " + username + " is not enrolled in course " + cid);
		}
		course.getUsers().add(user);
		courseRepository.save(course);
	}

	public Course save(Course course) throws Exception {
		return courseRepository.save(course);
	}
	
	public List<Course>findAll() throws Exception{
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
		Course course = courseRepository.findOne(cid);
		if (course == null) {
			throw new ResourceNotFoundException("Course " + cid + " not found");
		}
		courseRepository.delete(cid);
	}
	
}
