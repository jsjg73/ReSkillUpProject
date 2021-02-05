<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.mycompany.myapp.dto.*"%>
<%@ page import="java.util.*" %>
<%
	int pg = 1; // list.jsp 가 바로 호출되면 기본값인 1페이지로 셋팅!
	// list.jsp?pg=3
	String strPg = request.getParameter("pg"); // "3"
	if(strPg != null) {
		pg = Integer.parseInt(strPg); // 3
	}
	int size = 10; // 한 페이지에 보여줄 글의 수
	int begin = (pg-1) * size + 1; // 시작_글번호
	int end = begin + (size-1); // 끝_글번호
	PurposalDAO purDAO = new PurposalDAO();
	ArrayList<PurposalDTO> list = purDAO.purposalList(begin, end);
	int cnt = purDAO.purCount(); // 전체 글의 수
	int totalPage = (cnt/size) + (cnt % size == 0 ? 0 : 1); // 전체 페이지
	int pageSize = 10; // 링크를 10개 : [11] [12] [13] [14] [15] [16] [17] [18] [19] [20]
	int currentBlock = (pg/pageSize) + (pg % pageSize == 0 ? 0 : 1); // 블럭
	int startPage = (currentBlock-1) * pageSize + 1; // 시작_페이지, 11
	int endPage = startPage + (pageSize-1); // 끝_페이지, 20
	if(endPage > totalPage) { // 20 > 15
		endPage = totalPage; // 15
	}
	int max = cnt - ((pg-1) * size);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>제품 목록 화면</title>
<link rel="stylesheet" href="./css/bootstrap.min.css">
</head>
<body>
<br>
<br>
<br>
<br>
<br>
<div class="container">
	<h2 style="text-align:center" >제품 목록</h2>
	<br>
	<form action="search_pur_list" method="post">
		<table>
			<thead></thead>
			<tbody>
				<tr >
					<td align="right">
						<select name="searchCondition">
							<option value=''>-- 선택 --</option>
							<option value='제품명' selected>제품명</option>
							<option value='작성자'>작성자</option>
							<option value='내용'>내용</option>
							<option value='유형'>유형</option>
						</select> 
						<input type="text" name="searchKeyword"> 
						<input type="submit" value="검색">
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	
	<table class="table">
		<thead>
			<tr>
				<th scope="col">번호</th>
				<th scope="col">제품명</th>
				<th scope="col">작성자</th>
				<th scope="col">유형</th>
				<th scope="col">기획일</th>
				<th scope="col">수정일</th>
				
			</tr>
		</thead>
		<tbody>
		<!-- <tr>
		<th scoop=row>0</th>
		<td><a href="pur_read.jsp?pur_id=">더미 제품명</a></td>fromDBMS
		<td>더미 작성자</td>	fromDBMS
		<td>더미 유형</td>		fromDBMS
		<td>더미 기획일</td>	fromDBMS
		<td>더미 수정일</td>	fromDBMS
		</tr>
		<th scoop=row>1</th>
		<td><a href="pur_read.jsp?pur_id=">더미 제품명</a></td>fromDBMS
		<td>더미 작성자</td>	fromDBMS
		<td>더미 유형</td>		fromDBMS
		<td>더미 기획일</td>	fromDBMS
		<td>더미 수정일</td>	fromDBMS
		</tr> -->
<%
	for(int i=0; i < list.size(); i++) {
		PurposalDTO dto = list.get(i);
%>
<tr>
	<td><%=begin+i%></td>
	<td><a href="pur_read.jsp?pdt_name=<%=dto.getPdt_name()%>&pg=<%=pg%>"><%=dto.getPdt_name()%></a></td>
	<td><%=dto.getWriter()%></td>
	<td><%=dto.getPdt_type()%></td>
	<td><%=dto.getReg_date()%></td>
	<td><%=dto.getUpd_date()%></td>
</tr>
<%
	}// for
%>
		</tbody>
	</table>
	<div style="width:660px" align="left">
<% if(pg <= pageSize) { %>
	[ <span style="color:silver">◀◀</span> ]
	[ <span style="color:silver">◀</span> ]
<% } else { %>
	[ <a href="pur_list.jsp?pg=1">◀◀</a> ]
	[ <a href="pur_list.jsp?pg=<%=startPage-1%>">◀</a> ]
<% } %>
<% for(int i=startPage; i<=endPage; i++) { %>
	<% if(pg != i) { %>
		[ <a href="pur_list.jsp?pg=<%=i%>"><%=i%></a> ]
	<% } else { %>
		[ <%=i%> ]
	<% } %>
<% } %>
<% if(endPage < totalPage) { %>
	[ <a href="pur_list.jsp?pg=<%=endPage+1%>">▶</a> ]
	[ <a href="pur_list.jsp?pg=<%=totalPage%>">▶▶</a> ]
<% } else { %>
	[ <span style="color:silver">▶</span> ]
	[ <span style="color:silver">▶▶</span> ]
<% } %>
</div>
	</div>
</body>
</html>