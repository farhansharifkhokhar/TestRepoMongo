package com.stepsolar.sr.security.auth;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;


/**
 * Created by Farhan Sharif Khokhar 16/11/2017.
 */
public class TokenBasedAuthentication extends AbstractAuthenticationToken {

    private static final long serialVersionUID = -5244891124123184312L;
    
    private String token;
    private final UserDetails principal;

    public TokenBasedAuthentication( UserDetails principal ) {
        super( principal.getAuthorities() );
        this.principal = principal;
    }

    public String getToken() {
        return token;
    }

    public void setToken( String token ) {
        this.token = token;
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    @Override
    public UserDetails getPrincipal() {
        return principal;
    }

}