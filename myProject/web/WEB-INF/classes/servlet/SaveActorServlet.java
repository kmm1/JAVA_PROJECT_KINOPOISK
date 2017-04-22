package servlet;

import dao.ActorDao;
import dao.UserDao;
import entity.Actor;
import entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * Created by icons on 19.4.17.
 */
@WebServlet("/saveActor")
public class SaveActorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher
                = getServletContext().getRequestDispatcher("/WEB-INF/jsp/adminContent.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String lastname = req.getParameter("lastname");
        String year = req.getParameter("year");
        if (name.equals("") || lastname.equals("") || year.equals("")) {
            requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/adminContentWrong.jsp");
            requestDispatcher.forward(req, resp);
        }
        int yearOfBirth = Integer.parseInt(year);
        Optional<Actor> actorOptional = ActorDao.getInstance().addActor(
                new Actor(name, lastname, yearOfBirth));
        String jspName = actorOptional.isPresent() ? "adminContent.jsp" : "adminContentWrong.jsp";
        requestDispatcher
                = getServletContext().getRequestDispatcher("/WEB-INF/jsp/" + jspName);
        requestDispatcher.forward(req, resp);
    }
}
