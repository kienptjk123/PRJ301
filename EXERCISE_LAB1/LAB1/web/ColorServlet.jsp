
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String ms = (String)request.getAttribute("success");
        %>
        <h1>Welcome to Servlet course</h1>
        <script>
            setTimeout(function() {
                window.location.href = "ProductServlet.jsp";
            }, 2000);
        </script>
    </body>
</html>
