
package CE2_Packages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Rajshekhar Bhagat
 */
public class registerEventServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter(); 
        HttpSession session = req.getSession();
        
        String participantName = String.valueOf(session.getAttribute("username"));
        String participantEvent = req.getParameter("selectedEventName");
        
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/CE2_database","root","root");
            String sql = "INSERT INTO PARTICIPENTS VALUES(?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, participantName);
            preparedStatement.setString(2, participantEvent);
            preparedStatement.executeUpdate();
            String popupHtml = "<!DOCTYPE html>\n" +
                       "<html>\n" +
                       "<head>\n" +
                       "<title>Registration Successful</title>\n" +
                       "</head>\n" +
                       "<body>\n" +
                       "<script>\n" +
                       "    alert('Registration to Event is Successfull!!');\n" +
                       "    window.location.href = 'dashboard.jsp';\n" +
                       "</script>\n" +
                       "</body>\n" +
                       "</html>";
                out.println(popupHtml);
        }
        catch(Exception e)
        {
            out.println(e.getMessage());
        }
    }
}
