<%@page import="com.sample.FirstClass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="f1" class="com.sample.FirstClass"></jsp:useBean>

	<%
		out.println(f1.getName());
	%>




</body>
</html>