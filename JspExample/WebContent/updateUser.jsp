<%@page import="com.sample.HibernateUtil"%>
<%@page import="com.sample.User"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="org.hibernate.Session"%>
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
		int uid = Integer.parseInt(request.getParameter("uid"));

		Session s = HibernateUtil.getSessionFactory().openSession();
	
		User user = s.load(User.class, uid);

	%>


	<form method="post" action="updateUser">


		Username:<br> <input type="text" name="user"
			value="<%=user.getUsername()%>"> <br>
		<br> Password: <br> <input type="password" name="pass"
			value="<%=user.getPassword()%>"> <br>
		<br> Full Name: <br> <input type="text" name="fullName"
			value="<%=user.getFullName()%>"> <br>
		<br>


		<button type="submit">Next -></button>

		<input type="hidden" name="uid" value="<%=uid%>">




	</form>




</body>
</html>