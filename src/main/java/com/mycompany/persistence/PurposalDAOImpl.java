package com.mycompany.persistence;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.domain.Criteria;
import com.mycompany.domain.PageDTO;
import com.mycompany.domain.PurposalDTO;

@Repository
public class PurposalDAOImpl implements PurposalDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public void PurposalInsert(PurposalDTO pur){
		mybatis.insert("Pur.PurposalInsert", pur);
	}
	@Override
	public List<PurposalDTO> purposalList(){
		return mybatis.selectList("Pur.purposalList");	
	}
	@Override
	public PurposalDTO purposalRead(PurposalDTO dto) {
		return mybatis.selectOne("Pur.purposalRead", dto);
	}
	@Override
	public int purposalCnt() {
		return mybatis.selectOne("Pur.purCnt");
	}
	
	@Override
	public List<PurposalDTO> purposalListPaging(Criteria cri) {
		return mybatis.selectList("Pur.purposalListPaging",cri);
	}
	@Override
	public void purposalUpdate(PurposalDTO dto) {
		mybatis.update("Pur.purposalUpdate",dto);
	}
	@Override
	public int purposalSearchCnt(Criteria cri) {
		return mybatis.selectOne("Pur.purposalSearchCnt",cri);
	}
	@Override
	public List<PurposalDTO> purposalListPagingSearch(Criteria cri) {
		return mybatis.selectList("Pur.purposalListPagingSearch", cri);
	}
}
