<%-- 
    Document   : login
    Created on : Jul 4, 2024, 12:33:45 AM
    Author     : adm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <form action="MainController?action=Login" method="post">          
            <h1>Login</h1>
            <h5>Enter your details</h5>
            <div class="container">               
                <div class="user" 
                     <h5>Username</h5><br/>
                    <input type="text" name="username" placeholder="👤  Your userName" required/>
                </div>
                <div class="password"
                     <h5>Password</h5><br/>
                    <input type="password" name="password" placeholder="🔒  Your password" required/>
                </div>
            </div>
            <% String error = (String) request.getAttribute("message");
                if (error == null) {
                    error = "";
                }
            %>
            <p style="color:red; float: left;"><%=error%> </p>
            
            <div class="footer">
                <input type="submit" name="action" value="Login"/><br/>
                <div class="font">
                    Create new user account <a href="register.jsp"/>Click here</a>
                </div>
            </div>
        </form>

        <style>
            *{
                padding: 0;
                margin: 0;
                box-sizing: border-box;
            }

            form {
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%,-50%);
                width: 400px;
                padding: 20px 30px;
                box-shadow: rgba(0, 0, 0, 0.15) 0px 5px 15px 0px;
                border-radius: 10px;
            }

            h1 {
                text-align: center;
                text-transform: uppercase;
                color: #F7482E;
                font-size: 2.5rem;
            }

            h5 {
                text-align: center;
                font-weight: 300;
                color: #F7482E;
                font-size: 1.2rem;
            }

            .container {
                margin-top: 20px;
            }

            .user input,
            .password input{
                margin-top: 5px;
                padding: 12px 12px;
                width: 100%;
                box-shadow: rgba(0, 0, 0, 0.02) 0px 1px 3px 0px, rgba(27, 31, 35, 0.15) 0px 0px 0px 1px;
            }

            .password {
                margin-top: 15px;
            }

            .footer {
                margin-top: 50px;
                text-align: center;
            }

            .footer input {
                width: 100%;
                font-size: 1.3rem;
                padding: 4px 0;
                background-color: #F7482E;
                color: white;
            }

            .footer input:hover {
                cursor: pointer;
            }

            .footer a {
                color: #F7482E;
                text-decoration: none;
            }

            input {
                border-radius: 5px;
                border: none;
            }

            .font {
                margin-top: 10px;
            }
        </style>
    </body>
</html>
