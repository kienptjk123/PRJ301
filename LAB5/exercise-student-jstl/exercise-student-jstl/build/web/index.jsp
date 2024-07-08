<%-- 
   
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring MVC</title>
        
        <style>
            div{
                display: inline-block; 
                text-align: center; 
                margin: 5px; 
                padding:5px;
                border: 1px dotted orangered; 
                border-radius: 5px;
            }
            img{
                width: 100px;
            }
        </style>
    </head>
    <body>
        <h1>EL & JSTL</h1>
        <div>
            <img src="${photo}">
            <br>
            <strong>${name1}</strong>
            <em>${salary*levelname1}</em>
        </div>
        <div>
            <img src="${photo}">
            <br>
            <strong>${name2}</strong>
            <em>${salary*levelname2}</em>
        </div>
        <div>
            <img src="${photo}">
            <br>
            <strong>${name3}</strong>
            <em>${salary*levelname3}</em>
        </div>
            
    </body>
</html>
