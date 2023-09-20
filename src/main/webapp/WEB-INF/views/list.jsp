<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<style>
	h1 {
		text-align:center;
	}
	table {
		border-collapse:collapse;
		margin:40px auto;
	}
	table tr th {
		font-weight:700;
	}
	table tr td, table tr th {
		border:0.5px solid #818181;
		text-align:center;
	}
	a {
		text-decoration:none;
		color:#000;
		font-weight:700;
		border:none;
		cursor:pointer;
		padding:10px;
		display:inline-block;
	}
	
	ul {
		width:600px;
		height:50px;
		margin:10px auto;
	}
	li {
		list-style:none;
		width:50px;
		line-height:50px;
		border:1px solid #ededed;
		float:left;
		text-align:center;
		margin:0 5px;
		border-radius:5px;
	} 
	.button-container {
		text-align: center;
	}
	.custom-button {
		padding: 10px 10px;
		background-color: #007bff;
		color: #fff;
      	border: none;
      	border-radius: 3px;
      	cursor: pointer;
	}
	
	
</style>
<body>
	<h1>게시판</h1>
	<div style="text-align:center;">
		<form action="/list" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			<select name="keyWord">
				<option value="none">== 선택 ==</option>
				<option value="title">제목</option>
				<option value="tc">제목+내용</option>
				<option value="content">내용</option>
				<option value="writer">작성자</option>
			</select>
			<input type="text" placeholder="검색어 입력" name="search">
			<input type="submit" value="검색">
		</form>
	</div>
	<table style="text-align:center;">
		<col width="50px">
		<col width="150px">
		<col width="200px">
		<col width="50px">
		<col width="100px">
		<col width="100px">
      	<tr>
      		<td style="background-color:#eeeeee; text-align:center;">번호</td>
      		<td style="background-color:#eeeeee; text-align:center;">제목</td>
      		<td style="background-color:#eeeeee; text-align:center;">내용</td>
      		<td style="background-color:#eeeeee; text-align:center;">조회수</td>
      		<td style="background-color:#eeeeee; text-align:center;">작성자</td>
      		<td style="background-color:#eeeeee; text-align:center;">날짜</td>
      	</tr>
      	<c:forEach var="list" items="${list }">
	      	<tr>
	      		<td><a href="/detail?bId=${list.bId }">${list.bId}</a></td>
	      		<td>${list.bTitle }</td>
	      		<td>${list.bContent }</td>
	      		<td>${list.bView }</td>
	      		<td>${list.bWriter }</td>
	      		<td>${list.bDateTime }</td>
	      	</tr>
      	</c:forEach>
    </table>
    <div class="button-container">
      <a class="custom-button" href="insert-view" role="button">글쓰기</a>
      <a class="custom-button" href="/" role="button">home</a>
    </div>
    <div>
		<ul>
			<c:choose>
				<c:when test="${pagination.page > 5 }">
					<li><a href="/list?page=${pagination.prevPage}&keyWord=${param.keyWord}&search=${param.search}">◀</a></li>
				</c:when>
			</c:choose>
			<c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">
				<c:choose>
					<c:when test="${pagination.page == i }">
						<li style="background-color:#ededed;">
							<span>${i}</span>
						</li>
					</c:when>
					<c:when test="${pagination.page != i }">
						<li><a href="/list?page=${i}&keyWord=${param.keyWord}&search=${param.search}">${i}</a></li>
					</c:when>
				</c:choose>
			</c:forEach>
			<c:choose>
				<c:when test="${pagination.page < pagination.lastPage}">
					<li><a href="/list?page=${pagination.nextPage}&keyWord=${param.keyWord}&search=${param.search}">▶</a></li>
				</c:when>
			</c:choose>
		</ul>
	</div>
<script>
$(".pageInfo a").on("click", function(e){
	e.preventDefault();
	moveForm.find("input[name='pageNum']").val($(this).attr("href"));
	moveForm.attr("action", "/list");
	moveForm.submit();
	
});	
</script>
</body>
</html>