package com.mycompany.persistence;

import java.util.List;

import com.mycompany.domain.Criteria;
import com.mycompany.domain.PageDTO;
import com.mycompany.domain.PurposalDTO;

public interface PurposalDAO {

	void PurposalInsert(PurposalDTO pur);

	List<PurposalDTO> purposalList();
	List<PurposalDTO> purposalListPaging(Criteria cri);

	PurposalDTO purposalRead(PurposalDTO dto);
	
	int purposalCnt();

	void purposalUpdate(PurposalDTO dto);
	int purposalSearchCnt(Criteria cri);

	List<PurposalDTO> purposalListPagingSearch(Criteria cri);
}