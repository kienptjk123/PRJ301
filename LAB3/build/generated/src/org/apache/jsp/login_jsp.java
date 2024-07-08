package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"MainController\" method=\"POST\">\n");
      out.write("            <h1>Welcome</h1>\n");
      out.write("            <h5>Enter your details</h5>\n");
      out.write("            <div class=\"container\">               \n");
      out.write("                <div class=\"user\" \n");
      out.write("                     <h5>UserID</h5><br/>\n");
      out.write("                    <input type=\"text\" name=\"userID\" placeholder=\"👤  Your userID\"/>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"password\"\n");
      out.write("                     <h5>Password</h5><br/>\n");
      out.write("                    <input type=\"password\" name=\"password\" placeholder=\"🔒  Your password\"/>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"footer\">\n");
      out.write("                <input type=\"submit\" name=\"action\" value=\"Login\"/><br/>\n");
      out.write("                Create new user account <a href=\"signup.jsp\"/>Click here</a>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        ");
 
            String error= (String)request.getAttribute("message");
            if(error== null) error= "";
        
      out.write("\n");
      out.write("         <h1>");
      out.print( error );
      out.write("</h1>\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            *{\n");
      out.write("                padding: 0;\n");
      out.write("                margin: 0;\n");
      out.write("                box-sizing: border-box;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write(" \n");
      out.write("            form {\n");
      out.write("                position: absolute;\n");
      out.write("                top: 30%;\n");
      out.write("                right: 37%;\n");
      out.write("                width: 350px;\n");
      out.write("                padding: 20px 30px;\n");
      out.write("                box-shadow: 1px 2px 4px rgb(0, 0, 0, 0.5);\n");
      out.write("                border: 2px solid #aaa;\n");
      out.write("                border-radius: 10px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            h1 {\n");
      out.write("                text-align: center;\n");
      out.write("                text-transform: uppercase;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            h5 {\n");
      out.write("                text-align: center;\n");
      out.write("                font-weight: 300;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .container {\n");
      out.write("                margin-top: 20px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .user input,\n");
      out.write("            .password input{\n");
      out.write("                padding: 4px 12px;\n");
      out.write("                width: 100%;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .password {\n");
      out.write("                margin-top: 15px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .footer {\n");
      out.write("                margin-top: 30px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .footer input {\n");
      out.write("                width: 100%;\n");
      out.write("                font-size: 1.3rem;\n");
      out.write("                padding: 4px 0;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .footer input:hover {\n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .footer a {\n");
      out.write("                text-decoration: none;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
