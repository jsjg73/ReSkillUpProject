<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="vm.*" %>
<%@ page import="java.util.*" %>
<% 
	PurposalDAO purDAO = new PurposalDAO();
	ArrayList<PurposalDTO> list = purDAO.purposalList();
	//System.out.println(list.size());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/bootstrap.min.css">

</head>
<body>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<div class="container">
	<h2>샘플 목록</h2>
	<form action="search_samp_list" method="post">
		
		<table>
			<thead></thead>
			<tbody>
				<tr>
					<td align="right">
						<select name="searchCondition">
							<option value=''>-- 선택 --</option>
							<option value='제품명' selected>제품명</option>
							<option value='제조사명'>제조사명</option>
							<option value='등록날짜'>등록날짜</option>
							<option value='작성자명'>작성자명</option>
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
				<th>샘플ID</th>
				<th>제품명</th>
				<th>제조사</th>
				<th>유형</th>
				<th>단가</th>
				<th>도착날짜</th>
			</tr>
		</thead>
		<tbody>
<tr>
				<th scope="row">1</th>
				<td><a href='samp_read.jsp'>더미 샘플ID</a></td>
				<td>더미 제품명</td>
				<td>더미 제조사</td>
				<td>더미 유형</td>
				<td>더미 단가</td>
				<td>더미 도착날짜</td>
			</tr>
			<tr>
				<th scope="row">2</th>
				<td><a href='samp_read.jsp'>더미 샘플ID</a></td>
				<td>더미 제품명</td>
				<td>더미 제조사</td>
				<td>더미 유형</td>
				<td>더미 단가</td>
				<td>더미 도착날짜</td>
			</tr>
			<tr>
				<th scope="row">3</th>
				<td><a href='samp_read.jsp'>더미 샘플ID</a></td>
				<td>더미 제품명</td>
				<td>더미 제조사</td>
				<td>더미 유형</td>
				<td>더미 단가</td>
				<td>더미 도착날짜</td>
			</tr>
		</tbody>
	</table>
	</div>
</body>

</html>