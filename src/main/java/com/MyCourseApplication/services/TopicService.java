package com.MyCourseApplication.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyCourseApplication.domain.Topic;
import com.MyCourseApplication.exceptions.ResourceNotFoundException;
import com.MyCourseApplication.repositories.TopicRepository;
@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;

	public Topic save(Topic topic) throws Exception {
		return topicRepository.save(topic);
	}

	public List<Topic> findAll() throws Exception {
		return topicRepository.findAll();
	}

	public Topic findOne(int tid) throws Exception {
		Topic topic = topicRepository.findOne(tid);
		if (topic == null) {
			throw new ResourceNotFoundException("topic: " + tid + " not found");
		}
		return topic;
	}

	public void delete(int tid) throws Exception {
		if (topicRepository.findOne(tid) == null) {
			throw new ResourceNotFoundException("topic: " + tid + " not found ");
		}
		topicRepository.delete(tid);
	}

}
