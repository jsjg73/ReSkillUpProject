$(function(){
	$("#pur_writeform").submit(function(){
		var flag = false;
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
		if($("[name='pdt_type'] :selected").val()== "none"){
			alert("유형을 꼭 선택해주세요!");
			return false;
		}
		if($("input:checkbox[name='target']").is(":checked") == true){
				flag = true;
		}
		if( !flag ) {
			alert("고객층을 꼭 선택해주세요!");
			return false;
		}
		
	});
	
	$("#pur_updateform").submit(function(){	
		var flag = false;
		if( $("#reg_date").val() == "" ) {
			alert("기획날짜를 꼭 선택해주세요!");
			$("#reg_date").focus();
			return false;
		}
		if($("input:checkbox[name='target']").is(":checked") == true){
				flag = true;
		}
		if( !flag ) {
			alert("고객층을 꼭 선택해주세요!");
			return false;
		}
	});
	
});
