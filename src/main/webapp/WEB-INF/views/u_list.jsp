<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<meta name="_csrf" content="${_csrf.token }">
</head>
<style>
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
			border:1px solid #818181;
			width:200px;
			text-align:center;
		}
		a {
			text-decoration:none;
			color:#000;
			font-weight:700;
		}
</style>
<body>
<h1>회원 목록</h1>
<sec:authorize access="isAuthenticated()">
 <sec:authentication property="principal" var="principal"/>
	<div style="text-align: center;" class="userLevelDiv">

		<c:if test="${principal.uLevel >= 5 }">
			<button type="button" class="userLevel">레벨 설정</button>
		</c:if>
	</div>
	<div id="userLevelName">
	<table>
		<tr>
			<td colspan="4">전체 회원 수 : ${pagination.count}</td>
		<tr>
			<th>ID</th>
			<th>이름</th>
			<th>등급</th>
		</tr>
		<c:forEach items="${list}" var="user" varStatus="status" >
			<tr>
				<td>${user.username}</td>
				<td>${user.uName }</td>
				<td>${user.uLevelname }</td>
			</tr>
		</c:forEach>
	</table>
</div>
	<div style="text-align: center;">
		<a href="/list" ><input type="button" value="게시판 목록"></a>
		<a href="/"><input type="button" value="home"></a>
	</div>
<!-- 아래부터 pagination -->
	<div>
		<ul>
			<c:choose>
				<c:when test="${pagination.page > 5 }">
					<li><a href="/u_list?page=${pagination.prevPage}">◀</a></li>
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
						<li><a href="/u_list?page=${i}">${i}</a></li>
					</c:when>
				</c:choose>
			</c:forEach>
			<c:choose>
				<c:when test="${pagination.page <= pagination.endPage && pagination.page < pagination.lastPage}">
					<li><a href="/u_list?page=${pagination.nextPage}">▶</a></li>
				</c:when>
			</c:choose>
		</ul>
	</div>
</sec:authorize>
<script>
$(document).on('click', '.userLevel', function() {
	let targetUserId = prompt("레벨을 설정할 사용자의 ID를 입력하세요:", "");
	let newLevel = prompt("새로운 회원 등급을 입력하세요:", "");
	let csrfToken = $("meta[name='_csrf']").attr("content");
	
	$.ajax({
		method: "POST",
		url: "aj-user-level",
		headers: {
			"X-CSRF-TOKEN": csrfToken
		},
		data: { uLevel: newLevel, username: targetUserId }
	 })
	 	.done(function(msg) {
	 $('#userLevelName').html(msg);
	 });
});
</script>

</body>
</html>