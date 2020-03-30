<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
<!--
<b> ${errorlogin} </b><br><br>
Login: <br>
<form action="/login" method = "post">
User name: <input type="text" name="username" placeholder="enter user name" required="required" ><br>
Password: <input type="password" name="password" placeholder="password" required="required"><br>
<input type="submit" value="Submit"><br>
</form>
<br>
Forgot your username or password, click 
<a href="/forgotUserNameandPassword">Forgot Username and password</a>
<br>
<b>${error} </b><br><br>
-->
Registration:
<form action="/secure/rest/admin/add" method = "post">
Username: <input type="text" name="username" placeholder="enter user name" required="required"><br>
Password: <input type="password" name="password" placeholder="password" required="required"><br>
Email: <input type="email" name="email" placeholder="email" required="required"><br>
Account No: <input type="text" name="account_no" placeholder="Account No" required="required"><br>
Address: <input type="text" name="address" placeholder="Address" required="required"><br>
Name: <input type="text" name="name" placeholder="Name" required="required"><br>
Tele No: <input type="text" name="tele_no" placeholder="Telephone number" required="required"><br>
<!--Roles: <input type="${role}" name="roles" placeholder="USER or ADMIN" required="required"><br>-->
<input type="submit" value="Submit"><br>



</form>

</body>
</html>