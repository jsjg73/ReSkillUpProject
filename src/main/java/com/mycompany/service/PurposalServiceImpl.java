package com.mycompany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public void purposalUpdate(PurposalDTO dto) {
		purDAO.purposalUpdate(dto);
	}
	@Override
	public void PurposalInsert(PurposalDTO pur) {
		purDAO.PurposalInsert(pur);
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
