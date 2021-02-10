<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>제조사 정보 수정</title>
<!--부트스트랩 css 추가-->
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="/resources/js/coc.js"></script>

</head>
<body>
	<h1 style="text-align: center">제조사 정보 수정</h1>
	<br>
	<br>

	<div class="container">
		<form action="/coc_update" method="post" id="coc_updateform"
			name="cuf">
			<input type="hidden" name="pwd" id="pwd" value="${coc.pwd}">
			<input type="hidden" name="pageNum" value="${pageNum }">
			<div class="form-group">
				<label>제조사명</label>
				<input type="text" class="form-control" name="coc_name" id="coc_name"
					value="${coc.coc_name}" readonly>
			</div>
			<div class="form-group">
				<label>담당자</label>
				<input type="text" class="form-control" name="coc_emp" id="coc_emp"
					value="${coc.coc_emp }">
			</div>
			<div class="form-group">
				<label>연락처</label>
				<input type="text" class="form-control" name="coc_call" id="coc_call"
					value="${coc.coc_call }">
			</div>
			<div class="form-group">
				<label>이메일</label>
				<input type="text" class="form-control" name="coc_mail" id="coc_mail"
					value="${coc.coc_mail }">
			</div>
			<div class="form-group">
				<label>비밀번호</label>
				<input type="password" class="form-control" name="pwd_check" id="pwd_check">
				<input class="btn btn-primary" type="button" id="pwd_check_btn" value="비밀번호 확인">
			</div>
			<button type="submit" class="btn btn-primary">수정</button>
			<input class="btn btn-danger" type="reset" value="취소">
		</form>
	</div>
	<!-- /container -->

	<!--부트스트랩 js, jquery 추가-->
	<script src="/resources/js/jquery.min.js"></script>
	<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>