package com.example.model;



public class User {
	private int id;
	private String name;
	private String password;
	private String email;
	private boolean isAdmin;
	
	
		public User() {
		}
		
	public User(String name, String password, String email, boolean isAdmin) {
		
		this.name = name;
		this.password = password;
		this.email = email;
		this.isAdmin = isAdmin;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
	

}
