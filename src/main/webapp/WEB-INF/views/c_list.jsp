<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>  
<sec:authorize access="isAuthenticated()">
 <sec:authentication property="principal" var="user"/>
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
			<button type="button" class="reReUpdate" cid="${comment.cId }" bid="${comment.bId }">수정완료</button>
			<button type="button" class="reDelete">취소</button>
		</div>
		</c:forEach>
		<hr>
		
</sec:authorize>