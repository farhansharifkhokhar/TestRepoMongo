package com.stepsolar.sr.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class InstallerSalesRepInvite {
	
	public InstallerSalesRepInvite() {
	}
	
	@JsonCreator
	public InstallerSalesRepInvite(
			@JsonProperty("id") String id
			) {
		this.id = id;
	}
	
    @Id
    private String id;

	
	@Column
	private String installerManagerID;
	
	@Column
	private String emailSubject;
	
	@Column
	private String emailDetails;
	
	@Column
	private Boolean userCreated = false;
	
	@Column
	private String invUuid;
	
	@Column
	private String createdUserID;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInstallerManagerID() {
		return installerManagerID;
	}

	public void setInstallerManagerID(String installerManagerID) {
		this.installerManagerID = installerManagerID;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public String getEmailDetails() {
		return emailDetails;
	}

	public void setEmailDetails(String emailDetails) {
		this.emailDetails = emailDetails;
	}

	public Boolean getUserCreated() {
		return userCreated;
	}

	public void setUserCreated(Boolean userCreated) {
		this.userCreated = userCreated;
	}

	public String getInvUuid() {
		return invUuid;
	}

	public void setInvUuid(String invUuid) {
		this.invUuid = invUuid;
	}

	public String getCreatedUserID() {
		return createdUserID;
	}

	public void setCreatedUserID(String createdUserID) {
		this.createdUserID = createdUserID;
	}
	
}
