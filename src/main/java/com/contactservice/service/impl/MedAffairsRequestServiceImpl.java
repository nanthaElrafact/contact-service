package com.contactservice.service.impl;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contactservice.dto.request.MedAffairsReqDto;
import com.contactservice.entity.MedAffairsRequest;
import com.contactservice.repo.MedAffairsRequestRepository;
import com.contactservice.service.MedAffairsRequestService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MedAffairsRequestServiceImpl implements MedAffairsRequestService {

	@Autowired
	MedAffairsRequestRepository repository;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public String addMedAffReq(MedAffairsReqDto req) {
		try {
			StoredProcedureQuery query = entityManager.createStoredProcedureQuery("usp_Med_Affairs_Req_Add_Web");

			query.registerStoredProcedureParameter("USER", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("PRODUCT_NAME", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("MA_REQ_CATG", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("PROF_DESG", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("HCP_FIRST_NAME", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("HCP_LAST_NAME", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("NPI", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("HCP_EMAIL", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("ACCOUNT_NAME", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("Phone", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("Department", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("ADDRESS", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("City", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("State", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("Zip", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("MA_REQ_TYPE", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("Sales_REP_EMail", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("COMMENTS", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("SIGNATURE", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("SIGNATURE_OF", String.class, ParameterMode.IN);

			String base64Data = req.getSignature().split(",")[1];
			byte[] decodedBytes = java.util.Base64.getDecoder().decode(base64Data);

			String encodedSignatureData = Base64.getEncoder().encodeToString(decodedBytes);

			if(req.getUser()==null) {
				query.setParameter("USER", "Administrator");
			}else {
				query.setParameter("USER", req.getUser());
			}
			query.setParameter("USER", "Administrator");
			query.setParameter("PRODUCT_NAME", req.getProductName());
			query.setParameter("MA_REQ_CATG", req.getMedAffReqCat());
			query.setParameter("PROF_DESG", req.getDesignation());
			query.setParameter("HCP_FIRST_NAME", req.getHcpFirstName());
			query.setParameter("HCP_LAST_NAME", req.getHcpLastName());
			query.setParameter("NPI", " ");
			query.setParameter("HCP_EMAIL", req.getHcpEmail());
			query.setParameter("ACCOUNT_NAME", req.getFacility());
			query.setParameter("Phone", req.getPhone());
			query.setParameter("Department", req.getDepartment());
			query.setParameter("ADDRESS", req.getAddress());
			query.setParameter("City", req.getCity());
			query.setParameter("State", req.getState());
			query.setParameter("Zip", req.getZip());
			query.setParameter("MA_REQ_TYPE", req.getQuerySubmit());
			query.setParameter("Sales_REP_EMail", " ");
			query.setParameter("COMMENTS", req.getDescription());
			query.setParameter("SIGNATURE", encodedSignatureData);
			query.setParameter("SIGNATURE_OF", " ");

			query.execute();

		} catch (Exception e) {
			log.error("Error in med affair to add");
		}
		return "Added Successfully";
	}

	@Override
	public String saveMedAffReq(MedAffairsReqDto req) {
		MedAffairsRequest medAffairsRequest = new MedAffairsRequest();
		medAffairsRequest.setProductName(req.getProductName());
		medAffairsRequest.setMaReqCatg(req.getMedAffReqCat());
		medAffairsRequest.setMaReqType(req.getMedAffReqType());
		medAffairsRequest.setDesignation(req.getDesignation());
		medAffairsRequest.setHcpFirstName(req.getHcpFirstName());
		medAffairsRequest.setHcpLastName(req.getHcpLastName());
		//medAffairsRequest.setHcpName(req.getHcpName());
		medAffairsRequest.setNpi(req.getNpi());
		medAffairsRequest.setHcpEmail(req.getHcpEmail());
		medAffairsRequest.setAccountName(req.getAccountName());
		medAffairsRequest.setPhone(req.getPhone());
		medAffairsRequest.setDepartment(req.getDepartment());
		medAffairsRequest.setAddress(req.getAddress());
		medAffairsRequest.setCity(req.getCity());
		medAffairsRequest.setState(req.getState());
		medAffairsRequest.setZip(req.getZip());
		medAffairsRequest.setSalesRepEmail(req.getSalesRepEmail());
		medAffairsRequest.setDescription(req.getDescription());
		medAffairsRequest.setSignature(req.getSignature());
		medAffairsRequest.setMaReqStatus(req.getMedAffReqType());

		repository.save(medAffairsRequest);

		return "added successfuly";
	}

}
