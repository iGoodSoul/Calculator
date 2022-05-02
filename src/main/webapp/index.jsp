<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<br> <form action="login" method="post">
    Login:    <input type ="text" name="login" required/><br/><br/>
    Password: <input type="password" name="password" required/><br/><br/>
<input type="submit" value="Login"/>
    <p>${requestScope.message}</p>

</form>


<br/>
<a href="/reg">Registration</a>
</body>
</html>