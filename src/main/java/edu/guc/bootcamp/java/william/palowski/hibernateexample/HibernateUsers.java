package edu.guc.bootcamp.java.william.palowski.hibernateexample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HibernateUsers {

	@Id
	private int userId;
	@Column(name= "user_email_address")
	private String userEmailAddress;
	private double salary;
	private boolean hasHair;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int user_id) {
		this.userId = user_id;
	}
	public String getUserEmailAddress() {
		return userEmailAddress;
	}
	public void setUserEmailAddress(String userEmailAddress) {
		this.userEmailAddress = userEmailAddress;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public boolean isHasHair() {
		return hasHair;
	}
	public void setHasHair(boolean hasHair) {
		this.hasHair = hasHair;
	}
	
	@Override
	public String toString() {
		return "HibernateUsers[userId = "
				+ this.userId + ", userEmailAddress = " 
				+ this.userEmailAddress + ", hasHair = "
				+ this.hasHair + ", salary = "
				+ this.salary + "]";
	}
	
}
