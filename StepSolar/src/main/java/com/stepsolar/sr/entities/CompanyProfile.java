package com.stepsolar.sr.entities;
/**
 * Created by Farhan Sharif Khokhar 19/11/2017.
 */
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompanyProfile {

	@JsonCreator
	public CompanyProfile() {}

	@JsonCreator
	public CompanyProfile(
			@JsonProperty("name") String name,
			@JsonProperty("tagLine") String tagLine,
			@JsonProperty("phoneNumber") String phoneNumber,
			@JsonProperty("fax") String fax,
			@JsonProperty("salesEmail") String salesEmail,
			@JsonProperty("website") String website,
			@JsonProperty("linkedinProfile") String linkedinProfile,
			@JsonProperty("facebookProfile") String facebookProfile,
			@JsonProperty("profilePicture") String profilePicture,
			@JsonProperty("address") Address address
			) {
		this.name = name;
		this.tagLine = tagLine;
		this.phoneNumber = phoneNumber;
		this.fax = fax;
		this.salesEmail = salesEmail;
		this.website = website;
		this.linkedinProfile = linkedinProfile;
		this.facebookProfile = facebookProfile;
		this.profilePicture = profilePicture;
		this.address = address;
	}
	
	@Column
	String name;
	
	@Column
	String tagLine;
	
	@Column
	String phoneNumber;
	
	@Column
	String fax;
	
	@Column
	String salesEmail;
	
	@Column
	String website;
	
	@Column
	String linkedinProfile;
	
	@Column
	String facebookProfile;
	
	@Column
	String profilePicture;
	
	@Embedded
	private Address address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTagLine() {
		return tagLine;
	}

	public void setTagLine(String tagLine) {
		this.tagLine = tagLine;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getSalesEmail() {
		return salesEmail;
	}

	public void setSalesEmail(String salesEmail) {
		this.salesEmail = salesEmail;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getLinkedinProfile() {
		return linkedinProfile;
	}

	public void setLinkedinProfile(String linkedinProfile) {
		this.linkedinProfile = linkedinProfile;
	}

	public String getFacebookProfile() {
		return facebookProfile;
	}

	public void setFacebookProfile(String facebookProfile) {
		this.facebookProfile = facebookProfile;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}	
	
}
