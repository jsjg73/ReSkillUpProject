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
	String strId = request.getParameter("samp_id");
	int id = Integer.parseInt(strId);
	
	SampleDAO sampleDAO = new SampleDAO();
	SampleDTO dto = sampleDAO.sampleRead(id);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>샘플 수정</title>
   <!--부트스트랩 css 추가-->
   <link rel="stylesheet" href="./css/bootstrap.min.css">
</head>
<body>
<h1 style="text-align:center">샘플 수정</h1><br><br>

<div class="container">
   <form action="pur_updateform.jsp" method="post">
   <input type="hidden" name="writer" value="employee">
      <div class="form-group">
         <label>샘플ID</label>
         <input type="text" class="form-control" name="samp_id"
               value="<%=dto.getSamp_id() %>" readonly>
      </div>
      <div class="form-group">
         <label>제품명</label>
         <input type="text" class="form-control" name="pdt_name" value="<%= dto.getPdt_name() %>" readonly>
      </div>
      <div class="form-group">
         <label>유형</label>
         <select class="form-control" name="pdt_type" >
         	<!-- 선택된 유형의 이름을 어떻게 받아서 표시할지 모르겠음 -->
		    <option value="<%=dto.getPdt_name()%>" selected></option>
		    <option value="1">type1</option>
		    <option value="2">type2</option>
  		 </select>
      </div>
      <div class="form-group">
         <label>샘플 도착 날짜</label>
         <input type="date" class="form-control" name="reg_date"
         value="<%=dto.getArriv_date() %>" readonly>
      </div>
      <div class="form-group">
         <label>가격</label>
         <input type="number" class="form-control" name="price"
               value="<%=dto.getPrice() %>">
      </div>
            <div class="form-group">
         <label>제조사</label>
         <input type="text" class="form-control" name="coc_name"
               value="<%= dto.getCoc_name() %>">
      </div>
      <div class="form-group">
         <label>사진</label>
         <input type="file" class="form-control" name="pic" accept="image/gif,image/jpeg, image/png">
      </div>
      <div class="form-group">
         <label>비고</label>
         <textarea class="form-control" name="bigo" rows="5" cols="30" value="<%=dto.getBigo() %>"></textarea>
      </div>
      <button type="submit" class="btn btn-primary">수정</button>
      <input class="btn btn-danger" type="reset" value="취소">
   </form>
</div> <!-- /container -->

<!--부트스트랩 js, jquery 추가-->
<script src="./js/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
</body>
</html>