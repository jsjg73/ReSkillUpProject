package com.mycompany.service;

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
		return purDAO.purCnt();
	}
	@Override
	public void purposalUpdate(PurposalDTO dto) {
		purDAO.purposalUpdate(dto);
	}
}
