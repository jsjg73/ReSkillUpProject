<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>제조사 목록 화면</title>
	<!--부트스트랩 css 추가-->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<link rel="stylesheet" href="/resources/css/bootstrap.min.css">

</head>
<body>
	<br>
	<br>
	<br>
	<div class="container">
		<h2 style="text-align:center">제조사 목록</h2>
		<br><br><br>
		<form action="search_coc_list" method="post">

			<table>
				<thead></thead>
				<tbody>
					<tr>
						<td align="right"><select name="searchCondition">
								<option value=''>-- 선택 --</option>
								<option value='제조사명' selected>제조사명</option>
								<option value='유형'>제품유형</option>
								<option value='담당자'>담당자</option>
						</select> <input type="text" name="searchKeyword"> <input
							type="submit" value="검색"></td>
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
				<c:forEach var="b" items="${list}" varStatus="st">
					<tr>
						<td>${st.index}</td>
						<td><a href="/coc_read/${b.coc_name}/${page.cri.pageNum}">${b.coc_name}</a></td>
						<td>${b.pdt_type}</td>
						<td>${b.coc_emp}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
<div style="width:660px" align="left">
<c:if test="${page.prev}">
   [ <a href="/coc_list/1">◀◀</a>]
   [ <a href="/coc_list/${page.startPage-1}">◀</a>]
</c:if>
<c:if test="${not page.prev }">
   [ <span style="color:silver">◀</span> ]
   [ <span style="color:silver">◀◀</span> ]
</c:if>

<c:forEach var="i" begin="${page.startPage }" end="${page.endPage }">
   <c:if test="${page.cri.pageNum != i}">
      [<a href="/coc_list/${i }">${i}</a>]
   </c:if>
   <c:if test="${page.cri.pageNum == i}">
      [${i }]
   </c:if>
</c:forEach>
<c:if test="${page.next}">
   [<a href="/coc_list/${page.endPage+1}">▶</a>]
   [<a href="/coc_list/${page.totalPage }">▶▶</a>]
</c:if>
<c:if test="${not page.next}">
   [ <span style="color:silver">▶</span> ]
   [ <span style="color:silver">▶▶</span> ]
</c:if>
</div>
</div>

<script src="/resources/js/jquery.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>