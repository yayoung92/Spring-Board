<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>게시글 수정</h2>
	  <form action="/updateBoard" name="board" method="post">
		<input type="hidden" name="bId" value="${board.bId}">
	   		<p> 제목 : <input type="text" name="bTitle" value="${board.bTitle}"></p>
	   		<p> 내용 : <textarea rows="5" cols="50" name="bContent">${board.bContent}</textarea></p>
	   		<p> 작성자 : <input type="hidden" name="bWriter" value="${board.bWriter}" readonly>${board.bWriter}</p>
	   		<p> <input type="submit" value="수정완료"></p>
      </form>
</body>
</html>