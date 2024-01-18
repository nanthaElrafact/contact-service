package com.contactservice.service;

import com.contactservice.dto.request.SignUpRequest;
import com.contactservice.dto.request.SigninRequest;
import com.contactservice.dto.response.JwtAuthenticationResponse;

/**
 * Service interface for managing {@link AuthenticationService}.request
 * 
 * @author Raghu
 */

public interface AuthenticationService {

	/** Perform authentication for admin users. */
	JwtAuthenticationResponse adminSignin(SigninRequest request);

	/** Perform signup for admin users. */
	String adminSignup(SignUpRequest request);
}