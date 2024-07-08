

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
            UserError userError = (UserError) request.getAttribute("USER_ERROR");
            if (userError == null) {
                userError = new UserError();
            }
        %>
        <form action="MainController" method="POST">
            <h1>Register</h1>
            <h5>Enter your details</h5>
            <div class="container">               
                <div class="user" 
                     <h5>UserID</h5><br/>
                    <input type="text" name="userID"  placeholder="👤 Enter new userID" required=""/>
                    <h5 style="color: red; float: left"><%= userError.getUserID()%></h5>
                </div>
                <div class="name"
                     <h5>Name</h5><br/>
                    <input type="text" name="fullName" placeholder="📛 Enter new name" required=""/>
                    <h5 style="color: red; float: left"><%= userError.getFullName()%></h5>
                </div>
                <div class="password"
                     <h5>Password</h5><br/>
                    <input type="password" name="password" placeholder="🔒 Enter new password" required=""/>
                </div>
                <div class="confirm"
                     <h5>Confirm Password</h5><br/>
                    <input type="password" name="confirm" placeholder="🔓 Confirm new password" required=""/>
                    <h5 style="color: red; float: left"><%= userError.getConfirm()%></h5>
                </div>
            </div>
            <div class="footer">
                <input type="submit" name="action" value="Sign up"/><br/>
                <div class="font">
                    Back to login <a href="login.jsp"/>Click here</a>
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
                transform: translate(-50%, -50%);
                width: 400px;
                padding: 20px 30px;
                box-shadow: rgba(0, 0, 0, 0.15) 0px 5px 15px 0px;
                border-radius: 10px;
            }

            h1 {
                text-align: center;
                text-transform: uppercase;
                color: #5CB85C;
            }

            h5 {
                text-align: center;
                font-weight: 300;
                color: #5CB85C;
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
                margin-top: 5px;
                padding: 6px 12px;
                width: 100%;           
                box-shadow: rgba(0, 0, 0, 0.02) 0px 1px 3px 0px, rgba(27, 31, 35, 0.15) 0px 0px 0px 1px;
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
                background-color: #5CB85C;
                color: white;
            }

            .footer input:hover {
                cursor: pointer;
            }

            .footer a {
                color: #5CB85C;
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
