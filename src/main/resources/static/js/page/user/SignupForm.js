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
			auth();
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
		
		//타이머 
		let isStarted = false;
		const auth = () => {
		
		    if(isStarted === false) {
		        const divTimer = document.getElementById("timer")
		        const btnFinish = document.getElementById("authFinishBtn")
		
		        // 타이머가 작동중이 아닐때
		        isStarted = true
		        btnFinish.disabled = false
		        // 1. 인증번호 표시
		        let token = String(Math.floor(Math.random() * 1000000)).padStart(6,"0")
		        // console.log(token);
		        const divTarget = document.getElementById("authCode")
		        divTarget.innerText = token;
		    
		        // 2. 3분 타이머 시작
		        let time = 180
		        let timer
		    
		        timer = setInterval(function() {
		        
		            if(time >= 0) {
		                const min = Math.floor( time / 60 )
		                const sec = String(time % 60).padStart(2,"0")
		                // console.log(min + ":" + sec)
		                divTimer.innerText = `${min}:${sec}`
		                time = time - 1
		            } else {
		                btnFinish.disabled = true
		                isStarted = false
		                clearInterval(timer)
		            }
		            
		        },1000)
		    } else {
		        // 타이머가 작동중일때
		    }
		}
		
		
	});
});
