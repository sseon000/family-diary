<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en"
	class="fontawesome-i2svg-active fontawesome-i2svg-complete">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<%@ include file="/WEB-INF/views/include/head_css.jsp"%>
<%-- ******* CUSTOM CSS Link HERE ******* --%>
<style>
header.masthead {
  padding-top: 10.5rem;
  padding-bottom: 6rem;
  text-align: center;
  color: #fff;
  background-image: url(${pageContext.request.contextPath }/resources/assets/img/Notice.png);
  background-repeat: no-repeat;
  background-attachment: scroll;
  background-position: center center;
  background-size: cover;
}
header.masthead .masthead-subheading {
  font-size: 1.5rem;
  font-style: italic;
  line-height: 1.5rem;
  margin-bottom: 25px;
  font-family: "Roboto Slab", -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
}
header.masthead .masthead-heading {
  font-size: 3.25rem;
  font-weight: 700;
  line-height: 3.25rem;
  margin-bottom: 2rem;
  font-family: "Montserrat", -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
}

@media (min-width: 768px) {
  header.masthead {
    padding-top: 17rem;
    padding-bottom: 12.5rem;
  }
  header.masthead .masthead-subheading {
    font-size: 2.25rem;
    font-style: italic;
    line-height: 2.25rem;
    margin-bottom: 2rem;
  }
  header.masthead .masthead-heading {
    font-size: 4.5rem;
    font-weight: 700;
    line-height: 4.5rem;
    margin-bottom: 4rem;
  }
  .card {
  	margin-top: 125px;
  }
  
}
</style>
<%-- ******* CUSTOM CSS Link END ******* --%>
</head>
<body id="page-top">
	<%@ include file="/WEB-INF/views/include/top.jsp"%>
	<!-- 
	<header class="masthead">
			<div class="container">
			<div class="masthead-heading text-uppercase"></div><br><br><br><br>
			<div class="masthead-subheading"></div>
		</div>
	</header>
	 -->
    <div id="layoutAuthentication">
        <div id="layoutAuthentication_content">
            <main>
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-lg-7">
                            <div class="card shadow-lg border-0 rounded-lg">
                                <div class="card-header" id="registerTag"><h3 class="text-center font-weight-light my-4">회원가입</h3></div>
                                <div class="card-body">
                                    <form id="registerInput" action="register.members" method="post">
                                    	<div class="col-md-8 form-group">
                                        	<input class="form-check-input" id="inputType1" name="type" value="정규직" type="radio" placeholder="type" checked>
                                            <label for="inputType1">정규직</label>
                                        	<input class="form-check-input" id="inputType2" name="type" value="계약직" type="radio" placeholder="type">
                                            <label for="inputType2">계약직</label>
                                            <input class="form-check-input" id="inputType3" name="type" value="사업자" type="radio" placeholder="type">
                                            <label for="inputType3">사업자</label>
                                        </div>
                                        <br>
                                        <div class="row mb-3">
                                            <div class="col-md-6">
                                                <div class="form-floating mb-3 mb-md-0">
                                                    <input class="form-control" id="inputName" type="text" name="name" placeholder="Enter your first name">
                                                    <label for="inputName"> Name</label>
                                                </div>
                                            </div>

                                        </div>
                                        <div class="form-floating mb-3">
                                            <input class="form-control" id="inputPH" type="text" name="ph" placeholder="ph">
                                            <label for="inputPH">PhonNumber("-"없이 입력해주세요.)</label>
                                        </div>
                                        <div class="row mb-3">
                                         <div class="col-md-10">
                                          <div class="form-floating mb-3 mb-md-0">
                                              <input class="form-control" id="inputEmail" type="email" name="id" placeholder="name@example.com">
                                              <label for="inputEmail">Email address</label>
                                          </div>
                                         </div>
                                         <div class="col-md-2">
                                         	<div class="form-floating mb-3 mb-md-0" align="center">
                                         	 <input class="btn btn-primary" id="emailBtn" type="button" value="중복체크" onClick="checkEmail()">
                                         	</div>
                                         </div>
                                         <span id="id_check_alert" style="color: red; font-weight: bold; font-size: 11px;"></span>
                                         <span id="id_alert" style="color: green; font-weight: bold; font-size: 11px;"></span>
                                        </div>
                                        <div class="row mb-3">
                                            <div class="col-md-6">
                                                <div class="form-floating mb-3 mb-md-0">
                                                    <input class="form-control" id="inputPw" name="pw" type="password" placeholder="Create a password">
                                                    <label for="inputPassword">Password</label>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-floating mb-3 mb-md-0">
                                                    <input class="form-control" id="inputPwConfirm" type="password" placeholder="Confirm password">
                                                    <label for="inputPasswordConfirm">Confirm Password</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-8 form-group">
                                        	<input class="form-check-input" id="inputGender" name="gender" value="남자" type="radio" placeholder="gender" checked>
                                            <label for="inputGender">남자</label>
                                        	<input class="form-check-input" id="inputGender" name="gender" value="여자" type="radio" placeholder="gender">
                                            <label for="inputGender">여자</label>
                                        </div>
                                        <br>
                                        <div class="form-floating mb-3">
                                        	<input type="date" id="birth" class="form-control" name="birthday" placeholder="Birth">
                                      	    <label for="birth">생년월일</label>
                                      	    <input type="hidden" name="birth" value="${hiredate}">                                            	
                                        </div>
                                                                                    <br>
                                        <div class="form-floating mb-3">
                                        	<input type="date" id="hiredate" class="form-control" name="hiredate" placeholder="hiredate">
                                      	    <label for="hiredate">입사일자</label>
                                      	    <input type="hidden" name="hiredate" value="${hiredate}">
                                        	
                                        </div>
                                        <div class="mt-4 mb-0" align="center">
                                            <input class="btn btn-primary btn-block" type="submit" value="계정생성" onClick="return checkRegister()"> 
                                        </div>
                                    </form>
                                </div>
                                <div class="card-footer text-center py-3">
                                    <div class="small"><a href="login.members">이미 계정이 있으신가요? 로그인하러 가기</a></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
        </div>
    </div>
</body>
	<!-- Footer-->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	<%-- ******* CUSTOM Script HERE ******* --%>
	<%@ include file="/WEB-INF/views/include/footer_script.jsp"%>
	<script type="text/javascript">
		let checkId = false;
		
		function checkEmail(){
			
			var input_id = $("#inputEmail").val();
			
			if(input_id == ""){
				$("#id_check_alert").html("Email을 입력하세요.");
				$("#inputEmail").focus();
				return false;
			}
			
			$.ajax({
				url : "idCheck.members",
				type : "POST",
				data : {"input_id" : input_id},
				dataType : "text",
				success : function(data){
					if(data == "Y"){
						$("#id_check_alert").empty();
						$("#id_alert").html("사용 가능한 Email입니다.");
						checkId = true;
					}else{
						$("#id_alert").empty();
						$("#id_check_alert").html("이미 사용중인 Email입니다.");
						$("#inputEmail").val("");
						$("#inputEmail").focus();
						checkId = false;
					}
				},
				error : function(){
					console.log("checkDuplicating error!");
				}
			});
		}
		
		
		function checkRegister(){
			
			if($("#inputName").val() == ""){
				alert("이름을 입력해 주세요.");
				$("#inputName").focus();
				return false;
			}
			
			if($("#inputPH").val() == ""){
				alert("전화번호를 입력해 주세요.");
				$("#inputPH").focus();
				return false;
			}
			if($("#inputEmail").val() == ""){
				alert("Email을 입력해 주세요.");
				$("#inputEmail").focus();
				return false;
			}
			if(checkId == false){
				alert("Email 중복체크는 필수입니다.");
				$("#emailBtn").focus();
				return false;
			}
			if($("#inputPw").val() == ""){
				alert("비밀번호를 입력해 주세요.");
				$("#inputPw").focus();
				return false;
			}
			if($("#inputPwConfirm").val() == ""){
				alert("확인 비밀번호를 입력해 주세요.");
				$("#inputPwConfirm").focus();
				return false;
			}
			if($("#inputPw").val() != $("#inputPwConfirm").val()){
				alert("비밀번호가 다릅니다.");
				$("#inputPwConfirm").focus();
				return false;
			}
			if($("#birth").val() == ""){
				alert("생일을 선택해 주세요.");
				$("#birth").focus();
				return false;
			}
			if($("#hiredate").val() == ""){
				alert("입사일자를 선택해 주세요.");
				$("#hiredate").focus();
				return false;
			}
			
		}
		
	</script>
	<%-- ******* CUSTOM Script END ******* --%>
</body>
</html>