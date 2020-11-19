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
<div>
 <h2>Search Order</h2>
  <form action="searchOrderOpr" method="post">
<div class="inputBox">
      <input type="text" name="search_order" required value="${search_order}"
             onkeyup="this.setAttribute('value', this.value);">
    </div>
   		<input type="submit" name="searchOrder" value="Search Order">
 	</form>
 	<c:if test="${!SearchRes.isEmpty()}">
 	 Search Results for <b>${search_key}</b><br>
 	<table border="1" cellpadding="2" cellspacing="2">
		<tr>
		<th> Order_Id</th>
			<th>dishName</th>
			<th>Ingredients</th>
			<th>Quantity</th>
			<th>price</th>
			<th>Date of Order</th>
			
		</tr>
		<c:forEach var="Item" items="${SearchRes}">
			<tr>
			<td> ORD${Item.order_id}</td>
				<td>${Item.dish_name }</td>
				<td>${Item.ingredients }</td>
				<td>${Item.quantity }</td>
				<td>${Item.price }</td>
				<td>${Item.date_of_order}</td>
			</tr>
		</c:forEach>
	</table></c:if>
 	<c:if test="${SearchRes.isEmpty()}">
 	<br><br><c:if test="${msg!=null}">
 	${msg} <b>${search_key}</b><br></c:if>
 	</c:if>
 </div>
</body>
</html>