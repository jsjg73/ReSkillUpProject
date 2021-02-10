package com.mycompany.persistence;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mycompany.domain.CocompanyDTO;
import com.mycompany.domain.Criteria;

@Repository
public class CocompanyDAOImpl implements CocompanyDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public void cocompanyInsert(CocompanyDTO coc) {
		mybatis.insert("Coc.cocompanyInsert", coc);

	}

	@Override
	public List<CocompanyDTO> cocompanyList() {
		return mybatis.selectList("Coc.cocompanyList");	
	}

	@Override
	public List<CocompanyDTO> cocompanyListPaging(Criteria cri) {
		return mybatis.selectList("Coc.cocompanyListPaging",cri);
	}

	@Override
	public List<CocompanyDTO> cocompanyRead(CocompanyDTO dto) {
		return mybatis.selectList("Coc.cocompanyRead", dto);
	}

	@Override
	public int cocompanyCnt() {
		return mybatis.selectOne("Coc.cocCnt");
	}

	@Override
	public void cocompanyUpdate(CocompanyDTO dto) {
		mybatis.update("Coc.cocompanyUpdate",dto);
	}

}
