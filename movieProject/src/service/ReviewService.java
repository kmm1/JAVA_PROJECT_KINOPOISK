package service;

import dao.UserDao;
import entity.Movie;
import entity.Review;
import dao.MovieDao;
import dao.ReviewDao;
import entity.User;

import java.util.Optional;

/**
 * Created by icons on 9.4.17.
 */
public class ReviewService {


    public static void main(String[] args) {
        Optional<Movie> movie = MovieDao.getInstance().getMovieById(1L);
        Optional<User> user = UserDao.getInstance().getUserById(1L);
        if (movie.isPresent()) {
            ReviewDao.getInstance().saveReview(new Review("вау311", user.get(), movie.get()));
        }
    }
}
