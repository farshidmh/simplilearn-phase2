<%@page import="com.sample.User"%>
<%@page import="java.util.List"%>
<%@page import="com.sample.HibernateUtil"%>
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


<a href="newUser.jsp"> New User </a>

	<table border="1" width="100%">



		<tr>
			<th>Username</th>
			<th>Password</th>
			<th>Full Name</th>
			<th></th>
		</tr>




		<%
			Session sess = HibernateUtil.getSessionFactory().openSession();

			List<User> userList = sess.createQuery("from User").list();

			for (User tempUser : userList) {
		%>


		<tr>
			<td><%=tempUser.getUsername()%></td>
			<td><%=tempUser.getPassword()%></td>
			<td><%=tempUser.getFullName()%></td>
			<td>
			
			<a href="deleteUser?uid=<%= tempUser.getUserId() %>"> Delete </a>
			
			<a href="updateUser.jsp?uid=<%= tempUser.getUserId() %>"> Update </a>
			
			
			</td>
		</tr>




		<%
			}
		%>









	</table>




</body>
</html>