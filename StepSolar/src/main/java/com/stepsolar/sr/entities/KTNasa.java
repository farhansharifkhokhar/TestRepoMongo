package com.stepsolar.sr.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
public class KTNasa {

	@Id
	private String id;
	
	@Transient
	private String objectId;
	
	@Column
	private Float latitude;
	
	@Column
	private Float longitude;
	
	@Column
	private Float annual;
	
	@Column
	private Float jan;
	
	@Column
	private Float feb;
	
	@Column
	private Float mar;
	
	@Column
	private Float apr;
	
	@Column
	private Float may;
	
	@Column
	private Float jun;
	
	@Column
	private Float jul;
	
	@Column
	private Float aug;
	
	@Column
	private Float sep;
	
	@Column
	private Float oct;
	
	@Column
	private Float nov;
	
	@Column
	private Float dec;

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

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Float getAnnual() {
		return annual;
	}

	public void setAnnual(Float annual) {
		this.annual = annual;
	}

	public Float getJan() {
		return jan;
	}

	public void setJan(Float jan) {
		this.jan = jan;
	}

	public Float getFeb() {
		return feb;
	}

	public void setFeb(Float feb) {
		this.feb = feb;
	}

	public Float getMar() {
		return mar;
	}

	public void setMar(Float mar) {
		this.mar = mar;
	}

	public Float getApr() {
		return apr;
	}

	public void setApr(Float apr) {
		this.apr = apr;
	}

	public Float getMay() {
		return may;
	}

	public void setMay(Float may) {
		this.may = may;
	}

	public Float getJun() {
		return jun;
	}

	public void setJun(Float jun) {
		this.jun = jun;
	}

	public Float getJul() {
		return jul;
	}

	public void setJul(Float jul) {
		this.jul = jul;
	}

	public Float getAug() {
		return aug;
	}

	public void setAug(Float aug) {
		this.aug = aug;
	}

	public Float getSep() {
		return sep;
	}

	public void setSep(Float sep) {
		this.sep = sep;
	}

	public Float getOct() {
		return oct;
	}

	public void setOct(Float oct) {
		this.oct = oct;
	}

	public Float getNov() {
		return nov;
	}

	public void setNov(Float nov) {
		this.nov = nov;
	}

	public Float getDec() {
		return dec;
	}

	public void setDec(Float dec) {
		this.dec = dec;
	}
	
	
	
}
