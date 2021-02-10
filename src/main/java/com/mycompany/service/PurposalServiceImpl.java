package com.mycompany.service;


import java.util.List;
import java.util.UUID;
import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.domain.Criteria;
import com.mycompany.domain.PurposalDTO;
import com.mycompany.persistence.PurposalDAO;

@Service
public class PurposalServiceImpl implements PurposalService {
	@Autowired 
	public PurposalDAO purDAO;
	
	@Override
	public int purposalCnt() {
		return purDAO.purposalCnt();
	}

	@Override
	public void PurposalInsert(PurposalDTO dto) {
		purDAO.PurposalInsert(dto);
	}
	
	@Override
	public void purposalUpdate(PurposalDTO dto) {
		purDAO.purposalUpdate(dto);
	}

	@Override
	public List<PurposalDTO> purposalList() {
		return purDAO.purposalList();
	}
	@Override
	public List<PurposalDTO> purposalListPaging(Criteria cri) {
		return purDAO.purposalListPaging(cri);
	}
	@Override
	public PurposalDTO purposalRead(PurposalDTO dto) {
		return purDAO.purposalRead(dto);
	}


}
