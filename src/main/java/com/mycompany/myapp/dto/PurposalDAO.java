package com.mycompany.myapp.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PurposalDAO {
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
	
	public int PurposalInsert(PurposalDTO pur){
		int affected =0;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn =getConn();
			String sql = "INSERT INTO PURPOSAL"
					+"(pdt_name,reg_date,writer,pdt_type,bigo,target,pic)"
					+ "VALUES (?,?,?,?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, pur.getPdt_name());
			stmt.setDate(2, pur.getReg_date());
			stmt.setString(3, pur.getWriter());
			stmt.setInt(4, pur.getPdt_type());
			stmt.setString(5, pur.getBigo());
			stmt.setInt(6, pur.getTarget());
			stmt.setString(7, pur.getPic());
			
			affected = stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("insert exception occurred!!");
			e.printStackTrace();
		}finally{
			close(conn,stmt);
		}
		return affected;
	}
	public ArrayList<PurposalDTO> purposalList(){
		ArrayList<PurposalDTO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * "
				+ " FROM PURPOSAL "
				+ " ORDER BY reg_date DESC";
		try{
			conn=getConn();
			stmt=conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			//pur_id,ins_date,upd_date,reg_date,writer,pdt_name,pdt_type,bigo,target,pic
			while(rs.next()){
				PurposalDTO pur = new PurposalDTO();
				pur.setIns_date(rs.getDate("ins_date"));
				pur.setUpd_date(rs.getDate("upd_date"));
				pur.setWriter(rs.getString("writer"));
				pur.setBigo(rs.getString("bigo"));
				pur.setPdt_name(rs.getString("pdt_name"));
				pur.setPdt_type(rs.getInt("pdt_type"));
				pur.setPic(rs.getString("pic"));
				pur.setReg_date(rs.getDate("reg_date"));
				pur.setTarget(rs.getInt("target"));
				list.add(pur);
				//pur_id,ins_date,upd_date,reg_date,
				//writer,pdt_name,pdt_type,
				//bigo,target,pic
			}
		}catch(Exception e){
			System.out.println("list exception occurred");
			e.printStackTrace();
		}finally{
			close(conn,stmt,rs);
		}
		return list;
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
	
	
	public PurposalDTO purposalRead(String pdt_name) {
		PurposalDTO pur = new PurposalDTO();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM PURPOSAL WHERE pdt_name=?";
		try {
			conn=getConn();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,pdt_name);
			rs = stmt.executeQuery();
			if(rs.next()) {
				pur.setPdt_name(rs.getString("pdt_name"));
				pur.setIns_date(rs.getDate("ins_date"));
				pur.setUpd_date(rs.getDate("upd_date"));
				pur.setWriter(rs.getString("writer"));
				pur.setBigo(rs.getString("bigo"));
				pur.setPdt_type(rs.getInt("pdt_type"));
				pur.setPic(rs.getString("pic"));
				pur.setReg_date(rs.getDate("reg_date"));
				pur.setTarget(rs.getInt("target"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,stmt,rs);
		}
		
		return pur;
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
