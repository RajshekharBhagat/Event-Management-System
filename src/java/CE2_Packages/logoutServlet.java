
package CE2_Packages;

import java.io.IOException;
import java.io.PrintWriter;
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
public class logoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        HttpSession session = req.getSession();
        String action = req.getParameter("action");
        
         if(action.equals("logout"))
        {
            session.invalidate();
            RequestDispatcher rd = req.getRequestDispatcher("index.html");
            rd.forward(req, res);
        }
    }
}
