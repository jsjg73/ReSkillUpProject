<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vm.*" %>
<%@ page import="java.util.*" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<%
	//String strPg = request.getParameter("pg");
	//int pg = Integer.parseInt(strPg);
	String pdt_name = request.getParameter("pdt_name");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>샘플 등록</title>
   <!--부트스트랩 css 추가-->
   <link rel="stylesheet" href="./css/bootstrap.min.css">
</head>
<body>
<h1 style="text-align:center" >샘플 등록</h1>
<div class="container">
   <form action="samp_write.jsp" method="post">
      <div class="form-group">
         <label>샘플ID</label>
         <input type="text" class="form-control" name="samp_id"
               placeholder="샘플ID를 입력하세요">
      </div>
      <div class="form-group">
         <label>제품명</label>
         <input type="text" class="form-control" name="pdt_name" value=<%=pdt_name %>>
      </div>
      <div class="form-group">
         <label>유형</label>
         <input type="number" class="form-control" name="pdt_type"
               placeholder="유형을 입력하세요">
      </div>
      <div class="form-group">
         <label>샘플 도착 날짜</label>
         <input type="date" class="form-control" name="arriv_date" required>
      </div>
      <div class="form-group">
         <label>가격</label>
         <input type="number" class="form-control" name="price"
               placeholder="가격을 입력하세요">
      </div>
      <div class="form-group">
         <label>제조사</label>
         <input type="text" class="form-control" name="coc_name"
               placeholder="제조사를 입력하세요">
      </div>
      <div class="form-group">
         <label>사진</label>
         <input type="file" class="form-control" name="pic" accept="image/gif,image/jpeg, image/png">
      </div>
      <div class="form-group">
         <label>비고</label>
         <textarea class="form-control" name="content" rows="5" cols="30"></textarea>
      </div>
      <button type="submit" class="btn btn-primary">등록</button>
      <input class="btn btn-danger" type="reset" value="취소">
   </table>
   </form>
</div> <!-- /container -->

<!--부트스트랩 js, jquery 추가-->
<script src="./js/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
</body>
</html>