/*
######################################################################
# Filename : signupForm.js
# Description : 회원 등록
# author : KSH
# since : 2024.07.20
######################################################################
*/
define([], function() {
    $(document).ready(function(){
		//let url = "/user/authEmail";
		//id, password, email 유효성 체크 추가 필요 2024.07.27
		
        //1. 이메일 인증
        let isAuthEmail = false;
        
        $("#authBtn").click(function(){
			alert('authBtn click');
			
			let userDto = {
				"userId": $('#userId').val(),
				"password": $('#password').val(),
				"userName": $('#userName').val(),
				"email": $('#email').val(),
			}
			
			$.ajax({
				url: "/user/authEmail",
				type:"post",
				dataType: "json",
				contentType: "application/json",
				data:JSON.stringify(userDto),
				success:function(data){
					console.log(data);
					//alert(data.result.msg);
					isAuthEmail = true;
					$('#regBtn').removeAttr('disabled');
				},
                error: function(jqXHR, textStatus, errorThrown) {
					console.log(data);
                    //alert(data.result.msg);
                }
			});
		});
        
        //url = "/user/signup";
        //2. 회원가입
        $("#regBtn").click(function(){
			if(!isAuthEmail) {
				return false;
			}
			
			let userDto = {
				"userId": $('#userId').val(),
				"password": $('#password').val(),
				"userName": $('#userName').val(),
				"email": $('#email').val(),
			}
			
			$.ajax({
				url: "/user/signup",
				type:"post",
				dataType: "json",
				contentType: "application/json",
				data:JSON.stringify(userDto),
				success:function(data){
					console.log(data);
					//alert(data.result.msg);
					//성공 메세지 후 로그인창 이동
				},
                error: function(jqXHR, textStatus, errorThrown) {
					console.log(data);
                    //alert(data.result.msg);
                }
			});
		});
	});
});
