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
			//let param = $("#searchForm").serialize();
			
			$.ajax({
				type:"put",
				url:"/diary",
				dataType: "json",
				contentType: "application/json",
				data:JSON.stringify(param),
				success:function(diaryList){
					let tbody = document.getElementById('diaryTbody');
					while(tbody.childElementCount > 0) {
						tbody.removeChild(tbody.firstChild);
					}
					//console.log(diaryList);
					let tr;
					let td;
					let diaryDto;
					for(let i=0; i<diaryList.length; i++) {
						diaryDto = diaryList[i];
						tr = document.createElement('tr');
						tr.setAttribute("id","diaryDto_" + i);
						
						for(const [key, value] of Object.entries(diaryDto)) {
							//console.log(`key: ${key}, value: ${value}`);
							if(value != null) {
								td = document.createElement('td');
								td.setAttribute("id", key);
								if(key == 'diaryId') {
									td.classList.add('link-cell');
									td.addEventListener('click', function(e) {
										console.log(e.currentTarget.innerText)
										location.href = "/diary/detail?diaryId=" + decodeURIComponent(e.currentTarget.innerText);   
									})
								}
								td.innerText = value;
								tr.appendChild(td);	
							}
							
						} 
										
						$('#diaryTable > tbody')[0].appendChild(tr);	
					}	
				}
			});	
		});
		
		$('#searchBtn').click();	
    });
});
