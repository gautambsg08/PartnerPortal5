<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
Registration:
<form action="/secure/rest/admin/add" method = "post">
User name: <input type="text" name="username" placeholder="enter user name" required="required"><br>
Password: <input type="password" name="password" placeholder="password" required="required"><br>
Email: <input type="email" name="email" placeholder="enter the email" required="required"><br>
Role: <input type="text" name="roles" placeholder="enter the role either ADMIN or USER" required="required"><br>
<input type="submit" value="Submit"><br>



</form>
</body>
</html>