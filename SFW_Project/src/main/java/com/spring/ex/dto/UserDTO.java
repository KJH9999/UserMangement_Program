package com.spring.ex.dto;

public class UserDTO {
	
	private String id;
	private String pw;
	private String name;
	private String number;
	private int approve;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public int getApprove() {
		return approve;
	}
	public void setApprove(int approve) {
		this.approve = approve;
	}
	
	

}
