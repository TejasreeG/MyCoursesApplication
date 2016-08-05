package com.MyCourseApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@EnableJpaRepositories(basePackages={"com.courseapp.repositories"})
@EntityScan(basePackages={"com.MyCourseApplication.domain"})
@ComponentScan(basePackages={"com.MyCourseApplication.exceptions","com.MyCourseApplication.controller","com.MyCourseApplication.validations","com.MyCourseApplication.services"})
public class MyCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyCourseApplication.class, args);
	}
}
