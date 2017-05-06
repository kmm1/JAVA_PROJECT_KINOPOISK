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

@WebServlet("/saveMovieActor")
public class SaveMovieActorServlet extends HttpServlet {

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
        long movieId = Long.parseLong(req.getParameter("movieId"));
        long actorId = Long.parseLong(req.getParameter("actorId"));
        System.out.println(movieId);
        System.out.println(actorId);
        Optional<Movie> movieOptional = MovieDao.getInstance().addMovieWithActor(movieId, actorId);
        req.setAttribute("listMovies", MovieDao.getInstance().findAllMovies());
        req.setAttribute("listActors", ActorDao.getInstance().findAllActors());
        req.setAttribute("listProducers", ProducerDao.getInstance().findAllProducers());
        requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/admin-content.jsp");
        requestDispatcher.forward(req, resp);
    }
}