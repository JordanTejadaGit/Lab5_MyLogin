
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;
/**
 *
 * @author 694952
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession();
         
         if (request.getParameter("logout") != null) {
             session.removeAttribute("username");
             session.removeAttribute("password");
             session.setAttribute("message", "You have succesfully logged out!");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
         }
         
         else if (session.getAttribute("username") != null) {
             
             response.sendRedirect("home");
         }
         else {
             getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            
         }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        
        String username = (String) request.getParameter("username");
        String password = (String) request.getParameter("password");
        
        AccountService as = new AccountService();
        
        User user = new User();
        if (username == null || username == "" || password == null || password == "") {
            session.setAttribute("message", "Invalid login");
            response.sendRedirect("login");
        }
        else {
                user = as.login(username, password);
                if (user == null) {
                    session.setAttribute("message", "Invalid login");
                    response.sendRedirect("login");
                }
                else {
                    session.setAttribute("username", username);
                    session.setAttribute("password", password);
                    response.sendRedirect("home");
                }
            
        }
    }


}
