<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>제조사 등록</title>
   <!--부트스트랩 css 추가-->
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
   <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
   <script src="/resources/js/coc.js"></script>
</head>
<body>
<h1 style="text-align:center">제조사 등록</h1><br><br>

<div class="container">
   <form action="coc_write" method="post" id="coc_writeform" name="cwf">
   <input type="hidden" name="writer" value="employee">
      <div class="form-group">
         <label>제조사명</label>
         <input type="text" class="form-control" name="coc_name" id="coc_name"
               placeholder="제조사명을 입력하세요">
         <span id="coc_nametd"></span>
         <button id="coc_duplicate" >중복검사</button>
      </div>
      <div class="form-group">
         <label>유형</label><br>
  		 <c:forEach var="Pdt_type" items="${Pdt_type_list}">
         	<label><input type="checkbox" name="Pdt_type" value="${Pdt_type }" > ${Pdt_type }</label>
		 </c:forEach>
      </div>
      <div class="form-group">
         <label>인증번호</label> <!-- 아무 회사나 등록하지못하고 기획회사 직원이 인증한 회사만 정보등록가능하도록 -->
         <input type="text" class="form-control" name="empno" id="empno" placeholder="숫자만 입력하세요">
      </div>
      <div class="form-group">
         <label>담당자</label> 
         <input type="text" class="form-control" name="coc_emp" id="coc_emp">
      </div>
      <div class="form-group">
         <label>연락처</label> 
         <input type="text" class="form-control" name="coc_call" id="coc_call">
      </div>
      <div class="form-group">
         <label>이메일</label>
         <input type="text" class="form-control" name="coc_mail" id="coc_mail">
      </div>
      <div class="form-group">
         <label>비밀번호</label> <!-- 유효성검사 -->
         <input type="password" class="form-control" name="pwd" id="pwd">
      </div>
      <div class="form-group">
         <label>비밀번호확인</label>
         <input type="password" class="form-control" name="pwd_check" id="pwd_check">
      </div>
      
      <button type="submit" class="btn btn-primary">등록</button>
      <input class="btn btn-danger" type="reset" value="취소">
   </form>
</div> <!-- /container -->

<!--부트스트랩 js, jquery 추가-->
<script src="/resources/js/jquery.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>