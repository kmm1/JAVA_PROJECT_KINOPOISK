package servlet;

import dao.MovieDao;
import entity.Movie;
import entity.Producer;

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

import static dao.MovieDao.movieInfoByName;
import static dao.MovieDao.movieInfoByName2;
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
        String movieIdd = req.getParameter("movieId");
        if (movieIdd.equals("")) {
            resp.sendRedirect("user-content.jsp");
        }
        long movieId = Long.parseLong(movieIdd);
        List<Movie> movieInfoByName = movieInfoByName(movieId);
        List<Producer> movieInfoByName2 = movieInfoByName2(movieId);
        String movieName = movieInfoByName.get(0).getName();
        requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/show-actor-producer.jsp");
        req.setAttribute("movieInfoByName", movieInfoByName);
        req.setAttribute("movieInfoByName2", movieInfoByName2);
        req.setAttribute("movieName", movieName);
        requestDispatcher.forward(req, resp);
    }
}
