<%-- 
    Document   : main
    Created on : May 20, 2024, 1:58:26 PM
    Author     : adm
--%>

<%@page import="sample.user.MobileDTO"%>
<%@page import="java.util.List"%>
<%@page import="sample.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
    </head>
    <body>
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            String search = request.getParameter("search");
            if (search == null) {
                search = "";
            }
        %>  

        <div class="title">
            <h1>Welcome Admin <%= loginUser.getFullName()%></h1>
            <a href="./login.jsp">Logout</a>  
        </div>

        <form action="MainController" method="POST">
            <input placeholder="Search name" style="padding: 5px 10px; width: 300px; margin-right: 4px; border: none; 
                   box-shadow: rgba(0, 0, 0, 0.02) 0px 1px 3px 0px, rgba(27, 31, 35, 0.15) 0px 0px 0px 1px; background-color: white;
                   " type="text" name="search" value="<%= search%>"/>
            <input style="padding: 6px 10px; color: white; background-color:#5CB85C; border: none;border-radius: 5px ; cursor: pointer " type="submit" name="action" value="Search"/>
        </form>   

        <%
            List<MobileDTO> userList = (List<MobileDTO>) request.getAttribute("Mobile_List");
            if (userList != null && !userList.isEmpty()) {
        %>

        <table border="1">
            <thead>
                <tr >
                    <th>NO</th>
                    <th>Mobile ID</th> 
                    <th>Description</th> 
                    <th>Price</th> 
                    <th>Mobile Name</th>                   
                    <th>Year Of Production</th>
                    <th>Quantity</th>
                    <th>Not Sale</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (MobileDTO mobile : userList) {
                %>
            <form action="MainController" method="POST">
                <tr>
                    <td><%= count++%></td>
                    <td> <%= mobile.getMobileID()%></td>
                    <td>
                        <input  type="text" name="description" value="<%= mobile.getDescription()%>"/>                      
                    </td>
                    <td>
                        <input type="text" name="price" value="<%= mobile.getPrice()%>"/>
                    </td>
                    <td><%= mobile.getMobileName()%></td> 
                    <td><%= mobile.getYearOfProduction()%><td>
                        <input type="text" name="quantity" value="<%= mobile.getQuantity()%>"/>
                    </td> 
                    <td>
                        <input type="text" name="notSale" value="<%= mobile.getNotSale()%>"/>
                    </td> 

                    <td>
                        <a style="text-decoration: none; border-radius: 5px ;padding: 6px 14px; background-color: #4CAF50; cursor: pointer; color: white" 
                           onclick="confirmDelete('<%= mobile.getMobileID()%>')">Delete</a>
                    </td>
                    <td>
                        <input type="hidden" name="mobileID" value="<%= mobile.getMobileID()%>"/>
                        <input type="hidden" name="mobileName" value="<%= mobile.getMobileName()%>"/>
                        <input type="hidden" name="yearOfProduction" value="<%= mobile.getYearOfProduction()%>"/>


                        <input style="cursor: pointer;  border-radius: 5px ;padding: 6px 14px; text-transform: capitalize" type="submit" name="action" value="Update" onclick="return confirmUpdate()"/>
                        <input type="hidden" name="search" value="<%= search%>"/>
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
    <div style="text-align: center; margin-top: 10px">
        <button id="addRowBtn" style="margin: auto ;cursor: pointer; background: none; border: none; font-size: 1.2em; color: green">
            <i class="fas fa-plus-circle"></i>
        </button>
    </div> 

    <form id="addForm" action="MainController" method="POST" style="display: none; margin: 0">
        <table border="1">
            <tr style="background-color: #f2f2f2">
                <td>New</td>
                <td><input type="text" name="mobileID" required/></td>
                <td><input type="text" name="description" required/></td>
                <td><input type="text" name="price" required/></td>
                <td><input type="text" name="mobileName" required/></td>
                <td><input type="text" name="yearOfProduction" required/></td>
                <td><input type="text" name="quantity" required/></td>
                <td><input type="text" name="notSale" required/></td>
                <td>
                    <input style="padding: 6px 10px; border-radius: 5px" type="submit" value="Insert" name="action" onclick="confirmInsert()"/>
                    <input type="hidden" name="search" value="<%= search%>"/>
                </td>
            </tr>
        </table>
    </form>

    <div style="text-align: center; margin-top: 10px">
        <button id="remove" style="margin: auto ;cursor: pointer; background: none; border: none; font-size: 1.2em; color: green; ; display: none">
            <i class="fa fa-times-circle"></i>
        </button>
    </div> 

    <%
        String message = (String) request.getAttribute("MESSAGE");
        if (message == null) {
            message = "";
        }
    %>

    <div id="dupli">
        <h4 style="text-align: center; margin-top: 10px; color: red">
            <%= message%>
        </h4>
    </div>


    <style>
        *{
            padding: 0;
            margin: 0;
            box-sizing: border-box;
        }

        body {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%,-50%);
        }

        h1 {
            color: #5CB85C;
            margin-bottom: 10px;
        }

        .title {
            text-align: center;
        }

        .title a {
            margin-top: 10px;
            text-decoration: none;
            color: white;
            padding: 6px 10px;
            background-color: #5CB85C;
            text-align: center;
            border-radius: 5px;
        }

        form {
            text-align: center;
            margin-top: 20px;
        }

        table {
            margin-top: 10px;
            box-shadow: rgba(0, 0, 0, 0.15) 0px 5px 15px 0px;
            border: none;
            width: 100%;
            border-collapse: collapse;
            margin-right: 500px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }

        th {
            background-color: #4CAF50;
            color: white;
            text-transform: uppercase;
            text-align: center;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #ddd;
        }

        input[type="text"] {
            width: 100%;
            padding: 4px;
            box-sizing: border-box;
            border: none;
            background-color: #f2f2f2;
            text-align: center;
        }

        a {
            text-decoration: none;
            color: blue;
            cursor: pointer;
        }

        a:hover {
            background-color: #45a049;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 8px 16px;
            cursor: pointer;
            text-transform: uppercase;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

    </style>

    <script>
         const add = document.getElementById('addRowBtn');
        const remove = document.getElementById('remove');
        const table = document.getElementById('addForm');
        const duplicate = document.getElementById('dupli');
        add.addEventListener('click', function () {
            table.style.display = 'table';
            add.style.display = 'none';
            remove.style.display = 'block';
            duplicate.style.display = 'none';
        });

        remove.addEventListener('click', function () {
            remove.style.display = 'none';
            table.style.display = 'none';
            add.style.display = 'block';
        });

        function confirmDelete(mobileID) {
        var confirmation = confirm("Are you sure you want to delete this mobile?");
                if (confirmation) {
            window.location.href = "MainController?mobileID=" + mobileID + "&action=Delete&search=<%= search%>";
        } else {
            }       
        }
        
        function confirmUpdate() {
            var confirmation = confirm("Are you sure you want to update this mobile?");

            if (confirmation) {
                return true;
            } else {
                return false;
            }
        }
        
        function confirmInsert() {
            var confirmation = confirm("Are you sure you want to insert this mobile?");
            if (confirmation) {
                return true;
            } else {
                return false;
            }
        }
    </script>
</body>
</html>
