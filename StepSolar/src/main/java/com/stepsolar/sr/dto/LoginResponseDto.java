package com.stepsolar.sr.dto;

import com.stepsolar.sr.entities.User;
/**
 * Created by Farhan Sharif Khokhar 16/11/2017.
 */
public class LoginResponseDto {
    private String access_token;
    private User user;
    public LoginResponseDto() {
        this.access_token = null;
        this.user = null;
    }

    public LoginResponseDto(String access_token, User user) {
        this.access_token = access_token;
        this.user = user;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}