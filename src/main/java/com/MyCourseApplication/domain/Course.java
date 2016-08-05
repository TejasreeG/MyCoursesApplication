package com.MyCourseApplication.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "courses", schema = "mycourses_app")
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int c_id;
	private String c_name;
	private String c_description;
	private String c_prereq;
	private int c_duration;
	@Enumerated(EnumType.STRING)
	private SkillLevel skill_level;
	private LocalDateTime created_at;
	private LocalDateTime changed_at;
	private String user_name;

	@OneToMany(mappedBy = "Courses", cascade = CascadeType.ALL)
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
	public String toString() {
		return "Course [CourseID=" + c_id + ", CourseNAme=" + c_name + ", CourseDescription=" + c_description
				+ ", CoursePreRequisite=" + c_prereq + ", CourseDuration=" + c_duration + ", SkillLevel=" + skill_level
				+ ", CreatedAT=" + created_at + "UpdatedAt=" + changed_at + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((c_description == null) ? 0 : c_description.hashCode());
		result = prime * result + c_duration;
		result = prime * result + c_id;
		result = prime * result + ((c_name == null) ? 0 : c_name.hashCode());
		result = prime * result + ((c_prereq == null) ? 0 : c_prereq.hashCode());
		result = prime * result + ((changed_at == null) ? 0 : changed_at.hashCode());
		result = prime * result + ((created_at == null) ? 0 : created_at.hashCode());
		result = prime * result + ((skill_level == null) ? 0 : skill_level.hashCode());
		result = prime * result + ((topic == null) ? 0 : topic.hashCode());
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
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
		if (c_description == null) {
			if (other.c_description != null)
				return false;
		} else if (!c_description.equals(other.c_description))
			return false;
		if (c_duration != other.c_duration)
			return false;
		if (c_id != other.c_id)
			return false;
		if (c_name == null) {
			if (other.c_name != null)
				return false;
		} else if (!c_name.equals(other.c_name))
			return false;
		if (c_prereq == null) {
			if (other.c_prereq != null)
				return false;
		} else if (!c_prereq.equals(other.c_prereq))
			return false;
		if (changed_at == null) {
			if (other.changed_at != null)
				return false;
		} else if (!changed_at.equals(other.changed_at))
			return false;
		if (created_at == null) {
			if (other.created_at != null)
				return false;
		} else if (!created_at.equals(other.created_at))
			return false;
		if (skill_level != other.skill_level)
			return false;
		if (topic == null) {
			if (other.topic != null)
				return false;
		} else if (!topic.equals(other.topic))
			return false;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}

}
