package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class edit_005fevent_005fform_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <title>Edit Event</title>\n");
      out.write("</head>\n");
      out.write("<style>\n");
      out.write("    body {\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("            background-color: #f0f0f0;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        div {\n");
      out.write("            background-color: #3498db;\n");
      out.write("            color: #fff;\n");
      out.write("            padding: 5px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        h2 {\n");
      out.write("            margin: 0;\n");
      out.write("        }\n");
      out.write("        form{\n");
      out.write("            background-color: #fff;\n");
      out.write("            padding: 20px;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);\n");
      out.write("            max-width: 400px;\n");
      out.write("            margin: 20px auto;\n");
      out.write("        }\n");
      out.write("        label {\n");
      out.write("            display: block;\n");
      out.write("            text-align: left;\n");
      out.write("            margin-bottom: 5px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        input[type=\"text\"],\n");
      out.write("        input[type=\"date\"]{\n");
      out.write("            width: 100%;\n");
      out.write("            padding: 10px;\n");
      out.write("            margin-bottom: 10px;\n");
      out.write("            border: 1px solid #ccc;\n");
      out.write("            border-radius: 5px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        input[type=\"submit\"],\n");
      out.write("        input[type=\"reset\"] {\n");
      out.write("            background-color: #3498db;\n");
      out.write("            color: #fff;\n");
      out.write("            padding: 10px 20px;\n");
      out.write("            border: none;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        input[type=\"reset\"] {\n");
      out.write("            background-color: #e74c3c;\n");
      out.write("        }\n");
      out.write("</style>\n");
      out.write("<body>\n");
      out.write("    <div>\n");
      out.write("        <h1>Edit Event</h1>\n");
      out.write("    </div>\n");
      out.write("    <form action=\"updateEventServlet\" method=\"post\">\n");
      out.write("            <label for=\"editEventName\">Event Name:</label>\n");
      out.write("            <input type=\"text\" name=\"editEventName\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${editEventName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required><br><br>\n");
      out.write("            \n");
      out.write("            <label for=\"editEventDescription\">Event Description:</label>\n");
      out.write("            <input type=\"text\" name=\"editEventDescription\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${editEventDescription}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required><br><br>\n");
      out.write("            \n");
      out.write("            <label for=\"editEventDate\">Event Date:</label>\n");
      out.write("            <input type=\"date\" name=\"editEventDate\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${editEventDate}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required><br><br>\n");
      out.write("            \n");
      out.write("            <label for=\"editEventTime\">Event Time:</label>\n");
      out.write("            <input type=\"text\" name=\"editEventTime\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${editEventTime}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required><br><br>\n");
      out.write("  \n");
      out.write("            <input type=\"hidden\" name=\"originalEventName\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${editEventName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required>\n");
      out.write("            \n");
      out.write("            <input type=\"submit\" value=\"Save Changes\">\n");
      out.write("        </form>  \n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
