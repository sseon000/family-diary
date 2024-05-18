<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>List</title>
	<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<body>
<h1>
	회원목록 
</h1>
<table class="table">
	<tr>
		<th>num</th>
		<th>이름</th>
		<th>email</th>
		<th>입사 일자</th>
		<th>고용 형태</th>
		<th>승인 상태</th>
	</tr>
	<c:if test="${empty aceptList}">
		<tr>
			<th colspan="5">
				회원승인 대기자가 없습니다.
			<th>
		</tr>
	</c:if>
	<c:forEach var="list" items="${list}" varStatus="vs">
		<form action='/member/detail' method="POST">
			<input type="hidden" name="id" value="${list.id}"/>
			<input type="submit" id="${list.name}" style="display: none;"/>
			<tr onClick="onModifyPageMove('${list.name}')" style="cursor: pointer">
				<!-- <td align="center">${pageInfo.totalCount - ((pageInfo.pageNumber-1) * pageInfo.pageSize) - vs.count + 1}</td>  -->
				<td>${list.name}</td>	
				<td>${list.id}</td>
				<td>${list.hiredate}</td>
				<td>${list.type}</td>
				<td>${list.acept}</td>
			</tr>
		</form>
	</c:forEach>
</table>
</body>
<script type="text/javascript">

	function onModifyPageMove(el) {
		let d= "#"+el
		$(d).click()
	}

</script>
</html>
