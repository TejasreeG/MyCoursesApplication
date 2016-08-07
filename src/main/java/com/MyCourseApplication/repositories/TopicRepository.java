package com.MyCourseApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MyCourseApplication.domain.Topic;
/**
 * @author Tejasree
 *
 */

public interface TopicRepository extends JpaRepository<Topic, Integer>{

}
