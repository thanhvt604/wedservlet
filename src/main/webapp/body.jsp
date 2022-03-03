<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>

	<div class="row">
		<div class="leftcolumn">
			<c:forEach var="o" items="${product}">
				<div class="card col-lg-4">
					<img alt="cp1" src="${o.src}">
					<p>${o.type}</p>
					<a href="<c:url value="/Information?id=${o.id}"/>"><h5>${o.name}</h5></a>
					<p>${o.price} $</p>
				</div>
			</c:forEach>
		</div>
		<div class="rightcolumn">
			<div class="card single">
				<ul class="list-unstyled">
					<li><a href="" title="">Business <span class="pull-right">13</span></a></li>
					<li><a href="" title="">Technology <span
							class="pull-right">13</span></a></li>
					<li><a href="" title="">Web <span class="pull-right">13</span></a></li>
					<li><a href="" title="">Ecommerce <span class="pull-right">13</span></a></li>
					<li><a href="" title="">Wordpress <span class="pull-right">13</span></a></li>
					<li><a href="" title="">Android <span class="pull-right">13</span></a></li>
					<li><a href="" title="">IOS <span class="pull-right">13</span></a></li>
					<li><a href="" title="">Windows <span class="pull-right">13</span></a></li>
				</ul>
			</div>

			<div class="card">
				<hr>
				<h3>Popular products or banner</h3>
				<div class="fakeimg">
					
				</div>
				<div class="fakeimg">
					
				</div>
				<div class="fakeimg">
					

			</div>
		</div>
		
	</div>
	<nav class="pagination-container">
			<div class="pagination" style="height: 80px;">
				<a class="pagination-newer" href="#">PREV</a> <span
					class="pagination-inner"> <a
					href="<%=request.getContextPath() + "/index?pageid=1"%>">1</a> <a
					href="<%=request.getContextPath() + "/index?pageid=2"%>">2</a> <a
					href="#">3</a> <a href="#">4</a> <a href="#">5</a> <a href="#">6</a>
				</span> <a class="pagination-older" href="#">NEXT</a>
			</div>
		</nav>
		<script>
			$('.pagination-inner a').on('click', function() {
				$(this).siblings().removeClass('pagination-active');
				$(this).addClass('pagination-active');
			})
		</script>
</body>
</html>