<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="sign_up_ok" method="post">
	
		ID:	<input type="text" name="id" id="id" size="10"
				class="form-control" /> <input type="button" id="btnCheck"
				value="중복확인"> <span id="result"></span>
		 <br/>
		PW : <input type="password" name="pw" size="10"> <br/>
		NAME : <input type="text" name="name" size="10"> <br/>
		NUMBER : <input type="text" name="number" size="10"> <br/>

	<input type="submit" value="Sign_up"> <input type="reset" value="Reset">
</form>
<br/>
<a href="home">Home</a>

	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.4.1.js">
		</script>
	<script>
		$('#btnCheck').click(function() {
			if ($('#id').val() != '') {
				// 아이디를 서버로 전송 > DB 유효성 검사 > 결과 반환받기
				$.ajax({
					type : 'GET',
					url : 'http://localhost:8080/ex/idCk?id='+$('#id').val(),
					success : function(result) {
						if (result == '0') {
							$('#result').text('사용 가능한 아이디입니다.');
						} else {
							$('#result').text('이미 사용중인 아이디입니다.');
						}
					},
					error : function(a, b, c) {
						console.log(a, b, c);
					}
				});
			} else {
				alert('id을 입력하세요.');
				$('#id').focus();
			}
		});
	</script>


</body>
</html>