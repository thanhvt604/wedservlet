<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.1/js/bootstrap.min.js">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>Insert title here</title>

</head>
<%-- Get Cookie --%>
<%
	Cookie[] cookies=request.getCookies();
String user="";
String pass="";
String check="";
	if(cookies!=null){
	for(Cookie o: cookies)
	{
		if(o.getName().equals("userx"))
		{
			user=o.getValue();
		}
		if(o.getName().equals("pass"))
		{
			pass=o.getValue();
		}
		if(o.getName().equals("check"))
		{
			
			check=o.getValue();
		}
		
		
	}
	}


%>



<body id="bo">
	<div id="left">
		<form id="form" action="/PRJ123x-A5/LoginServlet" method="post">
			<h1>Sign in</h1>
			<input type="hidden" name="action" value="formsubmit"> <input
				type="text" name="username" value="<%=user%>" /><br> <input type="text"
				name="password" value="<%=pass%>" /><br> <a href="#">Forgot your password?</a><br>
			<div id="coverbutton">
				<input id="button" type="submit" value="LOGIN" /><br>
			</div>
			<div id= "check_remem">
			<p id="remem">Remember me :</p> <input type="checkbox" name="check" value="1"
			
			<%= "1".equals(check) ? "checked='/check'":" " %>
			
			/>
			<%-- hide/display notication form input --%>
			</div>  
			<p id="err" style="color: red">
				<% String err=(String)session.getAttribute("error");
					if(err==null)
					{
						out.print(" ");
					}
					else{
						out.print(err);
					}
				%>
				 </p>

		</form>


	</div>
	<div id="right">
		<div id="wellc">
			<h1 style="color: white;">Wellcome back !</h1>
			<p>
				To keep conect with us <br>please login with your personal<br>
				info
			</p>
		</div>
	</div>

</body>

</html>