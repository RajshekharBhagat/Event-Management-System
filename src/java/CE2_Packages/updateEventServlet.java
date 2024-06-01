package CE2_Packages;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Rajshekhar Bhagat
 */

@WebServlet("/edit_event_form")
public class updateEventServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Retrieve edited event details from the form
        String editedEventName = request.getParameter("editEventName");
        String editedEventDescription = request.getParameter("editEventDescription");
        String editedEventDate = request.getParameter("editEventDate");
        String editedEventTime = request.getParameter("editEventTime");
        String originalEventName = request.getParameter("originalEventName");
        
        try 
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/CE2_database","root","root");
            
            String sql = "UPDATE EVENTS SET EVENT_NAME=?, EVENT_DESCRIPTION=?, EVENT_DATE=?, EVENT_TIME=? WHERE EVENT_NAME=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, editedEventName);
            preparedStatement.setString(2, editedEventDescription);
            preparedStatement.setString(3, editedEventDate);
            preparedStatement.setString(4, editedEventTime);
            preparedStatement.setString(5, originalEventName);
            
            int updatedRows = preparedStatement.executeUpdate();
            
            if (updatedRows > 0) {
                String popupHtml = "<!DOCTYPE html>\n" +
                       "<html>\n" +
                       "<head>\n" +
                       "<title>Registration Successful</title>\n" +
                       "</head>\n" +
                       "<body>\n" +
                       "<script>\n" +
                       "    alert('Event Edited Successfully!!');\n" +
                       "    window.location.href = 'edit_event.jsp';\n" +
                       "</script>\n" +
                       "</body>\n" +
                       "</html>";
                out.println(popupHtml);
            } 
            else 
            {
                String popupHtml = "<!DOCTYPE html>\n" +
                       "<html>\n" +
                       "<head>\n" +
                       "<title>Registration Successful</title>\n" +
                       "</head>\n" +
                       "<body>\n" +
                       "<script>\n" +
                       "    alert('Failed in Editinf the event Please try again');\n" +
                       "    window.location.href = 'Login.html';\n" +
                       "</script>\n" +
                       "</body>\n" +
                       "</html>";
                    out.println(popupHtml);
            }
            preparedStatement.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) 
        {
            out.println(e.getMessage());
        }
    }
}