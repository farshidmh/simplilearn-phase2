<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<table border="1" width="100%">



		<tr>
			<th>Number</th>
			<th>x2</th>
			<th>x3</th>
		</tr>




		<%
			int a = Integer.parseInt(request.getParameter("a"));
			int b = Integer.parseInt(request.getParameter("b"));

			
			for (int i = a; i <= b; i++) {
		%>


		<tr>
			<td><%=i%></td>
			<td><%=i * 2%></td>
			<td><%=i * 3%></td>
		</tr>




		<%
			}
		%>









	</table>




</body>
</html>