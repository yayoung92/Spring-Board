<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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