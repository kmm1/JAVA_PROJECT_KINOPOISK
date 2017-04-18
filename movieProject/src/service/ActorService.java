package service;

import entity.Actor;
import entity.Movie;
import dao.MovieDao;

import java.util.Optional;

/**
 * Created by icons on 9.4.17.
 */
public class ActorService {

    public static void main(String[] args) {
        Optional<Movie> movie = MovieDao.getInstance().getMovieById(1L);
        if (movie.isPresent()) {
            Optional<Movie> movieWithActor
                    = MovieDao.getInstance().addActor(movie.get(), new Actor("George Clooney", 1961));
            if (movieWithActor.isPresent()) {
                System.out.println(movieWithActor.get());
            }
        }
    }
}
