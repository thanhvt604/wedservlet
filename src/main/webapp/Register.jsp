<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<link rel="stylesheet" type="text/css" href="css/regis.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="display: flex; justify-content: center; height: 100vh; ;align-items: center;" >
	<form action="<%=request.getContextPath() + "/Register"%>" method="post" style="padding:30px;
	background-color:lightcoral;">
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Pass</td>
				<td><input type="text" name="pass" /></td>
			</tr>
			<tr>
				<td>Re-pass</td>
				<td><input type="text" name="repass" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address" /></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input type="text" name="phone" /></td>
			</tr>
		</table>
		<input type="submit" value="Confirm"><br>
		<%=request.getAttribute("error")%>
	</form>

	
</body>
</html>