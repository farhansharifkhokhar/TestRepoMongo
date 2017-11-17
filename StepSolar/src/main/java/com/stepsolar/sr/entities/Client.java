package com.stepsolar.sr.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.ogm.options.shared.IndexOption;
import org.hibernate.ogm.options.shared.IndexOptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(indexes = {
		@Index(columnList = "userId", name = "userId_idx"),
		@Index(columnList = "name", name = "name_idx")
})
@IndexOptions(
		@IndexOption(forIndex = "name_email_text_idx", options = "{ text: true, default_language : 'en', weights : { email: 2, name: 5 } }")
)
public class Client {
	
	@Id
	private String id;
	
	@Transient
	private String objectId;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column
	private String address;
	
	@Column
	private String cellNo;
	
	@Column
	private String weatherModel;
	
	@Column
	private String energy;
	
	@Embedded
	private ParseTypeFile photoUrl;
	
	@Transient
	private InstallerUser installerUser;
	
	@Transient
	private List<Array> arrayList;
	
	@Column
	private String userId;
	
	@Column
	private String managerId;
	
	@Column
	private Double siteVisitDateTime;
	
	@Column
	private Double leadPitchDateTime;
	
	@Column
	private Double leadAssignmentDateTime;

	@Column (name = "_created_at")
	private Date createdAt;

	@Column (name = "_updated_at")
	private Date updatedAt;

	@Column
	private String timeStamp;

	@Column
	private String assignedTo;

	/*
	 Client Status Values
		1) Not attempted
		2) Attempted
		3) Site Visit 
		4) Quote 
		5) Negotiation
		
		6) Sold 
		7) Lost 
		8) Not interested. 
		
		A client will be considered active as long as it is 1-5 
	 */
	@Column
	private String status = "Not attempted";
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Double getLeadAssignmentDateTime() {
		return leadAssignmentDateTime;
	}

	public void setLeadAssignmentDateTime(Double leadAssigmentDateTime) {
		this.leadAssignmentDateTime = leadAssigmentDateTime;
//		org.hibernate.type.AnyType
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

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
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

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getWeatherModel() {
		return weatherModel;
	}

	public void setWeatherModel(String weatherModel) {
		this.weatherModel = weatherModel;
	}

	public String getEnergy() {
		return energy;
	}

	public void setEnergy(String energy) {
		this.energy = energy;
	}

	public InstallerUser getInstallerUser() {
		return installerUser;
	}

	public void setInstallerUser(InstallerUser installerUser) {
		this.installerUser = installerUser;
	}

	public ParseTypeFile getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(ParseTypeFile photoUrl) {
		this.photoUrl = photoUrl;
	}	

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.setId(objectId);
		this.objectId = objectId;
	}

	public Double getSiteVisitDateTime() {
		return siteVisitDateTime;
	}

	public void setSiteVisitDateTime(Double siteVisitDateTime) {
		this.siteVisitDateTime = siteVisitDateTime;
	}

	public Double getLeadPitchDateTime() {
		return leadPitchDateTime;
	}

	public void setLeadPitchDateTime(Double leadPitchDateTime) {
		this.leadPitchDateTime = leadPitchDateTime;
	}

	public List<Array> getArrayList() {
		return arrayList;
	}

	public void setArrayList(List<Array> arrayList) {
		this.arrayList = arrayList;
	}

	public void addArray(Array array) {
		if (this.arrayList == null) {
			arrayList = new ArrayList<>();
		}
		arrayList.add(array);
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
}
