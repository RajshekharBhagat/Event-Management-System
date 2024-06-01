package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import CE2_Beans.Events;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class edit_005fevent_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        div {\n");
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
      out.write("    </style>\n");
      out.write("    <body>\n");
      out.write("        <div>\n");
      out.write("            <h2>Edit Event</h2>\n");
      out.write("        </div>\n");
      out.write("        <br><br>\n");
      out.write("        ");

            try
            {
                String eventOwner = String.valueOf(session.getAttribute("username"));
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/CE2_database","root","root");
                String sql = "SELECT * FROM EVENTS WHERE EVENT_OWNER='"+eventOwner+"'";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next())
                    {
                        String eventName = resultSet.getString("EVENT_NAME");
                        String eventDescription = resultSet.getString("EVENT_DESCRIPTION");
                        Date date = resultSet.getDate("EVENT_DATE");
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        String eventDate = dateFormat.format(date);
                        System.out.println("Time for the Event is:"+eventDate);
                        String eventTime = resultSet.getString("EVENT_TIME");
                        
      out.write("\n");
      out.write("                        <form action=\"editEventServlet\" method=\"post\">\n");
      out.write("                            <table border=\"1\">\n");
      out.write("                                <tr>\n");
      out.write("                                    <th>Select</th>\n");
      out.write("                                    <th>Event Name</th>\n");
      out.write("                                    <th>Event Description</th>\n");
      out.write("                                    <th>Event Date</th>\n");
      out.write("                                    <th>Event Time</th>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td><input type=\"radio\" name=\"selectedEventName\" value=\"");
      out.print( eventName);
      out.write("\"></td>\n");
      out.write("                                    <td>");
      out.print( eventName);
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print( eventDescription);
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print( eventDate);
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print( eventTime);
      out.write("</td>\n");
      out.write("                                </tr>\n");
      out.write("                            </table>\n");
      out.write("                            <br><br>\n");
      out.write("        ");

                    }
                
      out.write("      <input type=\"submit\" value=\"Edit Event\">\n");
      out.write("                        </form> \n");
      out.write("                ");

                
            }
            catch(Exception e)
                {
                    out.println("Error Fount:"+e.getMessage());
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
