<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>�α���</h1>
		<form action="/loginPro" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }">
			<input type="text" name="username" placeholder="id�� �Է����ּ���.">
			<input type="password" name="password" placeholder="password�� �Է����ּ���.">
			<input id="remember_me" name="remember-me" type="checkbox"/>Remember me
			<button type="submit">�α���</button>
		</form>
</body>
</html>