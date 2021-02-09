<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>샘플 상세 조회</title>
<!--부트스트랩 js, jquery 추가-->
	<script src="/resources/js/jquery.min.js"></script>
	<script src="/resources/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="/resources/js/main.js"></script>
</head>
<body>
<h1 style="text-align:center">신제품 기획서 상세조회</h1><br><br>
<div class="container">
<form action="/samp_updateform" method="post" >
   <input type="hidden" name=writer value="${writer}">
   <input type="hidden" name=pageNum value="${pageNum}">
   
      <div class="form-group">
         <label>샘플ID</label>
         <input type="text" class="form-control" name="samp_id" id="samp_id"
               value="${samp.samp_id}" readonly="readonly">
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
         <input type="date" class="form-control" name="arriv_date" id="arriv_date" readonly="readonly"
         value="<fmt:formatDate type="both" value="${samp.arriv_date}" pattern="yyyy-MM-dd"/>">
      </div>
      <div class="form-group">
         <label>가격</label>
         <input type="number" class="form-control" name="price" id="price" readonly="readonly"
               value="${samp.price }">
      </div>
      <div class="form-group">
         <label>제조사(무결성 체크 필요)</label>
         <input type="text" class="form-control" name="coc_name" id="coc_name" readonly="readonly"
               value="${samp.coc_name }">
      </div>
      <div class="form-group">
         <label>사진</label>
         <input type="text" value="(사진보여주기)">
      </div>
      <div class="form-group">
         <label>비고</label>
         <textarea class="form-control" name="bigo" rows="5" cols="30" readonly="readonly">${samp.bigo}</textarea>
      </div>
      <a href="/samp_list/${pageNum}" class="btn btn-primary">확인</a>
      <button type="submit" class="btn btn-primary">수정페이지로</button>
   </table>
   </form>
   </div>
</body>
</html>