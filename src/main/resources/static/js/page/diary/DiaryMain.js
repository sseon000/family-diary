/*
######################################################################
# Filename : DiaryMain.js
# Description : 다이어리 메인
# author : KSH
# since : 2024.06.05
######################################################################
*/
define([], function() {
    $(document).ready(function(){
        $("#searchBtn").click(function() {
			//Search btn click
			let param = {
				"diaryTitle": $('#diaryTitle').val(),
				"diaryContent": $('#diaryContent').val()
			}
			
			$.ajax({
				url:"/diary",
				type:"post",
				dataType: "json",
				contentType: "application/json",
				data:JSON.stringify(param),
				success:function(diaryList){
					let diaryMainDiv = document.getElementById('diaryMain');
					while(diaryMainDiv.childElementCount > 0) {
					    diaryMainDiv.removeChild(diaryMainDiv.firstChild);
					}
					
					let str = '';
					$.each(diaryList, function(idx, item) {
						str += '<div class="col">'
                    	str += '<div class="card shadow-sm">'
                    	str += '<img class="bd-placeholder-img card-img-top" width="100%" height="225" src="'+ item.filePath + '" alt=""'
						str += 'aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false">'
						str += '<rect width="100%" height="100%" fill="#55595c">'
						str += '</img>' 
						str += '<div class="card-body">' 
						str += '<h5 class="card-text">' + item.diaryTitle + '</h5>'
						str += '<p class="card-text">' + item.diaryContent + '</p>' 
						str += '<div class="d-flex justify-content-between align-items-center">' 
						str += '<div class="btn-group">' 
						str += '<button type="button" class="btn btn-sm btn-outline-secondary detailBtn">View</button>'
						str += '<input type="hidden" id="diaryId" name="diaryId" value="' + item.diaryId + '">' 
						str += '</div>' 
						str += '<small class="text-muted">' + item.modiAt + '</small>' 
						str += '</div>' 
						str += '</div>' 
						str += '</div>' 
						str += '</div>' 
					}),
					$("#diaryMain").append(str);
					$('.detailBtn').click(function(e) {
					    location.href = "/diary/detail?diaryId=" + decodeURIComponent(e.currentTarget.nextSibling.value);
					})
				},
                error: function(jqXHR, textStatus, errorThrown) {
                	console.log(textStatus);
                }
			});
	    });
	    
		$('#searchBtn').click();
	});
});
