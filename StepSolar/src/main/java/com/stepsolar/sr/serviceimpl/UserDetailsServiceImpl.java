package com.stepsolar.sr.serviceimpl;

/**
 * Created by Farhan Sharif Khokhar 19/11/2017.
 */
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.stepsolar.sr.entities.User;
import com.stepsolar.sr.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Autowired
	private MessageSource messageSource;
	private Locale locale = LocaleContextHolder.getLocale();
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = null;
		try {
			user = userRepository.findByEmail(email);
		} catch (Exception ex) {

			log.error(messageSource.getMessage("database.record.read.error", null, locale) + ex);
		}
		if (user == null) {

			log.info(messageSource.getMessage("login.user.not.found", null, locale));
			throw new UsernameNotFoundException(String.format("No user found with username '%s'.", email));
		} else {
			return user;
		}
	}

}
