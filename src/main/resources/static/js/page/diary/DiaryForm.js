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
			$('.container > h1').text('다이어리 수정');
			$('#regBtn').text('수정');
			$('#deleteBtn').addClass('visible');
		} 
		
		$('#diaryFiles').change(function(e) {
		  	console.log(e);
		  
		  	let fileList = e.target.files;
			let previewTag = $('#preview');
		  
		  	for(let i=0; i<fileList.length; i++) {
				console.log(fileList[i]);
				let imgTag = document.createElement('img');
				imgTag.style.width = '400px';
				imgTag.style.height = '400px';
				let imgUrl = URL.createObjectURL(fileList[i]);
				imgTag.setAttribute('src', imgUrl);
				previewTag.append(imgTag);
		  	}
		});
		
        $("#regBtn").click(function(){
			let formData = new FormData();
			let files = $('#diaryFiles')[0].files;
			
			for(let i = 0; i < files.length; i++) {
                console.log(files[i]);
                formData.append("diaryFiles", files[i]);
            };
			
			let diaryDto = {
				"diaryId": $('#diaryId').val(),
				"diaryTitle": $('#diaryTitle').val(),
				"diaryContent": $('#diaryContent').val()
			}
			
			formData.append("diaryDto", new Blob([JSON.stringify(diaryDto)], { type: 'application/json' }));
			
			$.ajax({
				url: '/diary/uploadFileTest',
				type : "post",
				data : formData,  
				contentType: false,
				processData: false,
				enctype: "multipart/form-data",
				success:function(data){
					console.log(data);
					location.href = "/diary";
				},
                error: function(jqXHR, textStatus, errorThrown) {
                    console.log(textStatus);
                }
			});
			
		});
		
    });
});
