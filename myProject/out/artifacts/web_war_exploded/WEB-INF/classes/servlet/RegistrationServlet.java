package servlet;

import dao.UserDao;
import entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

/**
 * Created by icons on 19.4.17.
 */
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher
                = getServletContext().getRequestDispatcher("/WEB-INF/jsp/reg.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (name.equals("") || lastname.equals("") || email.equals("") || password.equals("")) {
            requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/reg.jsp");
            requestDispatcher.forward(req, resp);
        }

        Optional<User> userOptional = UserDao.getInstance().addUser(
                new User(name, lastname, email, password));

        if (userOptional.isPresent()) {
            requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/welcome.jsp");
            requestDispatcher.forward(req, resp);
        } else if (!userOptional.isPresent()) {
            requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/reg.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
