<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제조사 상세조회</title>
<!--부트스트랩 css 추가-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
	<br>
	<br>
	<div class="container">
		<h1 style="text-align: center">제조사 상세조회</h1>
		<br> <br>
		<form action="/coc_updateform" method="post">
			<input type="hidden" name="pwd" value="${coc.pwd}">
			<input type="hidden" name="pageNum" value="${pageNum}">
			<div class="form-group">
				<label>제조사명</label>
				<input type="text" class="form-control" name="coc_name"
					value="${coc.coc_name}" readonly>
			</div>
			<div class="form-group">
				<label>유형</label><br>
				<c:forEach var="dto" items="${list}">
					<label><input type="checkbox" name="Pdt_type"
							value="${dto.pdt_type }" disabled="disabled" checked="checked" >
						${dto.pdt_type }</label>
				</c:forEach>
			</div>
			<div class="form-group">
				<label>담당자</label>
				<input type="text" class="form-control" name="coc_emp"
					value="${coc.coc_emp }" readonly>
			</div>
			<div class="form-group">
				<label>연락처</label>
				<input type="text" class="form-control" name="coc_call"
					value="${coc.coc_call }" readonly>
			</div>
			<div class="form-group">
				<label>이메일</label>
				<input type="text" class="form-control" name="coc_mail"
					value="${coc.coc_mail }" readonly>
			</div>
			<a href="/coc_list/${pageNum}" class="btn btn-primary">확인</a>
			<button type="submit" class="btn btn-primary">수정페이지로</button>
		</form>
	</div>
</body>
</html>