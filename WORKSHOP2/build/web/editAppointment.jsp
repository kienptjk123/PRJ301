<%-- 
    Document   : editAppointment
    Created on : Jul 4, 2024, 8:31:08 AM
    Author     : adm
--%>
<%@page import="java.util.List"%>
<%@page import="dto.AppointmentDTO"%>
<%@page import="dto.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">   
    </head>

    <body>
        <%
            if (session == null || session.getAttribute("loginUser") == null) {
                response.sendRedirect("login.jsp");
            }
            AppointmentDTO currentAppointment = (AppointmentDTO) request.getAttribute("curAppointment");
            if (currentAppointment != null) {
                String username = ((UserDTO) session.getAttribute("loginUser")).getUsername();
        %>
        <aside class="app-sidebar">
            <div class="app-sidebar__user">
                <img class="app-sidebar__user-avatar" src="images/boy.png" width="50px" alt="User Image">
                <div>
                    <p class="app-sidebar__user-name"><b style="color: black">Welcome, <%= username%></b></p>
                </div>
                <a style="text-align: center; margin-bottom: 1rem; color: black; font-weight: bold" href="MainController?action=Logout">Logout</a>
            </div>
            <ul class="app-menu">
                <li><a class="app-menu__item" href="MainController?action=Dashboard"><i class="far fa-calendar-check"></i></i><span class="app-menu__label">Upcoming Appointments</span></a></li>
                <li><a class="app-menu__item" href="createAppointment.jsp"><i class="fas fa-plus-square"></i><span class="app-menu__label">Create New Appointments</span></a></li>
                <li><a class="app-menu__item" href="MainController?action=View"><i class="fas fa-street-view"></i><span class="app-menu__label">View All Appointments</span></a></li>
                <li><a class="app-menu__item" href="MainController?action=History"><i class="fas fa-history"></i><span class="app-menu__label">View Appointment History</span></a></li>
                <li><a class="app-menu__item" href="MainController?action=sendReminder"><i class="fas fa-stopwatch"></i><span class="app-menu__label">Send reminder</span></a></li>
            </ul>
        </aside>   

        <div class="content">
            <h1>Edit Appointment</h1>
            <form action="MainController?action=Edit" method="post">
                <input type="hidden" name="appointmentID" value="<%= currentAppointment.getId()%>">
                <div class="container">               
                    <div class="date">
                        <h5>Date</h5>
                        <input type="date" value="<%= currentAppointment.getAppointmentDate()%>" name="appointmentDate" required>
                    </div>
                    <div class="time">
                        <h5>Time</h5>
                        <input type="time" value="<%= currentAppointment.getAppointmentTime()%>" name="appointmentTime" required/>
                    </div>
                    <div class="purpose">
                        <h5>Purpose</h5>
                        <input type="text" name="purpose" value="<%= currentAppointment.getPurpose()%>" placeholder="Purpose" required/>
                    </div>
                </div>
                <input type="submit" value="Save Changes">
                <a style="padding: 14px;
                background-color: #5CB85C;
                color: white;
                border: none;
                cursor: pointer;
                margin-left: 15px" href="MainController?action=View">Cancel</a>
            </form>
        </div>      
        <% }%>
        <style>
            body {
                font-family: 'Arial', sans-serif;
                margin: 0;
                padding: 0;
                display: flex;
                height: 100vh;
            }

            a {
                margin: 0;
            } 

            .app-sidebar {
                width: 15%;
                background-color: #5CB85C;
                color: white;
                height: 100%;
                display: flex;
                flex-direction: column;
                align-items: center;
            }
            .app-sidebar__user {
                display: flex;
                align-items: center;
                flex-direction: column;
                justify-content: center;
                margin-top: 40px;
                border-bottom: 1px solid black;
                width: 100%;
            }
            .app-sidebar__user-avatar {
                background: white;
                border-radius: 50%;
                width: 70px;
                border: 3px solid white;
                margin-bottom: 10px;
            }
            .app-menu {
                width: 100%;
                list-style: none;
                padding: 0;
                margin-top: 20px;
                flex-grow: 1;
            }
            .app-menu__item {
                width: 100%;
                padding: 20px 15px;
                color: black;
                text-decoration: none;
                display: flex;
                align-items: center;
                gap: 15px;
            }
            .app-menu__item:hover {
                background-color: #7fc47f;
                color: black;
                text-decoration: none;
            }
            .content {
                width: 85%;
                padding: 20px;
                overflow-y: auto;
                margin: auto;
            }
            h1 {
                text-align: center;
            }
            form {
                width: 50%;
                margin: 0 auto;
            }
            .container {
                display: flex;
                flex-direction: column;
                gap: 10px;
            }
            .container div {
                margin-bottom: 10px;
            }
            .container h5 {
                margin: 0 0 5px 0;
            }
            input[type="date"], input[type="time"], input[type="text"] {
                width: 100%;
                padding: 8px;
                box-sizing: border-box;
            }
            input[type="submit"] {
                padding: 10px;
                background-color: #5CB85C;
                color: white;
                border: none;
                cursor: pointer;
                margin:10px 0 0 15px;
            }
            input[type="submit"]:hover {
                background-color: #7fc47f;
            }
            a:hover {
                color: #00baff;
                text-decoration: none;
            }
        </style>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
