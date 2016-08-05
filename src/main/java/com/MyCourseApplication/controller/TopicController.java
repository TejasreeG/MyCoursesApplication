package com.MyCourseApplication.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.MyCourseApplication.domain.Course;
import com.MyCourseApplication.domain.Topic;
import com.MyCourseApplication.domain.User;
import com.MyCourseApplication.services.TopicService;

public class TopicController {

	/*@Autowired
	private TopicRepository topicRepository;*/
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Topic> getAll() throws Exception {
		return topicService.findAll();
	}
	
	@RequestMapping(value = "{t_id}", method = RequestMethod.GET)
	public ResponseEntity<Topic> get(@PathVariable("t_id") int tid) throws Exception {
		return new ResponseEntity<Topic>(topicService.findOne(tid), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete/{t_id}", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> delete(@PathVariable("t_id") int tid)throws Exception{
		topicService.delete(tid);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "{t_id}/users", method = RequestMethod.GET)
	public ResponseEntity<Course> getUsersForCourse(@PathVariable("t_id") int tid) throws Exception {
		return new ResponseEntity<Course>(topicService.findOne(tid).getCourse(), HttpStatus.OK);
	}
}
