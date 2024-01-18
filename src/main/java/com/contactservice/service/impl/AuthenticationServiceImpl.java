package com.contactservice.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.contactservice.Constants.CommonConstants;
import com.contactservice.config.CustomPasswordEncoder;
import com.contactservice.dto.request.SignUpRequest;
import com.contactservice.dto.request.SigninRequest;
import com.contactservice.dto.response.JwtAuthenticationResponse;
import com.contactservice.entity.User;
import com.contactservice.repo.UserRepository;
import com.contactservice.service.AuthenticationService;
import com.contactservice.service.JwtService;

import lombok.RequiredArgsConstructor;

/**
 * Service Class for managing {@link AuthenticationServiceImpl}.request
 * 
 * @author Raghu
 */

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
   // private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    
    @Autowired
    private final CustomPasswordEncoder passwordEncoder;

   

    @Override
    public JwtAuthenticationResponse adminSignin(SigninRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
        var user = userRepository.findByUserName(request.getUserName())
                .orElseThrow(() -> new IllegalArgumentException(CommonConstants.INVALIDEMAILORPASSWORD));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).role(user.getRole()).userId(user.getUserId()).build();
    }

	@Override
	public String adminSignup(SignUpRequest request) {
		 var user = User.builder()
				 .userName(request.getUserName())
				 .firstName(request.getFirstName())
				 .middleName(request.getMiddleName())
				 .lastName(request.getLastName())
				 .userMail(request.getEmail())
				 .confirmPassword(passwordEncoder.encode(request.getConfirmPassword()))
				 .password(passwordEncoder.encode(request.getPassword()))
				 .otherPassword(passwordEncoder.encode(request.getOtherPassword()))
				 .passwordUpdatedDate(request.getPasswordUpdatedDate())
				 .phone(request.getPhone())
				 .address1(request.getAddress())
				 .role(request.getRole())
				 .userType(request.getType())
				 .city(request.getCity())
				 .state(request.getState())
				 .zip(request.getZip())
				 .userImageUrl(request.getImage())
				 .salesForce(request.getSalesForce())
				 .createdUser(request.getCreatedUser())
				 .createdDate(request.getCreatedDate())
				 .updatedUser(request.getUpdatedUser())
				 .updatedDate(request.getUpdateDate()).build();
	        userRepository.save(user);
	        return CommonConstants.ADMINUSERCREATEDSUCCESSFULLY;
	}
}