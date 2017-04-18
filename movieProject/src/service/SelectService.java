package service;

import dao.MovieDao;
import entity.Movie;

import java.util.Optional;

/**
 * Created by icons on 9.4.17.
 */
public class SelectService {
    public static void main(String[] args) {
        Optional<Movie> selectMovieByYear = MovieDao.getInstance().selectMovieByYear(1996);

        // Optional<Movie> fullInfo = MovieDao.getInstance().getFullInfo(1L);
        // if (fullInfo.isPresent()) {
        //      System.out.println(fullInfo.get().getSetActor());
        // }
    }
}

