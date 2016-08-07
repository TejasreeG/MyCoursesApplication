package com.MyCourseApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MyCourseApplication.domain.User;

/**
 * @author Tejasree
 *
 */

public interface UserRepository extends JpaRepository<User, String>{

		
}
