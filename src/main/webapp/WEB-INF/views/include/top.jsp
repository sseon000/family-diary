<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tagLib.jsp"%>
<nav class="navbar navbar-expand-md navbar-dark fixed-top" id="mainNav">
	<div class="container">
		<div class="col-xs-2">
			<a href="/"> 
				<img style="width: 35%;height: 100%;" src="${pageContext.request.contextPath}/assets/img/DBintechLogo_black.png" alt="...">
			</a>
		</div>	
		<div class="navbar-collapse">			 
			<ul class="navbar-nav text-uppercase ms-auto">
					<li class="nav-item"><a class="nav-link" href="/">소개</a></li>
					<li class="nav-item"><a class="nav-link" href="businessArea.dbinfo">Service</a></li>
					<li class="nav-item"><a class="nav-link" href="project.project">PROJECT</a></li> 
					<li class="nav-item"><a class="nav-link" href="communityNotice.dbinfo">NOTICE</a></li>
					<li class="nav-item"><a class="nav-link" href="recruit.dbinfo">RECRUIT</a></li>
				<c:if test="${not empty loginInfo}">
					<li class="nav-item"><a class="nav-link" href="preprocessing.data">DATA</a></li>
				</c:if>
				<c:if test="${empty loginInfo }">
					<li class="nav-item"><a class="nav-link" href="/login">로그인</a></li>
					<li class="nav-item"><a class="nav-link" href="/member">회원가입</a></li>
				</c:if>
				<c:if test="${not empty loginInfo}">
					<c:if test="${loginInfo.type ne '운영자'}">
						<li class="nav-item"><a class="nav-link" href="myPage.members">마이 페이지</a></li>
					</c:if>
						<li class="nav-item nav-link" style="color: #ffc800;">${loginInfo.name }님</li>
				</c:if>
				<c:if test="${loginInfo.type eq '운영자'}">
					<li class="nav-item"><a class="nav-link" href="management.admin">MANEGEMENT</a></li>
				</c:if>
				<c:if test="${not empty loginInfo}">
					<li class="nav-item"><a class="nav-link" href="logout.jsp">LOGOUT</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</nav>