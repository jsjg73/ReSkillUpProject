package com.mycompany.service;

import com.mycompany.domain.PurposalDTO;

public interface PurposalService {

	int purposalCnt();
	public void PurposalInsert(PurposalDTO dto);
	void purposalUpdate(PurposalDTO dto);
	
}
