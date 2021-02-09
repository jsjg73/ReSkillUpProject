<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>샘플 등록</title>
   <!--부트스트랩 css 추가-->
   <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
   <script src="/resources/js/samp.js"></script>
</head>
<body>
<h1 style="text-align:center" >샘플 등록</h1>
<div class="container">
   <form action="/samp_write" method="post" id="samp_writeform" enctype="multipart/form-data" >
   <input type="hidden" name=writer value="${writer}">
   
      <div class="form-group">
         <label>샘플ID(중복처리)</label>
         <input type="text" class="form-control" name="samp_id" id="samp_id"
               placeholder="샘플ID를 입력하세요">
      </div>
      <div class="form-group">
         <label>제품명</label>
         <input type="text" class="form-control" name="pdt_name"  value="${pur.pdt_name}" readonly="readonly">
      </div>
      <div class="form-group">
         <label>유형</label>
         <input type="text" class="form-control" name="pdt_type"
               value="${pur.pdt_type}" readonly="readonly">
      </div>
      <div class="form-group">
         <label>샘플 도착 날짜</label>
         <input type="date" class="form-control" name="arriv_date" id="arriv_date">
      </div>
      <div class="form-group">
         <label>가격</label>
         <input type="number" class="form-control" name="price" id="price"
               placeholder="가격을 입력하세요">
      </div>
      <div class="form-group">
         <label>제조사(무결성 체크 필요)</label>
         <input type="text" class="form-control" name="coc_name" id="coc_name"
               placeholder="제조사를 입력하세요">
      </div>
      <div class="form-group">
         <label>사진</label>
         <input type="file" class="form-control" name="file" accept="image/gif,image/jpeg, image/png">
      </div>
      <div class="form-group">
         <label>비고</label>
         <textarea class="form-control" name="bigo" rows="5" cols="30"></textarea>
      </div>
      <button type="submit" class="btn btn-primary">등록</button>
      <input class="btn btn-danger" type="reset" value="취소">
   </table>
   </form>
</div> <!-- /container -->

<!--부트스트랩 js, jquery 추가-->
<script src="/resources/js/jquery.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>