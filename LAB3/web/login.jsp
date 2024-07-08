<%-- 
    Document   : login
    Created on : May 19, 2024, 3:09:17 PM
    Author     : adm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="MainController" method="POST">
            <h1>Welcome</h1>
            <h5>Enter your details</h5>
            <div class="container">               
                <div class="user" 
                     <h5>UserID</h5><br/>
                    <input type="text" name="userID" placeholder="👤  Your userID"/>
                </div>
                <div class="password"
                     <h5>Password</h5><br/>
                    <input type="password" name="password" placeholder="🔒  Your password"/>
                </div>
            </div>
            
            <% 
            String error= (String)request.getAttribute("message");
            if(error== null) error= "";
            %>
            <h5 style="color: red; float: left;"><%= error %></h5>


            <div class="footer">
                <input type="submit" name="action" value="Login"/><br/>
                Create new user account <a href="signup.jsp"/>Click here</a>
            </div>
        </form>
        
        
        <style>
            *{
                padding: 0;
                margin: 0;
                box-sizing: border-box;
            }
            
            body {
                background-color:#c9c5c5;
            }
            
            form {
                position: absolute;
                top: 30%;
                right: 37%;
                width: 350px;
                padding: 20px 30px;
                box-shadow: 1px 2px 4px rgb(0, 0, 0, 0.5);
                border: 2px solid #aaa;
                border-radius: 10px;
            }

            h1 {
                text-align: center;
                text-transform: uppercase;
            }

            h5 {
                text-align: center;
                font-weight: 300;
            }

            .container {
                margin-top: 20px;
            }

            .user input,
            .password input{
                padding: 6px 12px;
                width: 100%;
            }
            
            .password {
                margin-top: 15px;
            }
            
            .footer {
                margin-top: 50px;
            }

            .footer input {
                width: 100%;
                font-size: 1.3rem;
                padding: 4px 0;
            }

            .footer input:hover {
                cursor: pointer;
            }
            
            .footer a {
                text-decoration: none;
            }
            
            input {
                border-radius: 5px;
                border: none;
            }
        </style>
    </body>
</html>

