package com.stepsolar.sr.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class UserRole {
	
	public UserRole(){
		
	}
	
	public UserRole(
			@JsonProperty("roleName") String roleName,
			@JsonProperty("roleDesc") String roleDesc
			){
		this.roleName = roleName;
		this.roleDesc = roleDesc;
	}

	@Id
	int id;
	
	@Column
	String roleName;
	
	@Column
	String roleDesc;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	
	
}
