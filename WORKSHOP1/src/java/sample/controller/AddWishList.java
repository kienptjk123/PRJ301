/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.product.CartDTO;
import sample.product.ListDTO;
import sample.user.MobileDAO;
import sample.user.MobileDTO;

/**
 *
 * @author hd
 */
@WebServlet(name = "AddWishList", urlPatterns = {"/AddWishList"})
public class AddWishList extends HttpServlet {

    private static final String ERROR="user.jsp";
    private static final String SUCCESS="user.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url= ERROR;
        try {
            String mobileID = request.getParameter("mobileID");
            String description = request.getParameter("description");
            Double price = Double.parseDouble(request.getParameter("price"));
            String mobileName = request.getParameter("mobileName");
            int yearOfProduction = Integer.parseInt(request.getParameter("yearOfProduction"));
            
            int quantityLoss= Integer.parseInt(request.getParameter("cmbQuantity"));
            
            HttpSession session= request.getSession();
            ListDTO cart= (ListDTO)session.getAttribute("WISHLIST");
            if(cart == null){
                cart= new ListDTO();
            }
           
            String searchCart1 = request.getParameter("searchCart1");
            String searchCart2 = request.getParameter("searchCart2");

            double priceFrom = 0;
            double priceTo = Double.MAX_VALUE;
            
            if (searchCart1 != null && !searchCart1.isEmpty()) {
                priceFrom = Double.parseDouble(searchCart1);
            }
            if (searchCart2 != null && !searchCart2.isEmpty()) {
                priceTo = Double.parseDouble(searchCart2);
            } 
            MobileDAO dao = new MobileDAO();    
            List<MobileDTO> productList = dao.getListUserPrice1(priceFrom, priceTo);
            request.setAttribute("Mobile_List", productList);
            
            
            
            
            
            boolean check;
            check = cart.add(new MobileDTO(mobileID, description, price, mobileName, yearOfProduction, quantityLoss, quantityLoss));
            if(check){
                session.setAttribute("WISHLIST", cart);                
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
