package com.stepsolar.sr.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class InstallerPackaging {
	public InstallerPackaging() {
	}
	
	@JsonCreator
	public InstallerPackaging(
			@JsonProperty("id") Integer id,
			@JsonProperty("description") String description
			) {
		this.id = id;
		this.description = description;
	}
	
	@Id
	private Integer id;
	
	@Column
	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
