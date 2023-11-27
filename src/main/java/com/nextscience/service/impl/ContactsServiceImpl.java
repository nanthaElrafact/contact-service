package com.nextscience.service.impl;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.nextscience.component.EmailBuilder;
import com.nextscience.config.CustomPasswordEncoder;
import com.nextscience.dto.request.ContactsReqDto;
import com.nextscience.dto.request.EmailDto;
import com.nextscience.entity.Contacts;
import com.nextscience.repo.ContactsRepository;
import com.nextscience.service.ContactsService;
import com.nextscience.service.EmailService;

import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ContactsServiceImpl implements ContactsService {
	@Autowired
	ContactsRepository contactsRepository;
	
	@Autowired
	private JavaMailSender javaMailSender;

	// private PasswordEncoder passwordEncoder;

	@Autowired
	private CustomPasswordEncoder passwordEncoder;

	@Autowired
	private EmailService emailService;

	@Value("${mail.from.email.id}")
	private String fromEmail;

	@Value("${mail.subject.resetpassword.template}")
	private String resetTemplate;

	@Value("${mail.subject.email}")
	private String subject;

	@Value("${mail.subject.resetpassword.link}")
	private String resetParams;

	@Value("${mail.subject.email.resetpassword}")
	private String resetPassword;

	@Value("${mail.subject.createUser.template}")
	private String createUserTemplate;

	@Value("${mail.subject.createUser.firstName}")
	private String firstName;

	@Value("${mail.subject.createUser.userName}")
	private String userName;

	@Value("${mail.subject.createUser.userCreated}")
	private String userCreated;

	@Override
	public String add(ContactsReqDto request) {
		String base64Data = request.getSignature().split(",")[1];
        byte[] decodedBytes = java.util.Base64.getDecoder().decode(base64Data);


		String encodedSignatureData = Base64.getEncoder().encodeToString(decodedBytes);

		// Convert signature data to a byte array
	//	byte[] signatureBytes = Base64.getDecoder().decode(signatureData);
		Date now = new Date();
		var contacts = Contacts.builder().healthCareProduct(request.getHealthCareProduct()).
				requsetType(request.getRequsetType()).designation(request.getDesignation()).
				hcpName(request.getHcpName()).hcpEmail(request.getHcpEmail()).facility(request.getFacility()).
				phone(request.getPhone()).
				department(request.getDepartment()).address(request.getAddress()).city(request.getCity()).
				state(request.getState()).zip(request.getZip()).querySubmit(request.getQuerySubmit()).
				description(request.getDescription()).signature(encodedSignatureData).
				createDate(now).updateDate(null).build();
		contactsRepository.save(contacts);
		log.info("Saved user");
		//log.info("Email Successfully Send");
		return "User created successfully";
	}

}
