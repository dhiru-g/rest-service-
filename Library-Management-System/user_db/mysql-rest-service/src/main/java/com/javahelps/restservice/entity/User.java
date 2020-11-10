package com.javahelps.restservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {



	@Id
	private String emailId;


	private String username;
	private String password;
	private String name;
	private long Phone_no;


//TODO:chckinng usernames
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return emailId;
	}

	public void setEmail(String email) {
		this.emailId = email;
	}

	public Long getPhoneNumber() {
		return Phone_no;
	}

	public void setPhoneNumber(Long phone) {
		this.Phone_no = phone;
	}

	@Override
	public String toString() {
		return "User{" + "username='" + username + '\'' + ", password='" + password + '\'' + ", name='" + name + '\''
				+ ", email='" + emailId + '\'' + ",phonenumber='"+ Phone_no + '\''+ '}';
	}
}
