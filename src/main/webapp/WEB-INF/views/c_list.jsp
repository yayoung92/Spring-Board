<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${comment }" var="comment">
		<div class="commentList">
			${comment.cWriter }<br>
			${comment.cContent }<br>
			${comment.cDateTime }<br>
		</div>
		<div>
			<button type="button" class="reReply">대댓글</button>
		<!--  	<form action="deleteComment" method="post">
				<input type="hidden" name="bId" value="${comment.bId }">
				<input type="hidden" name="cId" value="${comment.cId }">
				<input type="submit" value="삭제하기"></form> -->
				<button type="button" class="reUpdate">수정</button>
				<button type="button" class="reReDelete" cid="${comment.cId }" bid="${comment.bId }">삭제</button>
			
		</div>
		<div style="display: none;">
			<textarea rows="2" cols="80"></textarea>
			<button type="button" class="reReInsert" cid="${comment.cId }" bid="${comment.bId }" cwriter="${principal.username }">등록</button>
			<button type="button" class="reDelete">취소</button>
		</div>
		<div style="display: none;">
			<textarea rows="2" cols="80">${comment.cContent }</textarea>
			<button type="button" class="reUpdate" cid="${comment.cId }" bid="${comment.bId }">수정완료</button>
			<button type="button" class="reDelete">취소</button>
		</div>
		</c:forEach>