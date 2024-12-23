package com.cg.bookmydoctor.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {

	@Id
	@Column(name = "userId", unique=true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;

	@Column(name="userName")
	private String userName;

	@Column(name="emailId")
	private String emailId;
	
	@Column(name="password")
	private String password;
	
//	@Column(name="role")
//	private String role; // admin//doctor //patient
	
	public User() {
		
	}



	public User(int userId, String userName, String emailId, String password) {
		super();
		this.userId = userId;
		this.userName =  userName;
		this.emailId=emailId;
		this.password = password;

	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
//	public String getRole() {
//		return role;
//	}
//	public void setRole(String role) {
//		this.role = role;
//	}
	
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ",emailId=" + emailId +", password=" + password + "]";
	}


}
