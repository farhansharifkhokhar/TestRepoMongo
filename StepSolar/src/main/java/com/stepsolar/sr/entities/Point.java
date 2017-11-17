package com.stepsolar.sr.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(indexes = {
		@Index(columnList = "timeStamp", name = "timeStamp_idx"),
		@Index(columnList = "clientId", name = "clientId_idx")
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class Point {
	
	@Id
	private String id;
	
	@Transient
	private String objectId;
	
	@Column
	private String userId;
	
	@Column
	private String clientId;
	
	@Column
	private Double pitch;
	
	@Column
	private String captureDateTime;
	
	@Column
	private Double trueYaw;
	
	@Column
	private Double altitude;
	
	@Column
	private String centerAdjustment;
	
	@Column
	private Boolean isIncluded;
	
	@Column
	private Double declination;
	
	@Column
	private String energy;
	
	@Column
	private String name;
	
	@Column
	private String arrayId;
	
	@Embedded
	private ParseTypeGeoPoint location;
	
	@Embedded
	private ParseTypeFile photoThumbnailUrl;
	
	@Column
	private String timeStamp;
	
	@Column
	private Float timeZone;
	
	@Column
	private Integer captureDevice;
	
	@Column
	private Double yaw;
	
	@Column
	private Double roll;
	
	@Embedded
	private ParseTypeFile photoUrl;
	
	@Embedded
	private ParseTypeFile fileProcessedUrl;
	
	@Column
	private String modificationDateTime;

	@Column (name = "_created_at")
	private Date createdAt;

	@Column (name = "_updated_at")
	private Date updatedAt;

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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public Double getPitch() {
		return pitch;
	}

	public void setPitch(Double pitch) {
		this.pitch = pitch;
	}

	public String getCaptureDateTime() {
		return captureDateTime;
	}

	public void setCaptureDateTime(String captureDateTime) {
		this.captureDateTime = captureDateTime;
	}

	public Double getTrueYaw() {
		return trueYaw;
	}

	public void setTrueYaw(Double trueYaw) {
		this.trueYaw = trueYaw;
	}

	public Double getAltitude() {
		return altitude;
	}

	public void setAltitude(Double altitude) {
		this.altitude = altitude;
	}

	public String getCenterAdjustment() {
		return centerAdjustment;
	}

	public void setCenterAdjustment(String centerAdjustment) {
		this.centerAdjustment = centerAdjustment;
	}

	public Boolean getIsIncluded() {
		return isIncluded;
	}

	public void setIsIncluded(Boolean isIncluded) {
		this.isIncluded = isIncluded;
	}

	public Double getDeclination() {
		return declination;
	}

	public void setDeclination(Double declination) {
		this.declination = declination;
	}

	public String getEnergy() {
		return energy;
	}

	public void setEnergy(String energy) {
		this.energy = energy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArrayId() {
		return arrayId;
	}

	public void setArrayId(String arrayId) {
		this.arrayId = arrayId;
	}


	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Float getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(Float timeZone) {
		this.timeZone = timeZone;
	}

	public Integer getCaptureDevice() {
		return captureDevice;
	}

	public void setCaptureDevice(Integer captureDevice) {
		this.captureDevice = captureDevice;
	}

	public Double getYaw() {
		return yaw;
	}

	public void setYaw(Double yaw) {
		this.yaw = yaw;
	}

	public Double getRoll() {
		return roll;
	}

	public void setRoll(Double roll) {
		this.roll = roll;
	}

	public ParseTypeGeoPoint getLocation() {
		return location;
	}

	public void setLocation(ParseTypeGeoPoint location) {
		this.location = location;
	}

	public ParseTypeFile getPhotoThumbnailUrl() {
		return photoThumbnailUrl;
	}

	public void setPhotoThumbnailUrl(ParseTypeFile photoThumbnailUrl) {
		this.photoThumbnailUrl = photoThumbnailUrl;
	}

	public ParseTypeFile getFileProcessedUrl() {
		return fileProcessedUrl;
	}

	public void setFileProcessedUrl(ParseTypeFile fileProcessedUrl) {
		this.fileProcessedUrl = fileProcessedUrl;
	}

	public ParseTypeFile getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(ParseTypeFile photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getModificationDateTime() {
		return modificationDateTime;
	}

	public void setModificationDateTime(String modificationDateTime) {
		this.modificationDateTime = modificationDateTime;
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
}
