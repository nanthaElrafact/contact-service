package com.nextscience.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextscience.dto.request.MedAffairsReqDto;
import com.nextscience.repo.MedAffairsRequestRepository;
import com.nextscience.service.MedAffairsRequestService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;

@Service
public class MedAffairsRequestServiceImpl implements MedAffairsRequestService {

	@Autowired
	MedAffairsRequestRepository repository;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public String addMedAffReq(MedAffairsReqDto req) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("usp_Med_Affairs_Req_Add_Web");
		
		query.registerStoredProcedureParameter("USER", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("PRODUCT_NAME", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("MA_REQ_CATG", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("HCP_FIRST_NAME", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("HCP_LAST_NAME", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("NPI", Integer.class, ParameterMode.IN);
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
		
		query.setParameter("USER", "demo User");
		query.setParameter("PRODUCT_NAME", req.getProductName());
		query.setParameter("MA_REQ_CATG", req.getMedAffReqCat());
		query.setParameter("HCP_FIRST_NAME", req.getHcpName());
		query.setParameter("HCP_LAST_NAME", "");
		query.setParameter("NPI","");
		query.setParameter("HCP_EMAIL",req.getHcpEmail());
		query.setParameter("ACCOUNT_NAME", req.getFacility());
		query.setParameter("Phone", req.getPhone());
		query.setParameter("Department", req.getDepartment());
		query.setParameter("ADDRESS", req.getAddress());
		query.setParameter("City", req.getCity());
		query.setParameter("State", req.getState());
		query.setParameter("Zip", req.getZip());
		query.setParameter("MA_REQ_TYPE","");
		query.setParameter("Sales_REP_EMail","");
		query.setParameter("COMMENTS", req.getDescription());
		query.setParameter("SIGNATURE", "");
		query.setParameter("SIGNATURE_OF", "");

		query.execute();

		return "updated Successfully";
	}

}
