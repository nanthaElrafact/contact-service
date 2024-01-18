package com.contactservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Processes an {@link NextscienceServiceApplication } request.
 * 
 * @author Raghu
 *
 */

@SpringBootApplication

public class ContactServiceApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ContactServiceApplication.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

		return application.sources(ContactServiceApplication.class);
	}
}
