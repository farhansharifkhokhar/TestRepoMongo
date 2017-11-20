/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stepsolar.sr.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by Farhan Sharif Khokhar 19/11/2017.
 */
import com.stepsolar.sr.entities.User;
import com.stepsolar.sr.repository.UserRepository;
import com.stepsolar.sr.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public Iterable<User> findAll(Pageable pageable) {
		return userRepository.findAll(pageable).getContent();
	}

	@Override
	public User findById(String id) {
		return userRepository.findOne(id);
	}

	@Override
	public User save(User user) {

		if (user.getId() != null) {
			User u = userRepository.findOne(user.getId());

			// Do not update if password was not defined
			if (org.springframework.util.StringUtils.hasText(user.getPassword())) {
				user.setPassword(passwordEncoder.encode(user.getPassword()));
			} else {
				user.setPassword(u.getPassword());
			}
		} else if (user.getId() == null) {
			// TODO Do not hardcode default pass
			user.setPassword(passwordEncoder.encode(user.getPassword() != null ? user.getPassword() : "password"));
		}

		return userRepository.save(user);
	}

	@Override
	public Boolean delete(String id) {
		userRepository.delete(id);
		return !userRepository.exists(id);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
