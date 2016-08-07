package com.MyCourseApplication.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author Tejasree
 *
 */

@Entity
@Table(name = "topics", schema = "mycourses_app")
public class Topic implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int t_id;
	
	@NotNull(message="Topic name is Required, it should not be Blank")
	@Pattern(regexp="^[A-Z]+[a-z]*$", message = "Enter the Topic Name with the first letter Capitalized and numbers or special charecters are not allowed ")
	private String t_name;
	
	@NotNull(message = "Topic Duration is required, It should not be Blank")
	private int t_duration;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "c_id")
	private Course course;

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public int getT_duration() {
		return t_duration;
	}

	public void setT_duration(int t_duration) {
		this.t_duration = t_duration;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Topic [TopicID=" + t_id + ", TopicName=" + t_name + ", TopicDuration" + t_duration + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + t_id;
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
		Topic other = (Topic) obj;
		if (t_id != other.t_id)
			return false;
		return true;
	}

	
}
