package sample.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.product.ProductDAO;
import sample.product.ProductDTO;

@WebServlet(name = "AddController", urlPatterns = {"/AddController"})
public class AddController extends HttpServlet {
    private static final String SUCCESS = "itemsList.jsp";
    private static final String ERROR = "addError.jsp"; 

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        ProductDTO product = new ProductDTO(id, name, price, quantity);
        ProductDAO dao = new ProductDAO();
        try {
            if(dao.addProduct(product)) {
                request.setAttribute("MESSAGE", "Sản phẩm đã được thêm vào list.");
                request.getRequestDispatcher(SUCCESS).forward(request, response);
            } else {
                response.sendRedirect(ERROR);
            }
        } catch (Exception e) {
            log("Error at AddController: " + e.toString());
            response.sendRedirect(ERROR);
        }
    }
}
