package com.stepsolar.sr.repository;

/**
 * Created by Farhan Sharif Khokhar 19/11/2017.
 */
import org.springframework.data.mongodb.repository.MongoRepository;
import com.stepsolar.sr.entities.User;

public interface UserRepository extends MongoRepository<User, String> {
	public User findByEmail(String email);

}
