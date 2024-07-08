<%@page import="dto.AppointmentDTO"%>
<%@page import="java.util.List"%>
<%@page import="dto.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Send Reminder</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
        <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/@emailjs/browser@4/dist/email.min.js"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">   
    </head>
    <body>
        <%
            if (session == null || session.getAttribute("loginUser") == null) {
                response.sendRedirect("login.jsp");
            }
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
            <%
                List<AppointmentDTO> appointments = (List<AppointmentDTO>) request.getAttribute("appointments");
                if (appointments != null && appointments.size() > 0) {
            %>
            <h2>Send Reminder</h2>
            <table>
                <thead>
                    <tr>
                        <th>Date</th>
                        <th>Time</th>
                        <th>Purpose</th>
                        <th>Status</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (AppointmentDTO a : appointments) {%>
                    <tr>
                        <td><%= a.getAppointmentDate()%></td>
                        <td><%= a.getAppointmentTime().substring(0, 5)%></td>
                        <td><%= a.getPurpose()%></td>
                        <td><%= a.getStatus()%></td>
                        <td>
                            <button class="send-reminder-button" 
                                    onclick="sendEmail('<%= username%>', '<%= a.getAppointmentDate()%>', '<%= a.getAppointmentTime().substring(0, 5)%>',
                                                    '<%= a.getPurpose()%>', '<%= a.getStatus()%>')">Send Reminder</button>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
            <% } else { %>
            <p style="text-align: center;">No upcoming appointments.</p>
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
                font-size: 2.5rem;
            }
            p {
                color: red;
                text-align: center;
            } 

            .send-reminder-button {
                background-color: #5CB85C;
                color: white;
                border: none;
                padding: 10px 20px;
                border-radius: 5px;
                cursor: pointer;
                font-size: 16px;
            }
            .send-reminder-button:hover {
                background-color: #7fc47f;
            }
        </style>

        <script type="text/javascript">
            (function () {
                emailjs.init("OiZQwz0n_IrTmFCmq");
            })();

            function sendEmail(username, date, time, purpose, status) {
                console.log("username ", username);
                console.log("Date: ", date);
                console.log("Time: ", time);
                console.log("Purpose: ", purpose);
                console.log("Status: ", status);

                let params = {
                    to_name: username,
                    appointmentDate: date,
                    appointmentTime: time,
                    appointmentPurpose: purpose,
                    appointmentStatus: status
                };

                emailjs.send("service_5gdf1ag", "template_hgbg6ja", params)
                        .then(function (response) {
                            alert("Email sent successfully!");
                            console.log("SUCCESS: ", response);
                        }, function (error) {
                            console.log("FAILED: ", error);
                            alert("Failed to send email. Please try again later.");
                        });
            }
        </script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDzwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
