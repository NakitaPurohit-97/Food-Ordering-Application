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
<br><br>
  <form action="searchDishOpr" method="post">
<div class="inputBox">
      <input type="text" name="search_dish" required value="${search_dish}"
             onkeyup="this.setAttribute('value', this.value);">
      <label>Search Dish</label>
    </div>
   		<input type="submit" name="searchDish" value="Search Dish">
 	</form>
 	 </div>
</body>
</html>