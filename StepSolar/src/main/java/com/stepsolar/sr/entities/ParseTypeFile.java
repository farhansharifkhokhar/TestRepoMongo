package com.stepsolar.sr.entities;

import javax.persistence.Embeddable;

@Embeddable
public class ParseTypeFile {
	
	private String __type;
	private String name;
	private String url;
	public String get__type() {
		return __type;
	}
	public void set__type(String __type) {
		this.__type = __type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
