<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Login Success</h1>
<hr>
<br>
	<%
	
	Object s_id = session.getAttribute("id");
	String id = (String) s_id;
	out.println("Session : " + id);
	%>
	<br />
	<c:forEach var="userlist" items="${userlist}">
			Name : ${userlist.name}
			Number : ${userlist.number}
	</c:forEach>
	<br /><br />
		<a href="myInformation.do?id=${id}">MyInformation</a>&nbsp;&nbsp;&nbsp;
		<a href="updatePw">updatePw</a>&nbsp;&nbsp;&nbsp;
		<a href="updateName">updateName</a>&nbsp;&nbsp;&nbsp;
		<a href="updateNumber">updateNumberw</a>&nbsp;&nbsp;&nbsp;
		<a href="deleteUser.do?id=${id}">DeleteUser</a>
		<br/>

		<a href="logout">Logout</a>

</body>
</html>