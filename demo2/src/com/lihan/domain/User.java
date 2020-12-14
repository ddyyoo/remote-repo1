package com.lihan.domain;

import java.util.Date;

public class User {
	private Integer id;
	private String name;
	private String password;
	private String email;
	private Date birthday;
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	
	@Override
	public String toString() {
		return id + "," + name + "," + password + "," + email + "," + birthday;
	}
}
