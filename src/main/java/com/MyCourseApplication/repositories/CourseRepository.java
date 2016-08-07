package com.MyCourseApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MyCourseApplication.domain.Course;

/**
 * @author Tejasree
 *
 */

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
	
}
