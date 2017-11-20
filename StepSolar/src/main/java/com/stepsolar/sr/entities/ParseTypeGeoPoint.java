package com.stepsolar.sr.entities;

/**
 * Created by Farhan Sharif Khokhar 19/11/2017.
 */
import javax.persistence.Embeddable;

@Embeddable
public class ParseTypeGeoPoint {

	private String __type;
	private Double latitude;
	private Double longitude;

	public String get__type() {
		return __type;
	}

	public void set__type(String __type) {
		this.__type = __type;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

}
