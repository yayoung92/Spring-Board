<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>���� ������</h1>
	<hr>
		<div>
			<sec:authorize access="isAuthenticated()">
				<sec:authentication property="principal" var="principal"/>
				<h2>${principal }</h2>
			</sec:authorize>
			<a href="/">���ư���</a>
		</div>
</body>
</html>