package com.Admin.AdminApp.domain;

public class pojoPermission {
	String Perid;
	String Per_name;
	public pojoPermission() {
	}
	public pojoPermission(String perid, String per_name) {
		super();
		Perid = perid;
		Per_name = per_name;
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
