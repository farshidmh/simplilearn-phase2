<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%!int a = 10;%>


	<form method="post" action="form.jsp">
		<input type="text" name="inp" value="<%=a%>"> <br>
		<button type="submit">Click</button>
	</form>

	<hr>



	<form method="post" action="numbers.jsp">
		<input type="text" name="a"> <br> <input type="text"
			name="b"> <br>
		<button type="submit">Draw</button>
	</form>
	<hr>
	
	
	<a href="beans.jsp"> Object Using Beans!  </a>





</body>
</html>