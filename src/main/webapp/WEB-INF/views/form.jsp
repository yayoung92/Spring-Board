<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="form">
	<h1>설문조사</h1>
	<input type="text" placeholder="설문지 설명">
	
	<div class="q">
		<p>질문 제목</p>
		<select class="q_type">
			<option value="none">== 선택 ==</option>
			<option value="1">주관식</option>
			<option value="2">객관식</option>
			<option value="3">단답형</option>
			<option value="4">장문형</option>
		</select>
		<input type="text" value="" class="q_title">
	</div>
	
</div>
</body>
</html>