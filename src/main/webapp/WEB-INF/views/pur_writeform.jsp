<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>신제품 기획서 등록</title>
   <!--부트스트랩 css 추가-->
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
   <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
   <script src="/resources/js/pur.js"></script>
   
</head>
<body>
<h1 style="text-align:center">신제품 기획서 등록</h1><br><br>

<div class="container">
   <form action="pur_write" method="post" id="pur_writeform" name="pwf" enctype="multipart/form-data">
   <input type="hidden" name="writer" value="employee">
   <input type="hidden" name="pic" value=""><!-- 첨부파일 없을때 -->
   <input type="hidden" name="orgpic" value=""><!-- 첨부파일 없을때 -->
      <div class="form-group">
         <label>제품명(중복 조회 처리해야함)</label>
         <input type="text" class="form-control" name="pdt_name" id="pdt_name"
               placeholder="제품명을 입력하세요">
      </div>
      <div class="form-group">
         <label>기획날짜</label>
         <input type="date" class="form-control" name="reg_date" id="reg_date">
      </div>
      <div class="form-group">
         <label>유형</label>
         <select class="form-control" name="pdt_type" >
         	<option value="none">=== 선택 ===</option>
         	<c:forEach var="Pdt_type" items="${Pdt_type_list}">		    
			    <option value="${Pdt_type }" >${Pdt_type }</option>
		    </c:forEach>
  		 </select>
      </div>
      <div class="form-group">
         <label>주 고객층</label><br>
         <c:forEach var="TargetDTO" items="${TargetDTO_list}">
         	<label><input type="checkbox" name="target" value="${TargetDTO }" > ${TargetDTO }</label>
		 </c:forEach>
      </div>
      <div class="form-group">
         <label>비고</label>
         <textarea class="form-control" name="bigo" rows="5" cols="30"></textarea>
      </div>
      <div class="form-group">
         <label>사진</label>
         <input type="file" class="form-control" name="file" accept="image/gif,image/jpeg, image/png">
      </div>
      <button type="submit" class="btn btn-primary">등록</button>
      <input class="btn btn-danger" type="reset" value="취소">
   </form>
</div> <!-- /container -->
<!--부트스트랩 js, jquery 추가-->
<%-- <script src="<%=request.getContextPath() %>/resources/js/jquery.min.js"></script> --%>
<script src="/resources/js/jquery.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>