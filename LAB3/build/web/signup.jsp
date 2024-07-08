<%-- 
    Document   : signup
    Created on : May 19, 2024, 3:13:24 PM
    Author     : adm
--%>

<%@page import="sample.user.UserError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            UserError userError= (UserError)request.getAttribute("USER_ERROR");
            if(userError== null){
                userError= new UserError();
            }
        %>
        <form action="MainController" method="POST">
            <h1>Welcome</h1>
            <h5>Enter your details</h5>
            <div class="container">               
                <div class="user" 
                     <h5>UserID</h5><br/>
                    <input type="text" name="userID"  placeholder="Your userID(US*****)" required=""/>
                    <h5 style="color: red; float: left"><%= userError.getUserID() %></h5>
                </div>
                <div class="name"
                    <h5>Name</h5><br/>
                    <input type="text" name="fullName" placeholder="Your name" required=""/>
                    <h5 style="color: red; float: left"><%= userError.getFullName() %></h5>
                </div>
                <div class="role"
                     <h5>Role ID</h5><br/>
                    <input type="text" name="roleID" placeholder="Your name" />
                    <h5><%= userError.getRoleID() %></h5>
                </div>
                <div class="password"
                     <h5>Password</h5><br/>
                    <input type="password" name="password" placeholder="Your password" required=""/>
                </div>
                <div class="confirm"
                     <h5>Confirm Password</h5><br/>
                    <input type="password" name="confirm" placeholder="Your password" required=""/>
                    <h5 style="color: red; float: left"><%= userError.getConfirm() %></h5>
                </div>
            </div>
            <div class="footer">
                <input type="submit" name="action" value="Sign up"/><br/>
                Back to login <a href="login.jsp"/>Click here</a>
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
                top: 15%;
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
            .name input,
            .password input,
            .confirm input,
            .role input
            {
                padding: 6px 12px;
                width: 100%;
            }

            .password,
            .confirm,
            .name, 
            .role
            {
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
