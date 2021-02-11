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
	
	
});
