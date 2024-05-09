<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Register</title>
</head>
<body>
<h1>
	회원가입  
</h1>
<form action="register/add" method="post">
	id : <input type="text" name="memberId" />
	이름 : <input type="text" name="memberName" />
	<button type="submit">전송</button>
</form>
</body>
</html>
