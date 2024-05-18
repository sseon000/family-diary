<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Register</title>
	<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<body>
<h1>
	회원가입  
</h1>
<form action="register/add" method="post">
	<div class="col-md-8 form-group">
    	<input class="form-check-input" id="inputType1" name="type" value="정규직" type="radio" placeholder="type" checked>
        <label for="inputType1">정규직</label>
    	<input class="form-check-input" id="inputType2" nae="type" value="계약직" type="radio" placeholder="type">
        <label for="inputType2">계약직</label>
        <input class="form-check-input" id="inputType3" name="type" value="사업자" type="radio" placeholder="type">
        <label for="inputType3">사업자</label>
    </div>
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
<div class="card-footer text-center py-3">
    <div class="small"><a href="#">이미 계정이 있으신가요? 로그인하러 가기</a></div>
</div>
</body>
<script type="text/javascript">
	let checkId = false;
	checkId = true;
	
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
</html>
