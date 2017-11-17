package com.stepsolar.sr.security;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
/**
 * Created by Farhan Sharif Khokhar 16/11/2017.
 */
public class SpringSecurityAuditorAware implements AuditorAware<String> {

    private String defaultUser;

    public SpringSecurityAuditorAware(String defaultUser) {
        this.defaultUser = defaultUser;
    }

    public String getCurrentAuditor() {
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .filter(Authentication::isAuthenticated).map(Authentication::getName).orElse(defaultUser);
    }
}