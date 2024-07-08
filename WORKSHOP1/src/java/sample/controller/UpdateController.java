/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.user.MobileDAO;
import sample.user.MobileDTO;

/**
 *
 * @author hd
 */
@WebServlet(name = "UpdateController", urlPatterns = {"/UpdateController"})
public class UpdateController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "SearchCartController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String mobileID = request.getParameter("mobileID");
            String description = request.getParameter("description");
            Double price = Double.parseDouble(request.getParameter("price"));
            String mobileName = request.getParameter("mobileName");
            int yearOfProduction = Integer.parseInt(request.getParameter("yearOfProduction"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            int notSale = Integer.parseInt(request.getParameter("notSale"));
            MobileDTO mobile = new MobileDTO(mobileID, description, price, mobileName, yearOfProduction, quantity, notSale);
            MobileDAO dao = new MobileDAO();
            HttpSession session = request.getSession();
            boolean checkUpdate = dao.update(mobile);
            if (checkUpdate) {
                url = SUCCESS + request.getParameter("search");
                MobileDTO loginUser = (MobileDTO) session.getAttribute("LOGIN_USER");
                if (loginUser.getMobileID().equals(mobileID)) {
                    loginUser.setDescription(description);
                    loginUser.setPrice(price);
                    loginUser.setQuantity(quantity);
                    loginUser.setNotSale(notSale);
                    session.setAttribute("LOGIN_USER", loginUser);
                }
            } else {
                request.setAttribute("ERROR", "Update fail!");
            }
        } catch (Exception e) {
            log("Error at UpdateController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
