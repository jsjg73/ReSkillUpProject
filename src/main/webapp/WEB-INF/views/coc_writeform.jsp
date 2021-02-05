<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>제조사 등록</title>
   <!--부트스트랩 css 추가-->
   <link rel="stylesheet" href="./css/bootstrap.min.css">
</head>
<body>
<h1 style="text-align:center">제조사 등록</h1><br><br>

<div class="container">
   <form action="pur_write.jsp" method="post">
   <input type="hidden" name="writer" value="employee">
      <div class="form-group">
         <label>제조사명</label>
         <input type="text" class="form-control" name="coc_name"
               placeholder="제조사명을 입력하세요">
         <button id="coc_duplicate" disabled="disabled">중복검사</button>
      </div>
      <div class="form-group">
         <label>유형</label>
         <label><input type="checkbox" name="pdt_type" value="1"> type1</label>
		 <label><input type="checkbox" name="pdt_type" value="2"> type2</label>
      </div>
      <div class="form-group">
         <label>인증번호</label> <!-- 아무 회사나 등록하지못하고 기획회사 직원이 인증한 회사만 정보등록가능하도록 -->
         <input type="text" class="form-control" name="empno">
      </div>
      <div class="form-group">
         <label>담당자</label> 
         <input type="text" class="form-control" name="coc_emp">
      </div>
      <div class="form-group">
         <label>연락처</label> 
         <input type="text" class="form-control" name="coc_call">
      </div>
      <div class="form-group">
         <label>이메일</label>
         <input type="text" class="form-control" name="coc_mail">
      </div>
      <div class="form-group">
         <label>비밀번호</label> <!-- 유효성검사 -->
         <input type="password" class="form-control" name="pwd">
      </div>
      <div class="form-group">
         <label>비밀번호확인</label>
         <input type="password" class="form-control" name="pwd_ck">
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