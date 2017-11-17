/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stepsolar.sr.serviceimpl;

import com.stepsolar.sr.entities.User;
import com.stepsolar.sr.repository.UserRepository;
import com.stepsolar.sr.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by Farhan Sharif Khokhar 16/11/2017.
 */
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
		if (user.getId() == null) {
			user.setPassword(passwordEncoder.encode(user.getPassword() != null ? user.getPassword() : "password"));
		} else {
			User alreadyExists = userRepository.findOne(user.getId());
			user.setPassword(alreadyExists.getPassword());
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
