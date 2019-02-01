package com.Admin.AdminApp.domain;

public class UsersWithRole {
	String UserName ;
	String Phone;
	String Login;
	String Roles;
	
	
	public UsersWithRole() {}
	public UsersWithRole(String userName, String phone,  String login,String roles) {
		super();
		UserName = userName;
		Phone = phone;
		Login = login;
		Roles = roles;
		
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getLogin() {
		return Login;
	}
	public void setLogin(String login) {
		Login = login;
	}
	public String getRoles() {
		return Roles;
	}
	public void setRoles(String roles) {
		Roles = roles;
	}
	

	
	
}
