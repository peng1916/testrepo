package com.soecode.lyf.entity;

public class User {
	private long id;
	private String name;
	private String password;
	private String phone;
	private String mail;
	private String address;
	private String role;
	
	public User(){
		
	}
	
	public User(long id, String name, String password, String phone, String mail, String address, String role) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.mail = mail;
		this.address = address;
		this.role = role;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Customer:id=[" + this.id + "], name=[" + this.name + "]";
	}

}
