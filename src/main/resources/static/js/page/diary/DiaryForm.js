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
