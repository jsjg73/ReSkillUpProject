$(function(){
		
	$("#samp_writeform").submit(function(){
	   
		if( $("#samp_id").val() == "" ) {
			alert("샘플ID를 꼭 선택해주세요!");
			$("#samp_id").focus();
			return false;
		}
		
		if( $("#arriv_date").val() == "" ) {
			alert("도착날짜를 꼭 선택해주세요!");
			$("#arriv_date").focus();
			return false;
		}
		if( $("#price").val() == "" ) {
			alert("가격를 꼭 선택해주세요!");
			$("#price").focus();
			return false;
		}
		if( $("#coc_name").val() == "" ) {
			alert("제조사를 꼭 선택해주세요!");
			$("#coc_name").focus();
			return false;
		}
	});
	
	$("#samp_updateform").submit(function(){
	   
		if( $("#arriv_date").val() == "" ) {
			alert("도착날짜를 꼭 선택해주세요!");
			return false;
			$("#arriv_date").focus();
		}
		if( $("#price").val() == "" ) {
			alert("가격을 꼭 선택해주세요!");
			return false;
			$("#price").focus();
		}
	});
	
	//샘플ID 중복검사
	var samp_id ="";
	$("#samp_duplicate").on("click",function(){
	
		//중복검사한 샘플ID 저장
		samp_id = $("#samp_id").val().trim();
		
		var pattern2 = /[`~!@#$%^&*|\\\'\";:\/?]/;
		
		if(samp_id=="" || pattern2.test(samp_id)){
			alert("사용 불가능한 샘플ID임(특수문자 확인바람.)");
			$("#samp_idtd").text("올바른 샘플ID 입력바람");
			$("#samp_id").focus();
			return false;
		}
		
		$.ajax({
		 	url: '/samp_dupli',
		    type: 'GET',
		    dataType: 'json', //서버로부터 내가 받는 데이터의 타입
		    contentType : 'application/json',//내가 서버로 보내는 데이터의 타입
		    data: {samp_id : samp_id},

		    success: function(data){
		         if(data == -1){
		         	alert("사용가능한 샘플ID입니다.");
		         	//$("#samp_idtd").text(samp_id + " 은(는) 사용가능한 샘플ID ");
		         }else{
		         	alert("샘플ID 중복");
		         	$("#samp_id").val("").focus();
		         	$("#samp_idtd").text("");
		         	samp_id="";
		         	return false;
		         }
		    },
		    error: function (){        
		        alert("ajax 에러")
		    }
		});//ajax end
		
		return false;//submit 방지
	});
});
