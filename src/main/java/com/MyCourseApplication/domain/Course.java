package com.MyCourseApplication.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author Tejasree
 *
 */

@Entity
@Table(name = "courses", schema = "mycourses_app")
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int c_id;
	
	@NotNull(message = "CourseName is Required, It should not be Blank")
	@Pattern(regexp="^[A-Z]+[a-z]*$", message = "Enter the Course Name with the first letter Capitalized and numbers or special charecters are not allowed ")
	private String c_name;
	private String c_description;
	private String c_prereq;
	@NotNull(message = "Course Duration is required, It should not be Blank")
	private int c_duration;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Skill Level is Required")
	private SkillLevel skill_level;
	
	private LocalDateTime created_at;
	private LocalDateTime changed_at;
	private String user_name;

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private Set<Topic> topic = new HashSet<Topic>();

	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(name = "course_user", joinColumns = @JoinColumn(name = "c_id"), inverseJoinColumns = @JoinColumn(name = "user_name"))
	private Set<User> users;

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_description() {
		return c_description;
	}

	public void setC_description(String c_description) {
		this.c_description = c_description;
	}

	public String getC_prereq() {
		return c_prereq;
	}

	public void setC_prereq(String c_prereq) {
		this.c_prereq = c_prereq;
	}

	public int getC_duration() {
		return c_duration;
	}

	public void setC_duration(int c_duration) {
		this.c_duration = c_duration;
	}

	public SkillLevel getSkill_level() {
		return skill_level;
	}

	public void setSkill_level(SkillLevel skill_level) {
		this.skill_level = skill_level;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public LocalDateTime getChanged_at() {
		return changed_at;
	}

	public void setChanged_at(LocalDateTime changed_at) {
		this.changed_at = changed_at;
	}

	public Set<Topic> getTopic() {
		return topic;
	}

	public void setTopic(Set<Topic> topic) {
		this.topic = topic;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + c_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (c_id != other.c_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Course [CourseID=" + c_id + ", CourseNAme=" + c_name + ", CourseDescription=" + c_description
				+ ", CoursePreRequisite=" + c_prereq + ", CourseDuration=" + c_duration + ", SkillLevel=" + skill_level + "]";
	}

}
