package com.stepsolar.sr.entities;

/**
 * Created by Farhan Sharif Khokhar 19/11/2017.
 */
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class VendorUser {
	public VendorUser() {

	}

	@JsonCreator
	public VendorUser(@JsonProperty("userName") String userName, @JsonProperty("userPassword") String userPassword,
			@JsonProperty("personalProfile") PersonalProfile personalProfile,
			@JsonProperty("companyProfile") CompanyProfile companyProfile,
			@JsonProperty("vendorType") String vendorType, @JsonProperty("userRole") String userRole) {
		this.userName = userName;
		this.userPassword = userPassword;

		this.personalProfile = personalProfile;
		this.companyProfile = companyProfile;

		this.vendorType = vendorType;

		this.userRole = userRole;

	}

	@GeneratedValue(strategy = GenerationType.TABLE, generator = "stepSolarIdGenerator")
	@TableGenerator(name = "stepSolarIdGenerator", table = "stepSolarSequence", pkColumnValue = "allTypeUser", allocationSize = 1, valueColumnName = "nextAllTypeUserId")
	@Id
	private long id;

	@Column
	String userName;

	@Column
	String userPassword;

	@Column
	String vendorType;

	// Not a col, just to hold the value of user's active role
	// @Transient
	String userRole;

	@Column
	String userRoles;

	@Column
	String userToken;

	@Column
	String gmt;

	@Embedded
	private PersonalProfile personalProfile;

	@Embedded
	private CompanyProfile companyProfile;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getVendorType() {
		return vendorType;
	}

	public void setVendorType(String vendorType) {
		this.vendorType = vendorType;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(String userRoles) {
		this.userRoles = userRoles;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public PersonalProfile getPersonalProfile() {
		return personalProfile;
	}

	public void setPersonalProfile(PersonalProfile personalProfile) {
		this.personalProfile = personalProfile;
	}

	public CompanyProfile getCompanyProfile() {
		return companyProfile;
	}

	public void setCompanyProfile(CompanyProfile companyProfile) {
		this.companyProfile = companyProfile;
	}

	public String getGmt() {
		return gmt;
	}

	public void setGmt(String gmt) {
		this.gmt = gmt;
	}

}
