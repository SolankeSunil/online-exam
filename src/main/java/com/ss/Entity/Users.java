package com.ss.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users {
	@Id
	private String username;
	private String fname;
	private String lname;
	private String email;
	private String  mobile;
	private String password;
	private String password1;
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(String username, String fname, String lname, String email, String mobile, String password,
			String password1) {
		super();
		this.username = username;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.password1 = password1;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	@Override
	public String toString() {
		return "Users [username=" + username + ", fname=" + fname + ", lname=" + lname + ", email=" + email
				+ ", mobile=" + mobile + ", password=" + password + ", password1=" + password1 + "]";
	}

}
