<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>제품 목록 화면</title>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
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
		<c:forEach var="b" items="${list}" varStatus="st">
		<tr>
			<td>${st.index}</td>
			<td><a href="/pur_read/${b.pdt_name}">${b.pdt_name}</a></td>
			<td>${b.writer}</td>
			<td>${b.pdt_type}</td>
			<td><fmt:formatDate value="${b.reg_date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			<td><fmt:formatDate value="${b.upd_date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		</tr>
	</c:forEach>
</tbody>
</table>
<div style="width:660px" align="left">
<c:if test="${page.prev}">
   [ <a href="/pur_list/1">◀◀</a>]
   [ <a href="/pur_list/${page.startPage-1}">◀</a>]
</c:if>
<c:if test="${not page.prev }">
   [ <span style="color:silver">◀</span> ]
   [ <span style="color:silver">◀◀</span> ]
</c:if>

<c:forEach var="i" begin="${page.startPage }" end="${page.endPage }">
   <c:if test="${page.cri.pageNum != i}">
      [<a href="/pur_list/${i }">${i}</a>]
   </c:if>
   <c:if test="${page.cri.pageNum == i}">
      [${i }]
   </c:if>
</c:forEach>
<c:if test="${page.next}">
   [<a href="/pur_list/${page.endPage+1}">▶</a>]
   [<a href="/pur_list/${page.totalPage }">▶▶</a>]
</c:if>
<c:if test="${not page.next}">
   [ <span style="color:silver">▶</span> ]
   [ <span style="color:silver">▶▶</span> ]
</c:if>
</div>
</div>
	
	
</body>
</html>