package com.contactservice.entity;

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
@Table(name = "TRN_MED_AFFAIRS_REQUEST", schema = "dbo")
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class MedAffairsRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRN_MA_REQ_ID")
	private Integer trnMaReqId;

	@Column(name = "PRODUCT_NAME")
	private String productName;
	
	@Column(name = "MA_REQ_CATG")
	private String maReqCatg;

	@Column(name = "MA_REQ_TYPE")
	private String maReqType;

	@Column(name = "PROF_DESG")
	private String designation;

	@Column(name = "HCP_FIRST_NAME")
	private String hcpFirstName;
	
	@Column(name = "HCP_LAST_NAME")
	private String hcpLastName;
	
	@Column(name = "HCP_NAME")
	private String hcpName;
	
	@Column(name = "NPI")
	private String npi;

	@Column(name = "HCP_EMAIL")
	private String hcpEmail;
	
	@Column(name = "ACCOUNT_NAME")
	private String accountName;

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
	
	@Column(name = "SALES_REP_EMAIL")
	private String salesRepEmail;

	@Column(name = "COMMENTS")
	private String description;
	
	@Column(name = "SIGNATURE")
	private String signature;
	
	@Column(name = "SIGNATURE_OF")
	private String signatureOf;
	
	@Column(name = "MA_REQ_STATUS")
	private String maReqStatus;
	
	@Column(name = "USER_ID")
	private String userId;
	
	@Column(name = "SUBMITTED_DATE")
	private Date submittedDate;
	
	@Column(name = "CREATED_USER")
	private String createdUser;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "CREATED_DATE")
	private Date createDate;
	
	@Column(name = "UPDATED_USER")
	private String updatedUser;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "UPDATED_DATE")
	private Date updateDate;

}
