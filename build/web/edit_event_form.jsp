<%-- 
    Document   : edit_event_form
    Created on : 13 Sep, 2023, 12:28:25 PM
    Author     : Rajshekhar Bhagat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit Event</title>
</head>
<style>
    body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            text-align: center;
        }

        div {
            background-color: #3498db;
            color: #fff;
            padding: 5px;
        }

        h2 {
            margin: 0;
        }
        form{
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            max-width: 400px;
            margin: 20px auto;
        }
        label {
            display: block;
            text-align: left;
            margin-bottom: 5px;
        }

        input[type="text"],
        input[type="date"]{
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
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
</style>
<body>
    <div>
        <h1>Edit Event</h1>
    </div>
    <form action="updateEventServlet" method="post">
            <label for="editEventName">Event Name:</label>
            <input type="text" name="editEventName" value="${editEventName}" required><br><br>
            
            <label for="editEventDescription">Event Description:</label>
            <input type="text" name="editEventDescription" value="${editEventDescription}" required><br><br>
            
            <label for="editEventDate">Event Date:</label>
            <input type="date" name="editEventDate" value="${editEventDate}" required><br><br>
            
            <label for="editEventTime">Event Time:</label>
            <input type="text" name="editEventTime" value="${editEventTime}" required><br><br>
  
            <input type="hidden" name="originalEventName" value="${editEventName}" required>
            
            <input type="submit" value="Save Changes">
        </form>  
</body>
</html>




