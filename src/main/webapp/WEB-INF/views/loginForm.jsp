<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html lang="en"
	class="fontawesome-i2svg-active fontawesome-i2svg-complete">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<sec:csrfMetaTags />
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
  a {
  	text-decoration-line: none;
  }
}
</style>
<%-- ******* CUSTOM CSS Link END ******* --%>
</head>
<body id="page-top">
	<%@ include file="/WEB-INF/views/include/top.jsp"%>
	<header class="masthead">
			<div class="container">
			<div class="masthead-heading text-uppercase"></div><br><br><br><br>
			<div class="masthead-subheading"></div>
		</div>
	</header>
	<body>
		<div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-5">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Login</h3></div>
                                    <div class="card-body">
                                        <form id="loginInput">
                                            <div class="form-floating mb-3">
                                                <input class="form-control" id="inputEmail" name="id" type="email" placeholder="name@example.com">
                                                <label>Email address</label>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input class="form-control" id="inputPassword" name="pw" type="password" placeholder="Password">
                                                <label>Password</label>
                                            </div>
                                            <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
                                            <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
	                                            <div>
	                                                <a class="small" href="findId.members">아이디 찾기</a>
	                                                <a class="small" href="findPw.members">비밀번호 찾기</a> 
	                                            </div>
	                                            <div>
	                                            	<input class="btn btn-primary" id="submit" type="button" value="Login">
	                                            </div>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="card-footer text-center py-3">
                                        <div class="small"><a href="register.members">회원가입</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
	</body>
	<!-- Footer-->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	<%-- ******* CUSTOM Script HERE ******* --%>
	<%@ include file="/WEB-INF/views/include/footer_script.jsp"%>
	<script type="text/javascript">
	$(document).ready(function(){
		$("#submit").on("click",function(){
			
			if($("#inputEmail").val()==""){
				alert("email을 입력하세요.");
				$("#inputEmail").focus();
				return false;
			}
			if($("#inputPassword").val()==""){
				alert("Password를 입력하세요.");
				$("#inputPassword").focus();
				return false;
			}
			
			var param = $("#loginInput").serialize();
			var header = $("meta[name='_csrf_header']").attr("content");
			var token = $("meta[name='_csrf']").attr("content");
			
			$.ajax({
				url : "/login",
				type : "POST",
				data : param,
				beforeSend: function(xhr) {
					xhr.setRequestHeader(header, token);
				},
				success : function(data)
				{
					console.log('data : ' + data);
					if(data == "Yes"){
						alert('123');
						//location.href = "/main";
					}
					else if(data == "Acept"){
						alert("운영진의 회원가입승인(1~2일)을 기다려 주세요.");
						//location.href = "/main";
					}
					else{
						alert("Email과 비밀번호를 확인하세요.");  
						$("#inputEmail").focus();
						return false;
					}
				},
				error : function()
				{
					console.log("checkDuplicating error!");
				}
			});
		});
	});
	</script>
	<%-- ******* CUSTOM Script END ******* --%>
</body>
</html>