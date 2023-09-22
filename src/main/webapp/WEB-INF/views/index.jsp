<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>Home Page</h1>
		<hr>
		<div>
		  <sec:authorize access="isAnonymous()">
			<a href="/login">로그인</a>
			<a href="/beforeSignUp">회원가입</a>
		  </sec:authorize>
		</div>
		<div>
		  <sec:authorize access="isAuthenticated()">        
            <a href="/logout">로그아웃</a>
            <sec:authentication property="principal" var="principal"/>
            <h2>${principal }</h2>
          </sec:authorize>
		</div>
		<div>
		  <sec:authorize access="isAuthenticated()">
		  	<sec:authentication property="principal" var="principal"/>  
		  	<a href="/user/info">내 정보</a>
		  	<a href="/admin">관리자</a>
		  	<a href="/insert-view">게시글 작성</a>
		  	<a href="/list">게시글 리스트</a>
		  	 <c:choose>
               <c:when test="${principal.uLevel >= 5 }">
               		<a href="/u_list">회원 리스트</a>
               </c:when>
             </c:choose>
		  </sec:authorize>
		</div>
</body>
</html>