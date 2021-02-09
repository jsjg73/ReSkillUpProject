package com.mycompany.persistence;

import java.util.List;

import com.mycompany.domain.CocompanyDTO;
import com.mycompany.domain.Criteria;

public interface CocompanyDAO {
	void cocompanyInsert(CocompanyDTO pur);

	List<CocompanyDTO> cocompanyList();
	List<CocompanyDTO> cocompanyListPaging(Criteria cri);

	CocompanyDTO cocompanyRead(CocompanyDTO dto);
	
	int cocompanyCnt();

	void cocompanyUpdate(CocompanyDTO dto);
}
