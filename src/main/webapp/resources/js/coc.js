$(function(){
	$("#coc_writeform").submit(function(){
		var flag = false;
		if( $("#coc_name").val() == "" ) {
			alert("제조사명를 꼭 입력해주세요!");
			$("#coc_name").focus();
			return false;
		}
		if( $("#empno").val() == "" ) {
			alert("인증코드를 꼭 입력해주세요!");
			$("#empno").focus();
			return false;
		}
		if( $("#pwd").val() == "" ) {
			alert("비밀번호를 꼭 입력해주세요!");
			$("#pwd").focus();
			return false;
		}
		if( $("#pwd_check").val() == "" ) {
			alert("비밀번호 확인을 꼭 입력해주세요!");
			$("#pwd_check").focus();
			return false;
		}
		if( $("#pwd").val() != $("#pwd_check").val() ) {
			alert("비밀번호와 비밀번호 확인이 일치하도록 입력해주세요!");
			$("#pwd_check").focus();
			return false;
		}
		
		if($("input:checkbox[name='Pdt_type']").is(":checked") == true){
				flag = true;
		}
		if( !flag ) {
			alert("유형을 꼭 선택해주세요!");
			return false;
		}
		
	});
	
	$("#coc_updateform").submit(function(){
	   
		if( $("#pwd_check").val() != $("#pwd").val()){
			alert("비밀번호가 틀렸습니다.");
			$("#pwd_check").focus();
			return false;
		}
	});
	
	//제조사명 중복검사
	var coc_name ="";
	$("#coc_duplicate").on("click",function(){
	
		//중복검사한 제조사명 저장
		coc_name = $("#coc_name").val().trim();
		
		var pattern2 = /[`~!@#$%^&*|\\\'\";:\/?]/;
		
		if(coc_name=="" || pattern2.test(coc_name)){
			alert("사용 불가능한 제조사명임(특수문자 확인바람.)");
			$("#coc_nametd").text("올바른 제조사명 입력바람");
			$("#coc_name").focus();
			return false;
		}
		
		$.ajax({
		 	url: '/coc_dupli',
		    type: 'GET',
		    dataType: 'json', //서버로부터 내가 받는 데이터의 타입
		    contentType : 'application/json',//내가 서버로 보내는 데이터의 타입
		    data: {coc_name : coc_name},

		    success: function(data){
		         if(data == -1){
		         	alert("사용가능한 제조사명입니다.");
		         	//$("#coc_nametd").text(coc_name + " 은(는) 사용가능한 제조사명 ");
		         }else{
		         	alert("제조사명 중복");
		         	$("#coc_name").val("").focus();
		         	$("#coc_nametd").text("");
		         	pdt_name="";
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
