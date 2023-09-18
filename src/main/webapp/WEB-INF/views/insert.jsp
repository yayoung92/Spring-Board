<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시글 작성</h2>
	<sec:authorize access="isAuthenticated()">  
	<form action="/insertBoard" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }">
		<table>
			<tr>
				<td>제목 </td>
				<td><input type="text" name="bTitle" placeholder="제목를 입력해주세요."></td>
			</tr>
			<tr>
				<td>내용 </td>
				<td><textarea rows="5" cols="50" name="bContent" placeholder="내용을 입력해주세요."></textarea>
			</td>
			</tr>
		 	<tr>
		 		<sec:authentication property="principal" var="principal"/>
		 		<td>작성자 : </td>
				<td><input type="hidden" name="bWriter" value="${principal.username}" readonly>${principal.username}</td>
			</tr>
		</table>
		<button type="submit">작성완료</button>
		<a href="/list"><input type="button" value="취소"></a>
	</form>
	</sec:authorize>
</body>
</html>