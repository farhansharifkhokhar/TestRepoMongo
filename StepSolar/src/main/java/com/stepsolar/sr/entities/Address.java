package com.stepsolar.sr.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Address {

	@JsonCreator
	public Address() {}

	@JsonCreator
	public Address(
			@JsonProperty("addressStreet") String addressStreet,
			@JsonProperty("addressCity") String addressCity,
			@JsonProperty("addressState") String addressState, 
			@JsonProperty("addressCountry") String addressCountry,
			@JsonProperty("addressPostalCode") String addressPostalCode
			) {
		this.addressStreet = addressStreet;
		this.addressCity = addressCity;
		this.addressState = addressState;
		this.addressCountry = addressCountry;
		this.addressPostalCode = addressPostalCode;
	}

	@Column
	String addressStreet;

	@Column
	String addressCity;

	@Column
	String addressState;

	@Column
	String addressCountry;
	
	@Column
	String addressPostalCode;

	public String getAddressStreet() {
		return addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressState() {
		return addressState;
	}

	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}

	public String getAddressCountry() {
		return addressCountry;
	}

	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}

	public String getAddressPostalCode() {
		return addressPostalCode;
	}

	public void setAddressPostalCode(String addressPostalCode) {
		this.addressPostalCode = addressPostalCode;
	}
	
	
}
