$(function(){
	$("#pur_write_btn").on("click",function(){
		var flag = false;
		if( pdt_name=="" ||$("#pdt_name").val() != pdt_name ) {
			alert("제품명를 중복 검사해주세요!");
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
	
	$("#pur_update_btn").on("click",function(){	
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
	
	//제품명 중복검사
	var pdt_name ="";
	$("#pur_duplicate").on("click",function(){
	
		//중복검사한 제품명 저장
		pdt_name = $("#pdt_name").val().trim();
		
		var pattern2 = /[`~!@#$%^&*|\\\'\";:\/?]/;
		
		if(pdt_name=="" || pattern2.test(pdt_name)){
			alert("사용 불가능한 제품명임(특수문자 확인바람.)");
			$("#pdt_nametd").text("올바른 제품명 입력바람");
			$("#pdt_name").focus();
			return false;
		}
		
		$.ajax({
		 	url: '/pur_dupli',
		    type: 'GET',
		    dataType: 'json', //서버로부터 내가 받는 데이터의 타입
		    contentType : 'application/json',//내가 서버로 보내는 데이터의 타입
		    data: {pdt_name : pdt_name},

		    success: function(data){
		         if(data == -1){
		         	//alert("사용가능한 제품명");
		         	$("#pdt_nametd").text(pdt_name + " 은(는) 사용가능한 제품명 ");
		         }else{
		         	alert("제품명 중복");
		         	$("#pdt_name").val("").focus();
		         	$("#pdt_nametd").text("");
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
