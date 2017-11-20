/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stepsolar.sr.services;

/**
 * Created by Farhan Sharif Khokhar 19/11/2017.
 */
import org.springframework.data.domain.Pageable;

import com.stepsolar.sr.entities.User;

public interface UserService {

	Iterable<User> findAll(Pageable pageable);

	User findById(String id);

	User findByEmail(String email);

	User save(User user);

	Boolean delete(String id);
}
