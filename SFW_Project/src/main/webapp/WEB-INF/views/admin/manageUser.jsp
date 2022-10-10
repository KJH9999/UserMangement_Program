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
			ID : ${manageUser.id} &nbsp;&nbsp;&nbsp;
		<br />
		<br />
		<form action="approveOk" method="get">
			<input type="hidden" name="id" value="${manageUser.id}">
			Approve : ${manageUser.approve}&nbsp;&nbsp;&nbsp;<input type="submit"
				value="Approve">
		</form>

		<br />
		<form action="AupdatePwOk" method="post">
			Password : ${manageUser.pw}&nbsp;&nbsp;&nbsp; <input type="hidden"
				name="id" value="${manageUser.id}"><input type="text"
				name="pw"><input type="submit" value="UpdatePW">
		</form>
		<br />

		<form action="AupdateNameOk" method="get">
			Name : ${manageUser.name} &nbsp;&nbsp;&nbsp; <input type="hidden"
				name="id" value="${manageUser.id}"><input type="text"
				name="name"><input type="submit" value="UpdateName">
		</form>
		<br />

		<form action="AupdateNumberOk" method="get">
			Number : ${manageUser.number}&nbsp;&nbsp;&nbsp; <input type="hidden"
				name="id" value="${manageUser.id}"><input type="text"
				name="number"><input type="submit" value="UpdateNuber">
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