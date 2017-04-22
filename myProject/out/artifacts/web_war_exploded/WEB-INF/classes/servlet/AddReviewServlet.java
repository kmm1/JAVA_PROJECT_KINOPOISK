package servlet;

import dao.ActorDao;
import dao.MovieDao;
import dao.ReviewDao;
import dao.UserDao;
import entity.Actor;
import entity.Movie;
import entity.Review;
import entity.User;

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
import java.util.Random;

import static dao.ReviewDao.getReviewByMovieId;

/**
 * Created by icons on 22.4.17.
 */

@WebServlet("/addReview")
public class AddReviewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher
                = getServletContext().getRequestDispatcher("/WEB-INF/jsp/userContent.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String review = req.getParameter("review");
        HttpSession session = req.getSession();
        Long userId = (Long) session.getAttribute("userId");

        if (name.equals("") || review.equals("")) {
            requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/userContentWrong.jsp");
            requestDispatcher.forward(req, resp);
        }


        Optional<Movie> selectMovieByName = MovieDao.getInstance().getMovieByName(name);
        Optional<Movie> movie = MovieDao.getInstance().getMovieById(selectMovieByName.get().getId());
        Optional<User> user = UserDao.getInstance().getUserById(userId);
        ReviewDao.getInstance().saveReview(new Review(review, user.get(), movie.get()));


        List<String> reviews = getReviewByMovieId(selectMovieByName.get().getId());

        requestDispatcher= getServletContext().getRequestDispatcher("/WEB-INF/jsp/showReview.jsp");
        req.setAttribute("movieName", name);
        req.setAttribute("reviews", reviews);
        requestDispatcher.forward(req, resp);

    }
}
