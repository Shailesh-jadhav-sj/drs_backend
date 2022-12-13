package com.example.drs.entity;

public class Login {
	    private Long id;
	    private String password;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Login() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Login(Long id, String password) {
			super();
			this.id = id;
			this.password = password;
		}
	    
	
}
