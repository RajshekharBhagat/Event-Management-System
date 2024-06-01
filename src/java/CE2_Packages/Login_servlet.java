package CE2_Packages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rajshekhar Bhagat
 */
public class Login_servlet extends HttpServlet {

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        String Username = request.getParameter("username");
        String Password = request.getParameter("password");
        String action = request.getParameter("action");
        
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/CE2_database","root","root");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM registration_table WHERE USERNAME = ?");
            ps.setString(1,Username);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                if(rs.getString("PASSWORD").equals(Password))
                {
                    HttpSession session = request.getSession();
                    session.setAttribute("username",Username);
                    RequestDispatcher rd = request.getRequestDispatcher("/dashboard.jsp");
                    rd.forward(request, response);
                }else{
                    String popupHtml = "<!DOCTYPE html>\n" +
                       "<html>\n" +
                       "<head>\n" +
                       "<title>Login Message</title>\n" +
                       "</head>\n" +
                       "<body>\n" +
                       "<script>\n" +
                       "    alert('Incorrect Username or Password!!');\n" +
                       "    window.location.href = 'Login.html';\n" +
                       "</script>\n" +
                       "</body>\n" +
                       "</html>";
                       out.println(popupHtml);
                }
            }    
        }catch(ClassNotFoundException | SQLException | ServletException | IOException e){
            out.println(e);
        }
    }

}
