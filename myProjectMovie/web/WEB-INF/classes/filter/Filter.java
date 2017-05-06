package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(urlPatterns = {"/addReview", "/movie-details", "/saveActor", "/saveMovieActor",
        "/saveMovie", "/saveMovieProducer", "/saveProducer", "/searchActorProducer",
        "/userContent", "/searchMovieByYear"})
public class Filter implements javax.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        Object userLoggedIn = httpServletRequest.getSession().getAttribute("userLoggedIn");
        if (userLoggedIn == null && !httpServletRequest.getRequestURI().contains("/index")) {
            ((HttpServletResponse) servletResponse).sendRedirect("/index");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}