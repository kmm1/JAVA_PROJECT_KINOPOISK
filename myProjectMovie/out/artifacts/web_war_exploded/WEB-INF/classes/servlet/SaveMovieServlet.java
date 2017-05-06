package servlet;

import dao.ActorDao;
import dao.MovieDao;
import dao.ProducerDao;
import entity.Actor;
import entity.Movie;
import entity.Producer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * Created by icons on 21.4.17.
 */

@WebServlet("/saveMovie")
public class SaveMovieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher
                = getServletContext().getRequestDispatcher("/WEB-INF/jsp/admin-content.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String country = req.getParameter("country");
        String year = req.getParameter("year");
        String genre = req.getParameter("genre");
        if (name.equals("") || country.equals("") || year.equals("") ||
                genre.equals("")) {
            requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/admin-content-wrong.jsp");
            requestDispatcher.forward(req, resp);
        }
        int entryYear = Integer.parseInt(year);
        Optional<Movie> movieOptional = MovieDao.getInstance().addMovie(new Movie(name, entryYear, country, genre));
        req.setAttribute("listMovies", MovieDao.getInstance().findAllMovies());
        req.setAttribute("listActors", ActorDao.getInstance().findAllActors());
        req.setAttribute("listProducers", ProducerDao.getInstance().findAllProducers());
        String jspName = movieOptional.isPresent() ? "admin-content.jsp" : "admin-contentWrong.jsp";
        requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/" + jspName);
        requestDispatcher.forward(req, resp);

    }
}