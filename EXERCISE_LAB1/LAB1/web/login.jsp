

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="loginservlet" method="post">
            txtUser<input type="text" name="user"/><br/>
            txtPassword<input type="password" name="pass"/><br/>
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>
