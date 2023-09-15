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
	<h3>답글 달기</h3>
	<sec:authorize access="isAuthenticated()">
	<form action="reBoard" name="board" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }">
		<input type="hidden" name="bId" value="${bId}">
		<input type="hidden" name="bGroup" value="${board.bGroup}">
		<table>
			<tr>
				<td>제목 </td>
					<td><input type="text" name="bTitle" value="[답변]" size="60"></td>
				</tr>
			<tr>
				<td>내용 </td>
				<td><textarea rows="5" cols="50" name="bContent"></textarea>
			</td>
			</tr>
		  	<tr>
		  		<sec:authentication property="principal" var="principal"/>
		 		<td>작성자 </td>
		 	  	<td><input type="hidden" name="bWriter" value="${principal.username}" readonly>${principal.username}</td>
			</tr>
			 
		</table>
	
		<input type="submit" value="글등록">
	</form>
	</sec:authorize>
</body>
</html>