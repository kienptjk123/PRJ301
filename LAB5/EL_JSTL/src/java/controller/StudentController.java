/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "StudentController", urlPatterns = {"/StudentController"})
public class StudentController extends HttpServlet {

   

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
         ServletContext application = request.getServletContext();
         boolean check = true;
        application.setAttribute("name", "Phạm Minh Tuấn");
        application.setAttribute("level", 2);

        session.setAttribute("name", "Nguyễn Thị Kiều Oanh");
        session.setAttribute("level", 4);

        request.setAttribute("name", "Lê Phạm Tuấn Kiệt");
        request.setAttribute("level", 3);

        session.setAttribute("salary", 1000);

        request.setAttribute("photo","https://th.bing.com/th/id/OIP.PzYZEuku8eAKMBscWYHnLgHaE8?rs=1&pid=ImgDetMain");
        
        request.setAttribute("check", check);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

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

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
