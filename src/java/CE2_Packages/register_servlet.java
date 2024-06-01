package CE2_Packages;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
/**
 *
 * @author Rajshekhar Bhagat
 */
public class register_servlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        String username = req.getParameter("username");
        String mobileno = req.getParameter("mobno");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirm_password = req.getParameter("confirm_password");
        
        if(password.equals(confirm_password)==false)
        {
            String popupHtml = "<!DOCTYPE html>\n" +
                       "<html>\n" +
                       "<head>\n" +
                       "<title>Registration Successful</title>\n" +
                       "</head>\n" +
                       "<body>\n" +
                       "<script>\n" +
                       "    alert('Password must be same!!');\n" +
                       "    window.location.href = 'Registration.html';\n" +
                       "</script>\n" +
                       "</body>\n" +
                       "</html>";
            out.println(popupHtml);
        }
        else
        {
           try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/CE2_database","root","root");
            PreparedStatement ps = con.prepareStatement("INSERT INTO registration_table VALUES(?,?,?,?)");
            ps.setString(1,username);
            ps.setString(2,mobileno);
            ps.setString(3, email);
            ps.setString(4, password);
            ps.executeUpdate();
            String popupHtml = "<!DOCTYPE html>\n" +
                       "<html>\n" +
                       "<head>\n" +
                       "<title>Registration Successful</title>\n" +
                       "</head>\n" +
                       "<body>\n" +
                       "<script>\n" +
                       "    alert('You have successfully registered!');\n" +
                       "    window.location.href = 'Login.html';\n" +
                       "</script>\n" +
                       "</body>\n" +
                       "</html>";
            out.println(popupHtml);
        }  
           catch(Exception e)
            {
            out.println("Error has occured:"+e.getMessage());
            }
        }
        
        
       
    }
}
