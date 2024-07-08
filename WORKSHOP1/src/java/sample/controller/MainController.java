/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hd
 */
public class MainController extends HttpServlet {

    private static final String ERROR="error.jsp";
    
    private static final String LOGIN="Login";
    private static final String LOGIN_CONTROLLER="LoginController";
    private static final String SEARCH_CART="Search";
    private static final String SEARCHCART_CONTROLLER="SearchCartController";
    private static final String DELETE="Delete";
    private static final String DELETE_CONTROLLER="DeleteController";
    private static final String UPDATE="Update";
    private static final String UPDATE_CONTROLLER="UpdateController";
    private static final String CREATE="Sign up";
    private static final String CREATE_CONTROLLER="CreateController";
    private static final String REMOVE="Remove";
    private static final String ADD="Add";
    private static final String ADD_TO_CART_CONTROLLER="AddToCartController";
    private static final String VIEW="View";
    private static final String VIEW_CART="viewCart.jsp";
    private static final String CHANGE="Change";
    private static final String CHANGE_CONTROLLER="ChangeController";
    private static final String REMOVE_CONTROLLER="RemoveController";
    private static final String SEARCH="Search Cart";
    private static final String SEARCH_CONTROLLER="SearchController";
    private static final String INSERT="Insert";
    private static final String INSERT_CONTROLLER="InsertController";
    private static final String LIST = "WhishList";
    private static final String ADD_LIST = "AddWishList";
    private static final String REMOVE_LIST = "List";
    private static final String REMOVE_WISHLIST = "RemoveWishList";
    private static final String VIEW_LIST = "ViewWhishlist";
    private static final String VIEW_WISHLIST = "viewWhishList.jsp";

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url= ERROR;
        try {
            String action= request.getParameter("action");
            if(LOGIN.equals(action)){
                url= LOGIN_CONTROLLER;
            }else if(SEARCH_CART.equals(action)){
                url= SEARCHCART_CONTROLLER;
            }else if(DELETE.equals(action)){
                url= DELETE_CONTROLLER;
            }else if(UPDATE.equals(action)){
                url= UPDATE_CONTROLLER;
            }else if(CREATE.equals(action)){
                url= CREATE_CONTROLLER;
            }
            else if(ADD.equals(action)){
                url= ADD_TO_CART_CONTROLLER;
            }else if(REMOVE_LIST.equals(action)){
                url= REMOVE_WISHLIST;
            }else if(VIEW.equals(action)){
                url= VIEW_CART;
            }
                else if(VIEW_LIST.equals(action)){
                url= VIEW_WISHLIST ;
            }else if(SEARCH.equals(action)){
                url= SEARCH_CONTROLLER;
            }else if(CHANGE.equals(action)){
                url= CHANGE_CONTROLLER;
            }else if (LIST.equals(action)) {
                url = ADD_LIST;
            } if(REMOVE.equals(action)){
                url= REMOVE_CONTROLLER;
            } else if(INSERT.equals(action)) {
                url= INSERT_CONTROLLER;
            }else{
                request.setAttribute("message", "Your action not support");
            }
        } catch (Exception e) {
            log("Error at MainController: "+ e.toString());
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
