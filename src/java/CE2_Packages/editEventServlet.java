package CE2_Packages;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/edit_event")
public class editEventServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String selectedEvent = request.getParameter("selectedEventName");
        try 
        {
            String eventOwner = String.valueOf(session.getAttribute("username"));
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/CE2_database","root","root");
            String sql = "SELECT * FROM EVENTS WHERE event_name='"+selectedEvent+"'";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                String editEventName = resultSet.getString("EVENT_NAME");
                String editEventDescription = resultSet.getString("EVENT_DESCRIPTION");
                String editEventDate = resultSet.getString("EVENT_DATE");
                String editEventTime = resultSet.getString("EVENT_TIME");
//                out.println(editEventName);
//                out.println(editEventDescription);
//                out.println(editEventDate);
//                out.println(editEventTime);
                request.setAttribute("editEventName", editEventName);
                request.setAttribute("editEventDescription", editEventDescription);
                request.setAttribute("editEventDate", editEventDate);
                request.setAttribute("editEventTime", editEventTime);
                request.getRequestDispatcher("edit_event_form.jsp").forward(request, response);
                        
            }
            resultSet.close();
            preparedStatement.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            out.println(e.getMessage());
        }
    }
}
