<%-- 
    Document   : create_event
    Created on : 11 Sep, 2023, 8:34:25 PM
    Author     : Rajshekhar Bhagat
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
=<%
    
    String eventOwner = String.valueOf(session.getAttribute("username"));
    String eventName= request.getParameter("event_name");
    String eventDescription = request.getParameter("event_desc");
    String eventDate = request.getParameter("event_date");
    String eventTime = request.getParameter("event_time");
    try
    {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/CE2_database","root","root");
        PreparedStatement ps = con.prepareStatement("INSERT INTO EVENTS VALUES(?,?,?,?,?)");
        ps.setString(1,eventOwner);
        ps.setString(2,eventName);
        ps.setString(3,eventDescription);
        ps.setString(4,eventDate);
        ps.setString(5,eventTime);
        ps.executeUpdate();
        String popupHtml = "<!DOCTYPE html>\n" +
                       "<html>\n" +
                       "<head>\n" +
                       "<title>Event Message</title>\n" +
                       "</head>\n" +
                       "<body>\n" +
                       "<script>\n" +
                       "    alert('Event Created successfully');\n" +
                       "    window.location.href ='dashboard.jsp';\n" +
                       "</script>\n" +
                       "</body>\n" +
                       "</html>";
                       out.println(popupHtml);
    }
    catch(Exception e)
    {
        out.println(e.getMessage());
    }
    %>
