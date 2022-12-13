package com.example.drs.entity;

public class userLogin {

	public userLogin(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	private String email;
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
	public userLogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String password;
}
