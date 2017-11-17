package com.stepsolar.sr.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stepsolar.sr.entities.User;
/**
 * Created by Farhan Sharif Khokhar 16/11/2017.
 */
public interface UserRepository extends MongoRepository<User, String> {
       public User findByEmail(String email);

}
