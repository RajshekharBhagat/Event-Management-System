package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class showParticipant_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Event Management System</title>\n");
      out.write("    </head>\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("            /*background-color: #f0f0f0;*/\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .normalDiv{\n");
      out.write("            background-color: #3498db;\n");
      out.write("            color: #fff;\n");
      out.write("            padding: 10px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        h2 {\n");
      out.write("            margin: 0;\n");
      out.write("        }\n");
      out.write("        table {\n");
      out.write("            border-collapse: collapse;\n");
      out.write("            width: 80%;\n");
      out.write("            margin: 0 auto;\n");
      out.write("        }\n");
      out.write("        th, td {\n");
      out.write("            border: 1px solid #ddd;\n");
      out.write("            padding: 8px;\n");
      out.write("            text-align: left;\n");
      out.write("        }\n");
      out.write("        th {\n");
      out.write("            background-color: #f2f2f2;\n");
      out.write("        }\n");
      out.write("        tr:hover {\n");
      out.write("            background-color: #f5f5f5;\n");
      out.write("        }\n");
      out.write("        input[type=\"submit\"],\n");
      out.write("        input[type=\"reset\"] {\n");
      out.write("            background-color: #3498db;\n");
      out.write("            color: #fff;\n");
      out.write("            padding: 10px 20px;\n");
      out.write("            border: none;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("        .msgDiv {\n");
      out.write("            text-align: center;\n");
      out.write("            position: absolute;\n");
      out.write("            top: 50%;\n");
      out.write("            left: 50%;\n");
      out.write("            transform: translate(-50%, -50%);\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"normalDiv\">\n");
      out.write("            <h2> Participants List</h2>\n");
      out.write("        </div>\n");
      out.write("        ");

            String action = request.getParameter("showParticipant");
            String participantEvent = request.getParameter("selectedEventName");
            if(action.equals("show"))
            {
                try
                {
                    Class.forName("org.apache.derby.jdbc.ClientDriver");
                    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/CE2_database","root","root");
                    String sql = "SELECT * FROM PARTICIPENTS WHERE P_EVENT='"+participantEvent+"'";
                    PreparedStatement preparedStatement = con.prepareStatement(sql);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next())
                    {
                        while(resultSet.next())
                        {
                            String name = resultSet.getString("P_NAME");
                            String event = resultSet.getString("P_EVENT");
                            
      out.write("\n");
      out.write("                            <table border=\"1\">\n");
      out.write("                                <tr>\n");
      out.write("                                    <th>Participant Name</th>\n");
      out.write("                                    <th>Event Name</th>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>");
      out.print( name);
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print( event);
      out.write("</td>\n");
      out.write("                                </tr>\n");
      out.write("                            </table>\n");
      out.write("                            <br><br>\n");
      out.write("                            ");
    
                        }
                    }
                    else
                    {
                        
      out.write("\n");
      out.write("                        <div class=\"msgDiv\">\n");
      out.write("                            <h2>No Participants Registered</h2>\n");
      out.write("                        </div>\n");
      out.write("                        ");

                    }
                }
                catch(Exception e)
                {
                    out.println("Error"+e.getMessage());
                }
            }
        
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
