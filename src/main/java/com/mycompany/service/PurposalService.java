package com.mycompany.service;

import java.util.List;

import com.mycompany.domain.Criteria;
import com.mycompany.domain.PurposalDTO;

public interface PurposalService {

	int purposalCnt();
	void purposalUpdate(PurposalDTO dto);
	void PurposalInsert(PurposalDTO pur);

	List<PurposalDTO> purposalList();
	List<PurposalDTO> purposalListPaging(Criteria cri);

	PurposalDTO purposalRead(PurposalDTO dto);
}
