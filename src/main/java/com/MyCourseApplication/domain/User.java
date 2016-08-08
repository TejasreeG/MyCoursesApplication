package com.MyCourseApplication.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.MyCourseApplication.validations.Ssn;

/**
 * @author Tejasree
 *
 */

@Entity
@Table(name = "users", schema = "mycourses_app")

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@NotNull(message = "Username is required, it should not be blank")
	// @Pattern(regexp = "*@*.com",message = "Enter an emailId")
	private String user_name;

	@NotNull(message = "Password  is required, it should not be blank")
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,12})", message = "Password must have atleast 1 Uppercase,1 lowercase, 1 digit, 1 Special character and with a min length of 6 and max length of 12")
	private String pwd;

	@NotNull(message = "FirstName  is required, it should not be blank")
	@Pattern(regexp = "^[A-Z]+[a-z]*$", message = "Enter Your First Name with the first letter Capitalized and numbers or special charecters are not allowed ")
	private String first_name;

	@NotNull(message = "LastName  is required, it should not be blank")
	@Pattern(regexp = "^[A-Z]+[a-z]*$", message = "Enter Your Last Name with the first letter Capitalized and numbers or special charecters are not allowed ")
	private String last_name;

	@Ssn
	private String ssn;
	private LocalDateTime created_at;
	private LocalDateTime changed_at;

	@ManyToMany(mappedBy = "users")
	private Set<Course> courses;
	
	public User(){
		 		
		 }
		 	
		 	public User(String username, String pwd, String firstname, String lastname, String ssn, LocalDateTime createdDate, LocalDateTime updatedDate) {
		 		super();
		 		
		 		this.user_name = username;
		 		this.first_name = firstname;
		 		this.last_name = lastname;
		 		this.pwd = pwd;
		 		this.ssn = ssn;
		 		this.setCreated_at(createdDate);
		 		this.setChanged_at(updatedDate);
		 	}
		

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
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

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
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
		User other = (User) obj;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [Firstname=" + first_name + ", Lastname=" + last_name + ", username=" + user_name + "]";
	}

}
