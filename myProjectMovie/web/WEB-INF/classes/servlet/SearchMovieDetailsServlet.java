package servlet;

import dao.MovieDao;
import dao.UserDao;
import entity.Movie;
import entity.Producer;
import entity.Review;
import entity.User;
import service.MovieService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static dao.MovieDao.movieInfoByName;
import static dao.MovieDao.movieInfoByName2;
import static dao.ReviewDao.getReviewByMovieId;

/**
 * Created by icons on 28.4.17.
 */
@WebServlet("/movie-details")
public class SearchMovieDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long movieId = Long.parseLong(req.getParameter("id"));
        Optional<Movie> movie = MovieDao.getInstance().getFullInfo(movieId);
        String movieName = movie.get().getName();
        String movieCountry = movie.get().getCountry();
        int movieYear = movie.get().getYear();
        String movieGenre = movie.get().getGenre();
        req.setAttribute("movieId", movieId);
        req.setAttribute("movieName", movieName);
        req.setAttribute("movieCountry", movieCountry);
        req.setAttribute("movieYear", movieYear);
        req.setAttribute("movieGenre", movieGenre);
        List<Review> reviews = getReviewByMovieId(movieId);
        List<Movie> movieInfoByName = movieInfoByName(movieId);
        List<Producer> movieInfoByName2 = movieInfoByName2(movieId);
        req.setAttribute("movieInfoByName", movieInfoByName);
        req.setAttribute("movieInfoByName2", movieInfoByName2);

        req.setAttribute("reviews", reviews);
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/show-full-info.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}