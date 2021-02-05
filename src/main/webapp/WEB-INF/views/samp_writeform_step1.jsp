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
<title>샘플 등록 화면_1</title>
<link rel="stylesheet" href="./css/bootstrap.min.css">
</head>
<body>
<br>
<br>
<br>
<br>
	<h2 style="text-align:center">신제품 기획문서 목록</h2>
	<br>
	<br>
	<br>
<div class="container">
	<h3 style="text-align:center">샘플 등록을 위해 기획서를 선택하세요</h3>
	<form action="search_pur_list" method="post">
		
		<table>
			<thead></thead>
			<tbody>
				<tr>
					<td align="right">
						<select name="searchCondition">
							<option value=''>-- 선택 --</option>
							<option value='제품명' selected>제품명</option>
							<option value='제조사명'>제조사</option>
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
		<tr>
		<th scoop=row>0</th>
		<td><a href='samp_writeform_step2.jsp'>더미 제품명(클릭시 샘플등록 step2로 이동)</a></td><!-- fromDBMS -->
		<td>더미 작성자</td>	<!-- fromDBMS -->
		<td>더미 유형</td>		<!-- fromDBMS -->
		<td>더미 기획일</td>	<!-- fromDBMS -->
		<td>더미 수정일</td>	<!-- fromDBMS -->
		</tr>
		<th scoop=row>1</th>
		<td><a href='samp_writeform_step2.jsp'>더미 제품명(클릭시 샘플등록 step2로 이동)</a></td><!-- fromDBMS -->
		<td>더미 작성자</td>	<!-- fromDBMS -->
		<td>더미 유형</td>		<!-- fromDBMS -->
		<td>더미 기획일</td>	<!-- fromDBMS -->
		<td>더미 수정일</td>	<!-- fromDBMS -->
		</tr>

		</tbody>
	</table>
	</div>
</body>
</html>