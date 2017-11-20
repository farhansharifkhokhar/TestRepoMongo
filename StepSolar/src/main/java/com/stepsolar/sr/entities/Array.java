package com.stepsolar.sr.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Farhan Sharif Khokhar 19/11/2017.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Array {

	@Id
	private String id;

	@Transient
	private String objectId;

	@Column
	private Double inclination;

	@Column
	private String productionParameters;

	/************************
	 ************************
	 */
	// 1- salePrice
	// 2- moduleType
	// 3- InverterEfficiency
	// 4- mountType
	// 5- arraySize
	// 6- losses

	@Column
	private Double arraySize;

	@Column
	private String salePrice;

	@Column
	private String losses;

	@Column
	private String inverterEfficiency;

	@Column
	private Integer mountType;

	@Column
	private Integer moduleType;
	/************************
	 ************************
	 */

	@Column
	private String userId;

	@Column
	private String clientId;

	@Column
	private String energy;

	@Column
	private String name;

	@Column
	private Double azimuth;

	@Column
	private Double tilt;

	@Embedded
	private ParseTypeFile photoUrl;

	@Column
	private String modificationDateTime;

	@Transient
	private List<Point> pointList;
	@Column(name = "_created_at")
	private Date createdAt;

	@Column(name = "_updated_at")
	private Date updatedAt;

	public List<Point> getPointList() {
		return pointList;
	}

	public void setPointList(List<Point> pointList) {
		this.pointList = pointList;
	}

	public void addPoint(Point point) {
		if (this.pointList == null) {
			this.pointList = new ArrayList<>();
		}
		pointList.add(point);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getInclination() {
		return inclination;
	}

	public void setInclination(Double inclination) {
		this.inclination = inclination;
	}

	public String getProductionParameters() {
		return productionParameters;
	}

	public void setProductionParameters(String productionParameters) {
		this.productionParameters = productionParameters;
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

	public Double getAzimuth() {
		if (azimuth == null) {
			// setting default after confirmation
			azimuth = 180d;
		}

		return azimuth;
	}

	public void setAzimuth(Double azimuth) {
		this.azimuth = azimuth;
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

	public Double getTilt() {
		if (tilt == null) {
			// setting default after confirmation
			tilt = 17d;
		}
		return tilt;
	}

	public void setTilt(Double tilt) {
		this.tilt = tilt;
	}

	public String getModificationDateTime() {
		return modificationDateTime;
	}

	public void setModificationDateTime(String modificationDateTime) {
		this.modificationDateTime = modificationDateTime;
	}

	public Double getArraySize() {
		return arraySize;
	}

	public void setArraySize(Double arraySize) {
		this.arraySize = arraySize;
	}

	public String getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}

	public String getLosses() {
		return losses;
	}

	public void setLosses(String losses) {
		this.losses = losses;
	}

	public String getInverterEfficiency() {
		return inverterEfficiency;
	}

	public void setInverterEfficiency(String inverterEfficiency) {
		this.inverterEfficiency = inverterEfficiency;
	}

	public Integer getMountType() {
		return mountType;
	}

	public void setMountType(Integer mountType) {
		this.mountType = mountType;
	}

	public Integer getModuleType() {
		return moduleType;
	}

	public void setModuleType(Integer moduleType) {
		this.moduleType = moduleType;
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

	public Point lastIncludedPoint() {
		Point pointToReturn = null;
		for (Point point : getPointList()) {
			if (point.getIsIncluded()) {
				if (pointToReturn == null) {
					pointToReturn = point;
				} else if (point.getTimeStamp().compareTo(pointToReturn.getTimeStamp()) > 0) {
					pointToReturn = point;
				}
			}
		}
		return pointToReturn;
	}

	public int includedPointsCount() {
		int includedPointsCount = 0;
		for (Point point : getPointList()) {
			if (point.getIsIncluded()) {
				includedPointsCount++;
			}
		}
		return includedPointsCount;
	}
}
