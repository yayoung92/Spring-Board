<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>ȸ�� ����</h1>
		<hr>
		<form action="/signup" method="post">
		<!-- csrf -->
			<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
			<input type="text" name="username" placeholder="id �Է�">
			<input type="text" name="uName" placeholder="name �Է�">
			<input type="password" name="password" placeholder="password �Է�">
			<button type="submit">�����ϱ�</button>
		</form>
</body>
</html>