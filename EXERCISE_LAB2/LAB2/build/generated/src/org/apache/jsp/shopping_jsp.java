package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import sample.product.ProductCartDTO;
import java.util.List;

public final class shopping_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>CART</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            String searchCart = request.getParameter("searchCart");
            if (searchCart == null) {
                searchCart = "";
            }
        
      out.write("\n");
      out.write("        <h1>Welcome to product Store</h1>\n");
      out.write("        <form action=\"MainController\" method=\"POST\">\n");
      out.write("            <input type=\"submit\" name=\"action\" value=\"Logout\"/>\n");
      out.write("        </form>\n");
      out.write("        <form action=\"MainController\" method=\"POST\">\n");
      out.write("            Search<input type=\"text\" name=\"searchCart\" value=\"");
      out.print( searchCart);
      out.write("\"/>\n");
      out.write("            <input type=\"submit\" name=\"action\" value=\"SearchCart\"/>\n");
      out.write("            <input type=\"submit\" name=\"action\" value=\"View\"/>\n");
      out.write("        </form>\n");
      out.write("        ");

            List<ProductCartDTO> productList = (List<ProductCartDTO>) request.getAttribute("Product_List");
            if (productList != null && !productList.isEmpty()) {
        
      out.write("\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>No</th>\n");
      out.write("                    <th>Product ID</th> \n");
      out.write("                    <th>Product name</th> \n");
      out.write("                    <th>Price</th>\n");
      out.write("                    <th>size</th> \n");
      out.write("                    <th>Description</th>\n");
      out.write("                    <th>quantity</th>\n");
      out.write("                    <th>Add to cart</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                ");

                    int count = 1;
                    for (ProductCartDTO product : productList) {
                
      out.write("\n");
      out.write("            <form action=\"MainController\" method=\"POST\">\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( count++ );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( product.getId() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( product.getName() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( product.getPrice() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( product.getSize() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( product.getDescription() );
      out.write("</td>\n");
      out.write("                    \n");
      out.write("                    <td>");
      out.print( product.getQuantity() );
      out.write("</td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"hidden\" name=\"id\" value=\"");
      out.print( product.getId() );
      out.write("\">\n");
      out.write("                        <input type=\"hidden\" name=\"name\" value=\"");
      out.print( product.getName() );
      out.write("\">\n");
      out.write("                        <input type=\"hidden\" name=\"price\" value=\"");
      out.print( product.getPrice() );
      out.write("\">\n");
      out.write("                        <input type=\"hidden\" name=\"description\" value=\"");
      out.print( product.getDescription() );
      out.write("\">\n");
      out.write("                        <input type=\"hidden\" name=\"size\" value=\"");
      out.print( product.getSize() );
      out.write("\">\n");
      out.write("                        <input type=\"hidden\" name=\"quantity\" value=\"");
      out.print( product.getQuantity() );
      out.write("\">\n");
      out.write("                        <input type=\"hidden\" name=\"searchCart\" value=\"");
      out.print( searchCart );
      out.write("\">\n");
      out.write("                        <select name=\"cmbQuantity\">\n");
      out.write("                            <option value=\"1\">1</option>\n");
      out.write("                            <option value=\"2\">2</option>\n");
      out.write("                            <option value=\"3\">3</option>\n");
      out.write("                            <option value=\"4\">4</option>\n");
      out.write("                            <option value=\"5\">5</option>\n");
      out.write("                            <option value=\"10\">10</option>\n");
      out.write("                            <option value=\"50\">50</option>\n");
      out.write("                        </select>\n");
      out.write("                        <input type=\"submit\" name=\"action\" value=\"Add\">\n");
      out.write("                    </td>\n");
      out.write("                    \n");
      out.write("                </tr>\n");
      out.write("            </form>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("        ");

            String message = (String) request.getAttribute("MESSAGE");
            if (message == null) {
                message = "";
            }
        
      out.write("\n");
      out.write("        ");
      out.print( message );
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
