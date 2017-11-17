package com.stepsolar.sr.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown=true)
@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonalProfile {

	@Column
	String firstName;
	
	@Column
	String middleName;
	
	@Column
	String lastName;
	
	@Column
	String fullName;
	
	@Embedded
	private Address address;

	@Column
	String email;
	
	@Column
	String gender;
	
	@Column
	String phoneNumber;
	
	@Column
	String mobileNumber;
	
	@Column
	String skypeId;
	
	@Column
	String personalLinkedinProfile;
	
	@Column
	String profilePicture;	
	
	@Column
	String resetPasswordId;
	
	@Column
	String emailVerificationId;
	
	@Column
	Boolean isVerified;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getSkypeId() {
		return skypeId;
	}

	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}

	public String getPersonalLinkedinProfile() {
		return personalLinkedinProfile;
	}

	public void setPersonalLinkedinProfile(String personalLinkedinProfile) {
		this.personalLinkedinProfile = personalLinkedinProfile;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getResetPasswordId() {
		return resetPasswordId;
	}

	public void setResetPasswordId(String resetPasswordId) {
		this.resetPasswordId = resetPasswordId;
	}

	public String getEmailVerificationId() {
		return emailVerificationId;
	}

	public void setEmailVerificationId(String emailVerificationId) {
		this.emailVerificationId = emailVerificationId;
	}

	public Boolean getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}
	
	
	
}
