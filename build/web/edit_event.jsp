<%-- 
    Document   : edit_event
    Created on : 2 Sep, 2023, 7:57:49 PM
    Author     : Rajshekhar Bhagat
--%>

<%@page import="java.util.*"%>
<%@page import="CE2_Beans.Events"%>
<%@page import="java.sql.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Event Management System</title>
    </head>
    <style>
        body {
            font-family: Arial, sans-serif;
            /*background-color: #f0f0f0;*/
            text-align: center;
        }

        div {
            background-color: #3498db;
            color: #fff;
            padding: 10px;
        }

        h2 {
            margin: 0;
        }
        table {
            border-collapse: collapse;
            width: 80%;
            margin: 0 auto;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
        input[type="submit"],
        input[type="reset"] {
            background-color: #3498db;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
    </style>
    <body>
        <div>
            <h2>Edit Event</h2>
        </div>
        <br><br>
        <%
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
                        %>
                        <form action="editEventServlet" method="post">
                            <table border="1">
                                <tr>
                                    <th>Select</th>
                                    <th>Event Name</th>
                                    <th>Event Description</th>
                                    <th>Event Date</th>
                                    <th>Event Time</th>
                                </tr>
                                <tr>
                                    <td><input type="radio" name="selectedEventName" value="<%= eventName%>"></td>
                                    <td><%= eventName%></td>
                                    <td><%= eventDescription%></td>
                                    <td><%= eventDate%></td>
                                    <td><%= eventTime%></td>
                                </tr>
                            </table>
                            <br><br>
        <%
                    }
                %>      <input type="submit" value="Edit Event">
                        </form> 
                <%
                
            }
            catch(Exception e)
                {
                    out.println("Error Fount:"+e.getMessage());
                }
        %>
    </body>
</html>
