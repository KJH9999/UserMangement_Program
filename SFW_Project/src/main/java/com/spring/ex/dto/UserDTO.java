package com.spring.ex.dto;

public class UserDTO {
	private String email;
	private String pw;
	private String name;
	private String number;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "UserDTO [email=" + email + ", pw=" + pw + ", name=" + name + ", number=" + number + "]";
	}

}
