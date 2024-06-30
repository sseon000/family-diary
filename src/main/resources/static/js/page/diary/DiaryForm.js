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
		if(diaryDto.diaryId != 0) {
			alert('diaryDto' + JSON.stringify(diaryDto));
			$('#diaryTitle').val(diaryDto.diaryTitle);
			$('#diaryContent').val(diaryDto.diaryContent);
		}
		
        $("#regBtn").click(function(){
			let param = {
				"diaryTitle": $('#diaryTitle').val(),
				"diaryContent": $('#diaryContent').val()
			}
			//let param =  $("#diaryRegForm").serialize();
			
			$.ajax({
				type:"put",
				url:"/diary/reg",
				dataType: "json",
				contentType: "application/json",
				data:JSON.stringify(param),
				success:function(data){
					debugger
					console.log(data);
				}
			});	
			
		});
    });
});
