$(function(){
	$("#pur_writeform").submit(function(){
		if( $("#pdt_name").val() == "" ) {
			alert("제품명를 꼭 입력해주세요!");
			$("#pdt_name").focus();
			return false;
		}
		if( $("#reg_date").val() == "" ) {
			alert("기획날짜를 꼭 선택해주세요!");
			$("#reg_date").focus();
			return false;
		}
		if( pwf.target[0].checked == false &&
		pwf.target[1].checked == false &&
		pwf.target[2].checked == false &&
		pwf.target[3].checked == false 	) {
			alert("주 고객층을 꼭 선택해주세요!");
			return false;
		}
		if( $("#pdt_type").val() =="") {
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
				puf.target[3].checked == false 	) {
			alert("주 고객층을 꼭 선택해주세요!");
			return false;
		}
	});
	
	$("#samp_writeform").submit(function(){
	   
		if( samp_id.val == "" ) {
			alert("샘플ID를 꼭 선택해주세요!");
			samp_id.focus;
			return false;
		}
		
		if( arriv_date.val == "" ) {
			alert("도착날짜를 꼭 선택해주세요!");
			arriv_date.focus;
			return false;
		}
		if( price.val == "" ) {
			alert("가격를 꼭 선택해주세요!");
			price.focus;
			return false;
		}
		if( coc_name.val == "" ) {
			alert("제조사를 꼭 선택해주세요!");
			coc_name.focus;
			return false;
		}
	});
});
