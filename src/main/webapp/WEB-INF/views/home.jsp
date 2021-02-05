<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css">
<title>홈화면</title>
</head>
<body>


<div class="w3-row-padding w3-center w3-margin-top">
<div class="w3-third" >
  <div class="w3-card w3-container" style="min-height:460px">
  <br>
  <br>
  <br>
  <i class="fa fa-desktop w3-margin-bottom w3-text-theme" style="font-size:120px"></i>
  <h3>신제품 기획</h3><br>
  <button class="w3-button w3-border w3-hover-red" style="cursor:pointer" onclick="location.href='/pur_writeform'">등록</button>
  <button class="w3-button w3-border w3-hover-red" style="cursor:pointer" onclick="location.href='/pur_list'">조회</button>
  </div>
</div>

<div class="w3-third" >
  <div class="w3-card w3-container" style="min-height:460px">
  <br>
  <br>
  <br>
  <i class="fa fa-css3 w3-margin-bottom w3-text-theme" style="font-size:120px"></i>
  <h3>샘플 문서</h3><br>
  <button class="w3-button w3-border w3-hover-red" style="cursor:pointer" onclick="location.href='samp_writeform_step1.jsp'">등록</button>
  <button class="w3-button w3-border w3-hover-red" style="cursor:pointer" onclick="location.href='samp_list.jsp'" >조회</button>
  </div>
</div>

<div class="w3-third" >
  <div class="w3-card w3-container" style="min-height:460px">
  <br>
  <br>
  <br>
  <i class="fa fa-diamond w3-margin-bottom w3-text-theme" style="font-size:120px"></i>
  <h3>제조사</h3><br>
  <button class="w3-button w3-border w3-hover-red" style="cursor:pointer" onclick="location.href='coc_writeform.jsp'">등록</button>
  <button class="w3-button w3-border w3-hover-red" style="cursor:pointer" onclick="location.href='coc_list.jsp'">조회</button>
  </div>
</div>
</div>
</body>
</html>