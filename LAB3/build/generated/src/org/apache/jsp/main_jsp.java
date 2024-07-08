package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import sample.user.UserDTO;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         ");

            String search = request.getParameter("search");
            if (search == null) {
                search = "";
            }
        
      out.write("\n");
      out.write("        <i class=\"fas fa-ghost\"></i>\n");
      out.write("        <h5>Welcome Back Admin</h5>\n");
      out.write("        <form action=\"MainController\" method=\"POST\">\n");
      out.write("            <input style=\"border-bottom-left-radius: 12px; border-top-left-radius: 12px; border: none \" type=\"text\" name=\"search\" value=\"");
      out.print( search );
      out.write("\"/>\n");
      out.write("            <input style=\"border-radius: 20px; cursor: pointer;  border: none \" type=\"submit\" name=\"action\" value=\"Search\"/>\n");
      out.write("        </form>   \n");
      out.write("            \n");
      out.write("            <a style=\"position: absolute; top: 23.5%; right: 52%; \n");
      out.write("               border-radius: 20px; text-decoration: none; color: black; \n");
      out.write("               background-color: white; padding: 3px\" href=\"./login.jsp\">Logout<a/>                   \n");
      out.write("        ");

            List<UserDTO> userList = (List<UserDTO>) request.getAttribute("User_List");
            if(userList != null && !userList.isEmpty()) { 
        
      out.write("\n");
      out.write("        \n");
      out.write("        <table  style=\"position: absolute; top: 28%; right: 20%;\" border=\"1\">\n");
      out.write("            <thead>\n");
      out.write("                <tr >\n");
      out.write("                    <th style=\"padding: 4px\">NO</th>\n");
      out.write("                    <th style=\"padding: 4px\">User ID</th> \n");
      out.write("                    <th style=\"padding: 4px 50px\">Full Name</th> \n");
      out.write("                    <th style=\"padding: 4px 50px\">Role ID</th> \n");
      out.write("                    <th style=\"padding: 4px\">Password</th>\n");
      out.write("                    <th style=\"padding: 4px 7px\">Delete</th>\n");
      out.write("                    <th style=\"padding: 4px 7px\">Update</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                ");

                    int count = 1;
                    for (UserDTO user : userList) {
                
      out.write("\n");
      out.write("            <form action=\"MainController\" method=\"POST\">\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( count++ );
      out.write("</td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" name=\"userID\" value=\"");
      out.print( user.getUserID() );
      out.write("\"/>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" name=\"fullName\" value=\"");
      out.print( user.getFullName() );
      out.write("\"/>                      \n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" name=\"roleID\" value=\"");
      out.print( user.getRoleID() );
      out.write("\"\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"password\" name=\"password\" value=\"");
      out.print( user.getPassword() );
      out.write("\"\n");
      out.write("                    </td> \n");
      out.write("                    \n");
      out.write("                    <td>\n");
      out.write("                        <a style=\"text-decoration: none ;color: blue; cursor: pointer\" href=\"MainController?userID=");
      out.print( user.getUserID());
      out.write("&action=Delete&search=");
      out.print( search);
      out.write("\">Delete</a>\n");
      out.write("                        <!--<input style=\"color: blue; cursor: pointer\" type=\"submit\" name=\"action\" value=\"Delete\">-->\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input style=\"cursor: pointer\" type=\"submit\" name=\"action\" value=\"Update\">\n");
      out.write("                        <input type=\"hidden\" name=\"search\" value=\"");
      out.print( search );
      out.write("\"/>\n");
      out.write("                    </td>\n");
      out.write("                    \n");
      out.write("                </tr>\n");
      out.write("            </form>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("             ");

            }
        
      out.write("\n");
      out.write("        <style>\n");
      out.write("            *{\n");
      out.write("                padding: 0;\n");
      out.write("                margin: 0;\n");
      out.write("                box-sizing: border-box;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            body {\n");
      out.write("                background-color: #c9c5c5;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            i.fas.fa-ghost {\n");
      out.write("                display: flex;\n");
      out.write("                justify-content: center;\n");
      out.write("                font-size: 5rem;\n");
      out.write("                margin-top: 40px;\n");
      out.write("                color: white;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            input {\n");
      out.write("                padding: 4px;\n");
      out.write("            } \n");
      out.write("            h5 {\n");
      out.write("                text-align: center;\n");
      out.write("                color: white;\n");
      out.write("                margin-top: 20px;\n");
      out.write("            }\n");
      out.write("            form {\n");
      out.write("                position: absolute;\n");
      out.write("                top: 20%;\n");
      out.write("                right: 41%;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            input {\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            td {\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            td input {\n");
      out.write("                background-color: #c9c5c5; \n");
      out.write("                border: none\n");
      out.write("            }\n");
      out.write("        </style>\n");
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
