<%-- 
    Document   : Main
    Created on : 31 Aug, 2023, 8:33:39 PM
    Author     : Rajshekhar Bhagat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            text-align: center;
        }
        div{
            background-color: #3498db;
            color: #fff;
            padding: 10px;
        }
        h2{
            margin: 0;
        }
        a{
            text-decoration: none;
            color: #3498db;
        }
        .main{
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            max-width: 400px;
            margin: 20px auto;
        }
        .logout{
            color: #e74c3c;
        }
    </style>
    <body>
    <center>
        <div>
            <h2>
            Select What you want to do
            </h2>
        </div>
        <div class="main">
        <h1><a href="myEvents.jsp">My Events</a></h1>
        <h1><a href="create_event.html">Create Event</a></h1>
        <h1><a href="edit_event.jsp">Edit Event</a></h1>
        <h1><a href="registerEvent.jsp">Register Event</a></h1>
        <h1><a href="show_event.jsp">Show Events</a></h1>
        <h1><a class="logout" href="logoutServlet?action=logout">Logout</a></h1>
        </div>
    </center>
    </body>
</html>
