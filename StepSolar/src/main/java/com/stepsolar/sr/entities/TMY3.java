package com.stepsolar.sr.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;


@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
public class TMY3 {

	@Id
	private String id;
	
	@Transient
	private String objectId;
	
	@Column
	private String data;
	
	@Embedded
	private ParseTypeGeoPoint location;
	
	@Column
	private String latitude;
	
	@Column
	private String longitude;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.setId(objectId);
		this.objectId = objectId;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public ParseTypeGeoPoint getLocation() {
		return location;
	}

	public void setLocation(ParseTypeGeoPoint location) {
		this.location = location;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	
}
