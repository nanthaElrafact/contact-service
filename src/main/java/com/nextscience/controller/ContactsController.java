package com.nextscience.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.Constants.HealthCareConstants;
import com.nextscience.dto.request.ContactsReqDto;
import com.nextscience.service.ContactsService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(HealthCareConstants.APIV1HEALTH)
public class ContactsController {
	
	@Autowired
	private ContactsService contactsService;

	/** Create a User in userList */
	@PostMapping(HealthCareConstants.APIV1HEALTHADD)
	@CrossOrigin(origins = "*")
	public ResponseEntity<String> createUser(@RequestBody ContactsReqDto request) {
		return ResponseEntity.ok(contactsService.add(request));
	}

	/** Update User in UserDetails list */
	@PutMapping(HealthCareConstants.APIV1HEALTHADD_1)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<String> updateUser(@RequestBody ContactsReqDto request) {
		return ResponseEntity.ok(contactsService.add(request));
	}

}
