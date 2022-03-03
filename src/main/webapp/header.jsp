
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class ="header">


 <form class="container justify-content-center" action=<%=response.encodeUrl(request.getContextPath()+"/SearchController") %> method="post" >
    <input type="text" class="form-control" name="search" placeholder="Search this blog">
    <div class="input-group-append">
      <button class="btn btn-secondary" type="submit" >
        <i class="fa fa-search"></i>
      </button>
    </div>
    </form>
<div>
<h1>PRJ321</h1>
<p>Wellcome to my website !</p>
</div>
</div>
<div class="topnav">
<a href="#">Home</a>
<a href="#">Product</a>
<a href="#">About us</a>
<c:if test="${sessionScope.user==null}">
<a id="lg" href="login.jsp" ><button id="button">LOGIN</button></a>
</c:if>
<c:if test="${sessionScope.user!=null}">
<a id="lg" href="<c:url value="/Logout" />" ><button id="button">LOGOUT</button></a>
</c:if>
<a id="lg" href="login.jsp" ><button id="button">REGISTER</button></a>  
  </div>




   

</body>
</html>