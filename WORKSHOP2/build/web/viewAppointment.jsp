<%@page import="java.util.List"%>
<%@page import="dto.AppointmentDTO"%>
<%@page import="dto.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Appointment</title>
        <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/@emailjs/browser@4/dist/email.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    </head>
    <body>
        <%
            if (session == null || session.getAttribute("loginUser") == null) {
                response.sendRedirect("login.jsp");
            }
            List<AppointmentDTO> appointments = (List<AppointmentDTO>) request.getAttribute("appointmentAll");
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
                <li><a class="app-menu__item" href="MainController?action=Dashboard"><i class="far fa-calendar-check"></i><span class="app-menu__label">Upcoming Appointments</span></a></li>
                <li><a class="app-menu__item" href="createAppointment.jsp"><i class="fas fa-plus-square"></i><span class="app-menu__label">Create New Appointments</span></a></li>
                <li><a class="app-menu__item" href="MainController?action=View"><i class="fas fa-street-view"></i><span class="app-menu__label">View All Appointments</span></a></li>
                <li><a class="app-menu__item" href="MainController?action=History"><i class="fas fa-history"></i><span class="app-menu__label">View Appointment History</span></a></li>
                <li><a class="app-menu__item" href="MainController?action=sendReminder"><i class="fas fa-stopwatch"></i><span class="app-menu__label">Send reminder</span></a></li>
            </ul>
        </aside>
        <div class="content">
            <h2>All Appointments</h2>
            <% if (appointments != null && appointments.size() > 0) { %>
            <table>
                <tr>
                    <th>Date</th>
                    <th>Time</th>
                    <th>Purpose</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
                <% for (AppointmentDTO a : appointments) {%>
                <tr>
                    <td><%= a.getAppointmentDate()%></td>
                    <td><%= a.getAppointmentTime().substring(0, 5)%></td>
                    <td><%= a.getPurpose()%></td>
                    <td><%= a.getStatus()%></td>
                    <td class="action-buttons">
                        <a href="MainController?action=Edit&appointmentID=<%= a.getId()%>" class="edit-button">Edit</a> |
                        <a href="MainController?action=Cancel&appointmentID=<%= a.getId()%>" class="cancel-button">Cancel</a>
                    </td>
                </tr>
                <% } %>
            </table>
            <% } %>

            <% String error = (String) request.getAttribute("messageView");
                if (error != null && error.length() > 0) {%>
            <p><%= error%></p>
            <% }%>
        </div>

        <style>
            body {
                font-family: 'Arial', sans-serif;
                margin: 0;
                padding: 0;
                display: flex;
                height: 100vh;
            }
            h3 {
                font-size: 2.5rem;
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
            table {
                border-collapse: collapse;
                width: 100%;
                margin: auto;            
            }

            th, td {
                border: 1px solid #ddd;
                padding: 8px;
                text-align: center;
            }

            th {
                background-color: #f2f2f2;
            }

            tr:hover {
                background-color: #f1f1f1;
            }
            h2 {
                text-align: center;
                margin-top: 20px;
            }
            p {
                color: red;
                text-align: center;
            }

            .action-buttons a {
                padding: 5px 10px;
                color: white;
                text-decoration: none;
                border-radius: 5px;
            }
            .edit-button {
                background-color: #5CB85C;
            }
            .cancel-button {
                background-color: red;
            }
        </style>       
    </body>
</html>
