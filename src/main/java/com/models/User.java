package com.models;

import java.io.Serializable;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String APIKEY;
	private Boolean isAdmin;
	
	public User(){}
	
	public User(String usr, String key, Boolean isAdmin){
		this.username = usr;
		this.APIKEY = key;
		this.isAdmin = isAdmin;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAPIKEY() {
		return APIKEY;
	}
	public void setAPIKEY(String aPIKEY) {
		APIKEY = aPIKEY;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
