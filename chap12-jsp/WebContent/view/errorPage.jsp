<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String exceptionType = exception.getClass().getName();
		String exceptionMessage = exception.getMessage();
	%>
	
	<h1 align="center"><%= exceptionType %></h1>
	<h3 align="center"><%= exceptionMessage %></h3>
	<button onclick = "history.back()">이전페이지로</button>
	<!-- https://developer.mozilla.org/ko/docs/Web/API/History/back -->
</body>
</html>