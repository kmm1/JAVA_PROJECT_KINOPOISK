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
import java.util.Optional;

/**
 * Created by icons on 21.4.17.
 */

@WebServlet("/saveMovie")
public class SaveMovieServlet extends HttpServlet {

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
        String country = req.getParameter("country");
        String year = req.getParameter("year");
        String genre = req.getParameter("genre");
        String actLastname = req.getParameter("actLastname");
        String prodLastname = req.getParameter("prodLastname");
        if (name.equals("") || country.equals("") || year.equals("") ||
                genre.equals("") || actLastname.equals("") || prodLastname.equals("")) {
            requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/adminContentWrong.jsp");
            requestDispatcher.forward(req, resp);
        }
        int entryYear = Integer.parseInt(year);
        Optional<Producer> producer = ProducerDao.getInstance().getProducerByLastname(prodLastname);
        Optional<Actor> actor = ActorDao.getInstance().getActorByLastname(actLastname);
        Optional<Movie> movieOptional = MovieDao.getInstance().addMovieWithProducer(
                new Movie(name, entryYear, country, genre),
                producer.get(), actor.get());
        String jspName = movieOptional.isPresent() ? "adminContent.jsp" : "adminContentWrong.jsp";
        requestDispatcher
                = getServletContext().getRequestDispatcher("/WEB-INF/jsp/adminContent.jsp");
        requestDispatcher.forward(req, resp);
    }
}