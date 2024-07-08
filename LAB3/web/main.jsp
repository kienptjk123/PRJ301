<%-- 
    Document   : main
    Created on : May 20, 2024, 1:58:26 PM
    Author     : adm
--%>

<%@page import="java.util.List"%>
<%@page import="sample.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
    </head>
    <body>
         <%
            String search = request.getParameter("search");
            if (search == null) {
                search = "";
            }
        %>
        <i class="fas fa-ghost"></i>
        <h5>Welcome Back Admin</h5>
        <form action="MainController" method="POST">
            <input style="border-bottom-left-radius: 12px; border-top-left-radius: 12px; border: none " type="text" name="search" value="<%= search %>"/>
            <input style="border-radius: 20px; cursor: pointer;  border: none " type="submit" name="action" value="Search"/>
        </form>   
            
            <a style="position: absolute; top: 23.5%; right: 52%; 
               border-radius: 20px; text-decoration: none; color: black; 
               background-color: white; padding: 3px" href="./login.jsp">Logout<a/>                   
        <%
            List<UserDTO> userList = (List<UserDTO>) request.getAttribute("User_List");
            if(userList != null && !userList.isEmpty()) { 
        %>
        
        <table  style="position: absolute; top: 28%; right: 20%;" border="1">
            <thead>
                <tr >
                    <th style="padding: 4px">NO</th>
                    <th style="padding: 4px">User ID</th> 
                    <th style="padding: 4px 50px">Full Name</th> 
                    <th style="padding: 4px 50px">Role ID</th> 
                    <th style="padding: 4px">Password</th>
                    <th style="padding: 4px 7px">Delete</th>
                    <th style="padding: 4px 7px">Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (UserDTO user : userList) {
                %>
            <form action="MainController" method="POST">
                <tr>
                    <td><%= count++ %></td>
                    <td>
                        <input type="text" name="userID" value="<%= user.getUserID() %>"/>
                    </td>
                    <td>
                        <input type="text" name="fullName" value="<%= user.getFullName() %>"/>                      
                    </td>
                    <td>
                        <input type="text" name="roleID" value="<%= user.getRoleID() %>"
                    </td>
                    <td>
                        <input type="password" name="password" value="<%= user.getPassword() %>"
                    </td> 
                    
                    <td>
                        <a style="text-decoration: none ;color: blue; cursor: pointer" href="MainController?userID=<%= user.getUserID()%>&action=Delete&search=<%= search%>">Delete</a>
                        <!--<input style="color: blue; cursor: pointer" type="submit" name="action" value="Delete">-->
                    </td>
                    <td>
                        <input style="cursor: pointer" type="submit" name="action" value="Update">
                        <input type="hidden" name="search" value="<%= search %>"/>
                    </td>
                    
                </tr>
            </form>
                <%
                    }
                %>
            </tbody>
        </table>
             <%
            }
        %>
        <style>
            *{
                padding: 0;
                margin: 0;
                box-sizing: border-box;
            }
            
            body {
                background-color: #c9c5c5;
            }
            
            i.fas.fa-ghost {
                display: flex;
                justify-content: center;
                font-size: 5rem;
                margin-top: 40px;
                color: white;
            }
            
            input {
                padding: 4px;
            } 
            h5 {
                text-align: center;
                color: white;
                margin-top: 20px;
            }
            form {
                position: absolute;
                top: 20%;
                right: 41%;
            }
            
            input {
                text-align: center;
            }
            
            td {
                text-align: center;
            }
            
            td input {
                background-color: #c9c5c5; 
                border: none
            }
        </style>
    </body>
</html>
