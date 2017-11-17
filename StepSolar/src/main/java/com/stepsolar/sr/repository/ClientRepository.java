package com.stepsolar.sr.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stepsolar.sr.entities.User;

public interface ClientRepository extends MongoRepository<User, String> {

}
