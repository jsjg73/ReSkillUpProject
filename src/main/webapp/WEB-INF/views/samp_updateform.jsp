<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>샘플 수정</title>
   <!--부트스트랩 css 추가-->
   <script src="/resources/js/jquery.min.js"></script>
	<script src="/resources/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="/resources/js/samp.js"></script>
</head>
<body>
<h1 style="text-align:center">샘플 수정</h1><br><br>
<div class="container">
<form action="/samp/update" method="post" id="samp_updateform" enctype="multipart/form-data">
   <input type="hidden" name=writer value="${writer}">
   <input type="hidden" name=pageNum value="${pageNum}">
   <input type="hidden" name="orgpic" value="${samp.orgpic }">
   <input type="hidden" name="pic" value="${samp.pic }">
   <input type="hidden" name="ins_date" value="${samp.ins_date}">
      <div class="form-group">
         <label>샘플ID</label>
         <input type="text" class="form-control" name="samp_id" id="samp_id"
               value="${samp.samp_id}" readonly="readonly">
      </div>
      <div class="form-group">
         <label>작성자</label>
         <input type="text" class="form-control" value="${samp.writer}" readonly="readonly">
      </div>
      <div class="form-group">
         <label>제품명</label>
         <input type="text" class="form-control" name="pdt_name"  value="${samp.pdt_name}" readonly="readonly">
      </div>
      <div class="form-group">
         <label>유형</label>
         <input type="text" class="form-control" name="pdt_type"
               value="${samp.pdt_type}" readonly="readonly">
      </div>
      <div class="form-group">
         <label>샘플 도착 날짜</label>
         <input type="date" class="form-control" name="arriv_date" id="arriv_date"
         value="<fmt:formatDate type="both" value="${samp.arriv_date}" pattern="yyyy-MM-dd"/>">
      </div>
      <div class="form-group">
         <label>가격</label>
         <input type="text" class="form-control" name="price" id="price"
               value="${samp.price }">
      </div>
      <div class="form-group">
         <label>제조사</label>
         <input type="text" class="form-control" name="coc_name" id="coc_name" readonly="readonly"
               value="${samp.coc_name }">
      </div>
      <div class="form-group">
         <label>저장된 사진</label>
         <input type="text" value="${samp.orgpic}" readonly="readonly">
         <label>변경할 사진</label>
         <input type="file" class="form-control" name="file" accept="image/gif,image/jpeg, image/png" >
      </div>
      <div class="form-group">
         <label>비고</label>
         <textarea class="form-control" name="bigo" rows="5" cols="30">${samp.bigo}</textarea>
      </div>
      <button type="submit" class="btn btn-primary">수정</button>
      <input class="btn btn-danger" type="reset" value="취소">
   </table>
   </form>
   </div>
</body>
</html>