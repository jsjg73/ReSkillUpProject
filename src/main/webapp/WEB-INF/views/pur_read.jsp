<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>신제품 기획서 상세조회</title>
   <!--부트스트랩 css 추가-->
   <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
<h1 style="text-align:center">신제품 기획서 상세조회</h1><br><br>

<div class="container">
   <form action="/pur_updateform" method="post">
   <input type="hidden" name="writer" value="${pur.writer}">
      <div class="form-group">
         <label>제품명</label>
         <input type="text" class="form-control" name="pdt_name"
               value="${pur.pdt_name}" readonly>
      </div>
      <div class="form-group">
         <label>등록날짜</label>
         <input type="date" class="form-control" name="reg_date"
         value="<fmt:formatDate type="both" value="${pur.reg_date}" pattern="yyyy-MM-dd" />" readonly>
      </div>
      <div class="form-group">
         <label>주 고객층</label>
	        <c:set var="idx" value="0" />
	      <c:forEach var="i" begin="1" end="4" >
	      	<label>
      			<input type="checkbox" name="target" value="${i}" disabled="disabled"
      				<c:if test="${targets[idx] == i}">
      					<c:set var="idx" value="${idx+1}" />
      					checked="checked"
      				</c:if>
      			> code${i}
	      	</label>
	      </c:forEach>
      </div>
      <div class="form-group">
         <label>유형</label>
         <select class="form-control" name="pdt_type" >
         	<!-- 선택된 유형의 이름을 어떻게 받아서 표시할지 모르겠음 -->
		    <option value="${pur.pdt_type}" selected readonly>type ${pur.pdt_type}</option>
		    
  		 </select>
      </div>
      <div class="form-group">
         <label>비고</label>
         <textarea class="form-control" name="bigo" rows="5" cols="30" readonly>${pur.bigo}</textarea>
      </div>
      <div class="form-group">
         <label>사진</label>
         <!-- 선택된 사진을 어떻게 받아서 표시할지 모르겠음 -->
         <input type="file" class="form-control" name="pic" value="${pur.pic}" accept="image/gif,image/jpeg, image/png" readonly>
      </div>
      <a href="/pur_list/1" class="btn btn-primary">확인</a>
      <button type="submit" class="btn btn-primary">수정페이지로</button>
   </form>
</div> <!-- /container -->

<!--부트스트랩 js, jquery 추가-->
<script src="/resources/js/jquery.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>
