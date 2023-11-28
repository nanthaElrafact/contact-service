package com.nextscience.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "CONTACTS", schema = "dbo")
@JsonIgnoreProperties(ignoreUnknown = true)
//@Entity
public class Contacts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRN_MA_REQ_ID")
	private Integer contactId;

	@Column(name = "PRODUCT_NAME")
	private String healthCareProduct;
	
	private String MA_REQ_CATG;

	@Column(name = "MA_REQ_TYPE")
	private String requestType;

	@Column(name = "PROF_DESG")
	private String designation;

	private String HCP_FIRST_NAME;
	
	private String HCP_LAST_NAME;
	
	@Column(name = "HCP_NAME")
	private String hcpName;
	
	private String NPI;

	@Column(name = "HCP_EMAIL")
	private String hcpEmail;
	
	
	private String ACCOUNT_NAME;

	@Column(name = "FACILITY")
	private String facility;

	@Column(name = "PHONE")
	private String phone;

	@Column(name = "DEPARTMENT")
	private String department;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "CITY")
	private String city;

	@Column(name = "STATE")
	private String state;

	@Column(name = "ZIP")
	private String zip;
	
	private String SALES_REP_EMAIL;

	@Column(name = "QUERY_SUBMIT")
	private String querySubmit;

	@Column(name = "COMMENTS")
	private String description;
	
	@Column(name = "SIGNATURE")
	private String signature;
	
	private String SIGNATURE_OF;
	
	private String MA_REQ_STATUS;
	
	private String USER_ID;
	
	private Date SUBMITTED_DATE;
	
	private String CREATED_USER;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "CREATED_DATE")
	private Date createDate;
	
	private String UPDATED_USER;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "UPDATED_DATE")
	private Date updateDate;

}
