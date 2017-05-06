package service;

import dao.ActorDao;
import dao.ProducerDao;
import dao.UserDao;
import entity.*;
import dao.MovieDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static dao.MovieDao.movieNameByYear;
import static dao.ReviewDao.getReviewByMovieId;

/**
 * Created by icons on 9.4.17.
 */
public class MovieService {

    private static final Object LOCK = new Object();
    private static MovieService INSTANCE = null;

    public static MovieService getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new MovieService();
                }
            }
        }
        return INSTANCE;
    }

    public String selectMovieByName(String name) {
        Optional<Movie> selectMovieByName = MovieDao.getInstance().getMovieByName(name);
        if (selectMovieByName.isPresent()) {
            return selectMovieByName.get().getName();
        }
        return null;
    }

    public String movie(long id) {
        Optional<Movie> movie = MovieDao.getInstance().getMovieById(id);
        if (movie.isPresent()) {
            return movie.get().getName();
        }
        return null;
    }

    public List<Movie> getAllMovies() {
        return MovieDao.getInstance().findAllMovies();
    }
}