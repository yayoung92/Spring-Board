<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
	<h2>게시글 작성</h2>
	<sec:authorize access="isAuthenticated()">  
	<form action="/insertBoard" method="post" enctype="multipart/form-data">
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
			<tr>
				<td>첨부파일: </td>
				<td><input type="file" name="files" multiple></td>
			</tr>
		</table>
		<div>
			<button type="button" class="addFile">파일 추가</button>
		</div>
		<button type="submit">작성완료</button>
		<a href="/list"><input type="button" value="취소"></a>
	</form>
	</sec:authorize>
<script>
$(document).on('click', '.addFile', function() {
	const fileInput = document.createElement("input");
    fileInput.type = "file";
    fileInput.name = "files";
    fileInput.multiple = true;
    
    const form = document.querySelector("form");
    form.insertBefore(fileInput, form.lastElementChild);
});
</script>
</body>
</html>