package com.stepsolar.sr.entities;
/**
 * Created by Farhan Sharif Khokhar 19/11/2017.
 */
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class InstallerSize {
	
	public InstallerSize() {
	}
	
	@JsonCreator
	public InstallerSize(
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
