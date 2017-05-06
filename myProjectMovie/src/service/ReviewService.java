package service;

import dao.UserDao;
import entity.Movie;
import entity.Review;
import dao.MovieDao;
import dao.ReviewDao;
import entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

import static dao.MovieDao.movieNameByYear;
import static dao.ReviewDao.getReviewByMovieId;

/**
 * Created by icons on 9.4.17.
 */
public class ReviewService {

    private static final Object LOCK = new Object();
    private static ReviewService INSTANCE = null;

    public static ReviewService getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new ReviewService();
                }
            }
        }
        return INSTANCE;

    }
}