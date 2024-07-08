<%-- 
    Document   : index
    Created on : Jun 14, 2024, 6:56:56 AM
    
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bài 1</title>

        <style>
            *{
                margin: 0;
                padding: 0;
               box-sizing: border-box;
            }
            .container-item{
                display: inline-block; 
                text-align: center; 
                margin: 5px; 
                padding:5px;
                border: 1px dotted orangered; 
                border-radius: 5px;
            }
            img{
               width: 80%;
            }
            input{
                background-color: black;
                border: 1px solid #fff;
                border-radius: 1px;
                color: #fff;
                padding: 20px;
                cursor: pointer;
            }
            input:hover{
                opacity: 0.5;
            }
            .container{
                display: flex;
                justify-content: space-around;
              
            }
        </style>
    </head>
    <body>

        <h1>EL & JSTL</h1>

        <form action="StudentController" method="Post">
            <input type="submit" value="Bấm vào đây để hiển thị thông tin" />
        </form>
         
        <c:if test ="${requestScope.check}">
        <div class="container">
            <div class="container-item">
                <c:set var="tuanName" value="${applicationScope.name}" />
                <c:set var="tuanLevel" value="${applicationScope.level}" />
                <c:set var="photo" value="${requestScope.photo}" />
                <c:set var="sa" value="${sessionScope.salary}" />
                <img src="${photo}" alt="anh">
                <br>
                <strong>${tuanName}</strong>
                <br>
                <em>${sa*tuanLevel}</em>
            </div>
            <div class="container-item">
                <c:set var="oanhName" value="${sessionScope.name}" />
                <c:set var="oanhLevel" value="${sessionScope.level}" />
                <c:set var="photo" value="${requestScope.photo}" />
                <c:set var="sa" value="${sessionScope.salary}" />
                <img src="${photo}" alt="anh">
                <br>
                <strong>${oanhName}</strong>
                <br>
                <em>${sa*oanhLevel}</em>
            </div>
            <div class="container-item">
                <c:set var="kietName" value="${requestScope.name}" />
                <c:set var="kietLevel" value="${requestScope.level}" />
                <c:set var="photo" value="${requestScope.photo}" />
                <c:set var="sa" value="${sessionScope.salary}" />
                <img src="${photo}" alt="anh">
                <br>
                <strong>${kietName}</strong>
                <br>
                <em>${sa*kietLevel}</em>
            </div>
        </div>
</c:if >


    </body>
</html>
