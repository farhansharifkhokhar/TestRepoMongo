/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stepsolar.sr.entities;

/**
 * Created by Farhan Sharif Khokhar 19/11/2017.
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "User")
public class User implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	public String id;
	@Indexed(unique = true)
	@Column(unique = true)
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private long mobileNumber;
	private List<String> roles;
	@JsonIgnore
	@Transient
	private List<GrantedAuthority> authority = AuthorityUtils.createAuthorityList(new String[] { "ROLE_USER" });

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public String getUsername() {
		return email;
	}

	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	@JsonIgnore
	public List<GrantedAuthority> getAuthorities() {
		return this.authority;
	}

	@JsonIgnore
	public void setAuthorities(String authority) {
		List<String> roles = new ArrayList<>();
		for (GrantedAuthority grantedAuthority : this.authority) {
			roles.add(grantedAuthority.getAuthority());
		}
		if (authority.length() > 0) {
			roles.add(authority);
		}

		this.authority = AuthorityUtils.createAuthorityList(roles.toArray(new String[roles.size()]));
	}

	@JsonIgnore
	public boolean hasRole(String role) {
		Collection<? extends GrantedAuthority> authorities = this.authority;
		return authorities.contains(new SimpleGrantedAuthority(role));

	}

}
