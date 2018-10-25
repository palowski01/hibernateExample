package edu.guc.bootcamp.java.william.palowski.hibernateexample;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentDetails {
	
	private String firstName;
	private String lastName;
	@Id
	private int student_id;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	

}
