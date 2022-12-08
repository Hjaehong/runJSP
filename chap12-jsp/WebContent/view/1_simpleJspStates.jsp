<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- HTML 주석 : 개발자도구 탭에 노출됨(클라이언트에게 전달됨)-->
	<%-- JSP 주석 : 개발자도구 탭에 노출안됨(클라이언트에게 전달안됨) --%>
	<%!
	private String name;
	private int age;
	%>
	<%
	name = "홍길동";
	age = 20;

	System.out.println("name : " + name);
	System.out.println("age : " + age);
	
	for(int i = 0; i < name.length(); i++) {
  		System.out.println(name.charAt(i));
  	}
	%>
	
	name : <%= name %><br>
	age : <%= age %><br> 
</body>
</html>