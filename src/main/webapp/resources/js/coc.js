$(function(){
	$("#coc_writeform").submit(function(){
		if( $("#coc_name").val() == "" ) {
			alert("제조사명를 꼭 입력해주세요!");
			$("#coc_name").focus();
			return false;
		}
		if( $("#pwd").val() == "" ) {
			alert("비밀번호를 꼭 입력해주세요!");
			$("#pwd").focus();
			return false;
		}
		
		if( pwf.Pdt_type[0].checked == false &&
		pwf.Pdt_type[1].checked == false &&
		pwf.Pdt_type[2].checked == false &&
		pwf.Pdt_type[3].checked == false 	) {
			alert("유형을 꼭 선택해주세요!");
			return false;
		}
		
		
	});
	
	$("#pur_updateform").submit(function(){
	   
		if( $("#reg_date").val() == "" ) {
			alert("기획날짜를 꼭 선택해주세요!");
			$("#reg_date").focus();
			return false;
		}
		if( puf.target[0].checked == false &&
				puf.target[1].checked == false &&
				puf.target[2].checked == false &&
				puf.target[3].checked == false &&
				puf.target[4].checked == false 	) {
			alert("주 고객층을 꼭 선택해주세요!");
			return false;
		}
	});
	
	
});
