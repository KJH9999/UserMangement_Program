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
	<h1>ADMIN PAGE_ModifyUser</h1>
	<hr>
	<br />
	<c:forEach var="manageUser" items="${manageUser}">
			ID : ${manageUser.id}	
		<br />
		<br />
			Password : ${manageUser.pw} <form action="AupdatePwOk" method="post">
			<input type="hidden" name="id" value="${manageUser.id}"><input
				type="text" name="pw"><input type="submit" value="UpdatePW">
		</form>
		<br />
			Name : ${manageUser.name} 
			<form action="AupdateNameOk" method="get">
			<input type="hidden" name="id" value="${manageUser.id}"><input
				type="text" name="name"><input type="submit"
				value="UpdateName">
		</form>
		<br />
			Number : ${manageUser.number}
			<form action="AupdateNumberOk" method="get">
			<input type="hidden" name="id" value="${manageUser.id}"><input
				type="text" name="number"><input type="submit"
				value="UpdateNuber">
		</form>
		<br />
		<a href="AdeleteUser.do?id=${manageUser.id}">DeleteUser</a>
		<br />
		<br />
	</c:forEach>
	<a href="admin">AdminPage</a>&nbsp;&nbsp;&nbsp;
	<a href="home">UserPage</a>
</body>
</html>