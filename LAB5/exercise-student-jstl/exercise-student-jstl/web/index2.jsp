<%-- 
 
    Author     : Admin
--%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring MVC</title>
        <style>
            li{
                list-style: none; line-height: 25px;
            }
            li>label{
                display: inline-block; text-align: right; width:110px;
                font-variant: small-caps; font-weight: bold;
            }
        </style>

    </head>
    <body>
        <h1>EL and JSTL</h1>
        <ul>
            <li><label>Họ và tên:</label> ${sv1.name}</li>
            <li><label>Điểm TB:</label> ${sv1.mark}</li>
            <li><label>Chuyên ngành:</label> ${sv1.major}</li>
                <c:if test="${sv1.mark >= 9}">
                <li><label>Danh hiệu:</label> ONG VÀNG</li>
                </c:if>
            <li>
                <label>Xếp loại:</label>
                <c:choose>
                    <c:when test="${sv1.mark < 5}">YẾU</c:when>
                    <c:when test="${sv1.mark < 6.5}">TRUNG BÌNH</c:when>
                    <c:when test="${sv1.mark < 7.5}">KHÁ</c:when>
                    <c:when test="${sv1.mark < 9}">GIỎI</c:when>
                    <c:otherwise>XUẤT SẮC</c:otherwise>
                </c:choose>
            </li>

        </ul>

        <ul>
            <li><label>Họ và tên:</label>${sv2.name} </li>
            <li><label>Điểm TB:</label> ${sv2.mark}<li>
            <li><label>Chuyên ngành:</label>${sv2.major} </li>
                <c:if test="${sv2.mark >= 9}">
                <li><label>Danh hiệu:</label> ONG VÀNG</li>
                </c:if>
            <li>
                <label>Xếp loại:</label>
                <c:choose>
                    <c:when test="${sv2.mark < 5}">YẾU</c:when>
                    <c:when test="${sv2.mark < 6.5}">TRUNG BÌNH</c:when>
                    <c:when test="${sv2.mark < 7.5}">KHÁ</c:when>
                    <c:when test="${sv2.mark < 9}">GIỎI</c:when>
                    <c:otherwise>XUẤT SẮC</c:otherwise>
                </c:choose>
            </li>

        </ul>

        <ul>
            <li><label>Họ và tên:</label>${sv3.name} </li>
            <li><label>Điểm TB:</label>${sv3.mark}</li>
            <li><label>Chuyên ngành:</label>${sv3.major}</li>
                <c:if test="${sv3.mark >= 9}">
                <li><label>Danh hiệu:</label> ONG VÀNG</li>
                </c:if>
            <li>
                <label>Xếp loại:</label>
                <c:choose>
                    <c:when test="${sv3.mark < 5}">YẾU</c:when>
                    <c:when test="${sv3.mark < 6.5}">TRUNG BÌNH</c:when>
                    <c:when test="${sv3.mark < 7.5}">KHÁ</c:when>
                    <c:when test="${sv3.mark < 9}">GIỎI</c:when>
                    <c:otherwise>XUẤT SẮC</c:otherwise>
                </c:choose>
            </li>

        </ul>
    </body>
</html>
</body>
</html>
