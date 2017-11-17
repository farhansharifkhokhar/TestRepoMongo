package com.stepsolar.sr.entities;

import io.swagger.annotations.ApiModel;

@ApiModel
public class InstallerUserSrStatus {
	public static final String ACTIVE = "1";
	public static final String IN_ACTIVE = "2";
	public static final String SUSPENDED = "3";
	public static final String NOT_IN_SERVICE = "4";
}
