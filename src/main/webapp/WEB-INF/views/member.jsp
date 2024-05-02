<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	회원  
</h1>
<div>아이디 : ${member.memberId}</div>
<div>이름 : ${member.memberName}</div>
</body>
</html>
