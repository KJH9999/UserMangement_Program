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
	<c:forEach var="userlist" items="${userlist}">

			Name : ${userlist.name}
			Number : ${userlist.number}

		<br />
	</c:forEach>
	<br />

	<form method="post">
		PW : <input type="password" id="pw"><br /> PW Check : <input
			type="password" id="pw2"> <input type="button"
			onclick="updatePwCk()" value="UpdatePW">
	</form>

	<script type="text/javascript">
		function updatePwCk() {
			var p1 = document.getElementById('pw').value;
			var p2 = document.getElementById('pw2').value;

			if (p1 != p2) {
				alert("비밀번호불일치");
				return false;
			} else {
				$.ajax({
					url : "http://localhost:8080/ex/updatePwOk",
					type : 'post',
					data : {
						id : <%=id%>,
						pw : p1,
					},
					success : function(data) {
								
				     },
					error : function() {
						alert("error");
					}
				});
			}
		}
	</script>


	<a href="loginok">updateNumber</a>
	<a href="logout">Logout</a>

</body>
</html>