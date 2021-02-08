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
import org.springframework.stereotype.Service;

import com.mycompany.domain.Criteria;
import com.mycompany.domain.PageDTO;
import com.mycompany.domain.PurposalDTO;
@Service
public class PurposalDAOImpl implements PurposalDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
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
	public int purCnt() {
		return mybatis.selectOne("Pur.purCnt");
	}
	
	@Override
	public List<PurposalDTO> purposalListPaging(Criteria cri) {
		return mybatis.selectList("Pur.purposalListPaging",cri);
	}
	
	public ArrayList<PurposalDTO> purposalList(int begin, int end) {
		ArrayList<PurposalDTO> list = new ArrayList<PurposalDTO>();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql =
			"SELECT * " +
			"FROM (SELECT rownum as rn, A.* " +
			"      FROM (SELECT * FROM purposal ORDER BY ins_date DESC) A " +
			"      WHERE rownum <= ?) " +
			"WHERE rn >= ?";
		try {
			conn = getConn();
			st = conn.prepareStatement(sql);
			st.setInt(1, end);
			st.setInt(2, begin);
			rs = st.executeQuery();
			while(rs.next()) {
				PurposalDTO pur = new PurposalDTO();
				pur.setPdt_name(rs.getString("pdt_name"));
				pur.setIns_date(rs.getDate("ins_date"));
				pur.setUpd_date(rs.getDate("upd_date"));
				pur.setWriter(rs.getString("writer"));
				pur.setBigo(rs.getString("bigo"));
				pur.setPdt_type(rs.getInt("pdt_type"));
				pur.setPic(rs.getString("pic"));
				pur.setReg_date(rs.getDate("reg_date"));
				pur.setTarget(rs.getInt("target"));
				list.add(pur);
			}// while
		} catch(Exception e) {
			System.out.println("boardList 예외 발생!!!");
			e.printStackTrace();
		} finally {
			close(conn,st,rs);
		}
		return list;
	}
	
	public int purCount() {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "SELECT count(*) cnt FROM purposal";
		try {
			conn = getConn();
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt("cnt");
			}
		} catch(Exception e) {
			System.out.println("purCount 예외 발생!!!");
			e.printStackTrace();
		} finally {
			close(conn,st,rs);
		}
		return cnt;
	}
	
	
	
	
	private void close(Connection conn){
		try {
			if(conn !=null)
				conn.close();
		} catch (Exception e) {
			System.out.println("connection close error");
			e.printStackTrace();	
		}
	}
	private void close(Connection conn, PreparedStatement stmt){
		try {
			if(stmt != null){
				stmt.close();
			}
		} catch (SQLException e) {
			System.out.println("preparedstatment close error");
			e.printStackTrace();
		}
		close(conn);
	}
	private void close(Connection conn, PreparedStatement stmt,ResultSet rs){
		try {
			if(rs != null){
				rs.close();
			}
		} catch (SQLException e) {
			System.out.println("resultset close error");
			e.printStackTrace();
		}
		close(conn,stmt);
	}
}
