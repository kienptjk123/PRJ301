/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.appointmentDAO;
import dto.AppointmentDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adm
 */
@WebServlet(name = "EditController", urlPatterns = {"/EditController"})
public class EditController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String SUCCESS = "MainController?action=View"; //dashboard
    private final String ERROR = "error404.jsp"; //edit page

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

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
        int appointmentID = Integer.parseInt(request.getParameter("appointmentID"));
        appointmentDAO dao = new appointmentDAO();
        AppointmentDTO currentAppointment = dao.getAppoinmentByID(appointmentID);
        request.setAttribute("curAppointment", currentAppointment);
        request.getRequestDispatcher("editAppointment.jsp").forward(request, response);
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
        String url = ERROR;
        try {
            int appointmentID = Integer.parseInt(request.getParameter("appointmentID"));
            String appointmentDate = request.getParameter("appointmentDate");
            String appointmentTime = request.getParameter("appointmentTime");
            String purpose = request.getParameter("purpose");
            appointmentDAO dao = new appointmentDAO();
            AppointmentDTO currentAppointment = dao.getAppoinmentByID(appointmentID);
            boolean result = dao.updateAppointment(AppointmentDTO.builder()
                    .id(currentAppointment.getId())
                    .appointmentDate(appointmentDate)
                    .appointmentTime(appointmentTime)
                    .purpose(purpose)
                    .status(currentAppointment.getStatus())
                    .build());
            if (result) {
                request.setAttribute("message_app", "Edited successful!");
                url = SUCCESS;
            } else {
                request.setAttribute("message_app", "Edited fail!");
            }
        } catch (Exception e) {
            request.setAttribute("message_app", "Error at EDIT CONTROLLER");
        } finally {
            response.sendRedirect(url);
        }
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
