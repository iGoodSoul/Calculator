package by.vasiliev.calculator.servlet;

import by.vasiliev.calculator.entity.User;
import by.vasiliev.calculator.entity.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

        private static final long serialVersionUID = 1L;


        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            String login = request.getParameter("login");
            String password = request.getParameter("password");

            UserDAO userDao = new UserDAO();

            try {
                User user = userDao.checkLogin(login, password);
                String destPage;

                if (user != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);
                    destPage = "/pages/user_account.jsp";
                } else {
                    destPage = "index.jsp";
                    String message = "Invalid login/password";
                    request.setAttribute("message", message);
                }

                RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
                dispatcher.forward(request, response);

            } catch (SQLException | ClassNotFoundException ex) {
                throw new ServletException(ex);
            }
        }
}
