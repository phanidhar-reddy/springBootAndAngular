package com.rest.db.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//Table user
@Entity
public class Users {
	
	@Id // primary key
	@GeneratedValue //auto generated
	private long id;
	
	
	private String name;
	
	
	private String role;
	
	
	private String password;
	
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Users() {}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", role=" + role + ", password=" + password + "]";
	}

	public Users(String name, String role, String password) {
		super();
		this.name = name;
		this.role = role;
		this.password = password;
	}
	
	
}
