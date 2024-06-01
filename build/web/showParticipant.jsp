<%-- 
    Document   : showParticipant
    Created on : 15 Sep, 2023, 11:46:05 PM
    Author     : Rajshekhar Bhagat
--%>

<%@page import="java.sql.*"%>
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

        .normalDiv {
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
        }
        .msgDiv {
            text-align: center;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
        }
    </style>
    <body>
        <div class="normalDiv">
            <h2>Participants List</h2>
        </div>
        <br><br>
        <%
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
                        %>
                        <table border="1">
                            <tr>
                                <th>Participant Name</th>
                                <th>Event Name</th>
                            </tr>
                        <%
                        do
                        {
                            String name = resultSet.getString("P_NAME");
                            String event = resultSet.getString("P_EVENT");
                        %>
                            <tr>
                                <td><%= name%></td>
                                <td><%= event%></td>
                            </tr>
                        <%
                        } while(resultSet.next());
                        %>
                        </table>
                        <br><br>
                        <%
                    }
                    else
                    {
                        %>
                        <div class="msgDiv">
                            <h2>No Participants Registered</h2>
                        </div>
                        <%
                    }
                }
                catch(Exception e)
                {
                    out.println("Error"+e.getMessage());
                }
            }
        %>
    </body>
</html>
