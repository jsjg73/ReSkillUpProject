package com.mycompany.myapp.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SampleDAO {
	private static final String URL ="jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USER ="scott";
	private static final String PASSWORD ="tiger";
	private static final String DRIVER_NAME =
			"oracle.jdbc.driver.OracleDriver";
	private Connection getConn(){
		Connection conn = null;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (Exception e) {
		}
		return conn;
	}
	
	public SampleDTO sampleRead(int samp_id) {
		SampleDTO samp = new SampleDTO();
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM samp WHERE samp_id=?";
		try {
			conn=getConn();
			st = conn.prepareStatement(sql);
			st.setInt(1, samp_id);
			rs = st.executeQuery();
			if(rs.next()) {
				samp.setSamp_id(rs.getString("samp_id"));
				samp.setArriv_date(rs.getDate("arriv_date"));
				samp.setWriter(rs.getString("writer"));
				samp.setPrice(rs.getInt("price"));
				samp.setCoc_name(rs.getString("coc_name"));
				samp.setBigo(rs.getString("bigo"));
				samp.setPdt_name(rs.getString("pdt_name"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs,st,conn);
		}
		
		return samp;
	}
	
	private void close(Connection conn, PreparedStatement st) {
		if(st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void close(ResultSet rs, PreparedStatement st,
			Connection conn) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		close(conn, st);
	}
}
