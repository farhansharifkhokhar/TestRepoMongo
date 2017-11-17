package com.stepsolar.sr.serviceimpl;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stepsolar.sr.entities.Client;
import com.stepsolar.sr.services.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Override
	public Iterable<Client> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client save(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
