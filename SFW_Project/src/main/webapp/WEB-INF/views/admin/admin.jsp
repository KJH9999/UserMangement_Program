<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ADMIN PAGE</h1>
	<hr>
	<br />

	<table border="1">
		<tr>
			<td>ID</td>
			<td>PW</td>
			<td>NAME</td>
			<td>NUMBER</td>
			<td>APPROVE</td>
		</tr>

		<c:forEach items="${userlist}" var="userlist">
			<tr>
				<td><a href="manageUser.do?id=${userlist.id}">
						${userlist.id}</a></td>
				<td>${userlist.pw}</td>
				<td>${userlist.name}</td>
				<td>${userlist.number}</td>
				<td>${userlist.approve}</td>
			</tr>
		</c:forEach>

	</table>
	<br/>
	<a href="home">UserPage</a>
</body>
</html>