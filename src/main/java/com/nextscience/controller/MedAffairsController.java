package com.nextscience.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.Constants.HealthCareConstants;
import com.nextscience.dto.request.MedAffairsReqDto;
import com.nextscience.service.MedAffairsRequestService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(HealthCareConstants.APIV1MEDAFF)
public class MedAffairsController {
	
	@Autowired
	private MedAffairsRequestService requestService;

	@PostMapping(HealthCareConstants.APIV1MEDAFFADD)
	@CrossOrigin(origins = "*")
	public ResponseEntity<String> createUser(@RequestBody MedAffairsReqDto request) {
		return ResponseEntity.ok(requestService.addMedAffReq(request));
	}

}
