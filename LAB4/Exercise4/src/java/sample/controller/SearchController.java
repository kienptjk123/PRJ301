package sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.product.ProductDAO;
import sample.product.ProductDTO;

@WebServlet(name = "SearchController", urlPatterns = {"/SearchController"})
public class SearchController extends HttpServlet {

    private static final String ERROR = "itemsList.jsp";
    private static final String SUCCESS = "itemsList.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String fromPriceStr = request.getParameter("fromPrice");
            String toPriceStr = request.getParameter("toPrice");
            String brandName = request.getParameter("brand");
            List<ProductDTO> listProduct;
            listProduct = new ArrayList<>();
            ProductDAO dao = new ProductDAO();
            if (fromPriceStr != null && toPriceStr != null && !fromPriceStr.isEmpty() && !toPriceStr.isEmpty()) {
                double fromPrice = Double.parseDouble(fromPriceStr);
                double toPrice = Double.parseDouble(toPriceStr);
                
                listProduct = dao.getListProductByPrice(fromPrice, toPrice);
            }
            else if(fromPriceStr!=null && !fromPriceStr.isEmpty()){
                    double fromPrice = Double.parseDouble(fromPriceStr);
                    double toPrice = Double.MAX_VALUE;
                    listProduct = dao.getListProductByPrice(fromPrice, toPrice);
            }
            else if(toPriceStr!=null && !toPriceStr.isEmpty()){
                    double fromPrice = Double.MIN_VALUE;
                    double toPrice = Double.parseDouble(toPriceStr);
                    listProduct = dao.getListProductByPrice(fromPrice, toPrice);
            }else{
                    listProduct = dao.getListProductByPrice(Double.MIN_VALUE, Double.MAX_VALUE);
            }   
            if(brandName!=null && !brandName.isEmpty()){
                     listProduct = listProduct.stream()
                        .filter(product -> product.getBrand().equalsIgnoreCase(brandName))
                            .collect(Collectors.toList());
                }
            if (listProduct.isEmpty()) {
                request.setAttribute("NO_RESULTS", "No search Results");
            } else {
                request.setAttribute("LIST_PRODUCT", listProduct);
            }

        } catch (Exception e) {
            log("Error at SearchController: " + e.toString());
        } finally {
            request.getRequestDispatcher("itemsList.jsp").forward(request, response);
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
        return "SearchController handles product search functionality";
    }
    
    private void filterByBrand(List<ProductDTO> a, String brand){
       
    }
}
