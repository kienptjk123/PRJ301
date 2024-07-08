/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.user.MobileDAO;
import sample.user.MobileDTO;
import sample.user.UserError;

@WebServlet(name = "InsertController", urlPatterns = {"/InsertController"})
public class InsertController extends HttpServlet {

    private static final String ERROR = "SearchCartController";
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
            MobileDAO dao = new MobileDAO();
            
            if(dao.checkDuplicate(mobileID)) {
                request.setAttribute("MESSAGE", "Duplicate mobileID"); 
                url = ERROR;
            } else {
                MobileDTO mobile = new MobileDTO(mobileID, description, price, mobileName, yearOfProduction, quantity, notSale);
                boolean checkInsert = dao.insert(mobile);
                if (checkInsert) {
                    url = SUCCESS;
                } else {
                    request.setAttribute("ERROR", "Insert fail!");
                }
            }                     
        } catch (Exception e) {
            log("Error at InsertController: " + e.toString());
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
