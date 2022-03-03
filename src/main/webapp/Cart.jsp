<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page import="model.Account" %>
   <!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css">
<link rel="stylesheet" type="text/css" href="css/Cart.css">
<script src="https://kit.fontawesome.com/a8c8b85e20.js" ></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>



<c:set var="o" value='<%=(Account)session.getAttribute("user")%>' scope="session" />
<h2>Customer : ${o.name} </h2>

		
<jsp:useBean id="cart" scope="session" class="model.Cart"/>
<div class="container padding-bottom-3x mb-1">
  
    <div class="table-responsive shopping-cart">
        <table class="table">
            <thead style="background-color:yellow; ">
                <tr>
                	<th></th>
                    <th>Product Name</th>
                    <th class="text-center">Quantity</th>
                    <th class="text-center">Discount</th>
                    
                    <th class="text-center"><a class="btn btn-sm btn-outline-danger" href="#">Clear Cart</a></th>
                </tr>
            </thead>
            <tbody style="text-align: center;">
            <c:forEach items="${cart.items}" var="o">
                <tr>
                    <td>
                        <div class="product-item" >
                            <a class="product-thumb" href="#"><img src=${o.src} alt="Product"></a>
                        </div>
                    </td>
                    <td class="text-center text-lg text-medium" style="width: 30%">${o.name}</td>
                    <td class="text-center" style="width: 20%">
                        ${o.number} 
                    </td>
                    <td class="text-center text-lg text-medium" style="width: 20%">${o.price} $</td>
                    
                    
                    <td class="text-center"><a class="remove-from-cart" href="<c:url value="/AddToCartController?action=delete&id=${o.id}" />" data-toggle="tooltip" title="" data-original-title="Remove item"><i class="fa fa-trash"></i></a></td>
                </tr>
                </c:forEach>
             </tbody>
        </table>
    </div>
    <div class="shopping-cart-footer">
        <div class="column">
            <form class="coupon-form" method="post">
                <input class="form-control form-control-sm" type="text" placeholder="Coupon code" >
                <button class="btn btn-outline-primary btn-sm" type="submit">Apply Coupon</button>
            </form>
        </div>
        <div class="column text-lg">Subtotal: <span class="text-medium">${cart.getAmount()}</span></div>
    </div>
    <div class="shopping-cart-footer">
        <div class="column"><a class="btn btn-outline-secondary" href="<c:out value='<%=request.getContextPath()+"/index" %>' />" > <i class="icon-arrow-left"></i>&nbsp;Back to Shopping</a></div>
        <div class="column"><a class="btn btn-primary" href="#" data-toast="" data-toast-type="success" data-toast-position="topRight" data-toast-icon="icon-circle-check" data-toast-title="Your cart" data-toast-message="is updated successfully!">Update Cart</a><a class="btn btn-success" href="<c:out value="/PRJ123x-A5/PayController?name=${o.user}&discount=${cart.getAmount()}&address=${o.address}"/>">Checkout</a></div>
    </div>
</div>
    </body>
    </html>