package service;

import dao.ActorDao;
import dao.ProducerDao;
import entity.Actor;
import entity.Movie;
import dao.MovieDao;
import entity.Producer;

import java.util.Optional;

/**
 * Created by icons on 9.4.17.
 */
public class ActorService {


    private static final Object LOCK = new Object();
    private static ActorService INSTANCE = null;

    public static ActorService getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new ActorService();
                }
            }
        }
        return INSTANCE;
    }

}