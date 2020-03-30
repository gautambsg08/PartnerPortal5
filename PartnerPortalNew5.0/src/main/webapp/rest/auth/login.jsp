<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>	
<h1> Login</h1>
${SPRING_SECURITY_LAST_EXCEPTION.message}
<form action="login" method="post">
User name : <input type="text" name="username"/><br>
Password : <input type="password" name="password"/><br>
<input type="submit" name="submit" value="submit"/>


</form>

</body>
</html>