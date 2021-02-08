<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>신제품 기획서 수정</title>
   <!--부트스트랩 css 추가-->
   <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
<h1 style="text-align:center">신제품 기획서 수정</h1><br><br>

<div class="container">
   <form action="/pur_update" method="post">
   <input type="hidden" name="writer" value="${dto.writer}">
      <div class="form-group">
         <label>제품명</label>
         <input type="text" class="form-control" name="pdt_name"
               value="${dto.pdt_name}" readonly="readonly">
      </div>
      <div class="form-group">
         <label>등록날짜</label>
         <input type="date" class="form-control" name="reg_date"
         value="<fmt:formatDate type="both" value="${dto.reg_date}" pattern="yyyy-MM-dd"/>" readonly>
      </div>
      <div class="form-group">
         <label>주 고객층</label>
         <!-- 선택된 고객층을 어떻게 체크를 해놓을지 모르겠음 -->
         <label><input type="checkbox" name="target" value="1" checked="checked"> code1</label>
		 <label><input type="checkbox" name="target" value="2" checked="checked"> code2</label>
      </div>
      <div class="form-group">
         <label>유형</label>
         <input class="form-control" name="pdt_type" value="type${dto.pdt_type}" readonly="readonly" >
      </div>
      <div class="form-group">
         <label>비고</label>
         <textarea class="form-control" name="bigo" rows="5" cols="30" >${dto.bigo}</textarea>
      </div>
      <div class="form-group">
         <label>사진</label>
         <input type="file" class="form-control" name="pic" accept="image/gif,image/jpeg, image/png">
      </div>
      <button type="submit" class="btn btn-primary">수정</button>
      <input class="btn btn-danger" type="reset" value="취소">
   </form>
</div> <!-- /container -->

<!--부트스트랩 js, jquery 추가-->
<script src="/resources/js/jquery.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>