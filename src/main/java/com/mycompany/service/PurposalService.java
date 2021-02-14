package com.mycompany.service;

import java.util.List;
import com.mycompany.domain.Criteria;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.domain.PurposalDTO;

public interface PurposalService {

	int purposalCnt();
	int cocPurposalCnt(String coc_name);
	public void PurposalInsert(PurposalDTO dto);
	void purposalUpdate(PurposalDTO dto);


	List<PurposalDTO> purposalList();
	List<PurposalDTO> purposalListPaging(Criteria cri);
	List<PurposalDTO> purposalListPagingSearch(Criteria cri);

	PurposalDTO purposalRead(PurposalDTO dto);
	int purposalSearchCnt(Criteria cri);
	String purposalWriterCheck(String login);
	List<PurposalDTO> cocPurposalListPaging(Criteria cri);
	int cocPurposalSearchCnt(Criteria cri);
	List<PurposalDTO> cocPurposalListPagingSearch(Criteria cri);
}
