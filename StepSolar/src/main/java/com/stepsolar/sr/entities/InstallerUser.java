package com.stepsolar.sr.entities;
/**
 * Created by Farhan Sharif Khokhar 19/11/2017.
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name="_User", indexes = {
		@Index(columnList = "managerId", name = "managerId_idx")
})
public class InstallerUser {
	@Id
	private String id;
	
	private String objectId;
	
	@Column(name="username")
	private String username;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	//No need to be used in web as it is parse related thing
//	@Column(name="_perishable_token")
//	private String perishableToken;
	
	@Column(name="isCellNoVerified")
	private Boolean isCellNoVerified;
	
//	@Column(name="_hashed_password")
	private String password;
	
	//No need to be save in web as it is parse related thing
	private String sessionToken;
	
	@Column(name="activationCode")
	private String activationCode;
	
	@Column(name="_created_at")
	private Date createdAt;
	
	@Column(name="_updated_at")
	private Date updatedAt;
	
	@Column(name="_email_verify_token")
	private String emailVerifyToken;
	
	@Column(name="isEmailVerified")
	private Boolean isEmailVerified;
	
	@Column(name="emailVerified")
	private Boolean emailVerified;
	
	@Column(name="address")
	private String address;
	
	@Column(name="cellNo")
	private String cellNo;
	
	@Embedded
	private PersonalProfile personalProfile;
	
	@Embedded
	private CompanyProfile companyProfile;
	
	@Column
	private String userRole;

	@Column
	private String status = InstallerUserSrStatus.ACTIVE;
	
//	@Column
//	private String userRoles;
	
	@Column
	private String userToken;

	@Column
	private String invUuid;
	
	@Column
	private String managerId;

	@Column
	private String gmt;
	
	public Boolean getEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(Boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	@Transient
	@JsonIgnore
	private List<Client> clientList = new ArrayList<Client>();
	
	public List<Client> getClientList() {
		return clientList;
	}

	public void setClientList(List<Client> clientList) {
		this.clientList = clientList;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.id = objectId;
		this.objectId = objectId;
	}
	
	public String getInvUuid() {
		return invUuid;
	}

	public void setInvUuid(String invUuid) {
		this.invUuid = invUuid;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsCellNoVerified() {
		return isCellNoVerified;
	}

	public void setIsCellNoVerified(Boolean isCellNoVerified) {
		this.isCellNoVerified = isCellNoVerified;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getActivationCode() {
		return activationCode;
	}
	

	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getEmailVerifyToken() {
		return emailVerifyToken;
	}

	public void setEmailVerifyToken(String emailVerifyToken) {
		this.emailVerifyToken = emailVerifyToken;
	}

	public Boolean getIsEmailVerified() {
		return isEmailVerified;
	}

	public void setIsEmailVerified(Boolean isEmailVerified) {
		this.isEmailVerified = isEmailVerified;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCellNo() {
		return cellNo;
	}

	public void setCellNo(String cellNo) {
		this.cellNo = cellNo;
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

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getSessionToken() {
		return sessionToken;
	}

	public void setSessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
	}

	public String getGmt() {
		return gmt;
	}

	public void setGmt(String gmt) {
		this.gmt = gmt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
