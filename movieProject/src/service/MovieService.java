package service;

import entity.Movie;
import dao.MovieDao;

import java.util.Optional;

/**
 * Created by icons on 9.4.17.
 */
public class MovieService {

    public static void main(String[] args) {
        Optional<Movie> movieOptional = MovieDao.getInstance().saveMovie(
                // new Movie("From dusk till dawn movie", 1996, "USA", "Thriller"));
                //new Movie("Pulp Fiction", 1997, "USA", "Thriller"));
                new Movie("smth", 1996, "USA", "Thriller"));

        if (movieOptional.isPresent()) {
            System.out.println(movieOptional.get());
        }

    }
}
