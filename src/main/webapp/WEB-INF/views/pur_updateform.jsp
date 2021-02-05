<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.mycompany.myapp.dto.*"%><%@ page import="java.util.*" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<%
	String pdt_name = request.getParameter("pdt_name");
	PurposalDAO dao = new PurposalDAO();
	PurposalDTO dto = dao.purposalRead(pdt_name);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>신제품 기획서 수정</title>
   <!--부트스트랩 css 추가-->
   <link rel="stylesheet" href="./css/bootstrap.min.css">
</head>
<body>
<h1 style="text-align:center">신제품 기획서 수정</h1><br><br>

<div class="container">
   <form action="pur_updateform.jsp" method="post">
   <input type="hidden" name="writer" value=<%=dto.getWriter() %>>
      <div class="form-group">
         <label>제품명</label>
         <input type="text" class="form-control" name="pdt_name"
               value=<%=dto.getPdt_name() %>>
      </div>
      <div class="form-group">
         <label>등록날짜</label>
         <input type="date" class="form-control" name="reg_date"
         value=<%=dto.getReg_date() %> readonly>
      </div>
      <div class="form-group">
         <label>주 고객층</label>
         <!-- 선택된 고객층을 어떻게 체크를 해놓을지 모르겠음 -->
         <label><input type="checkbox" name="target" value="1"> code1</label>
		 <label><input type="checkbox" name="target" value="2"> code2</label>
      </div>
      <div class="form-group">
         <label>유형</label>
         <select class="form-control" name="pdt_type" >
         	<!-- 선택된 유형의 이름을 어떻게 받아서 표시할지 모르겠음 -->
		    <option value=<%=dto.getPdt_name()%> selected></option>
		    <option value="1">type1</option>
		    <option value="2">type2</option>
  		 </select>
      </div>
      <div class="form-group">
         <label>비고</label>
         <textarea class="form-control" name="bigo" rows="5" cols="30" ><%=dto.getBigo() %></textarea>
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
<script src="./js/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
</body>
</html>