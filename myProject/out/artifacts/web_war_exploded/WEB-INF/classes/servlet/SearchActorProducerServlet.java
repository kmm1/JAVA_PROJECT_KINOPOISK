package servlet;

import dao.MovieDao;
import entity.Movie;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static dao.MovieDao.movieNameByYear;

/**
 * Created by icons on 22.4.17.
 */

@WebServlet("/searchActorProducer")
public class SearchActorProducerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");

        if (name.equals("")) {
            resp.sendRedirect("userContent.jsp");
        }
        Optional<Movie> selectMovieByName = MovieDao.getInstance().getMovieInfoByName(name);
        requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/showActorProducer.jsp");
        req.setAttribute("movieName", name);
        req.setAttribute("actors", selectMovieByName.get().getSetActor());
        req.setAttribute("producers", selectMovieByName.get().getSetProducer());
        requestDispatcher.forward(req, resp);
    }
}
