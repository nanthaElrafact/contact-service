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
		query.registerStoredProcedureParameter("PRODUCT_NAME", Integer.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("MA_REQ_CATG", Integer.class, ParameterMode.IN);

				query.registerStoredProcedureParameter("PROF_ID", Integer.class, ParameterMode.IN);
				//query.registerStoredProcedureParameter("HCP_ID", Integer.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("SIGNATURE_FLAG", Integer.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("SIGNATURE_DATE", Date.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("FIRST_NAME", String.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("MIDDLE_NAME", String.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("LAST_NAME", String.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("NPI", String.class, ParameterMode.IN);
				
				
				
				query.setParameter("USER", req.getUpdatedUser());
				query.setParameter("TRN_FAX_ID", req.getTrnFaxId());
		        query.setParameter("TRN_RX_ID", req.getTrnRxId());

				query.setParameter("PROF_ID", req.getProfId());
				//query.setParameter("HCP_ID", req.getHcpId());
				query.setParameter("SIGNATURE_FLAG", req.getSignature_Flag());
				query.setParameter("SIGNATURE_DATE", req.getSignature_Date());
				query.setParameter("FIRST_NAME", req.getFirstName());
				query.setParameter("MIDDLE_NAME", req.getMiddleName());
				query.setParameter("LAST_NAME", req.getLastName());
				query.setParameter("NPI", req.getNpi());

				
				query.execute();

			return "updated Successfully";
	}

}
