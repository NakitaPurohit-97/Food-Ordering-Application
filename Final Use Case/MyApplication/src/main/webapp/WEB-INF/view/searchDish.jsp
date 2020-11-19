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
 <h2>Search Dish</h2>
 
  <form action="searchDishOpr" method="post">
<div class="inputBox">
      <input type="text" name="search_dish" required value="${search_dish}"
             onkeyup="this.setAttribute('value', this.value);">
      <label>Search Dish</label>
    </div>
   		<input type="submit" name="searchDish" value="Search Dish">
 	</form>
 	<c:if test="${!SearchRes.isEmpty()}">
 	 Search Results for <b>${search_key}</b><br>
 	<table border="1" cellpadding="2" cellspacing="2">
		<tr>
			<th>dishName</th>
			<th>price</th>
			<th>ingredients</th> 
			<th>Add to Cart</th>
			
		</tr>
		<c:forEach var="Item" items="${SearchRes}">
			<tr>
				<td>${Item.dishName }</td>
				<td>${Item.price }</td>
				<td>${Item.ingredients }</td> 
				<td>
			<!--  https://www.aspsnippets.com/Articles/Pass-send-HTML-Table-rows-from-View-to-Controller-in-ASPNet-MVC.aspx -->
				<Form action="addToCart" method="post" modelAttribute="menu_table">
   					 <input type="button" name="AddToCart" required value="${menu_table=Item}">
				</Form>
				<a href="/BuyNow">Buy Now</a></td>	
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