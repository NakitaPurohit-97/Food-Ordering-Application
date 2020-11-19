<%@page import="com.food.model.Menu_Table"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3> Welcome to user page</h3>
<br><c:if test="${msg!=null}">
<a href="/user/searchDish">Search For Dish</a><br><br>
<a href="/user/searchOrder">Search For Order</a></c:if>
<c:if test="${msg==null}">
<a href="/login"> Login </a></c:if>
<br>
<h3> TODAY'S MENU</h3><br><br>
<c:if test="${!todays_menu.isEmpty()}">
	<table border="1" cellpadding="2" cellspacing="2">
		<tr>
			<th>dishName</th>
			<th>price</th>
			<th>ingredients</th>
			<c:if test="${msg!=null}">
			<th>Add to Cart</th>
			</c:if>
			
		</tr>
		<c:forEach var="Item" items="${todays_menu}">
			<tr>
				<td>${Item.dishName }</td>
				<td>${Item.price }</td>
				<td>${Item.ingredients }</td>
				
				<!--  https://www.aspsnippets.com/Articles/Pass-send-HTML-Table-rows-from-View-to-Controller-in-ASPNet-MVC.aspx -->
				
				<c:if test="${msg!=null}">
			<td>
			
   				<Form action="addToCart" method="post" value="${Item}" target='<c:out value="${Item}">Items</c:out>'>
			   	<button value="${Item}">Add to Cart</button>
   				</Form>
				<a href="/BuyNow">Buy Now</a> </td>	</c:if>
			</tr>
		</c:forEach>
	</table>
	</c:if>
	<c:if test="${todays_menu.isEmpty()}">
	Today's Menu Not Upated</c:if>
</body>
</html>