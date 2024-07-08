/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.appointmentDAO;
import dto.AppointmentDTO;
import dto.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author adm
 */
@WebServlet(name = "HistoryController", urlPatterns = {"/HistoryController"})
public class HistoryController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            HttpSession session = request.getSession();
            UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");
            appointmentDAO dao = new appointmentDAO();
            List<AppointmentDTO> allAppointments = (List<AppointmentDTO>) dao.getAllAppoinmentScheduled(loginUser.getUserID());
            if (allAppointments != null && allAppointments.size() > 0) {
                for (AppointmentDTO a : allAppointments) {
                    if (compareDate(a.getAppointmentDate(), a.getAppointmentTime())) {
                        a.setStatus("Completed");
                        dao.updateAppointment(a);
                    }
                }
            }
            List<AppointmentDTO> appointments = (List<AppointmentDTO>) dao.getAllAppoinmentCompleted(loginUser.getUserID());
            request.setAttribute("appointmentHistory", appointments);
        } catch (Exception e) {
            request.setAttribute("messageView", "Error at HISTORY CONTROLLER");
        } finally {
            request.getRequestDispatcher("viewHistory.jsp").forward(request, response);

        }
    }

    private boolean compareDate(String date, String time) {
        time = time.substring(0, 8);
        String datetimeString = date + "T" + time;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime savedDateTime = LocalDateTime.parse(datetimeString, formatter);
        LocalDateTime currentDateTime = LocalDateTime.now();
        return !currentDateTime.isBefore(savedDateTime);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
