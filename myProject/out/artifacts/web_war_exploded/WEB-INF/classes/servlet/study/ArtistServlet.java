package servlet.study;

import dto.ArtistDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author i.sukach
 */
@WebServlet("/artist")
public class ArtistServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher
                = getServletContext().getRequestDispatcher("/WEB-INF/jsp/study/artist.jsp");
        long id = Long.valueOf(req.getParameter("id"));
        //TODO: ArtistDto dto = ArtistService.geInstance().getArtistById(id);
        req.setAttribute("artist", new ArtistDto(id, "Eminem", true));
        requestDispatcher.forward(req, resp);
    }
}
