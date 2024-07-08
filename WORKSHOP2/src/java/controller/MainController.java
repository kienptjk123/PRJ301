/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String ERROR = "error404.jsp";
    private static final String LOGIN = "Login";
    private static final String LOGIN_CONTROLLER = "LoginController";
    private static final String LOGOUT = "Logout";
    private static final String LOGOUT_CONTROLLER = "LogoutController";
    private static final String REGISTER = "register";
    private static final String REGISTER_CONTROLLER = "RegisterController";
    private static final String CREATE = "Create";
    private static final String CREATE_CONTROLLER = "CreateController";
    private static final String EDIT = "Edit";
    private static final String EDIT_CONTROLLER = "EditController";
    private static final String CANCEL = "Cancel";
    private static final String CANCEL_CONTROLLER = "CancelController";
    private static final String VIEW = "View";
    private static final String VIEW_CONTROLLER = "ViewController";
    private static final String HISTORY_VIEW = "History";
    private static final String HISTORY_VIEW_CONTROLLER = "HistoryController";
    private static final String DASHBOARD = "Dashboard";
    private static final String DASHBOARD_CONTROLLER = "DashboardController";
    private static final String SENDREMINDER = "sendReminder";
    private static final String REMINDER_CONTROLLER = "ReminderController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String url = ERROR;
        String action = request.getParameter("action");
        try {
            if (action == null) {
                request.setAttribute("message", "Your action is not supported");
            } else {
                switch (action) {
                    case LOGIN:
                        url = LOGIN_CONTROLLER;
                        break;
                    case LOGOUT:
                        url = LOGOUT_CONTROLLER;
                        break;
                    case REGISTER:
                        url = REGISTER_CONTROLLER;
                        break;
                    case CREATE:
                        url = CREATE_CONTROLLER;
                        break;
                    case EDIT:
                        url = EDIT_CONTROLLER;
                        break;
                    case CANCEL:
                        url = CANCEL_CONTROLLER;
                        break;
                    case VIEW:
                        url = VIEW_CONTROLLER;
                        break;
                    case HISTORY_VIEW:
                        url = HISTORY_VIEW_CONTROLLER;
                        break;
                    case DASHBOARD:
                        url = DASHBOARD_CONTROLLER;
                        break;
                    case SENDREMINDER:
                        url = REMINDER_CONTROLLER;
                        break;
                    default:
                        request.setAttribute("message", "Your action is not supported");
                        break;
                }
            }
        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
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
