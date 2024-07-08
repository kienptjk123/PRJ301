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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 
    </head>
    <body>
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            String searchCart1 = request.getParameter("searchCart1");
            String searchCart2 = request.getParameter("searchCart2");
            if (searchCart1 == null && searchCart2 == null) {
                searchCart1 = "";
                searchCart2 = "";
            }
        %>  

        <div class="title">
            <h1>Welcome User <%= loginUser.getFullName()%></h1>
            <a href="./login.jsp">Logout</a>  
        </div>

        <form action="MainController" method="POST">                       
            From: <input placeholder="From Price" style="padding: 5px 10px; width: 300px; margin-right: 4px; border: none; 
                         box-shadow: rgba(0, 0, 0, 0.02) 0px 1px 3px 0px, rgba(27, 31, 35, 0.15) 0px 0px 0px 1px; background-color: white;
                         " type="text" name="searchCart1" value="<%= searchCart1%>"/>
            To: <input placeholder="To Price" style="padding: 5px 10px; width: 300px; margin-right: 4px; border: none; 
                       box-shadow: rgba(0, 0, 0, 0.02) 0px 1px 3px 0px, rgba(27, 31, 35, 0.15) 0px 0px 0px 1px; background-color: white;
                       " type="text" name="searchCart2" value="<%= searchCart2%>"/>
            <input style="padding: 6px 10px; color: white; background-color:#5CB85C;
                   border: none;border-radius: 5px ; cursor: pointer " type="submit" name="action" value="Search Cart"/>
            <input style="padding: 6px 10px; color: white; background-color:#5CB85C; 
                   border: none;border-radius: 5px ; cursor: pointer " type="submit" name="action" value="View"/>
            <input style="padding: 6px 10px; color: white; background-color:#5CB85C; 
                   border: none;border-radius: 5px ; cursor: pointer " 
                   type="submit" name="action" value="ViewWhishlist" />
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
                    <th>Add</th>
                    <th>Wish List</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int rowCounter = 1;
                    for (MobileDTO mobile : userList) {
                %>
            <form action="MainController" method="POST">
                <tr>
                    <td><%= rowCounter%></td>
                    <td><%= mobile.getMobileID()%></td>
                    <td><%= mobile.getDescription()%></td>
                    <td>
                        <%= mobile.getPrice()%>
                    </td>
                    <td>
                        <%= mobile.getMobileName()%>
                    </td> 
                    <td>
                        <%= mobile.getYearOfProduction()%>
                    </td> 


                    <td><select name="cmbQuantity">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                        </select>
                    </td>

                    <td>                      
                        <input type="hidden" name="id" value="<%= rowCounter%>">
                        <input type="hidden" name="mobileID" value="<%= mobile.getMobileID()%>">
                        <input type="hidden" name="description" value="<%= mobile.getDescription()%>">    
                        <input type="hidden" name="price" value="<%= mobile.getPrice()%>">
                        <input type="hidden" name="mobileName" value="<%= mobile.getMobileName()%>">
                        <input type="hidden" name="yearOfProduction" value="<%= mobile.getYearOfProduction()%>"/> 
                        <input type="hidden" name="quantity" value="<%= mobile.getQuantity()%>">
                        <input type="hidden" name="searchCart1" value="<%= searchCart1%>">
                        <input type="hidden" name="searchCart2" value="<%= searchCart2%>">

                        <input style="cursor: pointer;  border-radius: 5px ;padding: 6px 14px; 
                               text-transform: capitalize" 
                               type="submit" name="action" value="Add">

                    </td>

                    <td>

                        <div style="position: relative">

                            <div style="position: relative" id="wishlistContainer<%= mobile.getMobileID()%>">
                                <input name="action" value="WhishList" type="submit" id="notLove<%= mobile.getMobileID()%>"  onclick="toggleWishlist('<%= mobile.getMobileID()%>', true)"
                                       style="right: 0 ;margin-top: -14px ;background-color: #f2f2f2;color: #f2f2f2; ;position:absolute ; border: none; cursor: pointer">
                                <i id="tick<%= mobile.getMobileID()%>" onclick="toggleWishlist('<%= mobile.getMobileID()%>', true)" 
                                   style="top: -12px ;display: inline; ;position: absolute; right: 35px; padding: 3px;font-size: 1.5rem; color: green" class="fa fa-heart-o"></i> 

                                <input name="action" value="List" type="submit" id="love<%= mobile.getMobileID()%>" onclick="toggleWishlist('<%= mobile.getMobileID()%>', false)"  
                                       style="display: none ;margin-top: -2px ;background-color: #f2f2f2;color: #f2f2f2; ;position: absolute; cursor: pointer">
                                <i id="check<%= mobile.getMobileID()%>" onclick="toggleWishlist('<%= mobile.getMobileID()%>', false)"
                                   style="top: -15px ;display: none ;position: absolute; right: 35px; padding: 3px;font-size: 1.5rem; color: green" class="fa fa-heart"></i> 

                            </div>
                        </div>


                    </td>
                </tr>

            </form>

            <%
                    rowCounter++;
                }
            %>
        </tbody>
    </table>
    <%
        }
    %>
    <%
        String message = (String) request.getAttribute("MESSAGE");
        if (message == null) {
            message = "";
        }
    %>
    <h4 style="text-align: center; margin-top: 10px">
        <%= message%>
    </h4>


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
            width: 100%;
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
            border-collapse: collapse;
            margin-right: 397px;
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
            padding: 8px 40px;
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
            padding: 8px 16px;
            cursor: pointer;
            text-transform: uppercase;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

    </style>

    <script>
        function toggleWishlist(mobileID, isAdding) {
            if (isAdding) {
                localStorage.setItem(mobileID, 'added');
            } else {
                localStorage.removeItem(mobileID);
            }
        }

        window.onload = function () {
            for (let i = 0; i < localStorage.length; i++) {
                const mobileID = localStorage.key(i);
                const loveBtn = document.getElementById('love' + mobileID);
                const notLoveBtn = document.getElementById('notLove' + mobileID);
                const tick = document.getElementById('tick' + mobileID);
                const check = document.getElementById('check' + mobileID);


                if (loveBtn && notLoveBtn) {
                    loveBtn.style.display = localStorage.getItem(mobileID) === 'added' ? 'inline' : 'none';
                    check.style.display = localStorage.getItem(mobileID) === 'added' ? 'inline' : 'none';
                    notLoveBtn.style.display = localStorage.getItem(mobileID) === 'added' ? 'none' : 'inline';
                    tick.style.display = localStorage.getItem(mobileID) === 'added' ? 'none' : 'inline';
                }
            }
        };

    </script>
</body>
</html>
