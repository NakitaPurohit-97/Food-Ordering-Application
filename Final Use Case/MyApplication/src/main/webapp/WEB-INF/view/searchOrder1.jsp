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
 <h2>Search Ord</h2>
  <form action="searchOrderOpr" method="post">
<div class="inputBox">
      <input type="text" name="search_order" required value="${search_Order}"
             onkeyup="this.setAttribute('value', this.value);">
    </div>
   		<input type="submit" name="searchOrder" value="Search Order">
 	</form>
 	 </div>
</body>
</html>