<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="indexstyle.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://kit.fontawesome.com/a8c8b85e20.js" ></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div id="part1">
		<h3 style="color: white ;padding-bottom: 40px; ">1849 TEAM</h3>
		<div> <a href="#">DashBoard</a><br></div>
		<div> <a href="#">Staff Manage</a></div>
	</div>
	<div id="part2">
		<div id="bg">
		<h1 id="ss"> Wellcome <%=session.getAttribute("user") %> ! </h1>
		<a href="/PRJ123x-A4/Logout"><button id="button">LOGOUT</button></a>
		</div>
		<div id="tb">
		<div style="height: 40px;background-color: #b22fbb;color: white;">Member Of Team</div>
			<table class="table">
  	
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Student ID</th>
      <th>Class</th>
    </tr>
 
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Member 1</td>
      <td>Member Code 1</td>
      <td>Class 1</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Member 2</td>
      <td>Member Code 2</td>
      <td>Class 2</td>
    </tr>
    
  </tbody>
</table>
		</div>
	</div>
</body>
</html>