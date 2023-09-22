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
			<a href="/login">�α���</a>
			<a href="/beforeSignUp">ȸ������</a>
		  </sec:authorize>
		</div>
		<div>
		  <sec:authorize access="isAuthenticated()">        
            <a href="/logout">�α׾ƿ�</a>
            <sec:authentication property="principal" var="principal"/>
            <h2>${principal }</h2>
          </sec:authorize>
		</div>
		<div>
		  <sec:authorize access="isAuthenticated()">
		  	<sec:authentication property="principal" var="principal"/>  
		  	<a href="/user/info">�� ����</a>
		  	<a href="/admin">������</a>
		  	<a href="/insert-view">�Խñ� �ۼ�</a>
		  	<a href="/list">�Խñ� ����Ʈ</a>
		  	 <c:choose>
               <c:when test="${principal.uLevel >= 5 }">
               		<a href="/u_list">ȸ�� ����Ʈ</a>
               </c:when>
             </c:choose>
		  </sec:authorize>
		</div>
</body>
</html>