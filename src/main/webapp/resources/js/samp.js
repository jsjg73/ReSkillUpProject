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
});
