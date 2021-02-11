<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>신제품 기획서 수정</title>
   <!--부트스트랩 css 추가-->
   <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
   <script src="/resources/js/pur.js"></script>
   
   
</head>
<body>
<h1 style="text-align:center">신제품 기획서 수정</h1><br><br>

<div class="container">
   <form action="/pur_update" method="post" id="pur_updateform" name="puf" enctype="multipart/form-data" >
   <input type="hidden" name="writer" value="${editor}">
   <input type="hidden" name="orgpic" value="${dto.orgpic }">
   <input type="hidden" name="pic" value="${dto.pic }">
   <input type="hidden" name="ins_date" value="${dto.ins_date}">
   <input type="hidden" name="pageNum" value="${pageNum }">
      <div class="form-group">
         <label>제품명</label>
         <input type="text" class="form-control" name="pdt_name"
               value="${dto.pdt_name}" readonly="readonly">
      </div>
      <div class="form-group">
         <label>등록날짜</label>
         <input type="date" class="form-control" name="reg_date"
         value="<fmt:formatDate type="both" value="${dto.reg_date}" pattern="yyyy-MM-dd"/>">
      </div>
      
      <div class="form-group">
         <label>주 고객층</label><br>
         <c:set var="idx" value="0" />		<!-- check할 targets배열의 인덱스  -->
         <c:forEach var="TargetDTO" items="${TargetDTO_list}">
         	<label>
         		<input type="checkbox" name="target" value="${TargetDTO }" 
         		<c:if test="${targets[idx] == TargetDTO}">
      				checked="checked"						<!-- check 활성화 -->
      				<c:set var="idx" value="${idx+1}" />	<!-- idx 늘려주기 -->
      			</c:if>>
      			 ${TargetDTO }
         	</label>
		 </c:forEach>

      </div>
      <div class="form-group">
         <label>유형</label>
         <input class="form-control" value="${dto.pdt_type}" readonly="readonly" >
         <input type="hidden" name="pdt_type" value="${dto.pdt_type}" >
      </div>
      <div class="form-group">
         <label>비고</label>
         <textarea class="form-control" name="bigo" rows="5" cols="30" >${dto.bigo}</textarea>
      </div>
      <div class="form-group">
         <label>저장된 사진</label>
         <input type="text" value="${dto.orgpic}" readonly="readonly">
         <label>변경할 사진</label>
         <input type="file" class="form-control" name="file" accept="image/gif,image/jpeg, image/png" >
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