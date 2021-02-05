<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.mycompany.myapp.dto.*"%><%
	request.setCharacterEncoding("utf-8");
%>
<%
String writer = request.getParameter("writer");
String pdt_name = request.getParameter("pdt_name");
String target = request.getParameter("target");
String pdt_type = request.getParameter("pdt_type");
String bigo = request.getParameter("bigo");
String pic = request.getParameter("pic");

PurposalDTO dto = new PurposalDTO();
dto.setWriter(writer);
dto.setPdt_name(pdt_name);
dto.setBigo(bigo);
dto.setPic(pic);
dto.setTarget(Integer.parseInt(target));
dto.setPdt_type(Integer.parseInt(pdt_type));

PurposalDAO dao = new PurposalDAO();
dao.PurposalInsert(dto);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>