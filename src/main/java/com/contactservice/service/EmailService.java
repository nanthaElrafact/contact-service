package com.contactservice.service;

import org.springframework.core.io.UrlResource;

import com.contactservice.dto.request.EmailDto;

import jakarta.mail.MessagingException;

/**
 * Service interface for managing {@link EmailService}.request
 * 
 * @author Raghu
 */

public interface EmailService {

	/**
	 * sendMail details
	 * 
	 * @param EmailDto,isHtml
	 * @return
	 */
	public void sendMail(EmailDto message, boolean isHtml) throws MessagingException;
	public void sendAlertMail(EmailDto message, boolean isHtml, UrlResource urlResource) throws MessagingException;
}