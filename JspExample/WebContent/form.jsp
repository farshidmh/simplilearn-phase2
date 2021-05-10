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

	<%
		FirstClass f = new FirstClass("Jane");

		out.println("Hello World Using Java");

		int a = Integer.parseInt(request.getParameter("inp"));

		out.println("<br>");
		if (a >= 20) {
			out.println("This is another Java code");
		}
	%>

	<hr>



	<%=f.getName()%>


</body>
</html>