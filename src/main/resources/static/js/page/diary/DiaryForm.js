/*
######################################################################
# Filename : DiaryForm.js
# Description : 다이어리 등록
# author : KSH
# since : 2024.06.29
######################################################################
*/
define([], function() {
    $(document).ready(function(){
		let isEdit = false;
		let url = "/diary/reg";
		
		if((Object.keys(diaryDto)).length != 0) { // 수정
			isEdit = true;
		}
		
		if(isEdit) { // 수정폼
			url = "/diary/modify";
			$('#diaryId').val(diaryDto.diaryId)
			$('#diaryTitle').val(diaryDto.diaryTitle);
			$('#diaryContent').val(diaryDto.diaryContent);
			$('#regBtn').text('수정');
			$('#deleteBtn').addClass('invisible');
		} 
		
        $("#regBtn").click(function(){
			
			let param = {
				"diaryId": $('#diaryId').val(),
				"diaryTitle": $('#diaryTitle').val(),
				"diaryContent": $('#diaryContent').val()
			}
			//let param =  $("#diaryRegForm").serialize();
			
			$.ajax({
					type:"put",
					url: url,
					dataType: "json",
					contentType: "application/json",
					data:JSON.stringify(param),
					success:function(data){
						console.log(data);
					}
				});
			
		});
		
    });
});
