<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style>

table{
position:absolute;
top:200px;
left:120px;
color:white;
font-size:20px;
}
td
{
}
.box {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 25rem;
  padding: 2.5rem;
  box-sizing: border-box;
  background: rgba(0, 0, 0, 0.6);
  border-radius: 0.625rem;
}

h1,h2{
color:black;
}
button:hover {
  opacity: 0.8;
}
button {
  background-color: skyblue;
  color: Blue;
  padding: 12px 18px;
  margin: 2px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}
input[type=text], input[type=password] {
  width: 100%;
  padding: 8px 16px;
  margin: 2px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}
body {
  margin: 0;
  padding: 0;
  background-size: cover;
  font-family: sans-serif;
}

.box {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 25rem;
  padding: 2.5rem;
  box-sizing: border-box;
  background: rgba(0, 0, 0, 0.6);
  border-radius: 0.625rem;
}

.box h2 {
  margin: 0 0 1.875rem;
  padding: 0;
  color: #fff;
  text-align: center;
}

.box .inputBox {
  position: relative;
}

.box .inputBox input {
  width: 100%;
  padding: 0.625rem 0;
  font-size: 1rem;
  color: #fff;
  letter-spacing: 0.062rem;
  margin-bottom: 1.875rem;
  border: none;
  border-bottom: 0.065rem solid #fff;
  outline: none;
  background: transparent;
}

.box .inputBox label {
  position: absolute;
  top: 0;
  left: 0;
  padding: 0.625rem 0;
  font-size: 1rem;
  color: #fff;
  pointer-events: none;
  transition: 0.5s;
}

.box .inputBox input:focus ~ label,
.box .inputBox input:valid ~ label,
.box .inputBox input:not([value=""]) ~ label {
  top: -1.125rem;
  left: 0;
  color: #03a9f4;
  font-size: 0.75rem;
}

.box input[type="submit"] {
  border: none;
  outline: none;
  color: white;
  background-color: black;
  padding: 0.625rem 1.25rem;
  cursor: pointer;
  border-radius: 0.312rem;
  font-size: 1rem;
}

.box input[type="submit"]:hover {
  background-color: #1cb1f5;
}

</style>
</head>
<body>

<div class="box">
  <h2>Register</h2>
  <form action="save-user" method="post">
  <tr>
		<td colspan="2"><c:if test="${message!=null}">
			<font color="red">${message}</font><br><br>
		</c:if></td>
	</tr>
    <div class="inputBox">
      <input type="text" name="user_name"  onkeyup="this.setAttribute('value', this.value);" required value="${ user_table.user_name}">
      <label>User Name</label>
    </div>
    <div class="inputBox">
      <input type="text" name="email" required value="${ user_table.email}"
             onkeyup="this.setAttribute('value', this.value);">
      <label>Email</label>
    </div>
    <div class="inputBox">
      <input type="text" name="address"  onkeyup="this.setAttribute('value', this.value);" required value="${ user_table.address}">
      <label>Address</label>
    </div>
    <div class="inputBox">
      <input type="password" name="password" required value="${ user_table.password}"
             onkeyup="this.setAttribute('value', this.value);">
      <label>Password</label>
    </div>
    <div class="inputBox">
      <input type="number" name="ph_number" required value="${ user_table.ph_number}"
             onkeyup="this.setAttribute('value', this.value);">
      <label>Phone Number</label>
    </div>
   <center> <input type="submit" name="sign-up" value="Sign Up"></center>
  </form></div>	
 <div>
  <center> <font color="black"><h1><a href="/login">Already have a Account? Login</a></h1></font></center></div>
</body>
</html>
     
    <!-- 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table align="center">
<tr>
<td align="center">
<form action="save-user" method="post"><b>register Here</b>
<div class="container">

    <label for="user_name"><b>user_name</b></label>
    <input type="text" placeholder="Enter username" name="user_name" required value="${ user_table.user_name}"><br>

<label for="email"><b>email</b></label>
    <input type="text" placeholder="Enter email" name="email" required value="${ user_table.email}"><br>

<label for="address"><b>address</b></label>
    <input type="text" placeholder="Enter address" name="address" required value="${ user_table.address}"><br>

<label for="ph_number"><b>ph_number</b></label>
    <input type="text" placeholder="Enter ph_number" name="ph_number" required value="${ user_table.ph_number}"><br>

    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required value="${ user_table.password}"><br>

    <button type="submit" value="Register">Register</button>
    </div>
  
  
  </td>
  </tr>
  </table>
</body>
</html> -->