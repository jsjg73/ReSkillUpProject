$(function() {
	$("#write-btn").on("click", function() {
		var flag = false;
		var pattern2 = /[`~!@#$%^&*|\\\'\";:\/?]/;

		if (coc_name == "" || pattern2.test(coc_name)) {
			alert("사용 불가능한 제조사명임(특수문자 확인바람.)");
			$("#coc_nametd").text("올바른 제조사명 입력바람");
			$("#coc_name").focus();
			return false;
		}

		if ($("#empno").val() == "") {
			alert("인증코드를 꼭 입력해주세요!");
			$("#empno").focus();
			return false;
		}
		if ($("#pwd").val() == "") {
			alert("비밀번호를 꼭 입력해주세요!");
			$("#pwd").focus();
			return false;
		}
		if ($("#pwd_check").val() == "") {
			alert("비밀번호 확인을 꼭 입력해주세요!");
			$("#pwd_check").focus();
			return false;
		}
		if ($("#pwd").val() != $("#pwd_check").val()) {
			alert("비밀번호와 비밀번호 확인이 일치하도록 입력해주세요!");
			$("#pwd_check").focus();
			return false;
		}

		if ($("input:checkbox[name='Pdt_type']").is(":checked") == true) {
			flag = true;
		}
		if (!flag) {
			alert("유형을 꼭 선택해주세요!");
			return false;
		}

	});
	
	//제조사명, 유형 중복검사
	var coc_name = "";
	$("#coc_duplicate").on("click", function() {
		coc_name = $("#coc_name").val();
		if(coc_name == ""){
			alert("제조사명을 입력해주세요.");
			$("#coc_name").focus();
			return false;
		}
		var checked_array = [];
		if ($("input:checkbox[name='Pdt_type']").is(":checked") == true) {
			$('input:checkbox[name="Pdt_type"]:checked').each(function() {
				checked_array.push($(this).val());
			});
		}
		else {
			alert("유형을 꼭 선택해주세요!");
			return false;
		}
		$.ajax({
			url: '/coc/dupli',
			type: 'GET',
			dataType: 'json', //서버로부터 내가 받는 데이터의 타입
			contentType: 'application/json',//내가 서버로 보내는 데이터의 타입
			data: {
				coc_name: coc_name,
				checked_array: checked_array
			},
	
			success: function(data)  {
				if (data == -1) {
					alert("기존에 등록된 유형이 존재합니다.");
					$("#write-btn").attr("disabled", true);
					return false;
				}
				else {
					alert("등록가능한 유형입니다.");
					$("#write-btn").attr("disabled", false);					
				}
			},
			error: function(request, status, error) {
				alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
			}
	
		});//ajax end
	
		return false;//submit 방지
	});
	
	//비밀번호 확인
	var pwd_check = "";
	$("#pwd_check_btn").on("click", function() {
		pwd_check = $("#pwd_check").val();
		var coc_name = $("#coc_name").val();
		$.ajax({
			url: '/coc/pwd_check',
			type: 'GET',
			dataType: 'json', //서버로부터 내가 받는 데이터의 타입
			contentType : 'application/json', //내가 서버로 보내는 데이터의 타입
			data: {
				pwd_check: pwd_check,
				coc_name: coc_name
			},
			success: function(data) {
				if (data == -1) {
					alert("비밀번호가 틀렸습니다.");
					$("#pwd_check").val("").focus();
					$("#update-btn").attr("disabled", true);
				}
				else {
					alert("비밀번호가 일치합니다.");
					$("#update-btn").attr("disabled", false);
				}
			},
			error: function() {
				alert("ajax 에러");
			}
		});//ajax end
		return false;//submit 방지
	});
	
});
