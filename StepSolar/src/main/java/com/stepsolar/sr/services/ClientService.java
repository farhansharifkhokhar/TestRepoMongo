package com.stepsolar.sr.services;

/**
 * Created by Farhan Sharif Khokhar 19/11/2017.
 */
import org.springframework.data.domain.Pageable;

import com.stepsolar.sr.entities.Client;

public interface ClientService {

	Iterable<Client> findAll(Pageable pageable);

	Client findById(String id);

	Client findByEmail(String email);

	Client save(Client client);

	Boolean delete(String id);

}
