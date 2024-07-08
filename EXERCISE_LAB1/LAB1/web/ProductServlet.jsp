<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
//            String ms = (String)request.getAttribute("success");
        %>
        <h1>Get Parameter Values Demo</h1>
        <form>
                <input type="checkbox"/>Servlet & JSB<br/>
                <input type="checkbox"/>Struts & JSF<br/>
                <input type="checkbox"/>EJB<br/>
                <input type="checkbox"/>XMJ<br/>
                <input type="checkbox"/>Java Web Services<br/>
                <input type="checkbox"/>Others<br/>
                <input type="submit" value="Choose"/>
         </form>
    </body>
</html>
