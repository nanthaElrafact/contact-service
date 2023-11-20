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
@Table(name = "CONTACTS", schema = "dbo")
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Contacts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONTACT_ID")
	private Integer contactId;

	@Column(name = "HEALTH_CARE_PRODUCT")
	private String healthCareProduct;

	@Column(name = "REQUSET_TYPE")
	private String requsetType;

	@Column(name = "DESIGNATION")
	private String designation;

	@Column(name = "HCP_NAME")
	private String hcpName;

	@Column(name = "HCP_EMAIL")
	private String hcpEmail;

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

	@Column(name = "QUERY_SUBMIT")
	private String querySubmit;

	@Column(name = "DESCRIPTION")
	private String description;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "CREATE_DATE")
	private Date createDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "UPDATE_DATE")
	private Date updateDate;

}
