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
		String userName = request.getParameter("user");
		String password = request.getParameter("pass");
		String fullName = request.getParameter("fullName");
	%>




	<form method="post" action="newUser">


		Username:<br> <input type="text" name="user"
			value="<%=userName%>" readonly="readonly"> <br> <br>
		Password: <br> <input type="password" name="pass"
			value="<%=password%>" readonly="readonly"> <br> <br>
		Full Name: <br> <input type="text" name="fullName"
			value="<%=fullName%>" readonly="readonly"> <br> <br>


		<button type="submit">Next -> </button>

		<br> <a href="newUser.jsp"> <- Back </a>


	</form>




</body>
</html>