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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static dao.MovieDao.movieInfoByName2;
import static dao.MovieDao.movieNameByYear;
import static java.awt.SystemColor.text;

/**
 * Created by icons on 21.4.17.
 */
@WebServlet("/searchMovieByYear")
public class SearchMovieByYearServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        req.setCharacterEncoding("UTF-8");
        String yearr = req.getParameter("year");
        if (yearr.equals("")) {
            resp.sendRedirect("user-content.jsp");
        }
        int year = Integer.parseInt(yearr);
        List<Movie> moviesNames = movieNameByYear(year);
        req.setAttribute("yearr", yearr);
        req.setAttribute("moviesNames", moviesNames);
        req.setAttribute("moviesNames", moviesNames);
        requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/show-movie-by-year.jsp");
        requestDispatcher.forward(req, resp);
    }
}