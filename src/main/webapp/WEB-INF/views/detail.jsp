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
	회원수정  
</h1>
<form id="modificationInput" action="member/detail" method="post">
	<input type="hidden" name="num" value="${member.num }">
	<input type="hidden" name="type" value="${member.type }">
	<input type="hidden" name="id" value="${member.id }">
	<input type="hidden" name="whatColumn" value="${whatColumn}">
	<input type="hidden" name="keyword" value="${keyword }">
	<div class="row mb-3">
	    <div class="col-md-12">
	     <div class="form-floating mb-3 mb-md-0">
	     	<font style="font-weight: bold;">Email address(ID) : ${member.id }(${member.type})</font>
	     </div>
	    </div>
	   </div>
	   <br>
	   <div class="row mb-3">
	       <div class="col-md-6">
	           <div class="form-floating mb-3 mb-md-0">
	               <input class="form-control" id="inputName" type="text" name="name" value="${member.name }" placeholder="Enter your first name">
	               <label for="inputName"> Name</label>
	           </div>
	       </div>
	       <div class="col-md-6">
	           <div class="form-floating mb-3 mb-md-0">
	               <input class="form-control" id="inputName" type="text" name="acept" value="${member.acept }" placeholder="">
	               <label for="inputName"> 승인상태</label>
	           </div>
	       </div>
	   </div>
	   <div class="form-floating mb-3">
	       <input class="form-control" id="inputPH" type="text" name="ph" value="${member.ph }" placeholder="ph">
	       <label for="inputPH">PhonNumber</label>
	   </div>
	
	   <div class="col-md-8 form-group">
	   	<input class="form-check-input" id="inputGender" name="gender" value="남자" type="radio" placeholder="gender" <c:if test="${member.gender=='남자'}">checked</c:if>>
	       <label for="inputGender">남자</label>
	   	<input class="form-check-input" id="inputGender" name="gender" value="여자" type="radio" placeholder="gender" <c:if test="${member.gender=='여자'}">checked</c:if>>
	       <label for="inputGender">여자</label>
	   </div>
	   <br>
	   <div class="form-floating mb-3">
	   	<fmt:parseDate var="fmtDate" value="${member.birthday}" pattern="yyyy-MM-dd"/>
	<fmt:formatDate var="regDate" value="${fmtDate}" pattern="yyyy-MM-dd"/>
	   	<input type="date" id="birth" class="form-control" name="birthday" value="${regDate }" placeholder="Birth">
	   </div>
	   
	   <div class="form-floating mb-3">
	   	<fmt:parseDate var="fmtDate" value="${hiredate}" pattern="yyyy-MM-dd"/>
		<fmt:formatDate var="regDate" value="${fmtDate}" pattern="yyyy-MM-dd"/>
	   	<input type="date" id="hiredate" class="form-control" name="hiredate" value="${regDate }" placeholder="hiredate">
	   </div>
	   <div class="mt-4 mb-0" align="center">
	       <input class="btn btn-primary btn-block" type="submit" value="수정하기" > 
	       <input class="btn btn-primary btn-block" type="button" id="aceptBtn" value="승인상태 변경" onClick="location.href='acept.admin?num=${member.num}&acept=${member.acept }'">
	<input class="btn btn-primary btn-block" type="button" value="삭제" onClick="location.href='deletmember.admin?num=${member.num}'">
	<input class="btn btn-primary btn-block" type="button" value="취소" onClick="history.back()"> 
	    </div>
	</form>
</body>
<script type="text/javascript">
function checkRegister(){
	if($("#inputName").val() == ""){
		alert("이름을 입력해 주세요.");
		$("#inputName").focus();
		return false;
	}
	if($("#inputAge").val() == ""){
		alert("나이를 입력해 주세요.");
		$("#inputAge").focus();
		return false;
	}
	if($("#inputEmail").val() == ""){
		alert("Email을 입력해 주세요.");
		$("#inputEmail").focus();
		return false;
	}
	if($("#inputPh").val() == ""){
		alert("전화번호를 입력해 주세요.");
		$("#inputPh").focus();
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
}
</script>
</html>
