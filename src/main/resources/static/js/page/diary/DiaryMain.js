define([], function() {
    // 여기에서 모듈 코드 작성
    $(document).ready(function(){
        console.log('234');
        
        $("#searchBtn").click(function(){
			//Search btn click
			let param = {
				"diaryTitle": $('#diaryTitle').val(),
				"diaryContent": $('#diaryContent').val()
			}
			
			debugger
			//let param = $("#searchForm").serialize();
			//param = { diaryDto: param };
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
