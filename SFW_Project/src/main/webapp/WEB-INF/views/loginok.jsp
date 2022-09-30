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
	
	Object s_email = session.getAttribute("id");
	String id = (String) s_email;
	out.println("Session : " + id);
	%>
	<br />
<%-- 	<c:forEach var="userlist" items="${userlist}">

			Name : ${userlist.name}
			Number : ${userlist.number}

		<br />
	</c:forEach> --%>
	<br /><br />
		<a href="updatePage">Modify</a> &nbsp;&nbsp;&nbsp;

		<a href="logout">Logout</a>

</body>
</html>