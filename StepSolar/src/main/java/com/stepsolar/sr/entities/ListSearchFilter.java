package com.stepsolar.sr.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;


@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
public class ListSearchFilter {

//    1) Size   (double)
//    2) Lead Assigned  (Integer >=0)
//    3) Site Visited (Integer >=0)
//    4) Status (String, it will have some fixed text values, so maybe an enum )
//    5) Usage (double/float)
//    6) Shading (double/float , up to 1 decimal place >=0)
//    7) Arrays (Integer >=0)
	
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "stepSolarIdGenerator")
    @TableGenerator(
            name = "stepSolarIdGenerator",
            table = "stepSolarSequence",
            pkColumnValue = "listSearchFilter",
            allocationSize = 1,
            valueColumnName = "nextListSearchFilterId"
        )
	@Id
	private long id;
	
	@Column
	private String installerManagerId;

	@Column
	private String name;
	
	@Column
	private Boolean sizeInclude;
	
	@Column
	private Double sizeStart;

	@Column
	private Double sizeEnd;
	
	@Column
	private Boolean leadsAssignedInclude;
	
	@Column
	private Integer leadsAssignedStart;

	@Column
	private Integer leadsAssignedEnd;
	
	@Column
	private Boolean siteVisitedInclude;
	
	@Column
	private Integer siteVisitedStart;

	@Column
	private Integer siteVisitedEnd;
	
	@Column
	private Boolean statusInclude;
	
	@Column
	private String status;

	@Column
	private Boolean usageInclude;

	@Column
	private Double usageStart;
	
	@Column
	private Double usageEnd;

	@Column
	private Boolean shaddingInclude;

	@Column
	private Double shaddingStart;
	
	@Column
	private Double shaddingEnd;

	@Column
	private Boolean arraysInclude;

	@Column
	private Integer arraysStart;
	
	@Column
	private Integer arraysEnd;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getInstallerManagerId() {
		return installerManagerId;
	}

	public void setInstallerManagerId(String installerManagerId) {
		this.installerManagerId = installerManagerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getSizeInclude() {
		return sizeInclude;
	}

	public void setSizeInclude(Boolean sizeInclude) {
		this.sizeInclude = sizeInclude;
	}

	public Double getSizeStart() {
		return sizeStart;
	}

	public void setSizeStart(Double sizeStart) {
		this.sizeStart = sizeStart;
	}

	public Double getSizeEnd() {
		return sizeEnd;
	}

	public void setSizeEnd(Double sizeEnd) {
		this.sizeEnd = sizeEnd;
	}

	public Boolean getLeadsAssignedInclude() {
		return leadsAssignedInclude;
	}

	public void setLeadsAssignedInclude(Boolean leadsAssignedInclude) {
		this.leadsAssignedInclude = leadsAssignedInclude;
	}

	public Integer getLeadsAssignedStart() {
		return leadsAssignedStart;
	}

	public void setLeadsAssignedStart(Integer leadsAssignedStart) {
		this.leadsAssignedStart = leadsAssignedStart;
	}

	public Integer getLeadsAssignedEnd() {
		return leadsAssignedEnd;
	}

	public void setLeadsAssignedEnd(Integer leadsAssignedEnd) {
		this.leadsAssignedEnd = leadsAssignedEnd;
	}

	public Boolean getSiteVisitedInclude() {
		return siteVisitedInclude;
	}

	public void setSiteVisitedInclude(Boolean siteVisitedInclude) {
		this.siteVisitedInclude = siteVisitedInclude;
	}

	public Integer getSiteVisitedStart() {
		return siteVisitedStart;
	}

	public void setSiteVisitedStart(Integer siteVisitedStart) {
		this.siteVisitedStart = siteVisitedStart;
	}

	public Integer getSiteVisitedEnd() {
		return siteVisitedEnd;
	}

	public void setSiteVisitedEnd(Integer siteVisitedEnd) {
		this.siteVisitedEnd = siteVisitedEnd;
	}

	public Boolean getStatusInclude() {
		return statusInclude;
	}

	public void setStatusInclude(Boolean statusInclude) {
		this.statusInclude = statusInclude;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getUsageInclude() {
		return usageInclude;
	}

	public void setUsageInclude(Boolean usageInclude) {
		this.usageInclude = usageInclude;
	}

	public Double getUsageStart() {
		return usageStart;
	}

	public void setUsageStart(Double usageStart) {
		this.usageStart = usageStart;
	}

	public Double getUsageEnd() {
		return usageEnd;
	}

	public void setUsageEnd(Double usageEnd) {
		this.usageEnd = usageEnd;
	}

	public Boolean getShaddingInclude() {
		return shaddingInclude;
	}

	public void setShaddingInclude(Boolean shaddingInclude) {
		this.shaddingInclude = shaddingInclude;
	}

	public Double getShaddingStart() {
		return shaddingStart;
	}

	public void setShaddingStart(Double shaddingStart) {
		this.shaddingStart = shaddingStart;
	}

	public Double getShaddingEnd() {
		return shaddingEnd;
	}

	public void setShaddingEnd(Double shaddingEnd) {
		this.shaddingEnd = shaddingEnd;
	}

	public Boolean getArraysInclude() {
		return arraysInclude;
	}

	public void setArraysInclude(Boolean arraysInclude) {
		this.arraysInclude = arraysInclude;
	}

	public Integer getArraysStart() {
		return arraysStart;
	}

	public void setArraysStart(Integer arraysStart) {
		this.arraysStart = arraysStart;
	}

	public Integer getArraysEnd() {
		return arraysEnd;
	}

	public void setArraysEnd(Integer arraysEnd) {
		this.arraysEnd = arraysEnd;
	}
	
}
