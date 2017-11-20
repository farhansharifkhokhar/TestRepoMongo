package com.stepsolar.sr.entities;

/**
 * Created by Farhan Sharif Khokhar 19/11/2017.
 */
public class BaseUser {

	private String id;
	private String userName;
	private String userRole;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}
