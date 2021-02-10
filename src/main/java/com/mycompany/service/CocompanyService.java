package com.mycompany.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.mycompany.domain.Criteria;
import com.mycompany.domain.CocompanyDTO;

public interface CocompanyService {
	int cocompanyCnt();
	public void cocompanyInsert(CocompanyDTO dto);
	void cocompanyUpdate(CocompanyDTO dto);


	List<CocompanyDTO> cocompanyList();
	List<CocompanyDTO> cocompanyListPaging(Criteria cri);

	List<CocompanyDTO> cocompanyRead(CocompanyDTO dto);

}
