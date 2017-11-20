package com.stepsolar.sr.controllers;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stepsolar.sr.constant.ResponseTagName;
import com.stepsolar.sr.entities.Client;
import com.stepsolar.sr.services.ClientService;

import io.swagger.annotations.Api;

/**
 * Created by Farhan Sharif Khokhar 18/11/2017.
 */
@Api(tags = ("v2/Clients"))
@RestController
@RequestMapping(path = "api/v2/clients", produces = { "application/json" })
public class ClientController {

	@Autowired
	private ClientService clientServices;

	private LinkedHashMap<Object, Object> apiResponse = new LinkedHashMap<Object, Object>();
	private LinkedHashMap<String, Object> serviceResponse = new LinkedHashMap<String, Object>();

	@PostMapping
	ResponseEntity<?> post(@RequestBody Client client) {

		Client o = clientServices.save(client);
		serviceResponse.put(ResponseTagName.CREATED, o);
		apiResponse.put(ResponseTagName.API_RESPONSE, serviceResponse);
		return new ResponseEntity<Object>(apiResponse, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	ResponseEntity<?> get(@PathVariable("id") String id) {
		Client o = clientServices.findById(id);
		if (o != null) {
			serviceResponse.put(ResponseTagName.RETRIEVED, 0);
			apiResponse.put(ResponseTagName.API_RESPONSE, serviceResponse);
			return new ResponseEntity<Object>(apiResponse, new HttpHeaders(), HttpStatus.OK);

		}

		return ResponseEntity.notFound().build();
	}

	@GetMapping("/list")
	ResponseEntity<?> list(Pageable pageable) {
		List<Client> client = (List<Client>) clientServices.findAll(pageable);
		serviceResponse.put(ResponseTagName.LIST, client);
		apiResponse.put(ResponseTagName.API_RESPONSE, serviceResponse);
		return new ResponseEntity<Object>(apiResponse, new HttpHeaders(), HttpStatus.OK);

	}

	@PutMapping("/{id}")
	ResponseEntity<?> put(@PathVariable("id") Long id, @RequestBody Client user) {

		Client o = clientServices.save(user);
		serviceResponse.put(ResponseTagName.RETRIEVED, 0);
		apiResponse.put(ResponseTagName.API_RESPONSE, serviceResponse);
		return new ResponseEntity<Object>(apiResponse, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	ResponseEntity<?> delete(@PathVariable("id") String id) {
		boolean isDeleted = clientServices.delete(id);
		if (isDeleted) {

			apiResponse.put(ResponseTagName.STATUS, Boolean.TRUE);
			apiResponse.put(ResponseTagName.MESSAGE, "Your statistics has been deleted successfully.");
			return new ResponseEntity<Object>(apiResponse, new HttpHeaders(), HttpStatus.OK);
		} else {

			return new ResponseEntity<Object>("error occured while delete", new HttpHeaders(), HttpStatus.BAD_REQUEST);
		}
	}

}
