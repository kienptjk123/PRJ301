/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.product.CartDTO;
import sample.product.ProductDAO;
import sample.product.ProductDTO;

/**
 *
 * @author hd
 */
@WebServlet(name = "AddToCartController", urlPatterns = {"/AddToCartController"})
public class AddToCartController extends HttpServlet {

    private static final String ERROR="itemsList.jsp";
    private static final String SUCCESS="itemsList.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url= ERROR;
        try {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            float price = Float.parseFloat(request.getParameter("price"));
            int quantity= 1;
            HttpSession session= request.getSession();
            CartDTO cart= (CartDTO)session.getAttribute("CART");
            if(cart == null){
                cart= new CartDTO();
            }
            String searchCart = request.getParameter("searchCart");
            ProductDAO dao = new ProductDAO();    
            boolean check= cart.add(new ProductDTO(id, name, price, quantity));
            if(check){
                session.setAttribute("CART", cart);
                request.setAttribute("MESSAGE", "You added "+name+". quantity: "+ quantity);
                
                url=SUCCESS;
            }else {
                
                request.setAttribute("MESSAGE", "The item is already in the cart");
            }
            
        } catch (Exception e) {
            log("Error at AddToCartController: "+ e.toString());
        }finally{
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
