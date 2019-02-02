package com.Admin.AdminApp.domain;

public class pojoPermission {
	String Per_name;
	String Perid;
	public pojoPermission() {
	}
	public pojoPermission(String per_name, String perid) {
		super();
		Per_name = per_name;
		Perid = perid;
	}
	public String getPerid() {
		return Perid;
	}
	public void setPerid(String perid) {
		Perid = perid;
	}
	public String getPer_name() {
		return Per_name;
	}
	public void setPer_name(String per_name) {
		this.Per_name = per_name;
	}
	
}
