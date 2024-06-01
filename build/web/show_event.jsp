<%--
    Document   : show_event
    Created on : 11 Sep, 2023, 8:55:21 PM
    Author     : Rajshekhar Bhagat
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Show Events</title>
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
</style>
<body>
    <div>
        <h2>List of Events:</h2>
    </div>
    <br><br>
    <table border="1">
        <tr>
            <th>Event Name</th>
            <th>Event Description</th>
            <th>Event Date</th>
            <th>Event Time</th>
        </tr>
        <%
        try
        {
            String eventOwner = String.valueOf(session.getAttribute("username"));
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/CE2_database", "root", "root");
            String sql = "SELECT * FROM EVENTS";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                String eventName = resultSet.getString("EVENT_NAME");
                String eventDescription = resultSet.getString("EVENT_DESCRIPTION");
                Date date = resultSet.getDate("EVENT_DATE");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String eventDate = dateFormat.format(date);
                System.out.println("Time for the Event is:" + eventDate);
                String eventTime = resultSet.getString("EVENT_TIME");
        %>
        <tr>
            <td><%= eventName %></td>
            <td><%= eventDescription %></td>
            <td><%= eventDate %></td>
            <td><%= eventTime %></td>
        </tr>
        <%
            }
            con.close();
        }
        catch (Exception e)
        {
            out.println(e.getMessage());
        }
        %>
    </table>
</body>
</html>
