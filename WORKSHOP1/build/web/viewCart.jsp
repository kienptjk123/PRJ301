<%-- 
    Document   : viewCart
    Created on : Oct 15, 2022, 4:36:03 PM
    Author     : hd
--%>

<%@page import="sample.user.MobileDTO"%>
<%@page import="sample.product.CartDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>
    </head>
    <body>
        <h1>Product inside the cart:</h1>
        <%
            CartDTO cart = (CartDTO) session.getAttribute("CART");
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
                    <th>Quantity</th>
                    <th>Change</th>
                    <th>Remove</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    double total = 0;
                    for (MobileDTO p : cart.getCart().values()) {
                        total += p.getPrice() * p.getQuantity();
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
                    <td>
                        <input type="number" min="1" name="quantity" value="<%= p.getQuantity()%>" required=""/>
                    </td>
                    <td>
                        <input type="submit" name="action" value="Change"/>
                    </td>

                    <td>
                        <input type="hidden" name="mobileID" value="<%= p.getMobileID()%>"/>
                        <input type="hidden" name="description" value="<%= p.getDescription()%>"/>    
                        <input type="hidden" name="price" value="<%= p.getPrice()%>"/>
                        <input type="hidden" name="mobileName" value="<%= p.getMobileName()%>"/>
                        <input type="hidden" name="yearOfProduction" value="<%= p.getYearOfProduction()%>"/> 
                        <input type="submit" name="action" value="Remove"/>
                    </td>
                </tr>
            </form>

            <%
                }
            %>

        </tbody>
    </table>

    <h1 style="margin-top: 10px">Total:<%= total%> $  </h1>      
    <%
        }
    %>
    </br>
    <a href="user.jsp">Add more</a>

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
