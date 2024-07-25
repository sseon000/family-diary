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
        //1. 이메일 인증
        
        //2. 중복체크
        let checkedId = '';
		let url = "/user/isExistUserId";
		
        $("#dupChkBtn").click(function(){
			let userDto = {
				"userId": $('#userId').val(),
			}
			
			$.ajax({
				url: url,
				type:"post",
				dataType: "json",
				contentType: "application/json",
				data:JSON.stringify(userDto),
				success:function(data){
					console.log(data);
					if(data.result.isExists != "0") {
						alert('이미 존재하는 회원입니다.');
					} else {
						alert('사용 가능 회원ID.');
						checkedId = data.result.checkedId; 
						$('#regBtn').removeAttr('disabled')
					}
				},
                error: function(jqXHR, textStatus, errorThrown) {
                    console.log(textStatus);
                }
			});
		});
		
		//회원가입 버튼 클릭시 현재 인풋값과 checkedId비교
	});
});
