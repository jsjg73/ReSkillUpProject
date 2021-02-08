package com.mycompany.service;

import com.mycompany.domain.PurposalDTO;

public interface PurposalService {
	int purposalCnt();
	void purposalUpdate(PurposalDTO dto);
}
