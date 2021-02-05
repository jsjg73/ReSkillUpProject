<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>신제품 기획서 등록</title>
   <!--부트스트랩 css 추가-->
   <link rel="stylesheet" href="./css/bootstrap.min.css">
</head>
<body>
<h1 style="text-align:center">신제품 기획서 등록</h1><br><br>

<div class="container">
   <form action="pur_write.jsp" method="post">
   <input type="hidden" name="writer" value="employee">
      <div class="form-group">
         <label>제품명</label>
         <input type="text" class="form-control" name="pdt_name"
               placeholder="제품명을 입력하세요">
      </div>
      <div class="form-group">
         <label>등록날짜</label>
         <input type="date" class="form-control" name="reg_date">
      </div>
      <div class="form-group">
         <label>주 고객층</label>
         <label><input type="checkbox" name="target" value="1"> code1</label>
		 <label><input type="checkbox" name="target" value="2"> code2</label>
      </div>
      <div class="form-group">
         <label>유형</label>
         <select class="form-control" name="pdt_type" >
		    <option value="none">=== 선택 ===</option>
		    <option value="1">type1</option>
		    <option value="2">type2</option>
  		 </select>
      </div>
      <div class="form-group">
         <label>비고</label>
         <textarea class="form-control" name="bigo" rows="5" cols="30"></textarea>
      </div>
      <div class="form-group">
         <label>사진</label>
         <input type="file" class="form-control" name="pic" accept="image/gif,image/jpeg, image/png">
      </div>
      <button type="submit" class="btn btn-primary">등록</button>
      <input class="btn btn-danger" type="reset" value="취소">
   </form>
</div> <!-- /container -->

<!--부트스트랩 js, jquery 추가-->
<script src="./js/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
</body>
</html>