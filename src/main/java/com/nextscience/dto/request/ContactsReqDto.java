package com.nextscience.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactsReqDto {
	
	private String healthCareProduct;
	
	private String requsetType;

	private String designation;

	private String hcpName;

	private String hcpEmail;

	private String facility;

	private String phone;

	private String department;

	private String address;

	private String city;

	private String state;

	private String zip;

	private String querySubmit;
	
	private String description;
}
