package com.mycompany.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.domain.Criteria;
import com.mycompany.domain.SampleDTO;

@Repository
public class SampleDAOImpl implements SampleDAO {
	private String ns = "Samp";	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public SampleDTO sampleRead(String samp_id) {
		return mybatis.selectOne(ns+".sampleRead", samp_id);
	}

	@Override
	public int sampleCnt() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void sampleInsert(SampleDTO dto) {
		mybatis.insert(ns+".sampleInsert", dto);
	}

	@Override
	public void sampleUpdate(SampleDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SampleDTO> sampleList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SampleDTO> sampleListPaging(Criteria cri) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
