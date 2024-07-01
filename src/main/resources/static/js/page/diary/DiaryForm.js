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
		
		if(diaryDto.diaryId != 0) { // 수정폼
			alert('diaryDto' + JSON.stringify(diaryDto));
			$('#diaryTitle').val(diaryDto.diaryTitle);
			$('#diaryContent').val(diaryDto.diaryContent);
			$('#regBtn').text('수정');
			$('#deleteBtn').addClass('invisible');
		} 
		
        $("#regBtn").click(function(){
			let url = "";
			let param = {
				"diaryTitle": $('#diaryTitle').val(),
				"diaryContent": $('#diaryContent').val()
			}
			//let param =  $("#diaryRegForm").serialize();
			
			if(false) {
				url = "/diary/reg";
			} else {
				url = "/diary/modify";
			}
			
			$.ajax({
					type:"put",
					url:"/diary/reg",
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
