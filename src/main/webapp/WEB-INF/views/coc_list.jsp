<%@page import="com.mycompany.myapp.dto.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mycompany.myapp.dao.*" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>제조사 목록 화면</title>
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
	<h2>제조사 목록</h2>
	<form action="search_coc_list" method="post">
		
		<table>
			<thead></thead>
			<tbody>
				<tr>
					<td align="right">
						<select name="searchCondition">
							<option value=''>-- 선택 --</option>
							<option value='제조사명' selected>제조사명</option>
							<option value='유형'>제품유형</option>
							<option value='담당자'>담당자</option>
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
				<th scope="col">제조사명</th>
				<th scope="col">유형</th>
				<th scope="col">담당자</th>
				
			</tr>
		</thead>
		<tbody>
<tr>
				<td>1</td>
				<td><a href='coc_read.jsp'>company1</a></td>
				<td>더미 가구</td>
				<td>더미 홍길동</td>
			</tr>
			<tr>
				<td>2</td>
				<td><a href='coc_read.jsp'>company1</a></td>
				<td>더미 가구</td>
				<td>더미 홍길동</td>
			</tr>
			<tr>
				<td>3</td>
				<td><a href='coc_read.jsp'>company1</a></td>
				<td>더미 미용</td>
				<td>더미 홍길동</td>
			</tr>
			<tr>
				<td>4</td>
				<td><a href='coc_read.jsp'>company1</a></td>
				<td>더미 가전</td>
				<td>더미 장길산</td>
			</tr>
		</tbody>
	</table>
	<div class="w3-center w3-padding-32">
    <div class="w3-bar">
      <a href="getProductList.do?pageIndex=${paging.startPage-1}&searchCondition=${product.searchCondition}&searchKeyword=${product.searchKeyword}" class="w3-bar-item w3-button w3-hover-theme">&laquo;</a>
      <c:forEach var="i" begin="${paging.startPage}" end="${paging.endPage}">
			<c:choose>
				<c:when test="${i eq paging.pageIndex}" ><a class="w3-bar-item w3-button w3-theme w3-hover-theme" href="#">${i}</a></c:when>
				<c:otherwise>
					<a href="getProductList.do?pageIndex=${i}&searchCondition=${product.searchCondition}&searchKeyword=${product.searchKeyword}"
						class="w3-bar-item w3-button w3-hover-theme">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
      <a href="getProductList.do?pageIndex=${paging.endPage+1}&searchCondition=${product.searchCondition}&searchKeyword=${product.searchKeyword}" class="w3-bar-item w3-button w3-hover-theme">&raquo;</a>
    </div>
  </div>
	</div>
</body>

</html>