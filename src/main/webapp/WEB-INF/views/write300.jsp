<%@page import="java.sql.Date"%>
<%@page import="vm.PurposalDTO"%>
<%@page import="vm.PurposalDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int start =353;
	int capa = 100;
	PurposalDAO boardDAO = new PurposalDAO();
	for(int i=start; i<=start+capa; i++) {
		Thread.sleep(200);
		PurposalDTO dto = new PurposalDTO();
		dto.setPdt_name("제품명" + i);
		dto.setWriter("홍길동"+ i);
		dto.setPdt_type(1);
		dto.setTarget(1);
		dto.setReg_date(new java.sql.Date(new java.util.Date().getTime()));
		boardDAO.PurposalInsert(dto);
	}// for
%>
<script>
	alert("10개의 글 저장 완료!");
</script>
