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
        $("#searchBtn").click(function(){
			//Search btn click
			let param = {
				"diaryTitle": $('#diaryTitle').val(),
				"diaryContent": $('#diaryContent').val()
			}
			//let param = $("#searchForm").serialize();
			
			$.ajax({
				type:"put",
				url:"/diary",
				dataType: "json",
				contentType: "application/json",
				data:JSON.stringify(param),
				success:function(diaryList){
					console.log(diaryList);
					console.log(typeof diaryList);
					let tr;
					let td;
					let diaryDto;
					for(let i=0; i<diaryList.length; i++) {
						diaryDto = diaryList[i];
						tr = document.createElement('tr');
						tr.setAttribute("id", i + "_diaryDto");
						
						for(const [key, value] of Object.entries(diaryDto)) {
							td = document.createElement('td');
							td.setAttribute("id", i + "_key");
							td.innerText = value;
							tr.appendChild(td);
						} 
										
						$('#diaryTable > tbody')[0].appendChild(tr);	
					}	
				}
			});	
		});		
        
        
    });

   
});
