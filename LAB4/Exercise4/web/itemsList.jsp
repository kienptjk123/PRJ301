<%@page import="sample.product.ProductDAO"%>
<%@page import="java.util.List"%>
<%@page import="sample.product.ProductDTO"%>
<%@page import="sample.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Items List Page</title>
    </head>
    <body>
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null) {
                response.sendRedirect("login.jsp");
                return;
            }

            ProductDAO dao = new ProductDAO();
            List<ProductDTO> listProduct = null;
            String noResults = (String) request.getAttribute("NO_RESULTS");

            if (request.getAttribute("LIST_PRODUCT") != null) {
                listProduct = (List<ProductDTO>) request.getAttribute("LIST_PRODUCT");
            } else {
                listProduct = dao.getAllProducts();
            }
        %>
        <h1>Welcome <%= loginUser.getFullName()%></h1>

        <%
            if (request.getAttribute("ERROR") != null) {
        %>
        <script>
            alert("${requestScope.ERROR}");
        </script>
        <%
            }
        %>

        <form action="MainController" method="POST">
            <input type="submit" name="action" value="Logout"/>
        </form>

        <%  
            String fromPrice = request.getParameter("fromPrice");
            String toPrice = request.getParameter("toPrice");
            String brand = request.getParameter("brand");
            if (fromPrice == null) {
                fromPrice = "";
            }
            if (toPrice == null) {
                toPrice = "";
            }
            if (brand == null) {
                brand = "";
            }
        %>
        <form action="MainController" method="POST">
            From Price: <input type="text" name="fromPrice" value="<%= fromPrice %>"/>
            To Price: <input type="text" name="toPrice" value="<%= toPrice %>"/>
            Brand: <input type="text" name="brand" value="<%= brand %>"/>
            <input type="submit" name="action" value="Search"/>
            <input type="submit" name="action" value="View"/>
        </form>

        <h2>Search Results</h2>
        <% if (noResults != null) { %>
        <p><%= noResults %></p>
        <% } else if (listProduct != null && !listProduct.isEmpty()) { %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Brand</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Subtotal</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 0;
                    for (ProductDTO product : listProduct) {
                        double subtotal = product.getPrice() * product.getQuantity();
                %>
                <tr>
                    <form action="MainController" method="post">
                        <td><%= ++count %></td>
                        <td><%= product.getId() %></td>
                        <td>
                            <input type="text" name="name" value="<%= product.getName() %>" required=""/>
                        </td>
                        <td>
                            <input type="text" name="brand" value="<%= product.getBrand() %>" required=""/>
                        </td>
                        <td>
                            <input type="text" name="price" value="<%= (float) product.getPrice() %>" required=""/>
                        </td>
                        <td>
                            <input type="number" name="quantity" value="<%= product.getQuantity() %>" required=""/>
                        </td>
                        <td><%= (float) subtotal %></td>
                        <td>
                            <input type="hidden" name="fromPrice" value="<%= fromPrice %>"/>
                            <input type="hidden" name="toPrice" value="<%= toPrice %>"/>
                            <input type="hidden" name="brand" value="<%= brand %>"/>
                            <input type="hidden" name="productId" value="<%= product.getId() %>"/>
                            <input type="hidden" name="id" value="<%= product.getId() %>">
                            <input type="hidden" name="name" value="<%= product.getName() %>">
                            <input type="hidden" name="price" value="<%= product.getPrice() %>">
                            <input type="hidden" name="quantity" value="<%= product.getQuantity() %>">
                            
                            <input type="submit" name="action" value="Remove"/>
                            <input type="submit" name="action" value="Update"/>
                            <input type="submit" name="action" value="Add to Cart"/>
                        </td>
                    </form>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <% } else { %>
        <p>No products found.</p>
        <% } %>

        <h3>Add New Items</h3>
        <form action="AddController" method="post">
            <input type="hidden" name="fromPrice" value="<%= fromPrice %>"/>
            <input type="hidden" name="toPrice" value="<%= toPrice %>"/>
            <input type="hidden" name="brand" value="<%= brand %>"/>

            ID: <input type="text" name="id" required=""/><br>
            Name: <input type="text" name="name" required=""/><br>
            Brand: <input type="text" name="brand" required=""/><br>
            Price: <input type="text" name="price" required=""/><br>
            Quantity: <input type="number" name="quantity" required=""/><br>
            <input type="submit" value="Add More"/>
        </form>

        <%
            String message = (String) request.getAttribute("MESSAGE");
            if (message == null) {
                message = "";
            }
        %>
        <div>
            <%= message %>
        </div>
    </body>
</html>
