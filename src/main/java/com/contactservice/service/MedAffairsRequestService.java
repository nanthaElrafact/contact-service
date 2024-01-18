package com.contactservice.service;

import com.contactservice.dto.request.MedAffairsReqDto;

public interface MedAffairsRequestService {
	
	public String addMedAffReq(MedAffairsReqDto req);
	public String saveMedAffReq(MedAffairsReqDto req);

}
