package com.mycompany.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.mycompany.domain.SampleDTO;

public class SampleDAOImpl implements SampleDAO {
	private String ns = "Samp";	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public SampleDTO sampleRead(String samp_id) {
		return mybatis.selectOne(ns+".sampleRead", samp_id);
	}
	
}
