<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%=request.getAttribute("name")%>님 환영합니다.
	</h1>
	<h3 align="right"><%=request.getParameter("name")%>님 환영합니다.
	</h3>
	<h3 align="right">${param.name}님환영합니다.</h3>

	<h2>jsp:useBean 활용하기</h2>
	<%-- <%
	com.uni.model.dto.MemberDTO m = new com.uni.model.dto.MemberDTO();
	m.setName("유재석");
	m.setAge(20);
	m.setPhone("010-1234-5678");
	m.setEmail("kjh@kh.or.kr");
	%>

	이름 :
	<%=m.getName()%><br> 나이 :
	<%=m.getAge()%><br> 전화번호 :
	<%=m.getPhone()%><br> 이메일 :
	<%=m.getEmail()%><br>--%>
	
	<jsp:useBean id="member" class="com.uni.model.dto.MemberDTO" scope="page"/>
	<jsp:setProperty property="name" name="member" value="홍길동"/>
	<%-- <jsp:setProperty property="age" name="member" value="홍길동"/> --%>
	<jsp:setProperty property="age" name="member" value="20"/><!--  int 상관없이 스트링 타입  -->
	<jsp:setProperty property="phone" name="member" value="010-1234-5678"/>
	<jsp:setProperty property="email" name="member" value="hong@greedy.com"/>
	
	이름 : <jsp:getProperty property="name" name="member"/> <br>
	나이 : <jsp:getProperty property="age" name="member"/> <br>
	전화번호 : <jsp:getProperty property="phone" name="member"/> <br>
	이메일 : <jsp:getProperty property="email" name="member"/> <br>
</body> 
</html>