

<%@page import="sample.product.ListDTO"%>
<%@page import="sample.user.MobileDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>
    </head>
    <body>
        <h1>View Whish List</h1>
        <%
            ListDTO cart = (ListDTO) session.getAttribute("WISHLIST");
            if (cart != null) {
        %>

        <table>
            <thead>
                <tr>
                    <th>NO</th>
                    <th>Mobile ID</th> 
                    <th>Description</th> 
                    <th>Price</th> 
                    <th>Mobile Name</th>                   
                    <th>Year Of Production</th>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (MobileDTO p : cart.getCart().values()) {
                %>
            <form action="MainController" method="POST">
                <tr>
                    <td><%= count++%></td>
                    <td><%= p.getMobileID()%></td>

                    <td><%= p.getDescription()%></td>
                    <td>
                        <%= p.getPrice()%>
                    </td>
                    <td>
                        <%= p.getMobileName()%>
                    </td> 
                    <td>
                        <%= p.getYearOfProduction()%>
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
    </br>
    <a href="user.jsp">Return user page</a>

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
            text-align: center;
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
            border-collapse: collapse;
            position: relative;
            left: 50%;
            transform: translateX(-50%);
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
            padding: 8px 35px;
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

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 6px 14px;
            cursor: pointer;
            text-transform: uppercase;
            border-radius: 5px;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        input[type="number"] {
            background-color: #f2f2f2;
            border: none;
            text-align: center;
        }

    </style>
</body>
</html>
