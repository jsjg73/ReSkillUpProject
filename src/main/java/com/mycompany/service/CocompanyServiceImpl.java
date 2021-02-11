package com.mycompany.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.domain.CocompanyDTO;
import com.mycompany.domain.Criteria;
import com.mycompany.persistence.CocompanyDAO;

@Service
public class CocompanyServiceImpl implements CocompanyService {
	@Autowired 
	public CocompanyDAO cocDAO;
	
	@Override
	public int cocompanyCnt() {
		return cocDAO.cocompanyCnt();
	}

	@Override
	public void cocompanyInsert(CocompanyDTO dto) {
		cocDAO.cocompanyInsert(dto);
	}

	@Override
	public void cocompanyUpdate(CocompanyDTO dto) {
		cocDAO.cocompanyUpdate(dto);
	}

	@Override
	public List<CocompanyDTO> cocompanyList() {		
		return cocDAO.cocompanyList();
	}

	@Override
	public List<CocompanyDTO> cocompanyListPaging(Criteria cri) {
		return cocDAO.cocompanyListPaging(cri);
	}

	@Override
	public List<CocompanyDTO> cocompanyRead(CocompanyDTO dto) {
		return cocDAO.cocompanyRead(dto);
	}

	@Override
	public List<String> cocompanyReadByPdt_type(String pdt_type) {
		return cocDAO.cocompanyReadByPdt_type(pdt_type);
	}

}
