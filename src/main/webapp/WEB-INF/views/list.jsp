<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
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
	<h1>�Խ���</h1>
	<table style="text-align:center;">
		<col width="50px">
		<col width="150px">
		<col width="200px">
		<col width="50px">
		<col width="100px">
		<col width="100px">
      	<tr>
      		<td style="background-color:#eeeeee; text-align:center;">��ȣ</td>
      		<td style="background-color:#eeeeee; text-align:center;">����</td>
      		<td style="background-color:#eeeeee; text-align:center;">����</td>
      		<td style="background-color:#eeeeee; text-align:center;">��ȸ��</td>
      		<td style="background-color:#eeeeee; text-align:center;">�ۼ���</td>
      		<td style="background-color:#eeeeee; text-align:center;">��¥</td>
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
      <a class="custom-button" href="insert-view" role="button">�۾���</a>
      <a class="custom-button" href="/" role="button">home</a>
    </div>
</body>
</html>