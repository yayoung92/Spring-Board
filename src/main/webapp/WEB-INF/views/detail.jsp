<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	table {
		border-collapse:collapse;
	}
	table tr th {
		font-weight:700;
	}
	table tr td, table tr th {
		border:1px solid #818181;
		width:200px;
		text-align:center;
	}

</style>
<body>
	<h1>게시글 상세페이지</h1>
 
	<form action="/detail" name="board" method="post">
		<table>

			 <tr>
				<td>게시글 번호</td>
				<td>${board.bId}</td>
			</tr>
		
			<tr>
				<td>작성자</td>
				<td>${board.bWriter}</td>
			</tr>
			<tr>
				<td>제목</td>	
				<td>${board.bTitle}</td>
			</tr>

			<tr>
				<td>내용</td>
				<td>${board.bContent}</td>
			</tr>

			<tr>
				<td>날짜</td>	
				<td>${board.bDateTime}</td>
			</tr>
				
		</table>
		<a href="/list"><input type="button" value="돌아가기"></a>
		<a href="/update-view?bId=${board.bId }"><input type="button" value="수정"></a>
		<a href="/delete?bId=${board.bId }"><input type="button" value="삭제"></a>
		<a href="/reply-view?bId=${board.bId}"><input type="button" value="답글"></a>
	</form>
<body>

</body>
</html>