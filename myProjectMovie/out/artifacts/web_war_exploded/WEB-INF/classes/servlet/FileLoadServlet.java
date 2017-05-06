package servlet;

import entity.Movie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static dao.MovieDao.movieNameByYear;
import static java.io.File.separator;

/**
 * @author i.sukach
 */
@WebServlet("/getFile")
public class FileLoadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        int year = Integer.parseInt(req.getParameter("year"));
        List<Movie> moviesNames = movieNameByYear(year);
        Properties properties = System.getProperties();
        String names = System.getProperty("line.separator");
        resp.setHeader("Content-disposition", "attachment; filename=report.txt");
        for (int i = 0; i < moviesNames.size(); i++) {
            names = movieNameByYear(year).get(i).getName() + (" ");
            resp.getWriter().println((i + 1) + " " + names);


        }
    }
}
