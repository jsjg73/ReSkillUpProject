package com.mycompany.persistence;

import java.util.List;

import com.mycompany.domain.CocompanyDTO;
import com.mycompany.domain.Criteria;

public interface CocompanyDAO {
	void cocompanyInsert(CocompanyDTO pur);

	List<CocompanyDTO> cocompanyList();
	List<CocompanyDTO> cocompanyListPaging(Criteria cri);

	List<CocompanyDTO> cocompanyRead(String coc_name);
	List<String> cocompanyReadByPdt_type(String pdt_type);
	
	int cocompanyCnt();

	void cocompanyUpdate(CocompanyDTO dto);
}
