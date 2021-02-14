<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>샘플 등록 화면_1</title>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
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
	<form action="/samp/writeform_step1/search" method="post">
		
		<table>
			<thead></thead>
			<tbody>
				<tr >
					<td align="right">
						<select name="condi">
						<c:forEach var="i" items="${pursearch }">
							<option <c:if test="${page.cri.condi==i.condi }">selected</c:if> value='${i.condi}'>${i.key}</option>
						</c:forEach>
						</select> 
						<input type="text" name="keyword" value=""> 
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
			<td><a href="/samp/writeform/${b.pdt_name}">${b.pdt_name}</a></td>
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
   [ <a href="/samp/writeform_step1/1/${page.cri.condi}/${page.cri.keyword}">◀◀</a>]
   [ <a href="/samp/writeform_step1/${page.startPage-1}">◀</a>]
</c:if>
<c:if test="${not page.prev }">
   [ <span style="color:silver">◀</span> ]
   [ <span style="color:silver">◀◀</span> ]
</c:if>

<c:forEach var="i" begin="${page.startPage }" end="${page.endPage }">
   <c:if test="${page.cri.pageNum != i}">
      [<a href="/samp/writeform_step1/${i }/${page.cri.condi}/${page.cri.keyword}">${i}</a>]
   </c:if>
   <c:if test="${page.cri.pageNum == i}">
      [${i }]
   </c:if>
</c:forEach>
<c:if test="${page.next}">
   [<a href="/samp/writeform_step1/${page.endPage+1}/${page.cri.condi}/${page.cri.keyword}">▶</a>]
   [<a href="/samp/writeform_step1/${page.totalPage }/${page.cri.condi}/${page.cri.keyword}">▶▶</a>]
</c:if>
<c:if test="${not page.next}">
   [ <span style="color:silver">▶</span> ]
   [ <span style="color:silver">▶▶</span> ]
</c:if>
</div>
</div>

</body>
</html>