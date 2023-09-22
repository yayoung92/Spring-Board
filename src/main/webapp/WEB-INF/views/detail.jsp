<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
 	<sec:authorize access="isAuthenticated()">
 	<sec:authentication property="principal" var="user"/>
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
			<tr>
				<td>이미지</td>
				<td><img alt="${board.fName }" src="/img/${board.fName }"></td>
			</tr>				
		</table>
	<div>
		<a href="/list"><input type="button" value="돌아가기"></a>
		<c:choose>
			<c:when test="${board.bWriter eq user.username}">
				<a href="/delete?bId=${board.bId }"><input type="button" value="삭제"></a>
				<a href="/update-view?bId=${board.bId }"><input type="button" value="수정"></a>
			</c:when>
			<c:when test="${user.uLevel >= 5 }">
				<a href="/delete?bId=${board.bId }"><input type="button" value="삭제"></a>
			</c:when>
		
		</c:choose>
		<a href="/reply-view?bId=${board.bId }"><input type="button" value="답글"></a>
	</div>
	</form>
	<h2>댓글 목록</h2>
	<hr>
	<div id="commentList">
		<c:forEach items="${comment }" var="comment">
		<div class="commentList">
			${comment.cWriter }<br>
			${comment.cContent }<br>
			${comment.cDateTime }<br>
		</div>
		<div>
		<c:choose>
			<c:when test="${comment.cWriter eq user.username}">
				
				<button type="button" class="reUpdate">수정</button>
				<button type="button" class="reReDelete" cid="${comment.cId }" bid="${comment.bId }">삭제</button>
			</c:when>
			<c:when test="${user.uLevel >= 5 }">
				<button type="button" class="reReDelete" cid="${comment.cId }" bid="${comment.bId }">삭제</button>
			</c:when>
		</c:choose>
		<button type="button" class="reReply">대댓글</button>
		</div>
		<div style="display: none;">
			<textarea rows="2" cols="80"></textarea>
			<button type="button" class="reReInsert" cid="${comment.cId }" bid="${comment.bId }" cwriter="${user.username }">등록</button>
			<button type="button" class="reDelete">취소</button>
		</div>
		<div style="display: none;">
			<textarea rows="2" cols="80">${comment.cContent }</textarea>
			<button type="button" class="reReUpdate" cid="${comment.cId }" bid="${comment.bId }" >수정완료</button>
			<button type="button" class="reDelete">취소</button>
		</div>
		</c:forEach>
		<hr>
	</div>
	<h2>댓글 작성</h2>
	
	<form action="/insertComment" name="comment" method="post">
		<input type="hidden" name="bId" value="${board.bId}">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }">
			<div>작성자 : <input type="hidden" name="cWriter" value="${user.username}" readonly>${user.username}</div>
			<textarea rows="3" cols="40" name="cContent"></textarea>
			<input type="submit" value="댓글달기">
	</form>
	</sec:authorize>
<script>
$(document).on('click', '.reReply', function() {		//대댓글 창 열기
	$(this).parent().next().css('display', '');
});
$(document).on('click', '.reDelete', function() {		//대댓글 창 취소. 창 닫기
	$(this).parent().toggle();
});
$(document).on('click', '.reReInsert', function() {		//대댓글 ajax 넘기기
	let cIdx = $(this).attr('cid');
	let comment = $(this).prev("textarea").val();
	let bIdx = $(this).attr('bid');
	let cWri = $(this).attr('cwriter');
	let csrfToken = $("meta[name='_csrf']").attr("content");

	$.ajax({
		method: "POST",
		url: "aj-comment-reReply",
		headers: {
			"X-CSRF-TOKEN": csrfToken
		},
		data: { cId: cIdx, cContent: comment, bId: bIdx, cWriter: cWri}
	})
	.done(function(msg) {
		$('#commentList').html(msg);
	});
});
$(document).on('click', '.reReDelete', function() {		//대댓글, 댓글 삭제
	let cIdx = $(this).attr('cid');
	let bIdx = $(this).attr('bid');
	let csrfToken = $("meta[name='_csrf']").attr("content");

	$.ajax({
		method: "POST",
		url: "aj-comment-reDelete",
		headers: {
			"X-CSRF-TOKEN": csrfToken
		},
		data: { cId: cIdx, bId: bIdx }
	})
	.done(function(msg) {
		$('#commentList').html(msg);
	});
});
$(document).on('click', '.reUpdate', function() {		//수정 값 가져오기
	$(this).parent().next().next().css('display', '');
});
$(document).on('click', '.reReUpdate', function() {		//수정 값 넘기기
	let cIdx = $(this).attr('cid');
    let comment = $(this).prev().val();
    let bIdx = $(this).attr('bid');
    let csrfToken = $("meta[name='_csrf']").attr("content");

	$.ajax({
		method: "POST",
		url: "aj-comment-reUpdate",
		headers: {
			"X-CSRF-TOKEN": csrfToken
		},
		data: { cId: cIdx, cContent: comment, bId: bIdx}
	})
	.done(function(msg) {
		$('#commentList').html(msg);
	});
});
</script>
</body>
</html>