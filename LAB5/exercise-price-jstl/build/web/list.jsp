<%@page import="product.Product"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product List</title>
        <style>
            table {
                width: 100%;
                border-collapse: collapse;
            }
            th, td {
                border: 1px solid #ddd;
                padding: 8px;
                text-align: left;
            }
            th {
                background-color: #f4f4f4;
            }
        </style>
    </head>
    <body>
        <h1>Product Management</h1>
        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Unit Price</th>
                    <th>Discount</th>
                    <th>Real Price</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${requestScope.productList}">
                    <tr>
                        <td><c:out value="${product.name}" /></td>
                        <td><c:out value="${product.unitPrice}" /></td>
                        <td><c:out value="${product.discount}" /></td>
                        <c:set var="realPrice" value="${product.unitPrice * (1 - product.discount)}" />
                        <td><c:out value="${realPrice}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
